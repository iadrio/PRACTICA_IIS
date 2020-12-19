
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Registros {

	Queue<Registro> registros;
	
	public Registros() {
		registros=new LinkedList();
	}
	
	public void añadirRegistro(Registro r) {
		if(esValido(r)){
			if(registros.size()<100) {
				registros.add(r);
			}else {
				registros.remove();
				registros.add(r);
			}
		}
	}
	
	public List<Registro> getRegMes(int mes,int año){
		List<Registro> listaRegistros = new LinkedList();
		Iterator<Registro> iter = iterator();
		
		while(iter.hasNext()) {
			Registro reg=iter.next();
			if(reg.perteneceMes(mes, año)) {
				listaRegistros.add(reg);
			}
		}
		return listaRegistros;
	}
	
	public List<Registro> getRegPosteriores(Calendar f){
		List<Registro> listaRegistros = new LinkedList();
		Iterator<Registro> iter = iterator();
		
		while(iter.hasNext()) {
			Registro reg=iter.next();
			if((reg.getFecha().compareTo(f))>0) {
				listaRegistros.add(reg);
			}
		}
		return listaRegistros;
	}
	
	public Iterator<Registro> iterator(){
		return registros.iterator();
	}
	
	private boolean esValido(Registro r) {
		if(registros.isEmpty()) {
			return true;
		}else {
			Registro ultimoReg=(Registro) ((LinkedList) registros).getLast();
			if(r.esPosterior(ultimoReg.getFecha())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	
	
	
	
}
