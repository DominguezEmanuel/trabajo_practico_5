package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter

@Entity(name = "ALUMNOS")
public class Alumno {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Lu" , nullable = false)
	private Integer lu;
	
	@Column(name = "Dni_alumno")
	@NotNull(message = "Debe ingresar su DNI")
	private int dni;
	
	@Column(name = "Nombre" , nullable = false)
	@NotBlank(message="Debe ingresar su nombre")
	@Pattern(regexp = "[a-z A-Z]*" , message = "Debe ingresar únicamente letras")
	private String nombre;
	
	@Column(name = "Apellido" , nullable = false)
	@NotBlank(message="Debe ingresar su apellido")
	@Pattern(regexp = "[a-z A-Z]*" , message = "Debe ingresar únicamente letras")
	private String apellido;

	@NotBlank(message="Debe ingresar su email")
	@Column(name = "Email" , nullable = false)
	private String email;

	
	@Column(name = "Telefono" , nullable = false)
	@NotBlank(message="Debe ingresar telefono")
	//@Pattern(regexp = "[1-9]*" , message = "Debe ingresar únicamente números")
	private String telefono;

	@Column(name = "Fecha_nacimiento" , nullable = false)
	@Past(message = "La fecha debe ser anterior a la fecha actual")
	@NotNull(message = "Debe ingresar la fecha de nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@Column(name = "Domicilio" , nullable = false)
	@NotBlank(message="Debe ingresar la nacionalidad")
	@NotNull(message = "Debe ingresar su domicilio")
	private String domicilio;

	
	@ManyToMany(mappedBy = "alumnos") //MAPEO RELACION ALUMNO-MATERIAS
	private List<Materia> materias = new ArrayList<>();
	@ManyToOne  //MAPEO RELACION ALUMNO-CARRERAS
	@JoinColumn(name="Codigo_carrera")
	private Carrera carreraAlumno;
	
	
}
