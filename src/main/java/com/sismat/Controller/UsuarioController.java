package com.sismat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.Usuario;
import com.sismat.Service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioservice;
	
	@RequestMapping("/")
	public String RedirectIndex(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		model.addAttribute("usuario", new Usuario());
		if(Util.VerificarEstadoLogin(session)){
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			boolean admin;
			if (usuario.getPerfil().getId() == 1) admin = true; else admin = false;
			model.addAttribute("admin", admin);
			model.addAttribute("mensajeerror", "");
			return "dashboard";
		}
		else{
			model.addAttribute("mensajeError", "");
			return "index";
		}		
	}
	
	@RequestMapping("/login")
	public String VerificarLogin(Model model, HttpServletRequest request, Usuario usuario){
		HttpSession session = request.getSession();
		int id = usuarioservice.ContarVerificarLogin(usuario);
		if(id != 0){
			usuario  = usuarioservice.findOne(id);
			boolean admin;
			if (usuario.getPerfil().getId() == 1) admin = true; else admin = false;
			model.addAttribute("admin", admin);
			session.setAttribute("usuario", usuario);
			return "redirect:/";
		}
		else{
			model.addAttribute("mensajeError", "Ingrese los datos correctamente");
			model.addAttribute("usuario", new Usuario());
			return "index";
		}
	}
}
