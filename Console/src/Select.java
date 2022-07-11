import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	//	public static void consultabd() {
	public static boolean consultabd() throws IOException {

		boolean retorno = false;
		String query = "SELECT * FROM pruebas_2022.productos where familiaProducto = 3";

		//		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = Conexion.Conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(query);
//			System.out.println("Inventario actual de los productos");

			System.out.println("********************* Detalle completo de inventario **********************\n");
			while(rs.next()) {
				int IdProducto = rs.getInt("idProducto");
				String producto = rs.getString("producto");
				int stock = rs.getInt("stock");

				System.out.println("ID: "+IdProducto+"    Stock: "+stock+"    "+producto+" ");
				System.out.println("---------------------------------------------------------------------------");
			}

			retorno = true;

		} catch (SQLException e) {
		} finally {
			try {
				if (rs!= null) {
					rs.close();
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
}
