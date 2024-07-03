package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;

public interface IAlumnoService {
	
	List<AlumnoDTO> getAlumnos();
	
	AlumnoDTO buscarAlumno(Integer lu);
	
	void agregarMateria(Integer lu , Integer codigo);
	
	Boolean agregarAlumno(AlumnoDTO alumnoDTO);
		
	void eliminarAlumno(Integer lu);
	
	void modificarAlumno(AlumnoDTO alumnoDTO) throws Exception;
	
	
}
