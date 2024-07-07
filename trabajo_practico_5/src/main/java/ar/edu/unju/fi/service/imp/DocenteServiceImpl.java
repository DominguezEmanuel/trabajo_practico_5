package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IDocenteService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("DocenteServiceMySQL")
public class DocenteServiceImpl implements IDocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private DocenteMapper docenteMapper;
	@Override
	public List<DocenteDTO> getDocentes() {
		List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(docenteRepository.findAll());
		return docentesDTO;
	}

	@Override
	public DocenteDTO buscarDocente(Integer legajo) {
		DocenteDTO docenteDTO = docenteMapper.toDocenteDTO(docenteRepository.findById(legajo).get());
		log.info("Docente encontrado");
		return docenteDTO;
	}

	@Override
	public Boolean agregarDocente(DocenteDTO docenteDTO) {
		Boolean respuesta;
		Docente docente = docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		if(docente != null) {
			respuesta = true;
			log.info("Docente agregado");
		}else {
			respuesta  = false;
			log.error("No se pudo agregar al docente");
		}
		return respuesta;
	}

	@Override
	public void eliminarDocente(Integer legajo) {
		Docente docente = docenteRepository.findById(legajo).get();
		Materia materiaDocente = docente.getMateria();
		materiaDocente.setDocente(null);
		docenteRepository.delete(docente);
		materiaRepository.save(materiaDocente);
		docente.setMateria(null);
		log.info("Docente eliminado");
	}

	@Override
	public void modificarDocente(DocenteDTO docenteDTO) throws Exception {
		docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		log.info("Docente modificado");
	}
}
