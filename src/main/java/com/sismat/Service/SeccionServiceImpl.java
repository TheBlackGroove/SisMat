package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.Seccion;
import com.sismat.Repository.SeccionRepository;

@Service
public class SeccionServiceImpl implements SeccionService {

	@Autowired
	private SeccionRepository seccionrepository;
	
	@Override
	public Iterable<Seccion> findAll() {
		return seccionrepository.findAll();
	}

	@Override
	public Seccion save(Seccion seccion) {
		return seccionrepository.save(seccion);
	}

	@Override
	public int countByCodigoseccion(String codigoseccion) {
		return seccionrepository.countByCodigoseccion(codigoseccion);
	}	

}
