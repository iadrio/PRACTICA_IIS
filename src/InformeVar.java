import java.util.List;

public class InformeVar {
 
	String informe;
	public InformeVar(List<Registro> registros,int mes, int año) {
		informe=(new Calendario(registros, mes,  año)).getDatos();
	}
	
	public String mostrarInforme() {
		return informe;
	}

	
}
