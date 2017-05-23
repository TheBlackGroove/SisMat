package com.sismat.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.Alumno;
import com.sismat.Entidades.Curso;
import com.sismat.Entidades.Matricula;
import com.sismat.Entidades.Seccion;
import com.sismat.Entidades.Usuario;
import com.sismat.Service.AlumnoService;
import com.sismat.Service.CursoService;
import com.sismat.Service.MatriculaService;
import com.sismat.Service.SeccionService;

@Controller
public class MatriculaController {

	@Autowired
	private AlumnoService alumnoservice;
	
	@Autowired
	private MatriculaService matriculaservice;
	
	@Autowired
	private CursoService cursoservice;
	
	@Autowired
	private SeccionService seccionservice;
	
	@RequestMapping("/matricula")
	public String RedirectMatriculas(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			Alumno alumno = alumnoservice.findByUsuario(usuario);
			model.addAttribute("matriculas", matriculaservice.findByAlumno(alumno));
			model.addAttribute("mensajeerror", "");
			return "matriculas";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/matricula/nuevo")
	public String RedirectMatriculaNuevo(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			Alumno alumno = alumnoservice.findByUsuario(usuario);
			model.addAttribute("curso", new Curso());
			model.addAttribute("cursos", cursoservice.findByCarrera(alumno.getCarrera()));
			model.addAttribute("matricula", new Matricula());
			model.addAttribute("mensajeerror", "");
			model.addAttribute("secciones", new ArrayList<Seccion>());
			return "nuevamatricula";
		}
		else{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/matricula/nuevo/buscar")
	public String BuscarCurso(Model model, HttpServletRequest request, Curso curso){
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		Alumno alumno = alumnoservice.findByUsuario(usuario);
		model.addAttribute("curso", curso);
		model.addAttribute("cursos", cursoservice.findByCarrera(alumno.getCarrera()));
		model.addAttribute("matricula", new Matricula());
		model.addAttribute("mensajeerror", "");
		model.addAttribute("secciones", seccionservice.findByCurso(curso));
		return "nuevamatricula";
	}
	
	@RequestMapping("/matricula/nuevo/guardar")
	public String GuardarMatricula(Model model, HttpServletRequest request, Matricula matricula){
		if(matricula.getSeccion().getId() != 0)
		{
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			Alumno alumno = alumnoservice.findByUsuario(usuario);
			matricula.setAlumno(alumno);
			matriculaservice.save(matricula);
			return "redirect:/matricula";
		}
		else
		{
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario)session.getAttribute("usuario");
			Alumno alumno = alumnoservice.findByUsuario(usuario);
			model.addAttribute("curso", new Curso());
			model.addAttribute("cursos", cursoservice.findByCarrera(alumno.getCarrera()));
			model.addAttribute("matricula", new Matricula());
			model.addAttribute("mensajeerror", "Busque y seleccione una seccion");
			model.addAttribute("secciones", new ArrayList<Seccion>());
			return "nuevamatricula";
		}
	}
	
	@RequestMapping("/matricula/eliminar/{id}")
	public String EliminarMatricula(@PathVariable int id){
		matriculaservice.delete(id);
		return "redirect:/matricula";
	}
	
}
