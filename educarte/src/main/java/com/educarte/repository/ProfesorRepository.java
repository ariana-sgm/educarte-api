package com.educarte.repository;

import com.educarte.model.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
    Profesor findByIdLogin(Long idLogin);
}
