import java.util.Calendar;
import java.util.List;

public class GestorInformes {
	Zona zona;
	
	public GestorInformes() {
		zona=Zona.getInstance();
	}
	
	public void informeReg(String nPresa,String nCuenca,int dia,int mes,int año) {
		Calendar fecha = (Calendar) Calendar.getInstance().clone();
		fecha.set(año,mes,dia);
		List<Registro> registros=zona.getRegPosteriores(fecha, nPresa, nCuenca);
		InformeReg informe = new InformeReg(registros);
		System.out.println(informe.mostrarInforme());
	}
	
	public void informeVar(String nPresa,String nCuenca,int mes,int año) {
		List<Registro> registros=zona.getRegMes(mes,año,nPresa,nCuenca);
		
		InformeVar informe = new InformeVar(registros,mes,año);
		System.out.println(informe.mostrarInforme());
	}
}
