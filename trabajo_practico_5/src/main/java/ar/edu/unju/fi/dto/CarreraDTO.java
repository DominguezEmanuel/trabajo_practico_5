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
public class CarreraDTO {
	
	private int codigo;
	@NotEmpty(message = "El campo nombre no puede estar vacío")
	private String nombre;
	@NotNull(message = "El campo duración no puede estar vacío")
	private byte cantidadAnios;
	@NotEmpty(message = "El campo estado no puede ser nulo")
	private String estado;
	
}
