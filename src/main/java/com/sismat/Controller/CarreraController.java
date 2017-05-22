package com.sismat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.Carrera;

@Controller
public class CarreraController {

	@RequestMapping("/carrera/nuevo")
	public String RedirectNuevaCarrera(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("carrera", new Carrera());
			model.addAttribute("mensajeerror", "");
			return "nuevacarrera";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/carrera/nuevo/guardar")
	public String GuardarNuevaCarrera(Model model, Carrera carrera){
		return "dashboard";
	}
	
}
