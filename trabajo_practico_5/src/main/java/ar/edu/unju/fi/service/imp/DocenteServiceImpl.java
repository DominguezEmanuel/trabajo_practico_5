package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.service.IDocenteService;

@Service
public class DocenteServiceImpl implements IDocenteService {

	@Autowired
	private DocenteMapper docenteMapper;
	@Override
	public List<DocenteDTO> getDocentes() {
		List<DocenteDTO> docentesDTO = docenteMapper.toDocenteDTOList(CollectionDocente.getDocentes());
		return docentesDTO;
	}

	@Override
	public DocenteDTO buscarDocente(String legajo) {
		DocenteDTO docenteDTO = docenteMapper.toDocenteDTO(CollectionDocente.buscarDocente(legajo));
		return docenteDTO;
	}

	@Override
	public Boolean agregarDocente(DocenteDTO docenteDTO) {
		Boolean respuesta = CollectionDocente.agregarDocente(docenteMapper.toDocente(docenteDTO));
		return respuesta;
	}

	@Override
	public void eliminarDocente(String legajo) {
		CollectionDocente.eliminarDocente(legajo);

	}

	@Override
	public void modificarDocente(DocenteDTO docenteDTO) throws Exception {
		CollectionDocente.modificarDocente(docenteMapper.toDocente(docenteDTO));
	}
}
