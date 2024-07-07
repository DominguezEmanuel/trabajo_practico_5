package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.IAlumnoService;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoDTO alumnoDTO;

	@Autowired
	private IAlumnoService alumnoService;

	@GetMapping("/listado")
	public String getAlumnosPage(Model model) {
		model.addAttribute("alumnos", alumnoService.getAlumnos());
		model.addAttribute("titulo", "Alumnos");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "alumnos";
	}

	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
		Boolean edicion = false;
		model.addAttribute("alumno", alumnoDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo Alumno");
		return "alumno";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result) {
		ModelAndView modelView;

		if (result.hasErrors()) {
			modelView = new ModelAndView("alumno");
			modelView.addObject("alumno", alumnoDTO);
			modelView.addObject("titulo", "Nuevo Alumno");
		} else {
			modelView = new ModelAndView("alumnos");
			Boolean exito = alumnoService.agregarAlumno(alumnoDTO);
			String mensaje;
			if (exito) {
				mensaje = "Alumno guardado con éxito!";
			} else {
				mensaje = "El alumno no se pudo guardar";
			}
			modelView.addObject("exito", exito);
			modelView.addObject("mensaje", mensaje);
			modelView.addObject("alumnos", alumnoService.getAlumnos());
		}
		return modelView;
	}

	@GetMapping("/modificar/{lu}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value = "lu") Integer lu) {
		AlumnoDTO alumnoEncontradoDTO = alumnoService.buscarAlumno(lu);
		boolean edicion = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontradoDTO);
		model.addAttribute("titulo", "Modificar Alumno");
		return "alumno";
	}

	@PostMapping("/modificar")
	public String modificarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result , Model model) {
		if(result.hasErrors()) {
			Boolean edicion = true;
			model.addAttribute("alumno" , alumnoDTO);
			model.addAttribute("edicion" , edicion);
			model.addAttribute("titulo" , "Modificar Alumno");
			return "alumno";
		}else {
			Boolean exito = false;
			String mensaje = "";
			try {
				alumnoService.modificarAlumno(alumnoDTO);
				mensaje = "Alumno modificado con exito!";
				exito = true;
			}catch(Exception e) {
				mensaje = e.getMessage();
			}
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("exito", exito);
			model.addAttribute("alumnos", alumnoService.getAlumnos());
			model.addAttribute("titulo", "Alumnos");
			return "alumnos";
		}
	}

	@GetMapping("/eliminar/{lu}")
	public String eliminarAlumno(@PathVariable(value = "lu") Integer lu) {
		alumnoService.eliminarAlumno(lu);
		return "redirect:/alumno/listado";
	}

}
