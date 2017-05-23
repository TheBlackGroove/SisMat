package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Curso;

@Repository
@Transactional
public interface CursoRepository extends CrudRepository<Curso, Integer> {

	public int countByCodigocurso(String codigocurso);
	public int countByNombrecurso(String nombrecurso);	
	
}
