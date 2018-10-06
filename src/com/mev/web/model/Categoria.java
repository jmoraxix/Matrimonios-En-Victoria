package com.mev.web.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

	private int categoriaId;
	private String descripcion;
	private Collection<Subcategoria> subcategorias;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORIA_ID")
	public int getCategoriaId() {
		return categoriaId;
	}
	
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categoria")  
	public Collection<Subcategoria> getSubcategorias() {
		return subcategorias;
	}
	
	public void setSubcategorias(Collection<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoriaId;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((subcategorias == null) ? 0 : subcategorias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (categoriaId != other.categoriaId)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (subcategorias == null) {
			if (other.subcategorias != null)
				return false;
		} else if (!subcategorias.equals(other.subcategorias))
			return false;
		return true;
	}
}
