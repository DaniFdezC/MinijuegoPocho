package mainPackageGame.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import static mainPackageGame.extras.Fonts.*;


public class HomePage extends JFrame {

    private JPanel contentPane;

    public HomePage(Connection connection, String user) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLocation(550,200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JButton buttonCollection = new JButton("Collection");
        buttonCollection.addActionListener(e -> {
            dispose();
            CollectionPage collPage = new CollectionPage(connection,user);
            collPage.show();
        });
        buttonCollection.setFont(getFontBySize(23));
        buttonCollection.setBounds(200, 40, 400, 60);
        contentPane.add(buttonCollection);

        JButton buttonCatch = new JButton("Catch");
        buttonCatch.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                ChooseCatchingPage catchingPage = new ChooseCatchingPage(connection);

                catchingPage.show();


            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonCatch.setFont(getFontBySize(23));
        buttonCatch.setBounds(200, 120, 400, 60);
        contentPane.add(buttonCatch);

        JButton buttonExtraThingToAdd = new JButton("AnotherThingToAdd");
        buttonExtraThingToAdd.setFont(getFontBySize(23));
        buttonExtraThingToAdd.setBounds(200, 280, 400, 60);
        contentPane.add(buttonExtraThingToAdd);

        JButton buttonItems = new JButton("Items");
        buttonItems.setFont(getFontBySize(23));
        buttonItems.setBounds(200, 200, 400, 60);
        contentPane.add(buttonItems);

        JButton buttonLogout = new JButton("Logout");
        buttonLogout.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                LoginPage logingPage = new LoginPage();

                logingPage.show();

                connection.close();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonLogout.setFont(getFontBySize(16));
        buttonLogout.setBounds(690, 520, 100, 40);
        contentPane.add(buttonLogout);

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(LoginPage.class.getResource("/mainPackageGame/images/chinpokomonBackground.jpg")));
        labelBackground.setBounds(-106, -97, 946, 668);
        contentPane.add(labelBackground);
    }

}
