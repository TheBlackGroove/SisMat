package com.sismat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
				if(curso.getCodigocurso().length() == 5 && curso.getNombrecurso().trim().length() > 0){
					if(cursoservice.countByCodigocurso(curso.getCodigocurso()) == 0 && cursoservice.countByNombrecurso(curso.getNombrecurso()) == 0){
						cursoservice.save(curso);
						return "redirect:/curso";
					}
					else{
						model.addAttribute("mensajeerror", "El codigo del curso debe de ser de 5 digitos y el nombre del curso no debe estar vacio.");
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
	
	@RequestMapping("/curso/eliminar/{id}")
	public String EliminarCurso(HttpServletRequest request, @PathVariable int id){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			cursoservice.delete(id);
			return "redirect:/curso";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/curso/modificar/{id}")
	public String RedirectModificarCurso(HttpServletRequest request, Model model, @PathVariable int id){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("curso", cursoservice.findOne(id));
			model.addAttribute("mensajeerror", "");
			return "modificarcurso";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/curso/modificar/{id}/modificado")
	public String ModificarCurso(Model model, HttpServletRequest request, @PathVariable int id, Curso curso){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			if(!curso.getCodigocurso().contains(" ")){
				if(curso.getCodigocurso().length() == 5 && curso.getNombrecurso().trim().length() > 0){
					if(cursoservice.countByCodigocurso(curso.getCodigocurso()) == 0 && cursoservice.countByNombrecurso(curso.getNombrecurso()) == 0){
						cursoservice.updateCurso(curso);
						return "redirect:/curso";
					}
					else{
						model.addAttribute("mensajeerror", "El curso ya existe en la base de datos.");
						model.addAttribute("curso", curso);
						return "modificarcurso";
					}
				}
				else{
					model.addAttribute("mensajeerror", "El codigo del curso debe de ser de 5 digitos y el nombre del curso no debe estar vacio.");
					model.addAttribute("curso", curso);
					return "modificarcurso";
				}
			}
			else{
				model.addAttribute("mensajeerror", "No deben de haber espacios en blanco en el codigo del curso.");
				model.addAttribute("curso", curso);
				return "modificarcurso";
			}
		}
		else{
			return "redirect:/";
		}
	}
	
}

