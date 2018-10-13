package com.mev.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name = "USUARIO")
@PrimaryKeyJoinColumn(name = "cedula")
public class Usuario extends Miembro {
	
	@Column(nullable = false)
	private String contrasena;

	public Usuario() {
		super();
	}

	public Usuario(String contrasena) {
		super();
		this.contrasena = contrasena;
	}
	
	public Usuario(String cedula, String nombre, String apellido, Date fechaNacimiento, String detalleDireccion,
			String sexo, String contrasena) {
		super(cedula, nombre, apellido, fechaNacimiento, detalleDireccion,
				sexo);
		this.contrasena = contrasena;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
