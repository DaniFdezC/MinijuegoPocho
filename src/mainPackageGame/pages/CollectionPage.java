package mainPackageGame.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.ResultSet;

import static mainPackageGame.extras.ConnectionAndSQLInteractions.*;
import static mainPackageGame.extras.Fonts.*;

public class CollectionPage extends JFrame {

    private JPanel contentPane;

    public CollectionPage(Connection connection, String username) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLocation(550,200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelUserName = new JLabel("Hello "+username + " !");
        labelUserName.setFont(getFontBySize(20));
        labelUserName.setBounds(191, 28, 200, 47);
        contentPane.add(labelUserName);

        JLabel labelDarkType = new JLabel("Dark type");
        labelDarkType.setFont(getFontBySize(20));
        labelDarkType.setBounds(67, 109, 99, 47);
        contentPane.add(labelDarkType);

        JLabel labelHolyType = new JLabel("Holy type ");
        labelHolyType.setFont(getFontBySize(20));
        labelHolyType.setBounds(67, 156, 91, 47);
        contentPane.add(labelHolyType);

        JLabel labelWaterType = new JLabel("Water type ");
        labelWaterType.setFont(getFontBySize(20));
        labelWaterType.setBounds(67, 203, 110, 47);
        contentPane.add(labelWaterType);

        JLabel labelFireType = new JLabel("Fire type ");
        labelFireType.setFont(getFontBySize(20));
        labelFireType.setBounds(67, 250, 91, 47);
        contentPane.add(labelFireType);

        JLabel labelElectricityType = new JLabel("Electricity type");
        labelElectricityType.setFont(getFontBySize(20));
        labelElectricityType.setBounds(67, 297, 143, 47);
        contentPane.add(labelElectricityType);

        /// Labels quantity

        JLabel labelQuantDarkType = new JLabel(String.valueOf(getQuantityOfGivenType(createSQLToGetData("dark",username),connection)));
        labelQuantDarkType.setFont(getFontBySize(20));
        labelQuantDarkType.setBounds(246, 114, 91, 37);
        contentPane.add(labelQuantDarkType);

        JLabel labelQuantHolyType = new JLabel(String.valueOf(getQuantityOfGivenType(createSQLToGetData("holy",username),connection)));
        labelQuantHolyType.setFont(getFontBySize(20));
        labelQuantHolyType.setBounds(246, 161, 91, 37);
        contentPane.add(labelQuantHolyType);

        JLabel labelQuantWaterType = new JLabel(String.valueOf(getQuantityOfGivenType(createSQLToGetData("water",username),connection)));
        labelQuantWaterType.setFont(getFontBySize(20));
        labelQuantWaterType.setBounds(246, 208, 91, 37);
        contentPane.add(labelQuantWaterType);

        JLabel labelQuantFireType = new JLabel(String.valueOf(getQuantityOfGivenType(createSQLToGetData("fire",username),connection)));
        labelQuantFireType.setFont(getFontBySize(20));
        labelQuantFireType.setBounds(246, 255, 91, 37);
        contentPane.add(labelQuantFireType);

        JLabel labelQuantElectricityType = new JLabel(String.valueOf(getQuantityOfGivenType(createSQLToGetData("electricity",username),connection)));
        labelQuantElectricityType.setFont(getFontBySize(20));
        labelQuantElectricityType.setBounds(246, 302, 91, 37);
        contentPane.add(labelQuantElectricityType);

        JButton buttonHomePage = new JButton("Home page");
        buttonHomePage.addActionListener(e -> {
            try {
                dispose();

                HomePage hpage = new HomePage(connection,username);

                hpage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonHomePage.setFont(getFontBySize(20));
        buttonHomePage.setBounds(404, 357, 170, 43);
        contentPane.add(buttonHomePage);

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(LoginPage.class.getResource("/mainPackageGame/images/chinpokomonBackground.jpg")));
        labelBackground.setBounds(-106, -97, 946, 668);
        contentPane.add(labelBackground);

    }


    public String createSQLToGetData (String type, String username){
        return "SELECT quantity FROM "+type+"type WHERE username="+'"'+username+'"';
    }

    public int getQuantityOfGivenType(String sql, Connection connection){
        ResultSet rs = getResultSetFromStatement(sql,connection);
        int quantity=0;

        try {
            while(rs.next()){
                quantity = rs.getInt("quantity");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return quantity;

    }
}
