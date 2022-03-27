package mainPackageGame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import static mainPackageGame.extras.ConnectionAndSQLInteractions.*;
import static mainPackageGame.extras.Fonts.*;

public class CreateUserPage extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldUser;
    private JPasswordField textFieldPassword;


    public CreateUserPage(Connection connection) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450);
        setLocation(700,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelUser = new JLabel("User");
        labelUser.setFont(getFontBySize(20));
        labelUser.setBounds(65, 67, 61, 36);
        contentPane.add(labelUser);

        JLabel labelPassword = new JLabel("Password");
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

        JButton buttonCreateUser = new JButton("CreateUser");
        buttonCreateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String usernameToCompareFromDatabase = textFieldUser.getText();
                    String passwordToCompareFromDatabase = textFieldPassword.getText();

                    String sql = "SELECT * FROM userslogin WHERE name='"+usernameToCompareFromDatabase+"'";
                    ResultSet rs = getResultSetFromStatement(sql, connection);

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Username already existing");

                        textFieldPassword.setText("");
                        textFieldUser.setText("");

                    } else {
                        String createUser = "" +
                                "CALL createUserAndSetTo0Types("+
                                '"'+textFieldUser.getText()+'"'+","+
                                '"'+textFieldPassword.getText()+'"'+
                                ")";


                        insertUsersStatement(createUser, connection);

                        JOptionPane.showMessageDialog(null, "Username created");

                        dispose();

                        LoginPage loginPage = new LoginPage();
                        loginPage.show();
                    }


                } catch (Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        buttonCreateUser.setFont(getFontBySize(20));
        buttonCreateUser.setBounds(45, 266, 206, 64);
        contentPane.add(buttonCreateUser);

        JButton buttonResetData = new JButton("Reset data");
        buttonResetData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldPassword.setText("");
                textFieldUser.setText("");
            }
        });
        buttonResetData.setFont(getFontBySize(20));
        buttonResetData.setBounds(329, 266, 206, 64);
        contentPane.add(buttonResetData);

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(CollectionPage.class.getResource("/mainPackageGame/images/chinpokomonBackground.jpg")));        labelBackground.setBounds(-25, 0, 655, 420);
        labelBackground.setBounds(-25, 0, 655, 420);
        contentPane.add(labelBackground);
    }

}