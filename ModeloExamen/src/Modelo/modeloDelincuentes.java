package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class modeloDelincuentes {
	
	private static String ID_DEL="id";
	private static String NOMBRE_DEL="nombre";
	private static String EDAD_DEL="edad";
	private static String SEXO_DEL="sexo";
	private static String NAC_DEL="nacionalidad";
	private static String DIR_DEL="direccion";
	private static String POB_DEL="poblacion";
	private static String ANT_DEL="antecedentes";
	
	private static String NOMBRE_US="usuario";
	
	
	Statement instruccion = null;
	ResultSet conjuntoResultados = null;
	Connection conexion =null;
	
	public modeloDelincuentes(Connection conexion){
		this.conexion=conexion;
	}
	
	/**MÉTODO QUE GENERA UN ARRAY LIST CON LOS DATOS DE LOS DELINCUENTES**/
	public ArrayList<String[]> getDelincuentes(String nombreDelincuente){
		//Generamos el array que utilizaremos para guardar los datos.
		ArrayList<String[]> usuarios=new ArrayList<String[]>();
		try{
		//Crea una instrucción para realizar una consulta a la base de datos que nos devuelvan los datos que necesitamos	
		instruccion = (Statement) this.conexion.createStatement();
		conjuntoResultados = instruccion.executeQuery("SELECT * FROM delincuentes WHERE nombre= '"+nombreDelincuente+"'");
		//Recorremomos las filas de la base de datos para almacenarlos datos en arrays de 7 Strings. 
		while(conjuntoResultados.next()){
			String[] delincuente=new String[7];
			System.out.print(conjuntoResultados.getString(NOMBRE_DEL)+";");
			delincuente[0]=conjuntoResultados.getString(NOMBRE_DEL);
			System.out.print(conjuntoResultados.getString(EDAD_DEL)+";");
			delincuente[1]=conjuntoResultados.getString(EDAD_DEL);
			System.out.print(conjuntoResultados.getString(SEXO_DEL)+";");
			delincuente[2]=conjuntoResultados.getString(SEXO_DEL);
			System.out.print(conjuntoResultados.getString(NAC_DEL)+";");
			delincuente[3]=conjuntoResultados.getString(NAC_DEL);
			System.out.print(conjuntoResultados.getString(DIR_DEL)+";");
			delincuente[4]=conjuntoResultados.getString(DIR_DEL);
			System.out.print(conjuntoResultados.getString(POB_DEL)+";");
			delincuente[5]=conjuntoResultados.getString(POB_DEL);
			System.out.println(conjuntoResultados.getString(ANT_DEL));
			delincuente[6]=conjuntoResultados.getString(ANT_DEL);
			usuarios.add(delincuente);
		}
		
	}catch ( SQLException excepcionSql ){
		excepcionSql.printStackTrace();
		}finally{
			//Una vez ya obtenidos los datos se cierra la instrucción.
			try{
				conjuntoResultados.close();
				instruccion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		//Devuelve el array de usuarios.
		return usuarios;
	}
	
	public ArrayList<String> getNombres(){
	
		ArrayList<String> nombres=new ArrayList<String>();
		
		try{
			//Sentencia sql
			instruccion = (Statement) this.conexion.createStatement();
			this.conjuntoResultados =instruccion.executeQuery("select nombre from delincuentes");
					
			//Recorremos los resultados y los almacenamos en un ArrayList
			while( conjuntoResultados.next() ) {
				nombres.add(conjuntoResultados.getString(NOMBRE_DEL));
			}
			
		}catch( SQLException excepcionSql ) {
			excepcionSql.printStackTrace();
		}finally{
			try{
				conjuntoResultados.close();
				instruccion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		return nombres;
	}
	
	public ArrayList<String> getUsuarios(){
		ArrayList<String> usuarios=new ArrayList<String>();
		try {
			instruccion= (Statement) this.conexion.createStatement();
			conjuntoResultados= instruccion.executeQuery("SELECT usuario FROM usuarios");
			
			while(conjuntoResultados.next()){
				usuarios.add(conjuntoResultados.getString(NOMBRE_US));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				conjuntoResultados.close();
				instruccion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		return usuarios;
	}
}
