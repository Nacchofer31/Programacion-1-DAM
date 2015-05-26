package Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Modelo.modeloDelincuentes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class PrincipalPane extends JPanel {
	private JPasswordField passwordField;
	JButton btnLogIn = new JButton("Log In");
	private modeloDelincuentes mDelincuentes;
	
	

	/**
	 * Create the panel.
	 */
	public PrincipalPane(modeloDelincuentes mDelincuentes) {
		setLayout(null);
		setBounds(0,0,700, 600);
		this.mDelincuentes=mDelincuentes;
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(61, 121, 200, 36);
		Iterator<String> it= mDelincuentes.getUsuarios().iterator();
		while(it.hasNext()){
			comboBox.addItem((String)it.next());
			}
		add(comboBox);
		
	}
}
