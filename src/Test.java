import java.util.*;
import static org.junit.Assert.*;
public class Test {
	
	public static void main(String[] args) {
		
		Test test=new Test();
		test.testGestorDatos();
		System.out.println("pruebas completadas con exito");
	}

	
	public void testGestorDatos() {
		
		GestorDatos gestor=new GestorDatos();
		GestorInformes gestorI=new GestorInformes();
		
		gestor.nuevaPresa("cuenca1", "presa11", 100);
		gestor.nuevaPresa("cuenca1", "presa12", 300);
		gestor.nuevaPresa("cuenca2", "presa21", 400);
		gestor.nuevaPresa("cuenca2", "presa22", 500);
		
		gestor.nuevaMedicion(1, 2, 2019,30, "presa11");
		gestor.nuevaMedicion(10, 2, 2019, 50, "presa11");
		gestor.nuevaMedicion(18, 2, 2019, 90, "presa11");
		gestor.nuevaMedicion(19, 2, 2019, 150, "presa11");
		gestor.nuevaMedicion(19, 2, 2019, 100, "presa11");
		gestor.nuevaMedicion(1, 2, 2019, 200, "presa12");
		gestor.nuevaMedicion(3, 2, 2019, 250, "presa12");
		gestor.nuevaMedicion(7, 2, 2019, 230, "presa12");
		gestor.nuevaMedicion(10, 2, 2019, 250, "presa12");
		gestor.nuevaMedicion(11, 2, 2019, 250, "presa12");
		gestor.nuevaMedicion(1, 2, 2019, 100, "presa21");
		gestor.nuevaMedicion(9, 2, 2019, 140, "presa21");
		gestor.nuevaMedicion(21, 2, 2019, 70, "presa21");
		gestor.nuevaMedicion(1, 2, 2019, 450, "presa22");
		
		gestorI.informeReg("todos", "todos", 0,2,2019);
		
		List<Registro> registros=Zona.getInstance().getRegMes(2,2019,"cuenca1","presa11");
		
		Calendario cal=new Calendario(registros,2,2019);
		

		System.out.println(cal.getDatos());
		
		
	}

}
