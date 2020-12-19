
public class Cuenca {
	private String nombre;
	private Presas presas;
	
	public Cuenca(String nombre) {
		presas=new Presas();
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Presa buscarPresa(String nPresa) {
		return presas.getPresa(nPresa);
	}
	
	public void crearPresa(String nPresa,int cap) {
		if(!presas.existePresa(nPresa)) {
			presas.crearPresa(nPresa, cap,nombre);
		}
	}
	
	public Presas getPresas() {
		return presas;
	}
}
