package proy05.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaApp extends JFrame {

	private JPanel contentPane;
	private PanelPrincipal pP;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaApp() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 503, 438);
		pP = new PanelPrincipal();
		this.setContentPane(pP);
	}
}
