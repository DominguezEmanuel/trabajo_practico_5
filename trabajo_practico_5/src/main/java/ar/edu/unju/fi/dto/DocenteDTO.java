package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DocenteDTO {
	
	private Integer legajo;
	@NotBlank(message = "Debe ingresar un nombre")
	private String nombre;
	@NotBlank(message = "Debe ingresar un apellido")
	private String apellido;
	@NotBlank(message = "Debe ingresar un email")
	private String email;
	@NotBlank(message = "Debe ingresar un teléfono")
	private String telefono;
}
