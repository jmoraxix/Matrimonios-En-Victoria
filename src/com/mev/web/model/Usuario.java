package com.mev.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import forms.newUsuarioForm;

@Entity
@Table(name = "USUARIO")
// @PrimaryKeyJoinColumn(name = "cedula")
public class Usuario {
	@Id
	private String cedula;

	@Column(nullable = false)
	private String contrasena;

	@OneToOne
	@MapsId
	private Miembro miembro;

	public Usuario() {
	}

	public Usuario(String contrasena) {
		this.contrasena = contrasena;
	}

	public Usuario(newUsuarioForm usuarioForm) {
		this.cedula = usuarioForm.getCedula();
		this.contrasena = usuarioForm.getContrasena();
		Miembro miembro = this.getMiembro();
		miembro.setCedula(usuarioForm.getCedula());
		miembro.setNombre(usuarioForm.getNombre());
		miembro.setApellido(usuarioForm.getApellido());
		miembro.setSexo(usuarioForm.getSexo());
		miembro.setFechaNacimiento(usuarioForm.getFechaNacimiento());
		miembro.setDetalleDireccion(usuarioForm.getDetalleDireccion());
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Miembro getMiembro() {
		return miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", contrasena=" + contrasena + ", miembro=" + miembro + "]";
	}

}
