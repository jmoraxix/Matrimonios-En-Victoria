package forms;

public class newComunidadForm {
	private String Nombre;
	private String distritoId;
	private String detalle;
	public newComunidadForm(String nombre, String distritoId, String detalle) {
		super();
		Nombre = nombre;
		this.distritoId = distritoId;
		this.detalle = detalle;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDistritoId() {
		return distritoId;
	}
	public void setDistritoId(String distritoId) {
		this.distritoId = distritoId;
	}
	public newComunidadForm(String nombre, String distritoId) {
		super();
		Nombre = nombre;
		this.distritoId = distritoId;
	}
	public newComunidadForm() {
		super();
	}
	
	
}
