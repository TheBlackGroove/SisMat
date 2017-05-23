package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.Curso;
import com.sismat.Repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursorepositpory;
	
	@Override
	public Iterable<Curso> findAll() {
		return cursorepositpory.findAll();
	}

	@Override
	public Curso save(Curso curso) {
		return cursorepositpory.save(curso);
	}

	@Override
	public int countByCodigocurso(String codigocurso) {
		return cursorepositpory.countByCodigocurso(codigocurso);
	}

	@Override
	public int countByNombrecurso(String nombrecurso) {
		return cursorepositpory.countByNombrecurso(nombrecurso);
	}

}
