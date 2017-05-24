package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Carrera;
import com.sismat.Entidades.Curso;

@Repository
@Transactional
public interface CursoRepository extends CrudRepository<Curso, Integer> {

	public int countByCodigocurso(String codigocurso);
	public int countByNombrecurso(String nombrecurso);	
	
	@Modifying
	@Query("Update Curso c set c.nombrecurso = ?1, c.codigocurso = ?2 where c.id = ?3")
	public void updateCurso(String nombrecurso, String codigocurso, int id);
	
	public Iterable<Curso> findByCarrera(Carrera carrera);
	
}
