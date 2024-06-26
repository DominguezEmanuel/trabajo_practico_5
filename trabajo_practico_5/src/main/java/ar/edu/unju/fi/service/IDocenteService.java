package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.DocenteDTO;

public interface IDocenteService {

	List<DocenteDTO> getDocentes();
	
	DocenteDTO buscarDocente(String legajo);
	
	Boolean agregarDocente(DocenteDTO docenteDTO);
	
	void eliminarDocente(String legajo);
	
	void modificarDocente(DocenteDTO docenteDTO) throws Exception;
}
