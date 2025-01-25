package PS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePS {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/jdbcps";
        String root = "root";
        String password = "@M.S._Magar7";
        String query = "Update JDBC set name = ? where id = ?";

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,root,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"John");
            preparedStatement.setInt(2,1);
            int x = preparedStatement.executeUpdate();

            if(x>0){
                System.out.println("Success");
            }else{
                System.out.println("Failed");
            }

            connection.close();
            preparedStatement.close();

        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
