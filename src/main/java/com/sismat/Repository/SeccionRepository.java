package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Seccion;

@Repository
@Transactional
public interface SeccionRepository extends CrudRepository<Seccion, Integer> {

	public int countByCodigoseccion(String codigoseccion);
	
}
