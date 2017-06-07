package com.sismat.Service;

import com.sismat.Entidades.Carrera;
import com.sismat.Entidades.Curso;

public interface CarreraService {
	public Carrera save(Carrera carrera);
	public boolean VerificarCodigoCarrera(String codigocarrera);
	public Iterable<Carrera> findAll();
	public Carrera findOne(int id);
	public void updateCarrera(Carrera carrera);
	public Carrera findByCurso(Curso curso);
}
