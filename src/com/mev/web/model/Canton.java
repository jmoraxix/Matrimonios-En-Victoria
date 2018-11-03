package com.mev.web.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "CANTON")

public class Canton {
	@Id
	private int cantonId;
	@Column
	private String canton;
	@Column
	private String provincia;
	
	
	public Canton() {
		
	}


	public Canton(int cantonId, String canton, String provincia) {
		this.cantonId = cantonId;
		this.canton = canton;
		this.provincia = provincia;
	}


	public int getCantonId() {
		return cantonId;
	}


	public void setCantonId(int cantonId) {
		this.cantonId = cantonId;
	}


	public String getCanton() {
		return canton;
	}


	public void setCanton(String canton) {
		this.canton = canton;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	@Override
	public String toString() {
		return "Canton [cantonId=" + cantonId + ", canton=" + canton + ", provincia=" + provincia + "]";
	}
	
	
	
	
}
