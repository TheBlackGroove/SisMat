package com.sismat.Repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sismat.Entidades.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("select u from Usuario u where ulogin = ?1 and upassword = ?2")
	public ArrayList<Usuario> ContarVerificarLogin(String ulogin, String upassword);
	
	@Query(value = "select p.id from usuario u inner join perfil p on p.id = u.idperfil where u.id = ?1", nativeQuery = true)
	public int GetIdPerfilxIdUsaurio(int id);
}
