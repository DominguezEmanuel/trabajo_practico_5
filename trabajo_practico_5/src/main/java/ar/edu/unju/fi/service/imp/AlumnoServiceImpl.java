package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.IAlumnoService;

@Service("alumnoServiceMySQL")
public class AlumnoServiceImpl implements IAlumnoService {

	
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AlumnoMapper alumnoMapper;
	
	
	@Override
	public List<AlumnoDTO> getAlumnos() {
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(alumnoRepository.findAll());
		return alumnosDTO;
	}

	@Override
	public AlumnoDTO buscarAlumno(Integer lu) {
		AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(alumnoRepository.findById(lu).get());
		return alumnoDTO;
	}
	
	@Override
	public Boolean agregarAlumno(AlumnoDTO alumnoDTO) {
		Boolean respuesta;
		Alumno alumno = alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
		if(alumno != null ) {
			respuesta = true;
		}else {
			respuesta = false;
		}
		return respuesta;
	}

	@Override
	public void eliminarAlumno(Integer lu) {
		Alumno alumno = alumnoRepository.findById(lu).get();
		alumnoRepository.delete(alumno);
	}

	@Override
	public void modificarAlumno(AlumnoDTO alumnoDTO) throws Exception {
		alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
	}

}
