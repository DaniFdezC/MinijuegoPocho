package mainPackageGame;

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
        setBounds(100, 100, 600, 450);
        setLocation(700,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton buttonCollection = new JButton("Collection");
        buttonCollection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CollectionPage collPage = new CollectionPage(connection,user);
                collPage.show();
            }
        });
        buttonCollection.setFont(getFontBySize(23));
        buttonCollection.setBounds(88, 11, 406, 57);
        contentPane.add(buttonCollection);

        JButton buttonCatch = new JButton("Catch");
        buttonCatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose(); //cerrar homepage

                    ChooseCatchingPage catchingPage = new ChooseCatchingPage(connection);

                    catchingPage.show();


                } catch (Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        buttonCatch.setFont(getFontBySize(23));
        buttonCatch.setBounds(88, 89, 406, 57);
        contentPane.add(buttonCatch);

        JButton buttonEvolve = new JButton("Evolve");
        buttonEvolve.setFont(getFontBySize(23));
        buttonEvolve.setBounds(88, 245, 406, 57);
        contentPane.add(buttonEvolve);

        JButton buttonItems = new JButton("Items");
        buttonItems.setFont(getFontBySize(23));
        buttonItems.setBounds(88, 167, 406, 57);
        contentPane.add(buttonItems);

        JButton buttonLogout = new JButton("Logout");
        buttonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose(); //cerrar homepage

                    LoginPage logingPage = new LoginPage();

                    logingPage.show();

                    connection.close();

                } catch (Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        });

        buttonLogout.setFont(getFontBySize(16));
        buttonLogout.setBounds(473, 363, 101, 37);
        contentPane.add(buttonLogout);

        JLabel labelBackground = new JLabel("");
        labelBackground.setIcon(new ImageIcon(CollectionPage.class.getResource("/mainPackageGame/images/chinpokomonBackground.jpg")));        labelBackground.setBounds(-25, 0, 655, 420);
        labelBackground.setBounds(-25, 0, 655, 420);
        contentPane.add(labelBackground);
    }

}
