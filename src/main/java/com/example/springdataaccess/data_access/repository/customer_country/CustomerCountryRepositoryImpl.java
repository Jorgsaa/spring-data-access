package com.example.springdataaccess.data_access.repository.customer_country;

import com.example.springdataaccess.data_access.model.CustomerCountry;
import com.example.springdataaccess.data_access.util.SqliteConnectionHelper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class CustomerCountryRepositoryImpl implements CustomerCountryRepository {

    @Override
    public ArrayList<CustomerCountry> findAll() {
        // Return a list of all countries with their corresponding number of customers
        // (descending by number of customers in each country)
        ArrayList<CustomerCountry> customersInEachCountry = new ArrayList<>();
        String sql = """
                SELECT Country, COUNT(*) AS 'CustomerCount'
                FROM Customer
                GROUP BY Country
                ORDER BY CustomerCount desc;
                """;

        try (Connection conn =
                     DriverManager.getConnection(
                             SqliteConnectionHelper.getURL())) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String countryName = resultSet.getString("Country");
                int numberOfCustomers = Integer.parseInt(resultSet.getString("CustomerCount"));

                customersInEachCountry.add(new CustomerCountry(countryName, numberOfCustomers));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return customersInEachCountry;
    }
}
