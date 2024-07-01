package ar.edu.unju.fi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity(name = "MATERIAS")
public class Materia {

	@Id
	@Column(name = "Codigo_materia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@NonNull
	@Column(name = "Nombre" , nullable = false)
	private String nombre;
	@NonNull
	@Column(name = "Curso" , nullable = false)
	private String curso;
	@Column(name = "Cantidad_horas" , nullable = false)
	private byte cantidadHoras;
	@NonNull
	@Column(name = "Modalidad" , nullable = false)
	private String modalidad;
	
	@ManyToMany //mapeo relacion alumnos-materias
	@JoinTable(name = "materias_alumnos",
	joinColumns= @JoinColumn(name = "Codigo_materia"),
	inverseJoinColumns = @JoinColumn(name="Dni_alumno"))
	private List<Alumno> alumnos = new ArrayList<>();
	
	@Autowired
	private Docente docente;
	
	@Autowired
	private Carrera carrera;
	
}
