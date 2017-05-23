package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Docente;

@Repository
@Transactional
public interface DocenteRepository extends CrudRepository<Docente, Integer> {

}
