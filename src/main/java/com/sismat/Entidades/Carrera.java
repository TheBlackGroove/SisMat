package com.sismat.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nombrecarrera")
	private String nombrecarrera;
	
	@Column(name = "codigocarrera")
	private String codigocarrera;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrecarrera() {
		return nombrecarrera;
	}

	public void setNombrecarrera(String nombrecarrera) {
		this.nombrecarrera = nombrecarrera;
	}

	public String getCodigocarrera() {
		return codigocarrera;
	}

	public void setCodigocarrera(String codigocarrera) {
		this.codigocarrera = codigocarrera;
	}
	
	
}
