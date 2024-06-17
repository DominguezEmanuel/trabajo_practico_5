package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MateriaDTO {
	private int codigo;
	private String nombre;
	private String curso;
	private byte cantidadHoras;
	private String modalidad;
	private String docente;
	private String carrera;
}
