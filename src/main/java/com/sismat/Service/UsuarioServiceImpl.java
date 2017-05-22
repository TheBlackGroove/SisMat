package com.sismat.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sismat.Entidades.Usuario;
import com.sismat.Repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Override
	public int ContarVerificarLogin(Usuario usuario) {
		ArrayList<Usuario> lista = usuariorepository.ContarVerificarLogin(usuario.getUlogin(), usuario.getUpassword());
		int cont = lista.size();
		if (cont > 0){
			return lista.get(0).getId();
		}
		else{
			return 0;
		}
	}

	@Override
	public Usuario findOne(int id) {
		return usuariorepository.findOne(id);
	}

	@Override
	public int GetIdPerfilxIdUsaurio(int id) {
		return usuariorepository.GetIdPerfilxIdUsaurio(id);
	}
	

}
