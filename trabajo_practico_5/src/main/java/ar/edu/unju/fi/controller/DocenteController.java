package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.IDocenteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/docente")
public class DocenteController {

	@Autowired 
	private DocenteDTO docenteDTO;
	
	@Autowired
	private IDocenteService docenteService;
	
	@GetMapping("/listado")
	public String getDocentesPage(Model model) {
		model.addAttribute("docentes", docenteService.getDocentes());
		model.addAttribute("titulo", "Docentes");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "listados/docentes";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		Boolean edicion = false;
		model.addAttribute("docente", docenteDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Docente");
		return "formularios/docente";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@Valid @ModelAttribute("docente") DocenteDTO docenteDTO, BindingResult result) {
		ModelAndView modelView ; 
		if(result.hasErrors()) {
			modelView = new ModelAndView("formularios/docente");
			modelView.addObject("docente", docenteDTO);
			modelView.addObject("titulo","Nuevo Docente");
		}else {
			modelView= new ModelAndView("listados/docentes");
			String mensaje;
			Boolean exito = docenteService.agregarDocente(docenteDTO);
			if (exito) {
				mensaje = "Docente guardado con éxito!";
			}else {
				mensaje = "El docente no se pudo guardar";
			}
			modelView.addObject("exito", exito);
			modelView.addObject("mensaje", mensaje);
			modelView.addObject("docentes", docenteService.getDocentes());
		}
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarDocentePage(Model model, @PathVariable(value="legajo") Integer legajo) {
		DocenteDTO docenteEncontradoDTO = docenteService.buscarDocente(legajo);
		boolean edicion = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontradoDTO);
		model.addAttribute("titulo", "Modificar Docente");
		return "formularios/docente";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@Valid @ModelAttribute("docente") DocenteDTO docenteDTO, BindingResult result , Model model) {
		if(result.hasErrors()) {
			Boolean edicion = true;
			model.addAttribute("docente" , docenteDTO);
			model.addAttribute("edicion" , edicion);
			model.addAttribute("titulo" , "Modificar Docente");
			return "formularios/docente";
		}else {
			Boolean exito = false;
			String mensaje = "";
			try {
				docenteService.modificarDocente(docenteDTO);
				mensaje = "Docente modificado con exito!";
				exito = true;
			}catch(Exception e) {
				mensaje = e.getMessage();
			}
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("exito", exito);
			model.addAttribute("docentes", docenteService.getDocentes());
			model.addAttribute("titulo", "Docentes");
			return "listados/docentes";
		}
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") Integer legajo) {
		docenteService.eliminarDocente(legajo);
		return "redirect:/docente/listado";
	}
}
