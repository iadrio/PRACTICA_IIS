import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cuencas {

	private List<Cuenca> cuencas;
	int maxCuencas;
	
	public Cuencas() {
		maxCuencas=3;
		cuencas=new LinkedList();
	}
	
	public boolean hayEspacio() {
		if(cuencas.size()<maxCuencas) {
			return true;
		}else {
			return false;
		}
	}
	
	public void añadirCuenca(String nombre) {
		if(hayEspacio()) {
			cuencas.add(new Cuenca(nombre));
		}
		
	}
	
	public Cuenca getCuenca(String nCuenca) {
		for(Cuenca cuenca:cuencas) {
			if(cuenca.getNombre().equals(nCuenca)) {
				return cuenca;
			}
		}		
		return null;
	}
	
	public boolean existeCuenca(String nCuenca) {
		Cuenca cuenca=getCuenca(nCuenca);
		
		if(cuenca==null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public Iterator<Cuenca> iterator(){
		return cuencas.iterator();
	}
}
