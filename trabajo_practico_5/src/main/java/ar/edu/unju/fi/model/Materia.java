package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "materia")

public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="mat_codigo")
	private int codigo;
	
	@Column(name = "mat_nombre", nullable = false)
	private String nombre;
	
	@Column(name = "mat_curso", nullable = false)
	private String curso;
	
	@Column(name = "mat_cantHoras", nullable = false)
	private byte cantidadHoras;
	
	@Column(name = "mat_modalidad", nullable = false)
	private String modalidad;
	
	@Autowired
	private Docente docente;
	
	@Autowired	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carr_cod")
	private Carrera carrera;
	
}
