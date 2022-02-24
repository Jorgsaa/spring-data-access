package com.example.springdataaccess.data_access.repository.customer_genre;

import com.example.springdataaccess.data_access.model.CustomerGenre;
import com.example.springdataaccess.data_access.util.SqliteConnectionHelper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class CustomerGenreRepositoryImpl implements CustomerGenreRepository {

    @Override
    public ArrayList<CustomerGenre> getFavoriteGenres(int customerID) {
        // Return the customers favorite genre (determined by how many songs the customer has bought having that genre).
        // If there are multiple genres that have been bought the same number of times, then return them all (hence returning an array)
        ArrayList<CustomerGenre> favoriteGenres = new ArrayList<>();
        String sql = """
    SELECT Genre.GenreId, Genre.Name, count(*) AS 'SongsBoughtFromGenre'
    FROM Customer
        INNER JOIN Invoice
            ON Customer.CustomerId = Invoice.CustomerId
        INNER JOIN InvoiceLine
            ON Invoice.InvoiceId = InvoiceLine.InvoiceId
        INNER JOIN Track
            ON Track.TrackId = InvoiceLine.TrackId
        INNER JOIN Genre
            ON Genre.GenreId = Track.GenreId
    WHERE Customer.CustomerId = ?
    GROUP BY Genre.GenreId, Genre.Name
    HAVING SongsBoughtFromGenre = (
        SELECT count(*) AS 'SongsBoughtFromGenre'
        FROM Customer
            INNER JOIN Invoice
                ON Customer.CustomerId = Invoice.CustomerId
            INNER JOIN InvoiceLine
                ON Invoice.InvoiceId = InvoiceLine.InvoiceId
            INNER JOIN Track
                ON Track.TrackId = InvoiceLine.TrackId
            INNER JOIN Genre
                ON Genre.GenreId = Track.GenreId
        WHERE Customer.CustomerId = ?
        GROUP BY Genre.Name
        ORDER BY SongsBoughtFromGenre desc LIMIT 1);
""";

        try (Connection conn =
                     DriverManager.getConnection(
                             SqliteConnectionHelper.getURL())) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, customerID);
            preparedStatement.setInt(2, customerID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int genreID = Integer.parseInt(resultSet.getString("GenreId"));
                String genreName = resultSet.getString("Name");
                int songsBoughtFromGenre = Integer.parseInt(resultSet.getString("SongsBoughtFromGenre"));

                favoriteGenres.add(new CustomerGenre(genreID, genreName, songsBoughtFromGenre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return favoriteGenres;
    }

}
