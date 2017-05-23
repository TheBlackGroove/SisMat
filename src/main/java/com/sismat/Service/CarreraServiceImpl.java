package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.Carrera;
import com.sismat.Repository.CarreraRepository;

@Service
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	private CarreraRepository carrerarepository;
	
	@Override
	public Carrera save(Carrera carrera) {
		return carrerarepository.save(carrera);
	}

	@Override
	public boolean VerificarCodigoCarrera(String codigocarrera) {
		int cont = carrerarepository.ContarCarreraxCodigo(codigocarrera);
		if (cont > 0) return false; else return true;
	}

	@Override
	public Iterable<Carrera> findAll() {
		return carrerarepository.findAll();
	}

	@Override
	public Carrera findOne(int id) {
		return carrerarepository.findOne(id);
	}

}
