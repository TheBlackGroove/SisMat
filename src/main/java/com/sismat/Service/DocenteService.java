package com.sismat.Service;

import com.sismat.Entidades.Docente;

public interface DocenteService {
	public Iterable<Docente> findAll();
	public Docente save(Docente docente);
	public Docente findOne(int id);
	public void update(Docente docente);
	public Iterable<Docente> BuscarPorCoddocente(String codigodocente);
	public void delete(int id);
}
