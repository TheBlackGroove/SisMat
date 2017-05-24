package com.sismat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.Alumno;
import com.sismat.Entidades.Perfil;
import com.sismat.Entidades.Usuario;
import com.sismat.Service.AlumnoService;
import com.sismat.Service.CarreraService;
import com.sismat.Service.UsuarioService;

@Controller
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoservice;
	
	@Autowired
	private CarreraService carreraservice;
	
	@Autowired
	private UsuarioService usuarioservice;
	
	@RequestMapping("/alumno")
	public String RedirectAlumno(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("alumnos", alumnoservice.findAll());
			model.addAttribute("busqueda", new Busqueda());
			model.addAttribute("mensajeerror", "");
			return "alumnos";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/alumno/nuevo")
	public String RedirectNuevoAlumno(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("alumno", new Alumno());
			model.addAttribute("carreras", carreraservice.findAll());
			model.addAttribute("mensajeerror", "");
			return "nuevoalumno";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/alumno/nuevo/guardar")
	public String GuardarAlumno(Model model, HttpServletRequest request, Alumno alumno){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			if(!alumno.getNombrealumno().trim().isEmpty() && !alumno.getUsuario().getUlogin().trim().isEmpty() && !alumno.getUsuario().getUpassword().isEmpty()){
				if(alumno.getUsuario().getUlogin().startsWith("U")){
					if(alumno.getUsuario().getUpassword().length() >= 8 && alumno.getUsuario().getUlogin().length() == 6){
						if(usuarioservice.countByUlogin(alumno.getUsuario().getUlogin()) == 0){	
							Usuario usuario = alumno.getUsuario();
							Perfil perfil = new Perfil();
							perfil.setId(2);
							usuario.setPerfil(perfil);
							alumno.setUsuario(usuario);
							alumno.setUsuario(usuarioservice.save(alumno.getUsuario()));
							alumnoservice.save(alumno);
							return "redirect:/alumno";
						}
						else{
							model.addAttribute("mensajeerror", "El codigo de alumno ya esta en uso.");
							model.addAttribute("carreras", carreraservice.findAll());
							model.addAttribute("alumno", alumno);
							return "nuevoalumno";
						}
					}
					else{
						model.addAttribute("mensajeerror", "La contrasena debe de tener por lo menos 8 digitos y el codigo 6.");
						model.addAttribute("carreras", carreraservice.findAll());
						model.addAttribute("alumno", alumno);
						return "nuevoalumno";
					}
				}
				else{
					model.addAttribute("mensajeerror", "El usuario del alumno debe empezar con U.");
					model.addAttribute("carreras", carreraservice.findAll());
					model.addAttribute("alumno", alumno);
					return "nuevoalumno";
				}
			}
			else{
				model.addAttribute("mensajeerror", "Debe de rellenar todos los campos.");
				model.addAttribute("carreras", carreraservice.findAll());
				model.addAttribute("alumno", alumno);
				return "nuevoalumno";
			}
		}
		else{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/alumno/modificar/{id}")
	public String RedirectModificarAlumno(Model model, HttpServletRequest request, @PathVariable int id){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("alumno", alumnoservice.findOne(id));
			model.addAttribute("mensajeerror", "");
			return "modificaralumno";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/alumno/modificar/{id}/modificado")
	public String ModificarAlumno(Model model, HttpServletRequest request, @PathVariable int id, Alumno alumno){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			if(!alumno.getNombrealumno().trim().isEmpty()){
				alumno.setId(id);
				alumnoservice.updateAlumno(alumno);
				return "redirect:/alumno";
			}
			else{
				model.addAttribute("alumno", alumno);
				model.addAttribute("mensajeerror", "El nombre del alumno no puede estar vacio");
				return "modificaralumno";
			}
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/alumno/eliminar/{id}")
	public String EliminarAlumno(HttpServletRequest request, @PathVariable int id){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			Alumno alumno = alumnoservice.findOne(id);
			alumnoservice.delete(id);
			usuarioservice.delete(alumno.getUsuario().getId());
			return "redirect:/alumno";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/alumno/busqueda")
	public String buscaralumno(Model model, Busqueda busqueda){
		model.addAttribute("alumnos",alumnoservice.BuscarPorCodalumno(busqueda.getText()));
		model.addAttribute("busqueda", busqueda);
		model.addAttribute("mensajeerror", "");
		return "alumnos";
	}
}
