package JDBC_PROGRAM;

import java.sql.*;
import java.io.*;

public class DisplayDataJDBC {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String root = "root";
        String password = "@M.S._Magar7";
        String querry = "Select * from jdbctable";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, root, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(querry);

            int i = 1;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");

                System.out.println("Data "+i+": ");
                System.out.println("id : "+id);
                System.out.println("Name : "+name);
                System.out.println("Address : "+address);

                System.out.println();
                i = i+1;
            }

            connection.close();
            statement.close();
            resultSet.close();

        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
