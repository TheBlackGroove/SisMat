package com.sismat.Service;

import org.springframework.stereotype.Service;

import com.sismat.Entidades.Curso;
import com.sismat.Entidades.Seccion;

@Service
public interface SeccionService {
	public Iterable<Seccion> findAll();
	public Seccion save(Seccion seccion);
	public int countByCodigoseccion(String codigoseccion);
	public Seccion findOne(int id);
	public void update(Seccion seccion);
	public void delete(int id);
	public Iterable<Seccion> findByCurso(Curso curso);
}
