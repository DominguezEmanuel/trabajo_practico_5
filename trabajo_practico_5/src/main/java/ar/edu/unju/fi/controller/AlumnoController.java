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
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IAlumnoService;
import ar.edu.unju.fi.service.IMateriaService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoDTO alumnoDTO;
	
	@Autowired
	private MateriaDTO materiaDTO;
	
	@Autowired
	private MateriaMapper materiaMapper;
	
	@Autowired
	private IAlumnoService alumnoService;
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
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
	public ModelAndView guardarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO) {
		ModelAndView modelView = new ModelAndView("alumnos");
		String mensaje;
		Boolean exito = alumnoService.agregarAlumno(alumnoDTO);
		if (exito) {
			mensaje = "Alumno guardado con éxito!";
		}else {
			mensaje = "El alumno no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("alumnos", alumnoService.getAlumnos());
		return modelView;
	}
	
	@GetMapping("/modificar/{lu}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="lu") Integer lu) {
		AlumnoDTO alumnoEncontradoDTO = alumnoService.buscarAlumno(lu);
		boolean edicion = true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontradoDTO);
		model.addAttribute("titulo", "Modificar Alumno");
		return "alumno";
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnoDTO, Model model) {
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
	
	@GetMapping("/eliminar/{lu}")
	public String eliminarAlumno(@PathVariable(value="lu") Integer lu) {
		alumnoService.eliminarAlumno(lu);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/inscripcion/{codigo}")
	public String inscripcionAlumnoEnMateriaPage(Model model, @PathVariable(value="codigo") Integer codigo) {
		//MateriaDTO materiaEncontradaDTO = materiaService.buscarMateria(codigo);
		//Materia materia = materiaMapper.toMateria(materiaEncontradaDTO);
		//AlumnoDTO alumnoDTO = new AlumnoDTO();
		model.addAttribute("titulo", "Formulario de Inscripción");
		model.addAttribute("materias" , materiaService.getMaterias());
		//model.addAttribute("alumnos" , alumnoService.getAlumnos());
		//model.addAttribute("alumno" , alumnoDTO);
		return "inscripcion_form";
	}
}
