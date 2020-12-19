import java.util.Calendar;
/**
 * Representa un registro de datos en una presa
 * 
 * @author Iván Adrio Muñiz 
 * @version 2019.05.22
 */
public class Registro {

	int aguaEmbalsada,capacidad;
	Calendar fecha;
	String presa, cuenca;

	public Registro(int aguaEmbalsada,Calendar fecha,String nPresa,String nCuenca, int capacidad) {
		this.aguaEmbalsada=aguaEmbalsada;
		this.fecha=fecha;
		this.capacidad=capacidad;
		presa=nPresa;
		cuenca=nCuenca;
	}
	
	public boolean esPosterior(Calendar fecha) {
		if(this.fecha.compareTo(fecha)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean perteneceMes(int mes, int año) {
		if(fecha.get(fecha.MONTH)==mes && fecha.get(fecha.YEAR)==año) {
			return true;			
		}else {
			return false;
		}		
	}

	/**
	 * Getters y setters
	 */
	public int getAguaEmbalsada() {
		return aguaEmbalsada;
	}

	public void setAguaEmbalsada(int aguaEmbalsada) {
		this.aguaEmbalsada = aguaEmbalsada;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = (Calendar) fecha.clone();
	}

	public String getPresa() {
		return presa;
	}

	public void setPresa(String presa) {
		this.presa = presa;
	}

	public String getCuenca() {
		return cuenca;
	}

	public void setCuenca(String cuenca) {
		this.cuenca = cuenca;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	
}
