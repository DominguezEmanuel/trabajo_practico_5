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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Legajo")
	private Integer legajo;
	
	@NonNull
	@Column(name = "Nombre")
	private String nombre;
	
	@NonNull
	@Column(name = "Apellido")
	private String apellido;
	
	@NonNull
	@Column(name = "Email")
	private String email;
	
	@NonNull
	@Column(name = "Telefono")
	private String telefono;
	
	@OneToOne(mappedBy="docente")
	private Materia materia;
}
