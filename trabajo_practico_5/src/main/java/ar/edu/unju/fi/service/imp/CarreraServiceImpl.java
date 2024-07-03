package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.ICarreraService;

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
	List<AlumnoDTO> alumnos = alumnoMapper.toAlumnoDTOList(carrera.getAlumnos());
	return alumnos;
	}
	@Override
	public List<CarreraDTO> getCarreras() {
		List<CarreraDTO> carrerasDTO = carreraMapper.toCarreraDTOList(carreraRepository.findAll());
		return carrerasDTO;
	}

	@Override
	public CarreraDTO buscarCarrera(int codigo) {
		CarreraDTO carreraDTO = carreraMapper.toCarreraDTO(carreraRepository.findById(codigo).get());
		return carreraDTO;
	}

	@Override
	public Boolean agregarCarrera(CarreraDTO carreraDTO) {
		Boolean respuesta;
		Carrera carrera = carreraRepository.save(carreraMapper.toCarrera(carreraDTO));
		if(carrera != null) {
			respuesta = true;
		}else {
			respuesta = false;
		}
		return respuesta;
	}

	@Override
	public void eliminarCarrera(int codigo) {
		Carrera carrera  = carreraRepository.findById(codigo).get();
		carreraRepository.delete(carrera);
	}

	@Override
	public void modificarCarrera(CarreraDTO carreraDTO) throws Exception {
		carreraRepository.save(carreraMapper.toCarrera(carreraDTO));
	}
	
	
}
