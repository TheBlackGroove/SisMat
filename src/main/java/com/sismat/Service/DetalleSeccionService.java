package com.sismat.Service;

import com.sismat.Entidades.DetalleSeccion;

public interface DetalleSeccionService {
	public Iterable<DetalleSeccion> findByTemp(int temp);
	public DetalleSeccion save(DetalleSeccion detalleseccion);
	public void DeleteAllTemp();
	public void UpdateAllTemp(int idseccion);
	
}
