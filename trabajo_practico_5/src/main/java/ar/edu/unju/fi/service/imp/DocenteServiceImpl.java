package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;

@Service("DocenteServiceMySQL")
public class DocenteServiceImpl implements IDocenteService {

	@Autowired
	private DocenteRepository docenteRepository;
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
		return docenteDTO;
	}

	@Override
	public Boolean agregarDocente(DocenteDTO docenteDTO) {
		Boolean respuesta;
		Docente docente = docenteRepository.save(docenteMapper.toDocente(docenteDTO));
		if(docente != null) {
			respuesta = true;
		}else {
			respuesta  = false;
		}
		return respuesta;
	}

	@Override
	public void eliminarDocente(Integer legajo) {
		Docente docente = docenteRepository.findById(legajo).get();
		docenteRepository.delete(docente);
	}

	@Override
	public void modificarDocente(DocenteDTO docenteDTO) throws Exception {
		docenteRepository.save(docenteMapper.toDocente(docenteDTO));
	}
}
