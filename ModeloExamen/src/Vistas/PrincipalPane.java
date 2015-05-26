package Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalPane extends JPanel {
	private JPasswordField passwordField;
	JButton btnLogIn = new JButton("Log In");

	/**
	 * Create the panel.
	 */
	public PrincipalPane() {
		setLayout(null);
		setBounds(0,0,700, 600);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(61, 121, 200, 36);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Log In:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(61, 59, 186, 36);
		add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(61, 179, 200, 36);
		add(passwordField);
		
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogIn.setBounds(61, 375, 200, 36);
		add(btnLogIn);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(61, 433, 200, 36);
		add(btnLogOut);
		
	}
}
