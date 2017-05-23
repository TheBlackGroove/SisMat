package com.sismat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.Curso;
import com.sismat.Service.CarreraService;
import com.sismat.Service.CursoService;

@Controller
public class CursoController {

	 @Autowired
	 private CursoService cursoservice;
	 
	 @Autowired
	 private CarreraService carreraservice;
	
	@RequestMapping("/curso")
	public String RedirectCurso(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("cursos", cursoservice.findAll());
			return "cursos";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/curso/nuevo")
	public String RedirectNuevoCurso(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("curso", new Curso());
			model.addAttribute("carreras", carreraservice.findAll());
			model.addAttribute("mensajeerror", "");
			return "nuevocurso";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/curso/nuevo/guardar")
	public String GuardarNuevoCurso(Model model, HttpServletRequest request, Curso curso){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			if(!curso.getCodigocurso().contains(" ")){
				if(curso.getCodigocurso().length() == 5){
					if(cursoservice.countByCodigocurso(curso.getCodigocurso()) == 0 && cursoservice.countByNombrecurso(curso.getNombrecurso()) == 0){
						cursoservice.save(curso);
						return "redirect:/curso";
					}
					else{
						model.addAttribute("mensajeerror", "El codigo del curso debe de ser de 5 digitos.");
						model.addAttribute("curso", curso);
						model.addAttribute("carreras", carreraservice.findAll());
						return "nuevocurso";
					}
				}
				else{
					model.addAttribute("mensajeerror", "El codigo del curso debe de ser de 5 digitos.");
					model.addAttribute("curso", curso);
					model.addAttribute("carreras", carreraservice.findAll());
					return "nuevocurso";
				}
			}
			else{
				model.addAttribute("mensajeerror", "No deben de haber espacios en blanco en el codigo del curso.");
				model.addAttribute("curso", curso);
				model.addAttribute("carreras", carreraservice.findAll());
				return "nuevocurso";
			}
		}
		else
		{
			return "redirect:/";
		}
		
	}
}

