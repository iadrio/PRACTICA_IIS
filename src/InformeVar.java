import java.util.List;

public class InformeVar {
 
	String informe;
	public InformeVar(List<Registro> registros,int mes, int a�o) {
		informe=(new Calendario(registros, mes,  a�o)).getDatos();
	}
	
	public String mostrarInforme() {
		return informe;
	}

	
}
