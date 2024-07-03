package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.ICarreraService;

@Controller
@RequestMapping("/consulta")
public class ConsultaAlumnosMateriasController {

	@Autowired
	IAlumnoService alumnoService;
	@Autowired
	ICarreraService carreraService;
	@GetMapping("/alumnos")
	public String getConsultaPage(Model model, @RequestParam(required = false)Integer carreraCodigo) {
		model.addAttribute("carreras", carreraService.getCarreras());
		model.addAttribute("titulo", "Consulta de Alumnos");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");

		return "consultaAlumnoCarrera";
	}
	
	
	//Aqui usé la anotación RequestParam que recibe parametros directamente desde la página
	@PostMapping("/buscar")
	public String getAlumnosByCarrera(@RequestParam Integer carreraCodigo, Model model ) {
		model.addAttribute("carreras", carreraService.getCarreras());
	    model.addAttribute("alumnos", carreraService.getAlumnosCarrera(carreraCodigo));
		model.addAttribute("titulo", "Consulta de Alumnos");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "consultaAlumnoCarrera";
	}
}
