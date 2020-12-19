import java.util.Calendar;
import java.util.List;

public class GestorInformes {
	Zona zona;
	
	public GestorInformes() {
		zona=Zona.getInstance();
	}
	
	public void informeReg(String nPresa,String nCuenca,int dia,int mes,int a�o) {
		Calendar fecha = (Calendar) Calendar.getInstance().clone();
		fecha.set(a�o,mes,dia);
		List<Registro> registros=zona.getRegPosteriores(fecha, nPresa, nCuenca);
		InformeReg informe = new InformeReg(registros);
		System.out.println(informe.mostrarInforme());
	}
	
	public void informeVar(String nPresa,String nCuenca,int mes,int a�o) {
		List<Registro> registros=zona.getRegMes(mes,a�o,nPresa,nCuenca);
		
		InformeVar informe = new InformeVar(registros,mes,a�o);
		System.out.println(informe.mostrarInforme());
	}
}
