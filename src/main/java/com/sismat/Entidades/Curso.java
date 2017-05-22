package com.sismat.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Curso {

	@Id
	private int id;
	
	@Column(name = "nombrecurso")
	private String nombrecurso;
	
	@Column(name = "codigocurso")
	private String codigocurso;
	
	@ManyToOne
	@JoinColumn(name = "idcarrera")
	private Carrera carrera;
	
	@Column(name = "estado")
	private int estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrecurso() {
		return nombrecurso;
	}

	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}

	public String getCodigocurso() {
		return codigocurso;
	}

	public void setCodigocurso(String codigocurso) {
		this.codigocurso = codigocurso;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	
}
