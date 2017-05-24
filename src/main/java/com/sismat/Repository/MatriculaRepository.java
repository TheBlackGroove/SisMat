package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Alumno;
import com.sismat.Entidades.Matricula;
import com.sismat.Entidades.Seccion;

@Repository
@Transactional
public interface MatriculaRepository extends CrudRepository<Matricula, Integer> {

	@Modifying
	@Query(value = "delete from matricula m where m.idseccion = ?1", nativeQuery = true)
	public void deletexidseccion(int idseccion);
	
	public Iterable<Matricula> findByAlumno(Alumno alumno);
	
	@Query("Select count(m) from Matricula m where m.alumno = ?1 and m.seccion = ?2")
	public int ContarMatriculasidenticas(Alumno alumno, Seccion seccion);
}
