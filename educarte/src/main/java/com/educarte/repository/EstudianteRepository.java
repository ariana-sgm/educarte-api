package com.educarte.repository;

import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
    Estudiante findByLogin(Login login);
    List<Estudiante> findByCurso_IdCurso(Long IdCurso);
}
