package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.service.IMateriaService;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private MateriaMapper materiaMapper;
	
	@Override
	public List<MateriaDTO> getMaterias() {
		List<MateriaDTO> materiasDTO = materiaMapper.toMateriaDTOList(CollectionMateria.getMaterias());
		return materiasDTO;
	}

	@Override
	public MateriaDTO buscarMateria(int codigo) {
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(CollectionMateria.buscarMateria(codigo));
		return materiaDTO;
	}

	@Override
	public Boolean agregarMateria(MateriaDTO materiaDTO) {
		Boolean respuesta = CollectionMateria.agregarMateria(materiaMapper.toMateria(materiaDTO));
		return respuesta;
	}

	@Override
	public void eliminarMateria(int codigo) {
		CollectionMateria.eliminarMateria(codigo);
	}

	@Override
	public void modificarMateria(MateriaDTO materiaDTO) throws Exception {
		CollectionMateria.modificarMateria(materiaMapper.toMateria(materiaDTO));
	}
}
