package com.sismat.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "idseccion")
	private Seccion seccion;
	
	@ManyToOne
	@JoinColumn(name = "idalumno")
	private Alumno alumno;
	
	@Column(name = "estadomatricula")
	private int estadomatricula;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getEstadomatricula() {
		return estadomatricula;
	}

	public void setEstadomatricula(int estadomatricula) {
		this.estadomatricula = estadomatricula;
	}
	
	
	
}
