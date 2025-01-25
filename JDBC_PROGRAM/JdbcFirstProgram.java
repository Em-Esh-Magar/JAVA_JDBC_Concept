package JDBC_PROGRAM;

import java.sql.*;

public class JdbcFirstProgram {
    public static void main(String[] args) throws Exception{

        String url="jdbc:mysql://localhost:3306/JDBC";
        String username="root";
        String password="@M.S._Magar7";
        String query="SELECT * FROM JDBCTABLE";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Driver Loaded Successfully");

            Statement statement = connection.createStatement();
            System.out.println("Connection Established Successfully");

            ResultSet rs = statement.executeQuery(query);

            System.out.println("Output1");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");

                System.out.println();
                System.out.println("Id : "+id);
                System.out.println("Name : "+name);
                System.out.println("Address : "+address);
            }


            connection.close();
            statement.close();
            rs.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
