package com.sismat.Service;

import com.sismat.Entidades.Alumno;

public interface AlumnoService {
	public Iterable<Alumno> findAll();
	public Alumno save(Alumno alumno);
	public Alumno findOne(int id);
	public void updateAlumno(Alumno alumno);
	public void delete(int id);
	public Iterable<Alumno> BuscarPorCodalumno(String ulogin);
}
