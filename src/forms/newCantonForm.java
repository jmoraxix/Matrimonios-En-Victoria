package forms;

public class newCantonForm {
	private String Nombre;
	private String ProvinciaId;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String name) {
		Nombre = name;
	}
	public String getProvinciaId() {
		return ProvinciaId;
	}
	public void setProvinciaId(String provinciaId) {
		ProvinciaId = provinciaId;
	}
	@Override
	public String toString() {
		return "newCantonForm [Nombre=" + Nombre + ", ProvinciaId=" + ProvinciaId + "]";
	}
	public newCantonForm(String name, String provinciaId) {
		super();
		Nombre = name;
		ProvinciaId = provinciaId;
	}
	public newCantonForm() {
		super();
	}
	
	
}
