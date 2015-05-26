package Modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBD {

	static final String CONTROLADOR_MYSQL="com.mysql.jdbc.Driver";
	
	//DATOS BD
	private String host;
	private String bd;
	private String usuario;
	private String pass;
	
	private Connection conexion = null; // maneja la conexión
	
	private static ConexionBD instance=null;
	
	private ConexionBD(String HOST,String BD, String USER, String PASS) {
		this.host=HOST;
		this.bd=BD;
		this.usuario=USER;
		this.pass=PASS;
	}
	public static ConexionBD getInstance(String HOST,String BD, String USER, String PASS){
		if(instance==null){
			instance=new ConexionBD(HOST,BD,USER,PASS);
		}
		return instance;
	}
	
	public boolean connectBD(){
		try{
			
			Class.forName(CONTROLADOR_MYSQL);
			conexion = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bd,this.usuario,this.pass);
			
			}catch (SQLException excepcionSql ){
				excepcionSql.printStackTrace();
				return false;
				
		}catch(ClassNotFoundException noClase){
			
			noClase.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Connection getConexion(){
		return this.conexion;
	}

}
