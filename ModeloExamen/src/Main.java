

import Modelo.ConexionBD;
import Vistas.AppFrame;
public class Main {
	
	public static void main(String[] args) {
		ConexionBD cBD;
		
		cBD = ConexionBD.getInstance("localhost","delincuentes","root","tonphp");
		if(cBD.connectBD()==true){
			System.out.println("CONECTADOS CON ÉXITO");	
			AppFrame frame = new AppFrame();
			frame.setVisible(true);
		}
		
	}

}
