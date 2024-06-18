package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Carrera {

	private int codigo;
	private String nombre;
	private byte cantidadAnios;
	private Boolean estado;
	

	
}
