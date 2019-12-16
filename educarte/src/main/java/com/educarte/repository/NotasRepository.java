package com.educarte.repository;

import com.educarte.model.Estudiante;
import com.educarte.model.Materia;
import com.educarte.model.Notas;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotasRepository extends CrudRepository<Notas, Long> {
    List<Notas> findByEstudiante_idEstudiante (Long idEstudiante);
    List<Notas> findByMateria_idMateria (Long idMateria);
    Notas findByMateriaAndEstudiante (Materia materia, Estudiante estudiante);

}
