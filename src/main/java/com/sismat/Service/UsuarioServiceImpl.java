package com.sismat.Service;

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
		return usuariorepository.ContarVerificarLogin(usuario.getUlogin(), usuario.getUpassword()).size();
	}

}
