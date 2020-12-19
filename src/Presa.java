import java.util.Calendar;
import java.util.List;

public class Presa {
	int capacidad;
	String nombre,cuenca;
	Registros registros;
	
	public Presa(int capacidad, String nombre,String nCuenca) {
		this.capacidad=capacidad;
		cuenca=nCuenca;
		this.nombre=nombre;
		registros=new Registros();
	}
	
	public void añadirRegistro(Registro registro) {
		if(registro.getAguaEmbalsada()<=capacidad) {
			registros.añadirRegistro(registro);
		}
	}
	
	public List<Registro> getRegMes(int mes,int año){
		return registros.getRegMes(mes, año);	
	}
	
	public List<Registro> getRegPosteriores(Calendar f){
		return registros.getRegPosteriores(f);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCuenca() {
		return cuenca;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
}
