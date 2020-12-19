import java.util.Scanner;

public class GRA {	
	
	public GRA() {
		
	}
	
	public static void main(String args[]) {
		GestorDatos gestorDatos=new GestorDatos();
		GestorInformes gestorInformes=new GestorInformes();
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		
		while(!fin) {
			printMenu();
			String opcion = sc.next();
			String nPresa,nCuenca;
			int dia,mes,año;

			switch(opcion) {
				case "A": 
					System.out.println("Alta cuenca/presa");
					System.out.println("       Nombre de la cuenca?");
					nCuenca=sc.next();
					System.out.println("       Nombre de la presa?");
					nPresa=sc.next();
					System.out.println("       Capacidad de la presa?");
					int cap=sc.nextInt();
					gestorDatos.nuevaPresa(nCuenca,nPresa,cap);
					break;
					
				case "N":
					System.out.println("Nueva medición");
					System.out.println("       Nombre de la presa?");
					nPresa=sc.next();
					System.out.println("       Volumen embalsado?");
					int vol=sc.nextInt();
					System.out.println("       Día de lectura?");
					dia=sc.nextInt();
					System.out.println("       Mes de lectura?");
					mes=sc.nextInt()-1;
					System.out.println("       Año de lectura?");
					año=sc.nextInt();
					gestorDatos.nuevaMedicion(dia, mes, año, vol, nPresa);
					break;
					
				case "R":
					System.out.println("Registros");
					System.out.println("       Nombre de la cuenca?");
					nCuenca=sc.next();
					System.out.println("       Nombre de la presa?");
					nPresa=sc.next();
					System.out.println("       Posterior al día?");
					dia=sc.nextInt();
					System.out.println("       Mes?");
					mes=sc.nextInt()-1;
					System.out.println("       Año?");
					año=sc.nextInt();
					gestorInformes.informeReg(nPresa,nCuenca,dia,mes,año);
					break;
					
				case "V":
					System.out.println("Variaciones mensuales");
					System.out.println("       Nombre de la cuenca?");
					nCuenca=sc.next();
					System.out.println("       Nombre de la presa?");
					nPresa=sc.next();
					System.out.println("       Mes?");
					mes=sc.nextInt()-1;
					System.out.println("       Año?");
					año=sc.nextInt();
					gestorInformes.informeVar(nPresa,nCuenca,mes,año);
					break;
					
				case "S":
					fin=true;
					break;
			
			}
			
			
		}
	}
	
	public static void printMenu() {
		System.out.println("Gestión de Reservas de Agua");
		System.out.println("       Alta cuenca/presa                  (Pulsar A)");
		System.out.println("       Nueva medición                     (pulsar N)");
		System.out.println("       Registros                          (pulsar R)");
		System.out.println("       Variaciones mensuales              (pulsar V)");
		System.out.println("       Salir                              (pulsar S)");
		System.out.println("Teclear una opción válida (A|N|R|V|S)?");
	}
	
	
}
