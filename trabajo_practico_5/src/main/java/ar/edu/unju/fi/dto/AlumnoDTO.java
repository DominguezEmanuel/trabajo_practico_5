package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AlumnoDTO {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String fechaNacimiento;
	private String domicilio;
	private String lu;
}
