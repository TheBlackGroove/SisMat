package com.sismat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.Docente;
import com.sismat.Repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	private DocenteRepository docenterepository;
	
	@Override
	public Iterable<Docente> findAll() {
		return docenterepository.findAll();
	}

	@Override
	public Docente save(Docente docente) {
		return docenterepository.save(docente);
	}

	@Override
	public Docente findOne(int id) {
		return docenterepository.findOne(id);
	}

	@Override
	public void update(Docente docente) {
		docenterepository.updateDocente(docente.getNombredocente(), docente.getId());		
	}

	@Override
	public Iterable<Docente> BuscarPorCoddocente(String codigodocente) {
		return docenterepository.BuscarPorCoddocente(codigodocente);
	}

	@Override
	public void delete(int id) {
		docenterepository.delete(id);
		
	}

}
