package proy05.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class modeloGDB {

	private static String NOMBRE_COL="nombre";
	private static String APELLIDOS_COL="apellidos";
	private static String JUEGO_COL="jPreferido";
	
	private static String COLUMNAS[]={NOMBRE_COL,APELLIDOS_COL,JUEGO_COL};
	
	ArrayList<String> usuarios = null;
	
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	Connection conexion =null;
	
	public modeloGDB(Connection conexion) {
		this.conexion=conexion;
		usuarios = new ArrayList<String>();
	}

	public void getDatosJugadores(){
		try{
			instruccion = (Statement) this.conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM jugadores");
			
			while(conjuntoResultados.next()){
				System.out.print(conjuntoResultados.getString(NOMBRE_COL)+";");
				System.out.print(conjuntoResultados.getString(APELLIDOS_COL)+";");
				System.out.println(conjuntoResultados.getString(JUEGO_COL));
				
			}
			
		}catch ( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
			}
	}
	
	public ArrayList getUsuarios(){
		try{
		instruccion = (Statement) this.conexion.createStatement();
		conjuntoResultados = instruccion.executeQuery("SELECT * FROM jugadores");
		while(conjuntoResultados.next()){
			usuarios.add(conjuntoResultados.getString(NOMBRE_COL));
		}
		return usuarios;
		
		}catch ( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
			return usuarios;
			}finally{
				try{
					conjuntoResultados.close();
					instruccion.close();
				}catch ( SQLException excepcionSql ){
					excepcionSql.printStackTrace();
					}
			}
		
	}

}
