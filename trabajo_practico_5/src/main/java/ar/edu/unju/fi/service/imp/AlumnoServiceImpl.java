package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IAlumnoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("alumnoServiceMySQL")
public class AlumnoServiceImpl implements IAlumnoService {

	
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private AlumnoMapper alumnoMapper;
	
	
	@Override
	public List<AlumnoDTO> getAlumnos() {
		List<AlumnoDTO> alumnosDTO = alumnoMapper.toAlumnoDTOList(alumnoRepository.findAll());
		return alumnosDTO;
	}

	@Override
	public void agregarMateria(Integer lu , Integer codigo) {
		Alumno alumno = alumnoRepository.findById(lu).get();
		Materia materia = materiaRepository.findById(codigo).get();
		alumno.getMaterias().add(materia);
		alumnoRepository.save(alumno);
		materia.getAlumnos().add(alumno);
		materiaRepository.save(materia);
		log.info("Materia Guardada");
	}
	
	@Override
	public Boolean buscarRepetidos(Integer lu , Integer codigo) {
		Alumno alumno = alumnoRepository.findById(lu).get();
		Materia materia = materiaRepository.findById(codigo).get();
		Boolean alumnoRepetido = false;
		
		for(int i = 0 ; i < materia.getAlumnos().size() ; i++) {
			if(alumno.getLu() == materia.getAlumnos().get(i).getLu()) {
				alumnoRepetido = true;
			}
		}
		
		return alumnoRepetido;
	}
	
	@Override
	public AlumnoDTO buscarAlumno(Integer lu) {
		AlumnoDTO alumnoDTO = alumnoMapper.toAlumnoDTO(alumnoRepository.findById(lu).get());
		log.info("Alumno encontrado");
		return alumnoDTO;
	}
	
	@Override
	public Boolean agregarAlumno(AlumnoDTO alumnoDTO) {
		Boolean respuesta;
		Alumno alumno = alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
		if(alumno != null ) {
			respuesta = true;
			log.info("Alumno agregado");
		}else {
			respuesta = false;
			log.error("No se agregó el alumno");
		}

		return respuesta;
	}

	@Override
	public void eliminarAlumno(Integer lu) {
		 Optional<Alumno> alumnoOpt = alumnoRepository.findById(lu);
	        if (alumnoOpt.isPresent()) {
	            Alumno alumno = alumnoOpt.get();
	            for (Materia materia : alumno.getMaterias()) {
	                materia.getAlumnos().remove(alumno);
	                materiaRepository.save(materia);  // Actualizar la materia en la base de datos
	            }
	            alumnoRepository.delete(alumno);
	        }
	        log.info("Alumno eliminado");
	}

	@Override
	public void modificarAlumno(AlumnoDTO alumnoDTO) throws Exception {
		alumnoRepository.save(alumnoMapper.toAlumno(alumnoDTO));
		log.info("Alumno modificado");
	}

}
