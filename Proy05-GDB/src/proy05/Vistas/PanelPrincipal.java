package proy05.Vistas;

import java.awt.Image;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;


import proy05.Modelo.ConexionBD;
import proy05.Modelo.modeloGDB;

public class PanelPrincipal extends JPanel {
	

	private JMenuBar menuBar;
	private JMenu mnPrincipal,mnJuegos,mnPerfil;
	private JLabel iAvatar;
	private JButton btnJuegos,btnPerfil;
	private JToggleButton tglbtnLogin,tglbtnRegistrarse;
	private JPasswordField passwordField;
	private JMenuItem mntmPrincipal,mntmJuegos,mntmPerfil;
	private JComboBox comboBox;
	private JLabel lblUsuario,lblPass;
	/**
	 * CONSTRUCTOR DEL JPANEL PRINCIPAL
	 */
	public PanelPrincipal() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		inicializarElementos();
		
	}
	
	private void inicializarElementos(){
		Image imgAvatar = new ImageIcon(this.getClass().getResource("/facebookAvatar.jpg")).getImage();
		iAvatar = new JLabel("");
		iAvatar.setBounds(25, 46, 150, 171);
		iAvatar.setIcon(new ImageIcon(imgAvatar));
		add(iAvatar);
		
		/*////////////////////////////////////
		 * 				LABELS
		 *///////////////////////////////////
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(25, 238, 69, 14);
		add(lblUsuario);
		
		lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(25, 272, 79, 14);
		add(lblPass);
		
		/*////////////////////////////////////
		 * 				MENÚ
		 *///////////////////////////////////
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 480, 21);
		add(menuBar);
		
		mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		mntmPrincipal = new JMenuItem("Principal");
		mnPrincipal.add(mntmPrincipal);
		
		mnJuegos = new JMenu("Juegos");
		menuBar.add(mnJuegos);
		
		mntmJuegos = new JMenuItem("Juegos");
		mnJuegos.add(mntmJuegos);
		
		mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		mntmPerfil = new JMenuItem("Perfil");
		mnPerfil.add(mntmPerfil);
		
		/*////////////////////////////////////
		 * 				BOTONES
		 *///////////////////////////////////
		
		btnJuegos = new JButton("Juegos        >");
		btnJuegos.setBounds(214, 57, 173, 23);
		add(btnJuegos);
		
		btnPerfil = new JButton("Perfil           >");
		btnPerfil.setBounds(214, 91, 173, 23);
		add(btnPerfil);
		
		tglbtnLogin = new JToggleButton("Login");
		tglbtnLogin.setEnabled(false);
		tglbtnLogin.setBounds(38, 308, 121, 23);
		add(tglbtnLogin);
		
		tglbtnRegistrarse = new JToggleButton("Registrarse");
		tglbtnRegistrarse.setEnabled(false);
		tglbtnRegistrarse.setBounds(38, 345, 121, 23);
		add(tglbtnRegistrarse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 269, 106, 20);
		add(passwordField);
		
		/*////////////////////////////////////
		 * 				COMBOBOX
		 *///////////////////////////////////
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(104, 235, 106, 20);
		llenarUsuarios();
		add(comboBox);
		
	}
	
	public void llenarUsuarios(){
		ConexionBD cBD;
		modeloGDB mGDB;
		cBD = ConexionBD.getInstance("localhost","proy06","root","tonphp");
		mGDB=new modeloGDB((com.mysql.jdbc.Connection) cBD.getConexion());
		Iterator<String> it= mGDB.getUsuarios().iterator();
		while(it.hasNext()){
			comboBox.addItem((String)it.next());
			}
			
			
	
	}
}
