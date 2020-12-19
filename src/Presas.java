import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Presas {
	private List<Presa> presas;
	private int maxPresas;
	
	public Presas() {
		presas=new LinkedList();
		maxPresas=5;
	}
	
	public void crearPresa(String nPresa,int cap,String nCuenca) {
		if(hayEspacio()) {
			presas.add(new Presa(cap,nPresa,nCuenca));
		}
	}
	
	public Presa getPresa(String nPresa) {
		Iterator<Presa> iter=iterator();
		while(iter.hasNext()) {
			Presa presa=iter.next();
			if(presa.getNombre().equals(nPresa)) {
				return presa;
			}
		}
		
		return null;
	}
	
	public boolean existePresa(String nPresa) {
		
		Presa presa=getPresa(nPresa);
		
		if(presa==null) {
			return false;
		}else {
			return true;
		}

	}
	
	public boolean hayEspacio() {		
		if(maxPresas>presas.size()) {
			return true;
		}else {
			return false;
		}
	}
	
	public Iterator<Presa> iterator(){
		return presas.iterator();
	}
	
}
