package com.mev.web.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
@Table(name = "DISTRITO")
public class Distrito {
	@Id
	private int distritoId;
	@Column
	private String distrito;
	@Column
	private String canton;
	
	

	public Distrito() {
		
	}

	public Distrito(int distritoId, String distrito, String canton) {
		this.distritoId = distritoId;
		this.distrito = distrito;
		this.canton = canton;
	}

	public int getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(int distritoId) {
		this.distritoId = distritoId;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	@Override
	public String toString() {
		return "Distrito [distritoId=" + distritoId + ", distrito=" + distrito + ", canton=" + canton + "]";
	}
	
	
	
	
}
