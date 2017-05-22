package com.sismat.Service;

import com.sismat.Entidades.Usuario;

public interface UsuarioService {
	public int ContarVerificarLogin(Usuario usuario);
	public Usuario findOne(int id);
}
