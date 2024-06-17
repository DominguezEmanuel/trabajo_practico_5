package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;

@Component
public class CollectionMateria {

	private static List<Materia> materias = new ArrayList<Materia>();
	
	public static List<Materia> getMaterias(){
		if(materias.isEmpty()) {
			return null;
		}else {
			return materias;
		}
	}
	
	//Agregar Materia
	public static Boolean agregarMateria(Materia materia) {
		return materias.add(materia) ? true : false;
	}
	
	//Eliminar Materia
	public static void eliminarMateria(int codigo) {
		Iterator<Materia> iterator = materias.iterator();
		while(iterator.hasNext()) {
			Materia mat = iterator.next();
			if (mat.getCodigo() == codigo) {
				iterator.remove();
			}
		}
	}
	
	//Modificar Materia
	public static void modificarMateria(Materia materia)throws Exception {
		Boolean encontrado = false;
		try {
			for(Materia mat : materias) {
				if(mat.getCodigo() == materia.getCodigo()) {
					mat.setNombre(materia.getNombre());
					mat.setCurso(materia.getCurso());
					mat.setCantidadHoras(materia.getCantidadHoras());
					mat.setModalidad(materia.getModalidad());
					mat.setDocente(materia.getDocente());
					mat.setCarrera(materia.getCarrera());
					encontrado = true;
				}
			}
			if (!encontrado)
				throw new Exception ("La materia con codigo " + materia.getCodigo() + " no existe");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	//Buscar Materia
	public static Materia buscarMateria(int codigo) {
		Predicate<Materia> filterCodigo = m -> m.getCodigo() == codigo;
		Optional<Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		if(materia.isPresent()) {
			return materia.get();
		}else {
			return null;
		}
	}
}
