package com.educarte.service;


import com.educarte.dto.ReqProfesorDto;
import com.educarte.model.Profesor;

public interface IProfesorService {
    Profesor saveProfesor(ReqProfesorDto profesor);
    Profesor findById(Long idProfesor);
    Profesor findByIdLogin(Long idLogin);
}
