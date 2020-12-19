import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Calendario {
	String calendario;
	int mes;
	int año;
	//
	public Calendario(List<Registro> registros,int mes, int año) {
		calendario="";
		this.mes=mes;
		this.año=año;
		construyeCalendario(registros);
	}
	public String getDatos() {
		return calendario;
	}
	
	private void construyeCalendario(List<Registro> registros) {
		añadeLinea7("AÑO",String.valueOf(getAño()),String.valueOf(getMes()),"","","","");
		añadeCabecera();
		añadeCuencaPresa(getCuenca(registros),getPresa(registros));
		añadeMesAño(getMes(),getAño());
		añadeSeparador();
		añadeDias();
		añadeLinea7("","","","","","","");
		fill(registros);

	
	}
	private void añadeLinea(String col1,String col2,String col3,String col4) {
		calendario=calendario+String.format("%8s%8s%8s%8s\n",col1,col2,col3,col4);
	}
	private void añadeCabecera() {
		calendario=calendario+"     %Variacion Agua Embalsada\n";
	}
	private void añadeLinea7(String col1,String col2,String col3,String col4,String col5,String col6,String col7) {
		añadeLinea11("","",col1,col2,col3,col4,col5+"|",col6,col7,"","");
	}
	private void añadeDias() {
		añadeLinea7("L","M","M","J","V","S","D");
	}
	private void añadeCuencaPresa(String cuenca, String presa) {
		calendario=calendario+String.format("%1$-17s %2$17s","Cuenca:"+cuenca,"Presa:"+presa)+"\n";
	}
	private void añadeSeparador() {
		calendario=calendario+String.format("%6s"," ")+String.format("%22s"," ").replace(" ","_")+String.format("%6s"," ")+"\n";
	}
	private void añadeMesAño(int mes,int año) {
		calendario=calendario+String.format("      %1$-10s %2$10s",getMonth(mes),String.valueOf(año))+"\n";
	}
	private void añadeLinea11(String col1,String col2,String col3,String col4,String col5,String col6,String col7,String col8,String col9,String col10,String col11) {
		calendario=calendario+String.format("%3s%3s%3s%3s%3s%3s%4s%3s%3s%3s%3s\n",col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11);
	}
    private String getMonth(int i){
        switch (i+1){
            case 1:
            return "Enero";
            case 2:
            return "Febrero";
            case 3:
            return "Marzo";
            case 4:
            return "Abril";
            case 5:
            return "Mayo";
            case 6:
            return "Junio";
            case 7:
            return "Julio";
            case 8:
            return "Agosto";
            case 9:
            return "Septiembre";
            case 10:
            return "Octubre";
            case 11:
            return "Noviembre";
            case 12:
            return "Diciembre";
            default:
            return "";
        }
    }    
    private int getDayOfWeek(int i){
        
        switch (i){
            case 1:
            return 7;
            case 2:
            return 1;
            case 3:
            return 2;
            case 4:
            return 3;
            case 5:
            return 4;
            case 6:
            return 5;
            case 7:
            return 6;
            default:
            return 0;
        }
        
    }    
    private String getCuenca(List<Registro> registros) {
    	String cuenca;
    	Iterator<Registro> iter=registros.iterator();
    	
    	if(iter.hasNext()) {
    		cuenca=iter.next().getCuenca();
    	}else {
    		return "TODAS";
    	}
    	
    	while(iter.hasNext()) {
    		Registro reg=iter.next();
    		if(!reg.getCuenca().equals(cuenca)) {
    			return "TODAS";
    		}
    	}   	
    	return cuenca;    	
    }
    private String getPresa(List<Registro> registros) {
    	String presa;
    	Iterator<Registro> iter=registros.iterator();
    	
    	if(iter.hasNext()) {
    		presa=iter.next().getPresa();
    	}else {
    		return "TODAS";
    	}
    	
    	while(iter.hasNext()) {
    		Registro reg=iter.next();
    		if(!reg.getPresa().equals(presa)) {
    			return "TODAS";
    		}
    	}   	
    	return presa;    	
    }
    private int getMes() {
    	return mes;
    	
    }
    private int getAño() {
    	return año;  	
    }
    private void fill(List<Registro> registros) {
    	int numeroDia,ultimoDia;
    	
    	Calendar calendar = (Calendar) Calendar.getInstance().clone();
    	calendar.set(getAño(),getMes(),1);
        numeroDia=getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));
        ultimoDia=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        
        List<String> variaciones= getVar(registros);
        int numero=1;
        Iterator<String> iterV=variaciones.iterator();

        for(int i=1;i<=5;i++){
        	String[] v=new String[7];
            String s="       ";
            for(int j=1;j<=7;j++){
            	
                if((numero<=ultimoDia)){
                    if(i==1&&j<numeroDia){
                        v[j-1]="";
                    }else{
                        v[j-1]=String.valueOf(iterV.next());
                        numero++;
                    }
                }else {
                	v[j-1]="";
                }
            }
            añadeLinea7(v[0],v[1],v[2],v[3],v[4],v[5],v[6]);
        }   
    }   
    private int getCapacidad(List<Registro> registros) {
    	int capacidad=0;
    	String cuenca=getCuenca(registros);
    	String presa=getPresa(registros);
    	Iterator<Registro> iter = registros.iterator();

		if(iter.hasNext()) {
			Registro reg=iter.next();
			capacidad=reg.getCapacidad();
			presa=reg.getPresa();	
		}
		while(iter.hasNext()) {
			Registro reg=iter.next();
			
			if(presa!=reg.getPresa()) {
				capacidad=capacidad+reg.getCapacidad();
				presa=reg.getPresa();
			}
			
		}

    	return capacidad;
    }
    private List<String> getVar(List<Registro> registros){
    	List<String> variaciones=new LinkedList();
    	NumberFormat formatter = new DecimalFormat("#0");
    	int capacidad=getCapacidad(registros);
    	Calendar calendar = (Calendar) Calendar.getInstance().clone();
    	int mes=getMes();
    	int año=getAño();
    	calendar.set(año,mes,1);
        int ultimoDia=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int ultimoRegistro=0;
        int variacion=0;
        int variacion2=0;
        
        System.out.println("ultimo día "+ultimoDia);
        
        HashMap<String,Integer> registroPresa = new HashMap();
        
        for(int i=1;i<=ultimoDia;i++) {
        	calendar.set(año,mes,i);
        	
        	Iterator<Registro> iter = registros.iterator();
        	int nRegistros=0;
        	while(iter.hasNext()) {
        		Registro reg=iter.next();
        		if(reg.getFecha().get(Calendar.DAY_OF_YEAR)==calendar.get(Calendar.DAY_OF_YEAR)) {
        			registroPresa.put(reg.getPresa(),reg.getAguaEmbalsada());
        			nRegistros++;
        		}
        	}
        	
        	Iterator iter2=registroPresa.entrySet().iterator();
        	int registro=0;
        	while(iter2.hasNext()) {
        		Entry pair = (Entry) iter2.next();
        		registro=registro+(int) pair.getValue();
        	}
        	
        	if(nRegistros==0) {
        		variaciones.add("--");
        	}else {
        		variacion2=registro-ultimoRegistro;
        		ultimoRegistro=registro;
        		variacion=(variacion2*100)/capacidad;
        		
        		if(variacion>9||variacion<-9) {
        			variaciones.add("EE");
        		}else if(variacion<0){
        			variaciones.add(""+variacion);
        		}else if(variacion>0) {
        			variaciones.add("+"+variacion);
        		}else {
        			variaciones.add("00");
        		}
        	}
        	
        }
    	
    	return variaciones;
    }
    

    
}
