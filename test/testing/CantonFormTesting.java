package testing;

public class CantonFormTesting {

	public String CantonFormName(String nombre) {
		if(nombre.matches(".*\\d+.*")) {
			nombre = null;
		}
		return nombre;
	}
	
	public String CantonFormID(String ID) {
		if(!ID.matches("[0-9]+")) {
			ID=null;
		}
		return ID;
	}
}
