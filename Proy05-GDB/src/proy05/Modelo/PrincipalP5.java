package proy05.Modelo;

import proy05.Vistas.VentanaApp;

public class PrincipalP5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionBD cBD;
		modeloGDB mGDB;
		//Generado el objeto
		cBD = ConexionBD.getInstance("localhost","proy06","root","tonphp");
		if(cBD.connectBD()==true){
			System.out.println("CONECTADOS CON ÉXITO");
			System.out.println("LISTADO DE JUGADORES");
			mGDB=new modeloGDB((com.mysql.jdbc.Connection) cBD.getConexion());
			mGDB.getDatosJugadores();
		}else{
			System.out.println("ERROR EN LA CONEXIÓN");
		}
		VentanaApp frame = new VentanaApp();
		frame.setVisible(true);
	} 
}
