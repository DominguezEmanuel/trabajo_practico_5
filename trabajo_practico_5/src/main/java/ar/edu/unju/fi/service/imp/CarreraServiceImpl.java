package ar.edu.unju.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("carreraServiceMySQL")
public class CarreraServiceImpl implements ICarreraService{

	@Autowired
	private CarreraRepository carreraRepository;
	@Autowired
	private CarreraMapper carreraMapper;
	@Autowired
	AlumnoMapper alumnoMapper;
	
	
	public List<AlumnoDTO> getAlumnosCarrera(int codigo){
	Carrera carrera = carreraRepository.findById(codigo).get();
	List<Alumno> alumnos =carrera.getAlumnos();
	List<AlumnoDTO> alumnosDTO = new ArrayList<AlumnoDTO>();
	for(Alumno a: alumnos) {
		if(a.getEstado() == true) {
			alumnosDTO.add(alumnoMapper.toAlumnoDTO(a));
		}
	}
	return alumnosDTO;
	}
	@Override
	public List<CarreraDTO> getCarreras() {
		List<Carrera> carreras = carreraRepository.findAll();
		List<CarreraDTO>  carrerasDTOActivas = new ArrayList<CarreraDTO>();
		for(Carrera c: carreras) {
			if(c.getEstado() == true) {
				carrerasDTOActivas.add(carreraMapper.toCarreraDTO(c));
			}
		}
		return carrerasDTOActivas;
	}

	@Override
	public CarreraDTO buscarCarrera(int codigo) {
		CarreraDTO carreraDTO = carreraMapper.toCarreraDTO(carreraRepository.findById(codigo).get());
		log.info("Carrera encontrada");
		return carreraDTO;
	}

	@Override
	public Boolean agregarCarrera(CarreraDTO carreraDTO) {
		Boolean respuesta;
		Carrera carrera = carreraRepository.save(carreraMapper.toCarrera(carreraDTO));
		if(carrera != null) {
			respuesta = true;
			log.info("Carrera agregada");
		}else {
			respuesta = false;
			log.error("No se pudo agregar la carrera");
		}
		return respuesta;
	}

	@Override
	public void eliminarCarrera(int codigo) {
		Carrera carrera = carreraRepository.findById(codigo).get();
		carrera.setEstado(false);
		carreraRepository.save(carrera);
		log.info("Carrera eliminada");
	}

	@Override
	public void modificarCarrera(CarreraDTO carreraDTO) throws Exception {
		Carrera carreraNueva = carreraMapper.toCarrera(carreraDTO);
		carreraRepository.save(carreraNueva);
		log.info("carrera modificada");
	}
	
	
}
