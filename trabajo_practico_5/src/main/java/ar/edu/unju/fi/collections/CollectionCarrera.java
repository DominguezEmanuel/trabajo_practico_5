package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	/**
	 * devuelve un ArrayList de objetos de la clase Carrera
	 * @return
	 */
	
	public static List<Carrera> getCarreras(){
		if(carreras.isEmpty()) {
			return null;
		}
		return carreras;
	}
	
	/**
	 * agrega un Objeto de la clase Carrera al ArrayList de carreras
	 * @param carrera
	 */
	
	public static Boolean agregarCarrera(Carrera carrera) {
		return carreras.add(carrera) ? true : false;
	}
	
	/**
	 * elimina un objeto Carrera del ArrayList de carreras
	 * @param codigoCarrera
	 */
	
	public static void eliminarCarrera(int codigoCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo() == codigoCarrera) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * modifica un objeto Carrera con nuevos valores enviado en
	 * @param carrera objeto con los valores de atributos modificados
	 */
	
	public static void modificarCarrera(Carrera carrera)throws Exception {
		Boolean encontrado = false;
		try {
			for(Carrera car : carreras) {
				if(car.getCodigo() == carrera.getCodigo()) {
					car.setNombre(carrera.getNombre());
					car.setCantidadAnios(carrera.getCantidadAnios());
					car.setEstado(carrera.getEstado());
					encontrado = true;
				}
			}
			if (!encontrado)
				throw new Exception ("La carrera con codigo " + carrera.getCodigo() + " no existe");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * busca un objeto Carrera dentro del ArrayList, el criterio es por
	 * @param codigo a buscar en el ArrayList carreras
	 * @return
	 */
	
	public static Carrera buscarCarrera(int codigo) {
		Predicate<Carrera> filterCodigo = c -> c.getCodigo() == codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		if(carrera.isPresent()) {
			return carrera.get();
		}else {
			return null;
		}
	}
	
}
