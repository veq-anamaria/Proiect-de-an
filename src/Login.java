import com.company.Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JDialog {
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btcOK;
    private JButton btnCancel;
    private JPanel loginPanel;

    private static Login instance;

    private static Login getInstance(){
        if(instance==null){
            instance= new Login(null);
        }
        return instance;
    }

    public Login(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setSize(new Dimension(450,474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        btcOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email=tfEmail.getText();
                String password= String.valueOf(pfPassword.getPassword());

                user=getAuthentificatedUser(email, password);

                if(user !=null){
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(Login.this,
                            "Email or password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public User user;
    private User getAuthentificatedUser(String email, String password){
        User user= null;

        final String DB_URL="jdbc:mysql://localhost/MyLogin?serverTimezone=UTC";
        final String USERNAME="root";
        final String PASSWORD="";

        try{
            Connection conn= DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt= conn.createStatement();
            String sql= "SELECT*FROM users WHERE email=? AND  password=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2,password);

            ResultSet resultSet= preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.name= resultSet.getString("name");
                user.email= resultSet.getString("email");
                user.phone= resultSet.getString("phone");
                user.address= resultSet.getString("address");
                user.password= resultSet.getString("password");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        Login login= Login.getInstance();
        User user= login.user;
        if(user!=null){
            Quiz quiz=new Quiz();
            System.out.println("Successful");
        }
        else{
            System.out.println("Authentication canceled");
        }
    }
}
