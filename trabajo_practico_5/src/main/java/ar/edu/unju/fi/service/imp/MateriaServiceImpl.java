package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("materiaServiceMySQL")
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private MateriaMapper materiaMapper;
	@Autowired
	private AlumnoMapper alumnoMapper;

	@Override
	public List<MateriaDTO> getMaterias() {
		List<Materia> materias = materiaRepository.findAll();
		List<MateriaDTO> materiasDTO =  new ArrayList<MateriaDTO>();
		for(Materia m: materias) {
			if(m.getEstado() == true) {
				materiasDTO.add(materiaMapper.toMateriaDTO(m));
			}
		}
		return materiasDTO;
	}

	@Override
	public MateriaDTO buscarMateria(int codigo) {
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(materiaRepository.findById(codigo).get());
		log.info("Materia encontrada");
		return materiaDTO;
	}

	@Override
	public Boolean agregarMateria(MateriaDTO materiaDTO) {
		Boolean respuesta;
		Materia nuevaMateria = materiaMapper.toMateria(materiaDTO);
		nuevaMateria.setEstado(true);
		Materia materia = materiaRepository.save(nuevaMateria);
		if (materia != null) {
			respuesta = true;
			log.info("Materia agregada");
		} else {
			respuesta = false;
			log.error("No se pudo agregar la materia");
		}
		return respuesta;
	}

	@Override
	public void eliminarMateria(int codigo) {
		Materia materia = materiaRepository.findById(codigo).get();
		materia.setEstado(false);
		materiaRepository.save(materia);
		log.info("Materia eliminada");
	}

	@Override
	public void modificarMateria(MateriaDTO materiaDTO) throws Exception {
		Materia materia = materiaMapper.toMateria(materiaDTO);
		materia.setEstado(true);
		materiaRepository.save(materia);
		log.info("Materia modificada");
	}

	@Override
	public List<AlumnoDTO> getAlumnosMateria(int codigo) {
		Materia materia = materiaRepository.findById(codigo).get();
		List<Alumno> alumnos =materia.getAlumnos();
		List<AlumnoDTO> alumnosDTO = new ArrayList<AlumnoDTO>();
		for(Alumno a: alumnos) {
			if(a.getEstado() == true) {
				alumnosDTO.add(alumnoMapper.toAlumnoDTO(a));
			}
		}
		return alumnosDTO;
	}
}
