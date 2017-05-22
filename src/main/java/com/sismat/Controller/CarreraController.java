package com.sismat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.Carrera;
import com.sismat.Service.CarreraService;

@Controller
public class CarreraController {
	
	@Autowired
	private CarreraService carreraservice;

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
		if(carrera.getNombrecarrera().trim().length() != 0 || carrera.getCodigocarrera().trim().length() != 0){
			if(!carrera.getCodigocarrera().contains(" ")){
				if(carrera.getCodigocarrera().startsWith("CV")){
					carrera = carreraservice.save(carrera);
					return "redirect:/carrera";
				}
				else{
					model.addAttribute("carrera",carrera);
					model.addAttribute("mensajeerror", "El codigo de la carrera debe empezar con CV.");
					return "nuevacarrera";
				}
			}
			else{
				model.addAttribute("carrera",carrera);
				model.addAttribute("mensajeerror", "El codigo de la carrera no puede tener espacios en blanco.");
				return "nuevacarrera";
			}
		}
		else{
			model.addAttribute("carrera",carrera);
			model.addAttribute("mensajeerror", "Llene todos los campos en blanco.");
			return "nuevacarrera";
		}
	}
	
	@RequestMapping("/carrera")
	public RedireccionarCarrera(){
		
	}
	
}
