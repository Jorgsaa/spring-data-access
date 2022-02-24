package com.example.springdataaccess.data_access.repository;

import com.example.springdataaccess.data_access.model.CustomerSpender;
import com.example.springdataaccess.data_access.util.SqliteConnectionHelper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class CustomerSpenderRepositoryImpl implements CustomerSpenderRepository {

    @Override
    public ArrayList<CustomerSpender> getHighestSpenders () {
        // Return the total spending of each customer (descending)
        ArrayList<CustomerSpender> highestSpenders = new ArrayList<>();
        String sql = """
                SELECT Customer.CustomerId, ROUND(SUM(Total), 2) AS TotalSpending
                FROM Customer
                    INNER JOIN Invoice
                        ON Customer.CustomerId = Invoice.CustomerId
                GROUP BY Customer.CustomerId, FirstName
                ORDER BY TotalSpending desc;
                """;

        try (Connection conn =
                     DriverManager.getConnection(
                             SqliteConnectionHelper.getURL())) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int customerId = Integer.parseInt(resultSet.getString("CustomerId"));
                double totalSpending = Double.parseDouble(resultSet.getString("TotalSpending"));

                highestSpenders.add(new CustomerSpender(customerId, totalSpending));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return highestSpenders;
    }
}
