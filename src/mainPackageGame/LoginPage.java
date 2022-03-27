package mainPackageGame;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import static mainPackageGame.extras.Fonts.*;
import static mainPackageGame.extras.ConnectionAndSQLInteractions.*;

public class LoginPage extends JFrame {

    private final JPanel contentPane;
    private final JTextField textFieldUser;
    private final JPasswordField textFieldPassword;
    private String user;
    private String userPassword;


    public LoginPage() {
        Connection connection = getConnection("jueguitopruebas","root","");

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450);
        setLocation(700,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelUser = new JLabel("User");
        labelUser.setForeground(Color.WHITE);
        labelUser.setFont(getFontBySize(20));
        labelUser.setBounds(65, 67, 61, 36);
        contentPane.add(labelUser);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setForeground(Color.WHITE);
        labelPassword.setFont(getFontBySize(20));
        labelPassword.setBounds(27, 184, 99, 36);
        contentPane.add(labelPassword);

        textFieldUser = new JTextField();
        textFieldUser.setFont(getFontBySize(17));
        textFieldUser.setBounds(125, 55, 410, 64);
        contentPane.add(textFieldUser);
        textFieldUser.setColumns(10);

        textFieldPassword = new JPasswordField();
        textFieldPassword.setFont(getFontBySize(17));
        textFieldPassword.setBounds(125, 172, 410, 64);
        contentPane.add(textFieldPassword);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    user = textFieldUser.getText();
                    userPassword = textFieldPassword.getText();

                    //Statement stm = connection.createStatement();
                    String sql = "SELECT * FROM userslogin WHERE name='"+user+"' AND password='"+userPassword+"'";
                    ResultSet rs = getResultSetFromStatement(sql,connection);

                    if (rs.next()) {
                        System.out.println("Se ha hecho login el usuario "+user);
                        dispose();  // close login page

                        HomePage hpage = new HomePage(connection,user);
                        hpage.show();

                    } else {
                        //si usuario y contraseña están mal
                        JOptionPane.showMessageDialog(null, "Username or password wrong");

                        textFieldPassword.setText("");
                        textFieldUser.setText("");

                    }


                } catch (Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        buttonLogin.setFont(getFontBySize(20));
        buttonLogin.setBounds(45, 266, 206, 64);
        contentPane.add(buttonLogin);

        JButton buttonCreateUser = new JButton("Create user");
        buttonCreateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateUserPage createUserPage = new CreateUserPage(connection);
                createUserPage.show();
                dispose();

            }
        });
        buttonCreateUser.setFont(getFontBySize(20));
        buttonCreateUser.setBounds(329, 266, 206, 64);
        contentPane.add(buttonCreateUser);

        JButton buttonResetData = new JButton("Reset data");
        buttonResetData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldPassword.setText("");
                textFieldUser.setText("");
            }
        });
        buttonResetData.setFont(getFontBySize(20));
        buttonResetData.setBounds(186, 341, 206, 64);
        contentPane.add(buttonResetData);

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(CollectionPage.class.getResource("/mainPackageGame/images/chinpokomonBackground.jpg")));        labelBackground.setBounds(-25, 0, 655, 420);
        labelBackground.setBounds(-25, 0, 655, 420);
        contentPane.add(labelBackground);
    }

    public static Connection getConnection(String database, String usernameDatabase, String passwordUsernameDatabase){
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?useSSL=false",usernameDatabase,passwordUsernameDatabase);

        }  catch (Exception e1){
            System.out.println(e1.getMessage());
        }

        return con;
    }
}