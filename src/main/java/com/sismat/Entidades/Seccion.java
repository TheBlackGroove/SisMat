package com.sismat.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "codigoseccion")
	private String codigoseccion;
	
	@ManyToOne
	@JoinColumn(name = "idcurso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name = "iddocente")
	private Docente docente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoseccion() {
		return codigoseccion;
	}

	public void setCodigoseccion(String codigoseccion) {
		this.codigoseccion = codigoseccion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
	
}
