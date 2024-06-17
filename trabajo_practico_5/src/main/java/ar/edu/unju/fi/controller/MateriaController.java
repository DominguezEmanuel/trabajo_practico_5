package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Carrera;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private Carrera carrera;
	
	@Autowired
	private Docente docente;
	
	@Autowired
	private Materia materia;
	
	@GetMapping("/listado")
	public String getMateriaPage(Model model) {
		model.addAttribute("materias", CollectionMateria.getMaterias());
		model.addAttribute("titulo", "Materias");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaMateriaPage(Model model) {
		Boolean edicion = false;
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		model.addAttribute("docentes", CollectionDocente.getDocentes());
		model.addAttribute("materia", materia);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Materia");
		return "materia";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
		ModelAndView modelView = new ModelAndView("materias");
		String mensaje = "";
		carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		Boolean exito = CollectionMateria.agregarMateria(materia);
		if (exito) {
			mensaje = "Materia guardada con éxito!";
		}else {
			mensaje = "La materia no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("materias", CollectionMateria.getMaterias());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") int codigo) {
		Materia materiaEncontrada = new Materia();
		boolean edicion = true;
		materiaEncontrada = CollectionMateria.buscarMateria(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontrada);
		model.addAttribute("titulo", "Modificar Materia");
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		model.addAttribute("docentes", CollectionDocente.getDocentes());
		return "materia";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") Materia materia, Model model) {
		carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		Boolean exito = false;
		String mensaje = "";
		try {
			CollectionMateria.modificarMateria(materia);
			mensaje = "La materia con codigo " + materia.getCodigo() + " fue modificada con exito!";
			exito = true;
		}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("exito", exito);
		model.addAttribute("materias", CollectionMateria.getMaterias());
		model.addAttribute("titulo", "Materias");
		return "materias";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") int codigo) {
		CollectionMateria.eliminarMateria(codigo);
		return "redirect:/materia/listado";
	}
}
