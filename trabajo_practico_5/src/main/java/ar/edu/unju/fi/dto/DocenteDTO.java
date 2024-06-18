package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DocenteDTO {
	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
}
