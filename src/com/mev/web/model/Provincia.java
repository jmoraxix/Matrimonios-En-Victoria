package com.mev.web.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "PROVINCIA")

public class Provincia {
	@Id
	private int provinciaId;
	@Column
	private String provincia;
	
	public Provincia() {
		
	}
	
	public Provincia(int provinciaId, String provincia) {
		this.provinciaId = provinciaId;
		this.provincia = provincia;
	}
	
	public int getProvinciaId() {
		return provinciaId;
	}
	
	public void setProvinciaId(int provinciaId) {
		this.provinciaId = provinciaId;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return "Provincia [provinciaId=" + provinciaId + ", provincia=" + provincia + "]";
	}
	
	
}
