package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp="[a-zA-ZÁÉÍÓÚáéíóúüÜñÑ ]*", message="Debe ingresar únicamente letras")
	private String nombre;
	@NotBlank(message = "Debe ingresar un apellido")
	@Pattern(regexp="[a-zA-ZÁÉÍÓÚáéíóúüÜñÑ ]*", message="Debe ingresar únicamente letras")
	private String apellido;
	@NotBlank(message = "Debe ingresar un email")
	private String email;
	@NotBlank(message = "Debe ingresar un teléfono")
	@Pattern(regexp="[0-9]*", message="Debe ingresar únicamente números")
	private String telefono;
	
	private Boolean estado;
}
