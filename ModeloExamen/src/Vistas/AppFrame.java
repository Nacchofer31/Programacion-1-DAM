package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.mysql.jdbc.Connection;

import Modelo.ConexionBD;
import Modelo.modeloDelincuentes;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppFrame extends JFrame {
	private JPanel contentPane;
	PrincipalPane pP;
	DelincuentesPane dP;
	modeloDelincuentes mDelincuentes;
	ConexionBD cBD;

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setBounds(100, 100, 700, 600);
		contentPane.setLayout(new CardLayout(0, 0));
		
		cBD = ConexionBD.getInstance("localhost","delincuentes","root","tonphp");
		mDelincuentes = new modeloDelincuentes((Connection) cBD.getConexion());
		
		pP= new PrincipalPane();
		dP = new DelincuentesPane(mDelincuentes);
		
		
		contentPane.add(pP, "PrincipalPane");
		pP.setLayout(null);
		
		contentPane.add(dP, "DelincuentesPane");
		dP.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c= (CardLayout)contentPane.getLayout();
				c.show(contentPane, "PrincipalPane");
			}
		});
		mnPrincipal.add(mntmPrincipal);
		
		JMenu mnDelincuentes = new JMenu("Delincuentes");
		menuBar.add(mnDelincuentes);
		
		JMenuItem mntmDelincuentes = new JMenuItem("Delincuentes");
		mntmDelincuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c= (CardLayout)contentPane.getLayout();
				c.show(contentPane, "DelincuentesPane");
			}
		});
		mnDelincuentes.add(mntmDelincuentes);
		
		
		setContentPane(contentPane);		
	}
}
