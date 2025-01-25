package JDBC_PROGRAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDataJDBC {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String password = "@M.S._Magar7";
        String root = "root";
        String query = "Delete from JDBCTABLE where id = 10";

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, root, password);
            Statement statement = connection.createStatement();
            int x = statement.executeUpdate(query);

            if(x>0){
                System.out.println("Success");
            }else{
                System.out.println("Failed");
            }

            connection.close();
            statement.close();

        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
