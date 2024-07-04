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
@RequestMapping("/filtrar")
public class filtrarAlumnoMateriaController {
	
	@Autowired
	IAlumnoService alumnoService;
	
	@Autowired
	IMateriaService materiaService;
	
	@GetMapping("/alumnos")
	public String getConsultaPage(Model model, @RequestParam(required = false) Integer materiaCodigo) {
		model.addAttribute("materias", materiaService.getMaterias());
		model.addAttribute("titulo", "Filtrado de alumnos");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "filtrarAlumnosMateria";
	}
	
	@PostMapping("/buscar")
	public String getAlumnosByMateria(@RequestParam Integer materiaCodigo, Model model) {
		model.addAttribute("materias", materiaService.getMaterias());
		model.addAttribute("alumnos", materiaService.getAlumnosMateria(materiaCodigo));
		model.addAttribute("materiaSeleccionada", materiaService.buscarMateria(materiaCodigo).getNombre());
		model.addAttribute("titulo", "Filtrado de Alumnos");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "filtrarAlumnosMateria";
	}
}
