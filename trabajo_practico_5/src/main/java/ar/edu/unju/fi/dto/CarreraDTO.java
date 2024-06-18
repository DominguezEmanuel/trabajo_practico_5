package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {
	
	private int codigo;
	private String nombre;
	private byte cantidadAnios;
	private String estado;
	
}
