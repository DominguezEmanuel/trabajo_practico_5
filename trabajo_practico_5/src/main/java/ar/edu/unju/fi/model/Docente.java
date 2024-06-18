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


public class Docente {

	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	
	
	
}
