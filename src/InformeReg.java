import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;



public class InformeReg {
	String informe;
	public InformeReg(List<Registro> registros) {
		construyeInforme(registros);
	}
	
	public String mostrarInforme() {
		return informe;
	}
	
	private void construyeInforme(List<Registro> registros) {		
		informe="";
		
		Iterator<Registro> iter=registros.iterator();
		String cuenca="",presa="";
		int volAcumuladoCuenca=0;
		int capacidadCuenca=0;
		int volAcumulado=0;
		int capacidadTotal=0;
		int aguaEmbalsada=0;
		int ultimaCapacidad=0;
		
		añadeLinea("Cuenca","Presa","Volumen","Fecha");
		añadeLinea("","","","");
		while(iter.hasNext()) {
			Registro registro=iter.next();
			
			if(!presa.equals(registro.getPresa())) {
				if(!presa.equals("")) {
					volAcumuladoCuenca=volAcumuladoCuenca+aguaEmbalsada;
					capacidadCuenca=capacidadCuenca+ultimaCapacidad;
				}
				presa=registro.getPresa();
				if(!cuenca.equals(registro.getCuenca())) {
					if(!cuenca.equals("")) {
						añadeLinea(cuenca,"TOTAL",formatCol3(volAcumuladoCuenca,capacidadCuenca),"");
						volAcumulado=volAcumulado+volAcumuladoCuenca;
						capacidadTotal=capacidadTotal+capacidadCuenca;
						volAcumuladoCuenca=0;
						capacidadCuenca=0;
					}
					cuenca=registro.getCuenca();
				}
			}
			
			aguaEmbalsada=registro.getAguaEmbalsada();
			ultimaCapacidad=registro.getCapacidad();
			
			String fecha=registro.getFecha().get(Calendar.DAY_OF_MONTH)+"/"+(registro.getFecha().get(Calendar.MONTH)+1)+"/"+registro.getFecha().get(Calendar.YEAR);
			añadeLinea(registro.getCuenca(),registro.getPresa(),formatCol3(aguaEmbalsada,registro.getCapacidad()),fecha);

		}
		volAcumuladoCuenca=volAcumuladoCuenca+aguaEmbalsada;
		capacidadCuenca=capacidadCuenca+ultimaCapacidad;
		volAcumulado=volAcumulado+volAcumuladoCuenca;
		capacidadTotal=capacidadTotal+capacidadCuenca;
		añadeLinea(cuenca,"TOTAL",formatCol3(volAcumuladoCuenca,capacidadCuenca),"");
		añadeLinea("TODOS","TOTAL",formatCol3(volAcumulado,capacidadTotal),"");
	}
	
	private String formatCol3(int aguaEmbalsada, int capacidad) {
		String formateado="";
		NumberFormat formatter = new DecimalFormat("#00.0");
		formateado = String.valueOf(aguaEmbalsada)+" ("+String.valueOf(formatter.format((((double)aguaEmbalsada)/capacidad)*100))+"%)";
		return formateado;
	}
	
	private void añadeLinea(String col1,String col2,String col3,String col4) {
		informe=informe+String.format("%10s%10s%20s%10s\n",col1,col2,col3,col4);
	}
	
}
