package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DocenteDTO {
	private Integer legajo;
	@NotEmpty(message = "El campo nombre no puede estar vacío")
	private String nombre;
	@NotEmpty(message = "El campo apellido no puede estar vacío")
	private String apellido;
	@NotEmpty(message = "El campo email no puede estar vacío")
	private String email;
	@NotEmpty(message = "El campo nombre no puede estar vacío")
	private String telefono;
}
