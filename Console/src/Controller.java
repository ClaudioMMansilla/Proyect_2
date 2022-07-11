import java.util.Scanner;

public class Controller {

	public static int menuPrincipal() {
		
		int opcion = 0;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("********** Menu de Opciones **********\n\n"); 	
		System.out.println("1: Consultar envasado sin ingreso al stock");
		System.out.println("2: Ingreso | Egreso de mercadería");
		System.out.println("3: Dar alta un producto en Base de Datos");       	
		System.out.println("4: Eliminar producto en Base de Datos");          	
		System.out.println("99: Salir del sistema \n");
		opcion = sc.nextInt();    
		
		return opcion;
	
	}
	
	
	public static int menuUpdateInput() {
		
		int opcion = 0;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("********** Seleccione el campo a modificar **********\n\n"); 	
		System.out.println("1: Modificar producto");
		System.out.println("2: Modificar cantidad");       	
		System.out.println("3: Volver al menu anterior\n");
		opcion = sc.nextInt();    
		
		return opcion;
	}

}
