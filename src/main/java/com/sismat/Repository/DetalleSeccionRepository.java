package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.DetalleSeccion;

@Repository
@Transactional
public interface DetalleSeccionRepository extends CrudRepository<DetalleSeccion, Integer> {
	
	public Iterable<DetalleSeccion> findByTemp(int temp);
	
	@Modifying
	@Query("Delete from DetalleSeccion d where d.temp = 1")
	public void DeleteAllTemp();
	
	@Modifying
	@Query(value = "Update detalleseccion d set d.temp = 0, d.idseccion = ?1", nativeQuery = true)
	public void UpdateAllTemps(int idseccion);
	
}
