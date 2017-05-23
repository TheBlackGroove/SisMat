package com.sismat.Service;

import com.sismat.Entidades.Curso;

public interface CursoService {
	public Iterable<Curso> findAll();
	public Curso save(Curso curso);
	public int countByCodigocurso(String codigocurso);
	public int countByNombrecurso(String nombrecurso);
}
