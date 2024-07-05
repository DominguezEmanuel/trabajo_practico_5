package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {
	
	private int codigo;
	@NotEmpty(message = "Debe ingresar el nombre de la Carrera")
	private String nombre;
	@Min(value=3,message="Debe tener 3 años como mínimo")
	private byte cantidadAnios;
	@NotEmpty(message = "El campo estado no puede ser nulo")
	private String estado;
	
}
