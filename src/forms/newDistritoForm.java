package forms;

public class newDistritoForm {
	private String Nombre;
	private String cantonId;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCantonId() {
		return cantonId;
	}

	public void setCantonId(String cantonId) {
		this.cantonId = cantonId;
	}
	public newDistritoForm(String nombre, String cantonId) {
		super();
		Nombre = nombre;
		this.cantonId = cantonId;
	}
	public newDistritoForm() {
		super();
	}
	
	
}
