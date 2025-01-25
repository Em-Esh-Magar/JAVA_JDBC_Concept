package JDBC_PROGRAM;

import java.sql.*;

public class InsertUsingStatement {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/JDBC";
        String username = "root";
        String password = "@M.S._Magar7";
        String query = "INSERT INTO JDBCTABLE(id, name, address)VALUES(5,'Raju','Kamalpokhari')";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            int x = statement.executeUpdate(query);

            if(x>0){
                System.out.println("Insertion Success full");
            }
            else{
                System.out.println("Insertion Failed");
            }

            connection.close();
            statement.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
