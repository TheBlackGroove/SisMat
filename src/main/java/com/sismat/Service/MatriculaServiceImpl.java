package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.Alumno;
import com.sismat.Entidades.Matricula;
import com.sismat.Repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {

	@Autowired
	MatriculaRepository matricularepository;
	
	@Override
	public void DeletexIdSeccion(int idseccion) {
		matricularepository.deletexidseccion(idseccion);
		
	}

	@Override
	public Iterable<Matricula> findByAlumno(Alumno alumno) {
		return matricularepository.findByAlumno(alumno);
	}

	@Override
	public Matricula save(Matricula matricula) {
		return matricularepository.save(matricula);
	}

	@Override
	public void delete(int id) {
		matricularepository.delete(id);		
	}

	@Override
	public int ContarMatriculasIdenticas(Matricula matricula) {
		return matricularepository.ContarMatriculasidenticas(matricula.getAlumno(), matricula.getSeccion());
	}

}
