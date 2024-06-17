package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

	private int codigo;
	private String nombre;
	private String curso;
	private byte cantidadHoras;
	private String modalidad;
	
	@Autowired
	private Docente docente;
	
	@Autowired
	private Carrera carrera;
	
}
