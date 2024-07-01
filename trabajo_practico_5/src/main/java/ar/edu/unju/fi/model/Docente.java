package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component


@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

@Entity(name = "DOCENTES")
public class Docente {
	
	@Id
	@Column(name = "Codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@NonNull
	@Column(name = "Legajo" , nullable = false)
	private String legajo;
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
	
	@OneToOne(mappedBy="docente")
	private Materia materia;
}
