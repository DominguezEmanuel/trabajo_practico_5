package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {

	private int codigo;
	private String nombre;
	private byte cantidadAnios;
	private Boolean estado;
	
	public Carrera() {
		
	}

	public Carrera(int codigo, String nombre, byte cantidadAnios, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getCantidadAnios() {
		return cantidadAnios;
	}

	public void setCantidadAnios(byte cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	//No necesario pero se puede usar para prueba
	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", cantidadAnios=" + cantidadAnios + ", estado="
				+ estado + "]";
	}
	
	
}
