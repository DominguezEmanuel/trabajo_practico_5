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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carrera")
public class Carrera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carr_cod")
	private int codigo;
	
	@Column(name = "carr_nombre", nullable = false)
	private String nombre;
	
	@Column(name = "carr_cantAnios", nullable = false)
	private byte cantidadAnios;
	
	@Column(name = "carr_estado" , nullable = false)
	private Boolean estado;
	
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List <Materia> materias = new ArrayList<Materia>();
	
}
