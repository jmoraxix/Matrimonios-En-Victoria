package forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class newReunionForm {
	private String grupoId;
	private String comunidadId;
	private String fechaString;
	
	
	public String getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(String grupoId) {
		this.grupoId = grupoId;
	}
	public String getComunidadId() {
		return comunidadId;
	}
	public void setComunidadId(String comunidadId) {
		this.comunidadId = comunidadId;
	}
	public String getFechaString() {
		return fechaString;
	}
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
	
	public Date parseFecha() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatter.parse(this.fechaString);
	}
}
