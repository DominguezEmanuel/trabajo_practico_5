package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.DocenteDTO;

public interface IDocenteService {

	List<DocenteDTO> getDocentes();
	
	DocenteDTO buscarDocente(Integer legajo);
	
	Boolean agregarDocente(DocenteDTO docenteDTO);
	
	void eliminarDocente(Integer legajo);
	
	void modificarDocente(DocenteDTO docenteDTO) throws Exception;
}
