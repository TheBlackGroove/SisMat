package com.sismat.Service;

import com.sismat.Entidades.Carrera;
import com.sismat.Entidades.Curso;

public interface CursoService {
	public Iterable<Curso> findAll();
	public Curso save(Curso curso);
	public int countByCodigocurso(String codigocurso);
	public int countByNombrecurso(String nombrecurso);
	public void delete(int id);
	public Curso findOne(int id);
	public void updateCurso(Curso curso);
	public Iterable<Curso> findByCarrera(Carrera carrera);
}
