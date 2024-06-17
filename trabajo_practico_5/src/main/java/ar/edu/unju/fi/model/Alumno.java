package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alumno {

	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String lu;
	
}
