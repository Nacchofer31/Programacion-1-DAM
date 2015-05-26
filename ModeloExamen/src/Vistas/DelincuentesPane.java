package Vistas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modelo.modeloDelincuentes;

public class DelincuentesPane extends JPanel {
	JPanel infoDel,anteDel,Del;
	private JButton btnVolver;
	private JButton btnSalvar;
	private JTextField textFieldNombre;
	private JTextField textFieldNacionalidad;
	private JTextField textFieldEdad;
	private JTextField textFieldSexo;
	private JTextField textFieldDireccion;
	private JTextField textFieldPoblacion;
	private modeloDelincuentes mDelincuentes;
	private Iterator<String[]> infodelincuentes;
	private String[] delincuente;
	
	/**
	 * Create the panel.
	 */
	public DelincuentesPane(modeloDelincuentes mDelincuentes) {
		setBounds(0,0,700, 600);
		setLayout(null);
		this.mDelincuentes=mDelincuentes;
		Del= new JPanel();
		Del.setBounds(10, 0, 640, 556);
		this.add(Del);
		Del.setLayout(new CardLayout(0, 0));
		infoDel= new JPanel();
		Del.add(infoDel, "infoDel");
		infoDel.setLayout(null);
		
		anteDel=new JPanel();
		Del.add(anteDel, "anteDel");
		anteDel.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c= (CardLayout)Del.getLayout();
				c.show(Del, "infoDel");
			}
		});
		btnVolver.setBounds(52, 486, 89, 23);
		anteDel.add(btnVolver);
		
		btnSalvar = new JButton("Salvar               >>");
		btnSalvar.setBounds(364, 486, 229, 23);
		anteDel.add(btnSalvar);
		
		definirInfoDel();
	
	}
	public void definirInfoDel(){
		
		JLabel lblNombre = new JLabel("Nombre:   ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(323, 66, 75, 29);
		infoDel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(391, 68, 182, 29);
		infoDel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:   ");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEdad.setBounds(323, 122, 75, 29);
		infoDel.add(lblEdad);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad: ");
		lblNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNacionalidad.setBounds(323, 177, 103, 29);
		infoDel.add(lblNacionalidad);
		
		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setColumns(10);
		textFieldNacionalidad.setBounds(414, 177, 182, 29);
		infoDel.add(textFieldNacionalidad);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(367, 119, 59, 29);
		infoDel.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setColumns(10);
		textFieldSexo.setBounds(496, 119, 59, 29);
		infoDel.add(textFieldSexo);
		
		JLabel lblSexo = new JLabel("Sexo:   ");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSexo.setBounds(452, 122, 75, 29);
		infoDel.add(lblSexo);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n: ");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDireccion.setBounds(323, 229, 103, 29);
		infoDel.add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(414, 229, 182, 29);
		infoDel.add(textFieldDireccion);
		
		JLabel lblPoblacion = new JLabel("Poblacion:");
		lblPoblacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPoblacion.setBounds(323, 281, 103, 29);
		infoDel.add(lblPoblacion);
		
		textFieldPoblacion = new JTextField();
		textFieldPoblacion.setColumns(10);
		textFieldPoblacion.setBounds(414, 281, 182, 29);
		infoDel.add(textFieldPoblacion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 52, 251, 387);
		infoDel.add(scrollPane);
		
		String[] delincuentesnombres=mDelincuentes.getNombres().toArray(new String[mDelincuentes.getNombres().size()]);
		JList list = new JList(delincuentesnombres);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(list.getSelectedValue());
				infodelincuentes = mDelincuentes.getDelincuentes((String) list.getSelectedValue()).iterator();
				while(infodelincuentes.hasNext()){
					delincuente=infodelincuentes.next();
					textFieldNombre.setText(delincuente[0]);
					textFieldEdad.setText(delincuente[1]);
					textFieldSexo.setText(delincuente[2]);
					textFieldNacionalidad.setText(delincuente[3]);
					textFieldDireccion.setText(delincuente[4]);
					textFieldPoblacion.setText(delincuente[5]);
				}
				
			}
		});
		scrollPane.setViewportView(list);
		
		JButton antebtn = new JButton("Antecedentes                >>");
		antebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c= (CardLayout)Del.getLayout();
				c.show(Del, "anteDel");
			}
		});
		antebtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		antebtn.setBounds(343, 470, 278, 29);
		infoDel.add(antebtn);
	}
}
