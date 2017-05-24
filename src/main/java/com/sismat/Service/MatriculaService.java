package com.sismat.Service;

import com.sismat.Entidades.Alumno;
import com.sismat.Entidades.Matricula;

public interface MatriculaService {
	public void DeletexIdSeccion(int idseccion);
	public Iterable<Matricula> findByAlumno(Alumno alumno);
	public Matricula save(Matricula matricula);
	public void delete(int id);
	public int ContarMatriculasIdenticas(Matricula matricula);
}
