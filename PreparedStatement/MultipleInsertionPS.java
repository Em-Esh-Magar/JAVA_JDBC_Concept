package PS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MultipleInsertionPS {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/jdbcps";
        String root = "root";
        String password = "@M.S._Magar7";
        String query = "INSERT INTO JDBC(id, name, address) VALUES (?, ?, ?)";

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, root, password);

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Turn off auto-commit for batch processing
            connection.setAutoCommit(false);

            // Add multiple entries to the batch
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "John Doe");
            preparedStatement.setString(3, "Kathmandu");
            preparedStatement.addBatch(); // Add first record to the batch

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Jane Smith");
            preparedStatement.setString(3, "Pokhara");
            preparedStatement.addBatch(); // Add second record to the batch

            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Bob Brown");
            preparedStatement.setString(3, "Biratnagar");
            preparedStatement.addBatch(); // Add third record to the batch

            // Execute all the queries in the batch
            int[] results = preparedStatement.executeBatch();

            // Commit the transaction
            connection.commit();

            // Print success message
            System.out.println("Inserted " + results.length + " rows successfully!");

            // Close resources
            preparedStatement.close();
            connection.close();

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
