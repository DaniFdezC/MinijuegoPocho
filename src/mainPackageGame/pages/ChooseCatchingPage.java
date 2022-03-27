package mainPackageGame.pages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.sql.Connection;

public class ChooseCatchingPage extends JFrame {

    private JPanel contentPane;

    public ChooseCatchingPage(Connection connection) {

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLocation(550,200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton buttonImaginationland = new JButton("");
        buttonImaginationland.setIcon(new ImageIcon(ChooseCatchingPage.class.getResource("/mainPackageGame/images/directions/imaginationLand.jpg")));
        buttonImaginationland.setBounds(0, 0, 800, 200);
        contentPane.add(buttonImaginationland);

        JButton buttonCasaBonita = new JButton("");
        buttonCasaBonita.setIcon(new ImageIcon(ChooseCatchingPage.class.getResource("/mainPackageGame/images/directions/casaBonita.jpg")));
        buttonCasaBonita.setBounds(0, 200, 800, 200);
        contentPane.add(buttonCasaBonita);

        JButton buttonCanada = new JButton("");
        buttonCanada.setIcon(new ImageIcon(ChooseCatchingPage.class.getResource("/mainPackageGame/images/directions/canada.jpg")));
        buttonCanada.setBounds(0, 400, 800, 200);
        contentPane.add(buttonCanada);
    }
}
