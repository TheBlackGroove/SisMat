package com.sismat.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Docente;

@Repository
@Transactional
public interface DocenteRepository extends CrudRepository<Docente, Integer> {
	
	@Modifying
	@Query("Update Docente d set d.nombredocente = ?1 where d.id = ?2")
	public void updateDocente(String nombredocente, int id);
	
	@Query(value = "select d.* from docente d inner join usuario u on d.idusuario = u.id where u.ulogin = ?1 limit 1", nativeQuery = true)
	public Iterable<Docente> BuscarPorCoddocente(String ulogin);
	
	
}
