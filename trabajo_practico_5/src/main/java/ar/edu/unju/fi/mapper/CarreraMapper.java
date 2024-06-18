package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarreraMapper {
	
	@Mapping(source="codigo" , target="codigo")
	@Mapping(source="nombre" , target="nombre")
	@Mapping(source="cantidadAnios" , target="cantidadAnios")
	@Mapping(source="estado" , target="estado")
	CarreraDTO toCarreraDTO(Carrera carrera);
	
	@InheritInverseConfiguration
	Carrera toCarrera(CarreraDTO carreraDTO);
	
	List<CarreraDTO> toCarreraDTOList(List<Carrera> carreras);
	
	List<Carrera> toCarreraList(List<CarreraDTO> carrerasDTO);
}
