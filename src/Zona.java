import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Zona {
	
	private static Zona zona; 
	Cuencas cuencas;
	
	private Zona() {
		cuencas= new Cuencas();
	}
	
	public static synchronized Zona getInstance() {
		if(zona==null) {
			zona=new Zona();
			return zona;
		}else {
			return zona;
		}
	}
	
	public void nuevaPresa(String nCuenca,String nPresa,int cap) {
		if(!cuencas.existeCuenca(nCuenca)) {
			if(cuencas.hayEspacio()) {
				cuencas.añadirCuenca(nCuenca);
				cuencas.getCuenca(nCuenca).crearPresa(nPresa, cap);
			}
		}else {
			cuencas.getCuenca(nCuenca).crearPresa(nPresa, cap);
		}
	}
	
	public Presa getPresa(String nPresa) {
		
		Iterator<Cuenca> iter=cuencas.iterator();
		
		while(iter.hasNext()) {
			Cuenca cuenca=iter.next();
			Presa presa=cuenca.buscarPresa(nPresa);
			if(presa!=null) {
				return presa;
			}
		}
		return null;
	}
	
	public List<Registro> getRegMes(int mes, int año,String nombrePresa, String nombreCuenca){
		List<Registro> registros = new LinkedList();
		Cuenca cuenca;
		Presas presas;
		
		if(cuencas.existeCuenca(nombreCuenca)) {
			cuenca=cuencas.getCuenca(nombreCuenca);
			presas=cuenca.getPresas();
			if(presas.existePresa(nombrePresa)) {
				return presas.getPresa(nombrePresa).getRegMes(mes, año);
			}else {
				Iterator<Presa> iterP=presas.iterator();
				while(iterP.hasNext()) {					
					registros.addAll(iterP.next().getRegMes(mes, año));
				}
			}
		}else {
			Iterator<Cuenca> iterC = cuencas.iterator();
			while(iterC.hasNext()) {
				presas=iterC.next().getPresas();
				Iterator<Presa> iterP=presas.iterator();
				while(iterP.hasNext()) {
					registros.addAll(iterP.next().getRegMes(mes, año));
				}
			}
		}

		return registros;
	}
	
	public List<Registro> getRegPosteriores(Calendar fecha,String nombrePresa, String nombreCuenca){
		List<Registro> registros = new LinkedList();
		Cuenca cuenca;
		Presas presas;
		
		if(cuencas.existeCuenca(nombreCuenca)) {
			cuenca=cuencas.getCuenca(nombreCuenca);
			presas=cuenca.getPresas();
			if(presas.existePresa(nombrePresa)) {
				return cuenca.buscarPresa(nombrePresa).getRegPosteriores(fecha);
			}else {
				Iterator<Presa> iterP=presas.iterator();
				while(iterP.hasNext()) {					
					registros.addAll(iterP.next().getRegPosteriores(fecha));
				}
			}
		}else {
			Iterator<Cuenca> iterC = cuencas.iterator();
			while(iterC.hasNext()) {
				presas=iterC.next().getPresas();
				Iterator<Presa> iterP=presas.iterator();
				while(iterP.hasNext()) {
					registros.addAll(iterP.next().getRegPosteriores(fecha));
				}
			}
		}

		return registros;
	}
	
}
