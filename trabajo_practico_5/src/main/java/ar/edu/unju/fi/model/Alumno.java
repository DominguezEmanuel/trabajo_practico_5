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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
	private int dni;
	@NonNull
	@Column(name = "Nombre" , nullable = false)
	private String nombre;
	@NonNull
	@Column(name = "Apellido" , nullable = false)
	private String apellido;
	@NonNull
	@Column(name = "Email" , nullable = false)
	private String email;
	@NonNull
	@Column(name = "Telefono" , nullable = false)
	private String telefono;
	@NonNull
	@Column(name = "Fecha_nacimiento" , nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@NonNull
	@Column(name = "Domicilio" , nullable = false)
	private String domicilio;

	
	@ManyToMany(mappedBy = "alumnos") //MAPEO RELACION ALUMNO-MATERIAS
	private List<Materia> materias = new ArrayList<>();
	@ManyToOne  //MAPEO RELACION ALUMNO-CARRERAS
	@JoinColumn(name="Codigo_carrera")
	private Carrera carreraAlumno;
	
}
