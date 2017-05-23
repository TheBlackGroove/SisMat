package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.Alumno;
import com.sismat.Repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository alumnorepository;
	
	@Override
	public Iterable<Alumno> findAll() {
		return alumnorepository.findAll();
	}

	@Override
	public Alumno save(Alumno alumno) {
		return alumnorepository.save(alumno);
	}

	@Override
	public Alumno findOne(int id) {
		return alumnorepository.findOne(id);
	}

	@Override
	public void updateAlumno(Alumno alumno) {
		alumnorepository.updateAlumno(alumno.getNombrealumno(), alumno.getId());		
	}

	@Override
	public void delete(int id) {
		alumnorepository.delete(id);		
	}

	@Override
	public Iterable<Alumno> BuscarPorCodalumno(String ulogin) {
		return alumnorepository.BuscarPorCodalumno(ulogin);
	}

}
