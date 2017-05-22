package com.sismat.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleseccion")
public class DetalleSeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "dia")
	private int dia;
	
	@Column(name = "horainicio")
	private int horainicio;
	
	@Column(name = "horafinal")
	private int horafinal;
	
	@ManyToOne
	@JoinColumn(name = "idseccion")
	private Seccion seccion;
	
	@Column(name = "temp")
	private int temp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(int horainicio) {
		this.horainicio = horainicio;
	}

	public int getHorafinal() {
		return horafinal;
	}

	public void setHorafinal(int horafinal) {
		this.horafinal = horafinal;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	
	
}
