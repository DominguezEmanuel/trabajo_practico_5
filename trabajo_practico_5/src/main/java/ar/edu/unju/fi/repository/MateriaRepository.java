package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}
