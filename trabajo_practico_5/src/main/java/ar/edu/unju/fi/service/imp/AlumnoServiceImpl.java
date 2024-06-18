package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private AlumnoMapper alumnoMapper;
	
	
	@Override
	public List<AlumnoDTO> getAlumnos() {
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(CollectionAlumno.getAlumnos());
		return alumnosDTO;
	}

	@Override
	public AlumnoDTO buscarAlumno(String lu) {
		AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(CollectionAlumno.buscarAlumno(lu));
		return alumnoDTO;
	}

	@Override
	public Boolean agregarAlumno(AlumnoDTO alumnoDTO) {
		Boolean respuesta = CollectionAlumno.agregarAlumno(alumnoMapper.toAlumno(alumnoDTO));
		return respuesta;
	}

	@Override
	public void eliminarAlumno(String lu) {
		CollectionAlumno.eliminarAlumno(lu);

	}

	@Override
	public void modificarAlumno(AlumnoDTO alumnoDTO) throws Exception {
		CollectionAlumno.modificarAlumno(alumnoMapper.toAlumno(alumnoDTO));
	}

}
