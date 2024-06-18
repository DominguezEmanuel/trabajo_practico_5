package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface IMateriaService {

	List<MateriaDTO> getMaterias();
	
	MateriaDTO buscarMateria(int codigo);
	
	Boolean agregarMateria(MateriaDTO materiaDTO);
	
	void eliminarMateria(int codigo);
	
	void modificarMateria(MateriaDTO materiaDTO) throws Exception;
}
