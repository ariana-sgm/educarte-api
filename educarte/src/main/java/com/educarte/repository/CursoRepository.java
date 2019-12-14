package com.educarte.repository;

import com.educarte.model.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepository extends CrudRepository<Curso, Long>{
    List<Curso> findByProfesor_IdProfesor(Long IdProfesor);

}
