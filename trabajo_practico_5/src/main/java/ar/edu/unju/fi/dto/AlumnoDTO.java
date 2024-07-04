package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AlumnoDTO {
	@NotNull(message = "Debe ingresar su DNI")
	private int dni;
	@NotEmpty(message="Debe ingresar su nombre")
	private String nombre;
	@NotEmpty(message="Debe ingresar su apellido")
	private String apellido;
	@NotEmpty(message="Debe ingresar su email")
	private String email;
	@NotEmpty(message="Debe ingresar telefono")
	private String telefono;
	@NotNull(message = "Debe ingresar la fecha de nacimiento")
	private String fechaNacimiento;
	@NotEmpty(message = "Debe ingresar su domicilio")
	private String domicilio;
	
	private Integer lu;
}
