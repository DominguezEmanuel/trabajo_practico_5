package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {

	private static List<Docente> docentes = new ArrayList<Docente>();
	
	//Listar Docentes
	public static List<Docente> getDocentes(){
		if(docentes.isEmpty()) {
			return null;
		}
		return docentes;
	}
	
	//Agregar Docente
	public static Boolean agregarDocente(Docente docente) {
		return docentes.add(docente) ? true : false;
	}
	
	//Eliminar Docente
	public static void eliminarDocente(String legajo) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			Docente doc = iterator.next();
			if (doc.getLegajo().equals(legajo)) {
				iterator.remove();
			}
		}
	}
	
	//Modificar Docente
	public static void modificarDocente(Docente docente)throws Exception {
		Boolean encontrado = false;
		try {
			for(Docente doc : docentes) {
				if(doc.getLegajo().equals(docente.getLegajo())) {
					doc.setLegajo(docente.getLegajo());
					doc.setNombre(docente.getNombre());
					doc.setApellido(docente.getApellido());
					doc.setEmail(docente.getEmail());
					doc.setTelefono(docente.getTelefono());
					encontrado = true;
				}
			}
			if (!encontrado)
				throw new Exception ("El docente con legajo " + docente.getLegajo() + " no existe");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	//Buscar Docente
	public static Docente buscarDocente(String legajo) {
		Predicate<Docente> filterCodigo = d -> d.getLegajo().equals(legajo);
		Optional<Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
		if(docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}
	}
}
