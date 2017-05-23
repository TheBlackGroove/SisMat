package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Alumno;

@Repository
@Transactional
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {
	
	@Modifying
	@Query("Update Alumno a set a.nombrealumno = ?1 where a.id = ?2")
	public void updateAlumno(String nombrealumno, int id);
	
	@Query(value = "select a.* from alumno a inner join usuario u on a.idusuario = u.id where u.ulogin = ?1 limit 1", nativeQuery = true)
	public Iterable<Alumno> BuscarPorCodalumno(String ulogin);
	
	
}
