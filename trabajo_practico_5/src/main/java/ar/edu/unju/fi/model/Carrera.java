package ar.edu.unju.fi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Component

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "CARRERAS")
public class Carrera {


	@Id
	@Column(name = "Codigo_carrera")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@NonNull
	@Column(name = "Nombre" , nullable = false)
	private String nombre;
	
	@Column(name = "Cantidad_anos" , nullable = false)
	private byte cantidadAnios;
	
	@NonNull
	@Column(name = "Estado" , nullable = false)
	private Boolean estado;
	
	/*
	 * CascadeType.all: Especifica que las operaciones de persistencia deben propagarse a las entidades asociadas
	 * orphanRemoval : especifica que las entidades hijas deben ser eliminadas cuando se eliminen de la colección padre
	 */
	@OneToMany(mappedBy = "carreraAlumno", cascade = CascadeType.ALL, orphanRemoval = true) //MAPEO RELACION CARRERA-ALUMNO
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	 @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	 private List <Materia> materias = new ArrayList<Materia>();

	
}
