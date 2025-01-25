package PS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertionPS {
    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/jdbcps";
        String root = "root";
        String password = "@M.S._Magar7";
        String query = "Insert into JDBC(id, name, address) values (?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, root, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"Em Esh");
            preparedStatement.setString(3,"Goldhunga");

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
