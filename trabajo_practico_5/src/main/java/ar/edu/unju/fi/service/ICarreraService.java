package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;

@Service
public interface ICarreraService {

	List<CarreraDTO> getCarreras();
	
	CarreraDTO buscarCarrera(int codigo);
	
	Boolean agregarCarrera(CarreraDTO carreraDTO);
	
	void eliminarCarrera(int codigo);
	
	void modificarCarrera(CarreraDTO carreraDTO) throws Exception;
	
}
