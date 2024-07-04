package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.ICarreraService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	private CarreraDTO carreraDTO;
	
	@Autowired
	private ICarreraService carreraService;
	
	@GetMapping("/listado")
	public String getCarrerasPage(Model  model) {
		model.addAttribute("carreras", carreraService.getCarreras());
		model.addAttribute("titulo", "Carreras");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "carreras";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		boolean edicion = false;
		model.addAttribute("carrera", carreraDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Carrera");
		return "carrera";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO) {
		ModelAndView modelView = new ModelAndView("carreras");
		String mensaje;
		carreraDTO.setEstado("true");
		Boolean exito = carreraService.agregarCarrera(carreraDTO);
		if (exito) {
			mensaje = "Carrera guardada con éxito!";
		}else {
			mensaje = "La Carrera no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("carreras", carreraService.getCarreras());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="codigo") int codigo) {
		CarreraDTO carreraEncontradaDTO = carreraService.buscarCarrera(codigo);
		boolean edicion = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontradaDTO);
		model.addAttribute("titulo", "Modificar Carrera");
		return "carrera";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO, Model model) {
		Boolean exito = false;
		String mensaje = "";
		try {
			carreraService.modificarCarrera(carreraDTO);
			mensaje = "Carrera modificada con exito!";
			exito = true;
		}catch(Exception e) {
			mensaje = e.getMessage();
		}
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("exito", exito);
		model.addAttribute("carreras", carreraService.getCarreras());
		model.addAttribute("titulo", "Carreras");
		return "carreras";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo") int codigo) {
		carreraService.eliminarCarrera(codigo);
		return "redirect:/carrera/listado";
	}
	
}
