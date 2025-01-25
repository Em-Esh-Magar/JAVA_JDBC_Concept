import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class SwingWithDatabase extends JFrame{
    JLabel label1, label2;
    JTextField textField1, textField2;
    JButton button;
    public SwingWithDatabase(){
        this.setTitle("Demo Project");
        this.setLayout(new FlowLayout());

        label1 = new JLabel("Name ");
        label2 = new JLabel("Age");

        textField1 = new JTextField(20);
        textField2 = new JTextField(10);

        button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WriteData();
            }
        });

        this.add(label1);
        this.add(textField1);
        this.add(label2);
        this.add(textField2);
        this.add(button);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setVisible(true);
    }

    private void WriteData(){
        String name = String.valueOf(textField1.getText());
        int age = Integer.valueOf(textField2.getText());

        String url = "jdbc:mysql://localhost:3306/TryDemo";
        String username = "root";
        String password = "@M.S._Magar7";
        String query = "Insert into Try value(?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            int x = preparedStatement.executeUpdate();
            if(x>0){
                System.out.println("Success");
            }
            else{
                System.out.println("Failed");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SwingWithDatabase();
    }
}