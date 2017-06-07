package com.sismat.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sismat.Entidades.Carrera;

public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
	
	@Query("Select count(c) from Carrera c where c.codigocarrera = ?1")
	public int ContarCarreraxCodigo(String codigocarrera);
	
	@Query("Update Carrera c set c.nombrecarrera = ?1 where c.id = ?2")
	public void updateCarrera(String nombrecarrera, int idcarrera);
	
	@Query(value = "select ca.* from curso cu inner join carrera ca on ca.id = cu.idcarrera where cu.id = ?1", nativeQuery = true)
	public Carrera SelectByCurso(int idcurso);	
	
}
