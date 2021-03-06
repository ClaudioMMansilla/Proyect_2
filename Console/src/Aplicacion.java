import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;



public class Aplicacion {
	public static void main(String[] args) throws SQLException, IOException {

		int opcion = 0;
		boolean retorno = false;
		int retornoAux = -1;
		String eleccion = null;

//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		
		System.out.println("Bienvenido, \n");
		do {

			switch (Controller.menuPrincipal()) 
			{
			
			case 1: // consultar stock
				do {
				if(PrintInputs.selectbd()) // listar todos los ingresos, if flag 1
				{
					if(selectInputUser.selectbd()) // listar detalle del ingreso seleccionado
					{
						switch(Controller.menuUpdateInput()) // seleccionar update, producto o cantidad
						{
						case 1:
							retornoAux = UpdateInput.updatebd();
							UpdateInput.ejecutarUpdateId(retornoAux);
							break;
						
//						case 2:
//							break;
						}
					}

					System.out.println("\n?Quiere repetir la consulta? s|n\n");
					eleccion = br.readLine();
				} 
				else {
					System.out.println("Ocurrio un error, operaci?n no realizada\n");
				}


				}while ( eleccion.equals("s") || eleccion.equals("S") ); 
				retorno = false;
				break;

			case 2: 
			do {
				System.out.println("Cargando m?dulo, aguarda por favor");
				//					UPDATEtest.uptadebd();
				System.out.println("Actualizacion ejecutada");
				System.out.println("------------------------------------------ \n");  	
				System.out.println("Quieres ingresar otro producto? s|n");
				eleccion = br.readLine(); 
				
				}while (eleccion.equals("s")); 
				System.out.println("Actualizacion finalizada"); 
				break;

			case 3: 	
			do  {
				System.out.println("Cargando m?dulo, aguarda por favor");
				//		          	INSERT_test.insertbd();
				System.out.println("Alta ejecutada");
				System.out.println("------------------------------------------ \n");  
				System.out.println("Quieres ingresar nueva Alta? s|n");
				eleccion = br.readLine(); 
				}while (eleccion.equals("s")); 
				
				System.out.println("Alta de producto finalizada");
				break;

			case 4: 
			do  {			
				System.out.println("Cargando m?dulo, aguarda por favor");
				System.out.println("ATENCION, UD. ESTA POR ELIMINAR UN PRODUCTO DE LA BASE DE DATOS EN FORMA DEFINITIVA");
				//		          	DELETEtest.deletebd();
				System.out.println("Baja ejecutada");
				System.out.println("------------------------------------------ \n");  
				System.out.println("Desea repetir la consulta? s|n");
				eleccion = br.readLine(); 

				}while (eleccion.equals("s")); 
			
			
			case 99:
				opcion = 99;
				break;
			
			}

		}while (opcion != 99);     
//		sc.close();
	} 
}
