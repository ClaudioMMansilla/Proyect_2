import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class UpdateInput {
	
//	String tablaInput = "pruebas_2022.test_inputsbudines";
	static String tablaInput = "pruebas_2022.test_inputsbudines";
	static String tablaProductos = "pruebas_2022.test_productos";
	
	
	public static int updatebd() throws SQLException, IOException{

		int retorno = 0;

		Connection cn = null;
		Statement stm = null;
		ResultSet rs2 = null;
		Scanner sc = new Scanner(System.in);

		try {
			
			System.out.println("Introduce numero de pallet para acceder a sus datos");	
//			Scanner sc = new Scanner(System.in);
			int pallet = sc.nextInt();
			String query = "SELECT * FROM pruebas_2022.test_inputsbudines where flagDisponible=1 and numPallet ='"+pallet+"' ";
			
			cn = Conexion.Conectar();
			stm = cn.createStatement();
			rs2 = stm.executeQuery(query);	

	        System.out.flush();

			while(rs2.next()) 
			{
				System.out.println("adentro del res2.next");
				int orden = rs2.getInt("numPallet");
				String fecha = rs2.getString("fechaIngreso");
				int cajas = rs2.getInt("cajasInformadas");
				int id = rs2.getInt("idProducto");
				String producto = rs2.getString("producto");

				System.out.println("******************************************* Menu de modificación de datos *******************************************\n");
				System.out.println("Pallet: "+orden+"    ID: "+id+"    Cajas: "+cajas+"       fecha env: "+fecha+"    "+producto+" ");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------\n");
				
			}
			
			if(pallet != 0)
			{
				retorno = pallet;
				System.out.println("Num: "+pallet+" ");
//				sc.close();
			}
			

		} catch (SQLException e) {
			System.out.println(e);
			
		} finally {

			try {
				if (rs2!= null) {
					rs2.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println(e2);
			}
		}
		
		return retorno;
	}
	
	
	public static void ejecutarUpdateId(int numPallet) throws SQLException {

		Scanner sc = new Scanner(System.in);
    	Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		int idValidado = 0;
		
		System.out.println("Ingrese el id correcto\n");
		sc.nextInt(); 
		
		int rowsAffected;
		String descripcion = "";
		
   		try {
   			cn = Conexion.Conectar();
   			stm = cn.createStatement();	
   			rs = stm.executeQuery("SELECT * FROM "+tablaProductos+" where idProducto='"+idValidado+"'");
   			
			while(rs.next()) 
			{
				idValidado = rs.getInt("idProducto");
				descripcion = rs.getString("producto");
			}
			
			if(idValidado != 0)
			{
				String sql = "UPDATE "+tablaInput+" "
						+ "set idProducto = '"+idValidado+"', producto = '"+descripcion+"' where numPallet = '"+numPallet+"' ";
				
				rowsAffected = stm.executeUpdate(sql);
			}

   		}
   		catch (SQLException e){
			System.out.println(e);
		}
		
	}

}
