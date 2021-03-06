import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class PrintInputs {

	public static boolean selectbd() throws SQLException, IOException{
		
		boolean retorno = false;
		String query = "SELECT * FROM pruebas_2022.test_inputsbudines where flagDisponible=1 ";
		
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.Conectar();
			stm = cn.createStatement();

	        int num =0;
			rs = stm.executeQuery(query);	
            rs.next();
  
			System.out.println("******************************************* Detalle de envasado pendiente autorizacion *******************************************\n");
			while(rs.next())
			{
	            num = rs.getInt("numPallet");
	            String fecha = rs.getString("fechaIngreso");
	            String cajas = rs.getString("cajasInformadas");
	            int id = rs.getInt("idProducto");
				String producto = rs.getString("producto");

				System.out.println("Pallet: "+num+"    ID: "+id+"    Cajas: "+cajas+"       fecha env: "+fecha+"    "+producto+" ");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
			}

			// invoco la funcion para realizar update sobre el id ingresado
			//UpdateInput.updatebd();
			
		} catch (SQLException e) {
			System.out.println(e);
		} 
		
		finally {
			
//			try {
//				
//				if (rs!= null) {
//					rs.close();
//				}
//
//				if (stm != null) {
//					stm.close();
//				}
//
//				if (cn != null) {
//					cn.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//				System.out.println(e2);
//			}
			
			retorno = true;
		}
		
		return retorno;
	}
}