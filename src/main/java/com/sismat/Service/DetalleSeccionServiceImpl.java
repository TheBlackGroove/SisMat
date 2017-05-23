package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.DetalleSeccion;
import com.sismat.Repository.DetalleSeccionRepository;

@Service
public class DetalleSeccionServiceImpl implements DetalleSeccionService {

	@Autowired
	private DetalleSeccionRepository detalleseccionrepository;
	
	@Override
	public Iterable<DetalleSeccion> findByTemp(int temp) {
		return detalleseccionrepository.findByTemp(temp);
	}

	@Override
	public DetalleSeccion save(DetalleSeccion detalleseccion) {
		return detalleseccionrepository.save(detalleseccion);
	}

	@Override
	public void DeleteAllTemp() {
		detalleseccionrepository.DeleteAllTemp();		
	}

	@Override
	public void UpdateAllTemp(int idseccion) {
		detalleseccionrepository.UpdateAllTemps(idseccion);
	}
	
	

}
