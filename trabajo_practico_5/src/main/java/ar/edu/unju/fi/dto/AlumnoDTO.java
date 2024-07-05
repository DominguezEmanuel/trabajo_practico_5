package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AlumnoDTO {

	@Min(value=1,message="Debe ingresar un DNI válido")
	private int dni;
	@NotEmpty(message="Debe ingresar su nombre")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	private String nombre;
	@NotEmpty(message="Debe ingresar su apellido")
	@Pattern(regexp= "[a-z A-Z]*", message="Debe ingresar únicamente letras")
	private String apellido;
	@NotEmpty(message="Debe ingresar su email")
	private String email;
	@NotEmpty(message="Debe ingresar su telefono")
	private String telefono;
	@NotBlank(message = "Debe ingresar una fecha")
	private String fechaNacimiento;
	@NotEmpty(message = "Debe ingresar su domicilio")
	private String domicilio;
	
	private Integer lu;
}
