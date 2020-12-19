import java.util.Calendar;

public class GestorDatos {
	Zona zona;
	
	public GestorDatos() {
		zona=Zona.getInstance();
	}
	public void nuevaPresa(String nCuenca,String nPresa,int cap) {
		zona.nuevaPresa(nCuenca, nPresa, cap);
	}
	
	public void nuevaMedicion(int dia,int mes,int a�o,int vol,String nPresa) {
		Calendar fecha=(Calendar) Calendar.getInstance().clone();
		fecha.set(a�o,mes,dia);
		Presa presa=zona.getPresa(nPresa);
		if(presa!=null) {
			presa.a�adirRegistro(new Registro(vol,fecha,nPresa,presa.getCuenca(),presa.getCapacidad()));
		}
	}
}
