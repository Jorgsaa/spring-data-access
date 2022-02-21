package com.example.springdataaccess.data_access;

import com.example.springdataaccess.data_access.model.CustomerGenre;
import com.example.springdataaccess.data_access.util.SqliteConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerGenreDAO {
    public List<CustomerGenre> getFavoriteGenres(int customerID) {
        List<CustomerGenre> favoriteGenres = new ArrayList<>();
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
        WHERE Customer.CustomerId = 57
        GROUP BY Genre.Name
        ORDER BY SongsBoughtFromGenre desc LIMIT 1);
""";

        try (Connection conn =
                     DriverManager.getConnection(
                             SqliteConnectionHelper.getURL())) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, customerID);

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
