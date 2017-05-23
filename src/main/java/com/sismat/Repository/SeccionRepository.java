package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Curso;
import com.sismat.Entidades.Seccion;

@Repository
@Transactional
public interface SeccionRepository extends CrudRepository<Seccion, Integer> {

	public int countByCodigoseccion(String codigoseccion);
	
	@Modifying
	@Query(value = "update seccion s set s.iddocente = ?1 where s.id = ?2", nativeQuery = true)
	public void updateseccion(int iddocente, int id);
	
	public Iterable<Seccion> findByCurso(Curso curso);
}
