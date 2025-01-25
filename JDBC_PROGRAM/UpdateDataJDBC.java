package JDBC_PROGRAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Stack;

public class UpdateDataJDBC {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String password = "@M.S._Magar7";
        String root = "root";
        String query = "Update JDBCTABLE set name = 'Raju' where name = 'Kale' ";

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, root, password);
            Statement statement = connection.createStatement();
            int x = statement.executeUpdate(query);

            if(x>0){
                System.out.println("Successfull");
            }
            else{
                System.out.println("Failed");
            }

            connection.close();
            statement.close();
        }

        catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
