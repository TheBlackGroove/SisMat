package com.sismat.Service;

import com.sismat.Entidades.Carrera;

public interface CarreraService {
	public Carrera save(Carrera carrera);
	public boolean VerificarCodigoCarrera(String codigocarrera);
	public Iterable<Carrera> findAll();
	public Carrera findOne(int id);
}
