package com.educarte.service;


import com.educarte.dto.ReqProfesorDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.model.Login;
import com.educarte.model.Profesor;

public interface IProfesorService {
    ResponseProfesorDto saveProfesor(ReqProfesorDto profesor);
    Profesor findById(Long idProfesor);
    ResponseProfesorDto findByIdLogin(Login idLogin);
}
