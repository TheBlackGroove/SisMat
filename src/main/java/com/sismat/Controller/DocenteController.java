package com.sismat.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sismat.Entidades.Docente;
import com.sismat.Entidades.Perfil;
import com.sismat.Entidades.Usuario;
import com.sismat.Service.DocenteService;
import com.sismat.Service.UsuarioService;

@Controller
public class DocenteController {

	@Autowired
	private DocenteService docenteservice;
	
	@Autowired
	private UsuarioService usuarioservice;
	
	@RequestMapping("/docente")
	public String RedirectDocente(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("docentes", docenteservice.findAll());
			model.addAttribute("busqueda", new Busqueda());
			return "docentes";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/docente/nuevo")
	public String RedirectDocenteNuuevo(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			model.addAttribute("docente", new Docente());
			model.addAttribute("mensajeerror", "");
			return "nuevodocente";
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/docente/nuevo/guardar")
	public String GuardarDocente(Model model, HttpServletRequest request, Docente docente){
		HttpSession session = request.getSession();
		if(Util.VerificarEstadoLogin(session)){
			if(!docente.getUsuario().getUlogin().trim().isEmpty() || !docente.getNombredocente().trim().isEmpty() || !docente.getUsuario().getUlogin().trim().isEmpty()){
				if(!docente.getUsuario().getUlogin().contains(" ")){
					if(usuarioservice.countByUlogin(docente.getUsuario().getUlogin()) == 0){
						if(docente.getUsuario().getUlogin().startsWith("D")){
							Usuario usuario = docente.getUsuario();
							Perfil perfil = new Perfil();
							perfil.setId(1);
							usuario.setPerfil(perfil);
							docente.setUsuario(usuario);
							docente.setUsuario(usuarioservice.save(docente.getUsuario()));
							docenteservice.save(docente);
							return "redirect:/docente";
						}
						else{
							model.addAttribute("docente", docente);
							model.addAttribute("mensajeerror", "El codigo del docente debe empezar con D.");
							return "nuevodocente";
						}
					}
					else{
						model.addAttribute("docente", docente);
						model.addAttribute("mensajeerror", "El codigo de usuario ya esta en uso.");
						return "nuevodocente";
					}
				}
				else{
					model.addAttribute("docente", docente);
					model.addAttribute("mensajeerror", "No se permiten Espacios en blanco en el codigo del docente.");
					return "nuevodocente";
				}
			}
			else{
				model.addAttribute("docente", docente);
				model.addAttribute("mensajeerror", "Debe llenar los campos en blanco.");
				return "nuevodocente";
			}
		}
		else{
			return "redirect:/";
		}
	}
	
	@RequestMapping("/docente/modificar/{id}")
	public String RedirectModificarDocente(Model model, @PathVariable int id){
		model.addAttribute("docente",docenteservice.findOne(id));
		model.addAttribute("mensajeerror", "");
		return "modificardocente";
	}
	
	@RequestMapping("/docente/modificar/{id}/modificado")
	public String ModificarDocente(Model model, @PathVariable int id, Docente docente){
		if(docente.getNombredocente().trim().length() != 0){
			docente.setId(id);
			docenteservice.update(docente);
			return "redirect:/docente";
		}
		else{
			model.addAttribute("docente", docente);
			model.addAttribute("mensajeerror", "El nombre no puede estar vacio");
			return "modificardocente";
		}
	}
	
	@RequestMapping("/docente/busqueda")
	public String BuscarDocente(Model model, Busqueda busqueda){
		model.addAttribute("docentes",docenteservice.BuscarPorCoddocente(busqueda.getText()));
		model.addAttribute("busqueda", busqueda);
		model.addAttribute("mensajeerror", "");
		return "docentes";
	}
	
	@RequestMapping("/docente/eliminar/{id}")
	public String DeleteDocente(Model model, @PathVariable int id){
		Docente docente = docenteservice.findOne(id);
		usuarioservice.delete(docente.getUsuario().getId());
		docenteservice.delete(id);
		return "redirect:/docentes";
	}
	
}
