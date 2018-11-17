package testing;

public class DistritoFormTesting {
	public String DistritoFormName(String nombre) {
		if(nombre.matches(".*\\d+.*")) {
			nombre = null;
		}
		return nombre;
	}
	
	public String DistritoFormID(String ID) {
		if(!ID.matches("[0-9]+")) {
			ID=null;
		}
		return ID;
	}

}
