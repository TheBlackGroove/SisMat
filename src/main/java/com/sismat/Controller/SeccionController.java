package com.sismat.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.DetalleSeccion;
import com.sismat.Entidades.Seccion;
import com.sismat.Service.CursoService;
import com.sismat.Service.DetalleSeccionService;
import com.sismat.Service.DocenteService;
import com.sismat.Service.SeccionService;

@Controller
public class SeccionController {

	@Autowired
	private SeccionService seccionservice;
	
	@Autowired
	private DocenteService docenteservice;
	
	@Autowired 
	private CursoService cursoservice;
	
	@Autowired
	private DetalleSeccionService detalleseccionservice;
	
	@RequestMapping("/seccion")
	public String RedirectSeccion(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("secciones", seccionservice.findAll());
			model.addAttribute("mensajeerror", "");
			return "secciones";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/seccion/nuevo")
	public String RedirectNuevaSeccion(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			detalleseccionservice.DeleteAllTemp();
			model.addAttribute("seccion", new Seccion());
			model.addAttribute("cursos", cursoservice.findAll());
			model.addAttribute("detalleseccion",new DetalleSeccion());
			model.addAttribute("docentes", docenteservice.findAll());
			model.addAttribute("mensajeerror", "");
			model.addAttribute("listahorarios", new ArrayList<DetalleSeccion>());
			return "nuevaseccion";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/seccion/nuevo/horario")
	public String AñadirnuevohorarioTemp(Model model, DetalleSeccion detalleseccion, Seccion seccion){
		if(detalleseccion.getHorainicio() <= detalleseccion.getHorafinal()){
			if(detalleseccion.getHorafinal() - detalleseccion.getHorafinal() <= 4){
				detalleseccion.setTemp(1);
				detalleseccionservice.save(detalleseccion);
				model.addAttribute("seccion", seccion);
				model.addAttribute("cursos", cursoservice.findAll());
				model.addAttribute("detalleseccion",detalleseccion);
				model.addAttribute("docentes", docenteservice.findAll());
				model.addAttribute("mensajeerror", "");
				model.addAttribute("listahorarios", detalleseccionservice.findByTemp(1));
				return "nuevaseccion";
			}
			else{
				model.addAttribute("seccion", seccion);
				model.addAttribute("cursos", cursoservice.findAll());
				model.addAttribute("detalleseccion",detalleseccion);
				model.addAttribute("docentes", docenteservice.findAll());
				model.addAttribute("mensajeerror", "La hora clase no debe de durar mas de 4 horas.");
				model.addAttribute("listahorarios", detalleseccionservice.findByTemp(1));
				return "nuevaseccion";
			}
		}
		else{
			model.addAttribute("seccion", seccion);
			model.addAttribute("cursos", cursoservice.findAll());
			model.addAttribute("detalleseccion",detalleseccion);
			model.addAttribute("docentes", docenteservice.findAll());
			model.addAttribute("mensajeerror", "La hora inicial debe ser menor que la hora final.");
			model.addAttribute("listahorarios", detalleseccionservice.findByTemp(1));
			return "nuevaseccion";
		}
	}
	
	@RequestMapping("/seccion/nuevo/guardar")
	public String GuardarNuevaSeccion(Model model, Seccion seccion){
		if(seccion.getCodigoseccion().startsWith("cv") || seccion.getCodigoseccion().startsWith("CV")){
			if(seccionservice.countByCodigoseccion(seccion.getCodigoseccion()) == 0){
				seccion = seccionservice.save(seccion);
				detalleseccionservice.UpdateAllTemp(seccion.getId());
				return "redirect:/seccion";	
			}
			else{
				model.addAttribute("seccion", seccion);
				model.addAttribute("cursos", cursoservice.findAll());
				model.addAttribute("detalleseccion", new DetalleSeccion());
				model.addAttribute("docentes", docenteservice.findAll());
				model.addAttribute("mensajeerror", "El codigo de la seccion ya esta en uso.");
				model.addAttribute("listahorarios", detalleseccionservice.findByTemp(1));
				return "nuevaseccion";
			}			
		}
		else{
			model.addAttribute("seccion", seccion);
			model.addAttribute("cursos", cursoservice.findAll());
			model.addAttribute("detalleseccion", new DetalleSeccion());
			model.addAttribute("docentes", docenteservice.findAll());
			model.addAttribute("mensajeerror", "El codigo de la seccion debe empezar con CV.");
			model.addAttribute("listahorarios", detalleseccionservice.findByTemp(1));
			return "nuevaseccion";
		}		
	}
	
	@RequestMapping("/seccion/modificar/{id}")
	public String RedirectModificarSeccion(Model model, @PathVariable int id){
		
	}
}
