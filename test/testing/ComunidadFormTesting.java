package testing;

public class ComunidadFormTesting {
	public String ComunidadFormName(String nombre) {
		if(nombre.matches(".*\\d+.*")) {
			nombre = null;
		}
		return nombre;
	}
	
	public String ComunidadFormID(String ID) {
		if(!ID.matches("[0-9]+")) {
			ID=null;
		}
		return ID;
	}
	
	public String ComunidadFormDetalle(String detalle) {
		if(detalle==null || detalle=="") {
			detalle="false";
		}
		return detalle;
	}

}
