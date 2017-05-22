package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sismat.Entidades.Carrera;
import com.sismat.Repository.CarreraRepository;

public class CarreraServiceImpl implements CarreraService {

	@Autowired
	private CarreraRepository carrerarepository;
	
	@Override
	public Carrera save(Carrera carrera) {
		return carrerarepository.save(carrera);
	}

}
