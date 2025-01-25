package PS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayDataPS {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/jdbcps";
        String root = "root";
        String password = "@M.S._Magar7";
        String query = "Select * from jdbc where id = ?";

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,root,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");

                System.out.println("Id : "+id);
                System.out.println("Name : "+name);
                System.out.println("Address : "+address);
            }

            connection.close();
            preparedStatement.close();
            resultSet.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
