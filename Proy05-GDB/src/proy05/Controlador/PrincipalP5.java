package proy05.Controlador;

import proy05.Modelo.ConexionBD;
import proy05.Modelo.modeloGDB;
import proy05.Vistas.VentanaApp;

public class PrincipalP5 {

	public static void main(String[] args) {
		ConexionBD cBD;
		modeloGDB mGDB;
		
		//Generado  la instrancia de la clase ConexionBD.
		cBD = ConexionBD.getInstance("localhost","proy06","root","tonphp");
		if(cBD.connectBD()==true){
			System.out.println("CONECTADOS CON ÉXITO");
			System.out.println("LISTADO DE JUGADORES");
			mGDB=new modeloGDB((com.mysql.jdbc.Connection) cBD.getConexion());
			mGDB.getDatosJugadores();
		}else{
			System.out.println("ERROR EN LA CONEXIÓN");
		}
		
		//CARGA LA PANTALLA DEL APLICATIVO
		VentanaApp frame = new VentanaApp();
		frame.setVisible(true);
	} 
}
