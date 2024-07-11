package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MateriaDTO {
	private int codigo;
	@NotEmpty(message="Debe ingresar el nombre de la materia")
	private String nombre;
	@NotEmpty(message="Debe ingresar el curso de la materia")
	private String curso;
	@Min(value=30,message="La cantidad de horas mínima es 30hs")
	private byte cantidadHoras;
	@NotEmpty(message="Debe ingresar la modalidad")
	private String modalidad;
	@NotNull(message = "Debe ingresar un Docente")
	private DocenteDTO docente;
	@NotNull(message = "Debe ingresar una Carrera")
	private CarreraDTO carrera;
	
	private Boolean estado;
}
