package com.sismat.Service;

import org.springframework.stereotype.Service;

import com.sismat.Entidades.Seccion;

@Service
public interface SeccionService {
	public Iterable<Seccion> findAll();
	public Seccion save(Seccion seccion);
	public int countByCodigoseccion(String codigoseccion);
}
