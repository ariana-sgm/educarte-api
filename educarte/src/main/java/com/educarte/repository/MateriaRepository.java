package com.educarte.repository;

import com.educarte.model.Curso;
import com.educarte.model.Materia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MateriaRepository extends CrudRepository<Materia, Long> {
    List<Materia> findByCurso_IdCurso(Long IdCurso);


}
