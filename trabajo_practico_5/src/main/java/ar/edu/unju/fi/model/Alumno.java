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
import jakarta.validation.constraints.NotNull;
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
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Apellido")
	private String apellido;

	@Column(name = "Email")
	private String email;

	
	@Column(name = "Telefono")
	private String telefono;

	@Column(name = "Fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@Column(name = "Domicilio")
	private String domicilio;
	@Column(name = "Estado")
	private Boolean estado;

	
	@ManyToMany(mappedBy = "alumnos") //MAPEO RELACION ALUMNO-MATERIAS
	private List<Materia> materias = new ArrayList<>();
	@ManyToOne  //MAPEO RELACION ALUMNO-CARRERAS
	@JoinColumn(name="Codigo_carrera")
	private Carrera carreraAlumno;
	
	
}
