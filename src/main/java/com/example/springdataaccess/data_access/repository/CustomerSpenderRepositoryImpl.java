package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.CustomerSpender;
import com.example.springdataaccess.data_access.util.SqliteConnectionHelper;

import java.sql.*;
import java.util.ArrayList;

public class CustomerSpenderRepositoryImpl {

    public ArrayList<CustomerSpender> getHighestSpenders() {
        // Return the highest spending of each customer (descending/highest invoice first)
        ArrayList<CustomerSpender> highestSpenders = new ArrayList<>();
        String sql = """
                SELECT Customer.CustomerId, max(Total) AS HighestSpending
                FROM Customer
                    INNER JOIN Invoice
                        ON Customer.CustomerId = Invoice.CustomerId
                GROUP BY Customer.CustomerId, FirstName
                ORDER BY HighestSpending desc;
                """;

        try (Connection conn =
                     DriverManager.getConnection(
                             SqliteConnectionHelper.getURL())) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int customerId = Integer.parseInt(resultSet.getString("CustomerId"));
                int highestSpending = Integer.parseInt(resultSet.getString("HighestSpending"));

                highestSpenders.add(new CustomerSpender(customerId, highestSpending));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return highestSpenders;
    }
}
