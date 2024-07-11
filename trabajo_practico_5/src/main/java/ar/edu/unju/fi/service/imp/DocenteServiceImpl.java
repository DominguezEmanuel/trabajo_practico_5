package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
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
		List<Docente> docentes =docenteRepository.findAll();
		List<DocenteDTO> docentesDTO = new ArrayList<DocenteDTO>();
		for(Docente d: docentes) {
			if(d.getEstado() == true)
				docentesDTO.add(docenteMapper.toDocenteDTO(d));
		}
		return docentesDTO;
	}
	@Override
	public List<DocenteDTO> getDocentesForMateria() {
		List<Docente> docentes =docenteRepository.findAll();
		List<DocenteDTO> docentesDTO = new ArrayList<DocenteDTO>();
		for(Docente d: docentes) {
			if(d.getEstado() == true && d.getMateria() == null)
				docentesDTO.add(docenteMapper.toDocenteDTO(d));
		}
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
		Docente docenteNuevo = docenteMapper.toDocente(docenteDTO);
		docenteNuevo.setEstado(true);
		Docente docente = docenteRepository.save(docenteNuevo);
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
		docente.setEstado(false);
		docenteRepository.save(docente);
		log.info("Docente eliminado");
	}

	@Override
	public void modificarDocente(DocenteDTO docenteDTO) throws Exception {
		Docente docente = docenteMapper.toDocente(docenteDTO);
		docente.setEstado(true);
		docenteRepository.save(docente);
		log.info("Docente modificado");
	}
}
