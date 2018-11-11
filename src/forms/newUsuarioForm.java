package forms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.mev.web.model.Usuario;

public class newUsuarioForm {
	private String cedula;
	private String nombre;
	private String apellido;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	private String detalleDireccion;
	private String Sexo;
	private String contrasena;
	private String confirmarContrasena;
	private Boolean upgrade;
	
	@Override
	public String toString() {
		return "newUsuarioForm [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", detalleDireccion=" + detalleDireccion + ", Sexo=" + Sexo
				+ ", contrasena=" + contrasena + ", confirmarContrasena=" + confirmarContrasena + ", upgrade=" + upgrade
				+ "]";
	}
	public Boolean getUpgrade() {
		return upgrade;
	}
	public void setUpgrade(Boolean upgrade) {
		this.upgrade = upgrade;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDetalleDireccion() {
		return detalleDireccion;
	}
	public void setDetalleDireccion(String detalleDireccion) {
		this.detalleDireccion = detalleDireccion;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getConfirmarContrasena() {
		return confirmarContrasena;
	}
	public void setConfirmarContrasena(String confirmarContrasena) {
		this.confirmarContrasena = confirmarContrasena;
	}
	public newUsuarioForm() {
		super();
	}
	public newUsuarioForm(String cedula, String nombre, String apellido, Date fechaNacimiento, String detalleDireccion,
			String sexo, String contrasena, String confirmarContrasena) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.detalleDireccion = detalleDireccion;
		this.Sexo = sexo;
		this.contrasena = contrasena;
		this.confirmarContrasena = confirmarContrasena;
	}
	public newUsuarioForm(Usuario usuario) {
		this.cedula = usuario.getCedula(); 
		this.nombre = usuario.getMiembro().getNombre();
		this.apellido = usuario.getMiembro().getApellido(); 
		this.fechaNacimiento = usuario.getMiembro().getFechaNacimiento();
		this.detalleDireccion = usuario.getMiembro().getDetalleDireccion(); 
		this.Sexo = usuario.getMiembro().getSexo(); 
		this.contrasena = usuario.getContrasena(); 
		this.confirmarContrasena = usuario.getContrasena();
	}
	
	
}
