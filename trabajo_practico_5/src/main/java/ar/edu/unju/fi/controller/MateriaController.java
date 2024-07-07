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

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.ICarreraService;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.service.IMateriaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private CarreraDTO carreraDTO;
	
	@Autowired
	private DocenteDTO docenteDTO;
	
	@Autowired
	private MateriaDTO materiaDTO;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IDocenteService docenteService;
	
	@Autowired
	private ICarreraService carreraService;

	
	@GetMapping("/listado")
	public String getMateriaPage(Model model) {
		model.addAttribute("materias", materiaService.getMaterias());
		model.addAttribute("titulo", "Materias");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaMateriaPage(Model model) {
		Boolean edicion = false;
		model.addAttribute("carreras", carreraService.getCarreras());
		model.addAttribute("docentes", docenteService.getDocentes());
		model.addAttribute("materia", materiaDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Materia");
		return "materia";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("materia");
			modelView.addObject("materia",materiaDTO);
			modelView.addObject("docentes", docenteService.getDocentes());
			modelView.addObject("carreras", carreraService.getCarreras());
			modelView.addObject("titulo","Nueva Materia");
		}else {
			modelView = new ModelAndView("materias");
			String mensaje = "";
			carreraDTO = carreraService.buscarCarrera(materiaDTO.getCarrera().getCodigo());
			docenteDTO = docenteService.buscarDocente(materiaDTO.getDocente().getLegajo());
			materiaDTO.setCarrera(carreraDTO);
			materiaDTO.setDocente(docenteDTO);
			Boolean exito = materiaService.agregarMateria(materiaDTO);
			if (exito) {
				mensaje = "Materia guardada con éxito!";
			}else {
				mensaje = "La materia no se pudo guardar";
			}
			modelView.addObject("exito", exito);
			modelView.addObject("mensaje", mensaje);
			modelView.addObject("materias", materiaService.getMaterias());
		}
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") int codigo) {
		MateriaDTO materiaEncontradaDTO = materiaService.buscarMateria(codigo);
		boolean edicion = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontradaDTO);
		model.addAttribute("titulo", "Modificar Materia");
		model.addAttribute("carreras", carreraService.getCarreras());
		model.addAttribute("docentes", docenteService.getDocentes());
		return "materia";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result , Model model) {
		if(result.hasErrors()) {
			Boolean edicion = true;
			model.addAttribute("edicion", edicion);
			model.addAttribute("materia", materiaDTO);
			model.addAttribute("titulo", "Modificar Materia");
			model.addAttribute("carreras", carreraService.getCarreras());
			model.addAttribute("docentes", docenteService.getDocentes());
			return "materia";
		}else {
			carreraDTO = carreraService.buscarCarrera(materiaDTO.getCarrera().getCodigo());
			docenteDTO = docenteService.buscarDocente(materiaDTO.getDocente().getLegajo());
			materiaDTO.setCarrera(carreraDTO);
			materiaDTO.setDocente(docenteDTO);
			Boolean exito = false;
			String mensaje = "";
			try {
				materiaService.modificarMateria(materiaDTO);
				mensaje = "Materia modificada con exito!";
				exito = true;
			}catch(Exception e) {
				mensaje = e.getMessage();
			}
			model.addAttribute("mensaje", mensaje);
			model.addAttribute("exito", exito);
			model.addAttribute("materias", materiaService.getMaterias());
			model.addAttribute("titulo", "Materias");
			return "materias";
		}
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") int codigo) {
		materiaService.eliminarMateria(codigo);
		return "redirect:/materia/listado";
	}
	
	

}
