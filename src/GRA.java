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
			int dia,mes,a�o;

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
					System.out.println("Nueva medici�n");
					System.out.println("       Nombre de la presa?");
					nPresa=sc.next();
					System.out.println("       Volumen embalsado?");
					int vol=sc.nextInt();
					System.out.println("       D�a de lectura?");
					dia=sc.nextInt();
					System.out.println("       Mes de lectura?");
					mes=sc.nextInt()-1;
					System.out.println("       A�o de lectura?");
					a�o=sc.nextInt();
					gestorDatos.nuevaMedicion(dia, mes, a�o, vol, nPresa);
					break;
					
				case "R":
					System.out.println("Registros");
					System.out.println("       Nombre de la cuenca?");
					nCuenca=sc.next();
					System.out.println("       Nombre de la presa?");
					nPresa=sc.next();
					System.out.println("       Posterior al d�a?");
					dia=sc.nextInt();
					System.out.println("       Mes?");
					mes=sc.nextInt()-1;
					System.out.println("       A�o?");
					a�o=sc.nextInt();
					gestorInformes.informeReg(nPresa,nCuenca,dia,mes,a�o);
					break;
					
				case "V":
					System.out.println("Variaciones mensuales");
					System.out.println("       Nombre de la cuenca?");
					nCuenca=sc.next();
					System.out.println("       Nombre de la presa?");
					nPresa=sc.next();
					System.out.println("       Mes?");
					mes=sc.nextInt()-1;
					System.out.println("       A�o?");
					a�o=sc.nextInt();
					gestorInformes.informeVar(nPresa,nCuenca,mes,a�o);
					break;
					
				case "S":
					fin=true;
					break;
			
			}
			
			
		}
	}
	
	public static void printMenu() {
		System.out.println("Gesti�n de Reservas de Agua");
		System.out.println("       Alta cuenca/presa                  (Pulsar A)");
		System.out.println("       Nueva medici�n                     (pulsar N)");
		System.out.println("       Registros                          (pulsar R)");
		System.out.println("       Variaciones mensuales              (pulsar V)");
		System.out.println("       Salir                              (pulsar S)");
		System.out.println("Teclear una opci�n v�lida (A|N|R|V|S)?");
	}
	
	
}
