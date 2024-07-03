package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionAlumnoController {

	@Autowired
	private IAlumnoService alumnoService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping("/listado_materias")
	public String listadoDeMateriasPage(Model model) {
		Boolean inscripto = false;
		String mensaje = "";
		model.addAttribute("materias" , materiaService.getMaterias());
		model.addAttribute("alumnos" , alumnoService.getAlumnos());
		model.addAttribute("inscripto" , inscripto);
		model.addAttribute("mensaje" , mensaje);
		return "inscripcion_form";
	}
	
	@PostMapping("/materias")
	public String inscripcionAMateriasPage(Model model , @RequestParam Integer materiaCodigo , @RequestParam Integer alumnoLu) {
		Boolean inscripto = false;
		String mensaje = "";
		try {
			alumnoService.agregarMateria(alumnoLu, materiaCodigo);
			mensaje = "Alumno inscripto correctamente";
			inscripto = true;
		}catch(Exception e) {
			mensaje = "Ha ocurrido un pronlema durante la inscripción";
		}
		model.addAttribute("materias" , materiaService.getMaterias());
		model.addAttribute("alumnos" , alumnoService.getAlumnos());
		model.addAttribute("inscripto" , inscripto);
		model.addAttribute("mensaje" , mensaje);
		return "inscripcion_form";
	}
}
