package mainPackageGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

public class ChooseCatchingPage extends JFrame {

	private JPanel contentPane;
	private final JButton buttonGoToMountains = new JButton("");

	public ChooseCatchingPage(Connection connection) {
		
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 450);
        setLocation(700,300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        buttonGoToMountains.setIcon(new ImageIcon(ChooseCatchingPage.class.getResource("/mainPackageGame/images/directions/goToMountain.jpg")));
        buttonGoToMountains.setBounds(0, 0, 594, 178);
        contentPane.add(buttonGoToMountains);
        
        JButton buttonGoToSea = new JButton("");
        buttonGoToSea.setIcon(new ImageIcon(ChooseCatchingPage.class.getResource("/mainPackageGame/images/directions/goToBeach.png")));
        buttonGoToSea.setBounds(0, 178, 302, 243);
        contentPane.add(buttonGoToSea);
        
        JButton buttonGoToCave = new JButton("");
        buttonGoToCave.setIcon(new ImageIcon(ChooseCatchingPage.class.getResource("/mainPackageGame/images/directions/goToTheCave.jpg")));
        buttonGoToCave.setBounds(302, 178, 292, 243);
        contentPane.add(buttonGoToCave);
	}	
}
