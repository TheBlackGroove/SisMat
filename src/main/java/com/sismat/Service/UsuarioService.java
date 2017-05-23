package com.sismat.Service;

import com.sismat.Entidades.Usuario;

public interface UsuarioService {
	public int ContarVerificarLogin(Usuario usuario);
	public Usuario findOne(int id);
	public int GetIdPerfilxIdUsaurio(int id);
	public Usuario save(Usuario usuario);
	public void delete(int id);
	public int countByUlogin(String ulogin);
}
