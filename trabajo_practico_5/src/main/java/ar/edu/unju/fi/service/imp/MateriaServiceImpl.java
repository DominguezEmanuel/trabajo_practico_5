package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.IMateriaService;

@Service("materiaServiceMySQL")
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private MateriaMapper materiaMapper;
	
	@Override
	public List<MateriaDTO> getMaterias() {
		List<MateriaDTO> materiasDTO = materiaMapper.toMateriaDTOList(materiaRepository.findAll());
		return materiasDTO;
	}

	@Override
	public MateriaDTO buscarMateria(int codigo) {
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(materiaRepository.findById(codigo).get());
		return materiaDTO;
	}

	@Override
	public Boolean agregarMateria(MateriaDTO materiaDTO) {
		Boolean respuesta;
		Materia materia = materiaRepository.save(materiaMapper.toMateria(materiaDTO));
		if(materia != null) {
			respuesta = true;
		}else {
			respuesta = false;
		}
		return respuesta;
	}

	@Override
	public void eliminarMateria(int codigo) {
		Materia materia = materiaRepository.findById(codigo).get();
		materiaRepository.delete(materia);
	}

	@Override
	public void modificarMateria(MateriaDTO materiaDTO) throws Exception {
		materiaRepository.save(materiaMapper.toMateria(materiaDTO));
	}
}
