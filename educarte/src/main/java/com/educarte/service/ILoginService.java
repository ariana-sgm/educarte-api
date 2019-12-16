package com.educarte.service;

import com.educarte.dto.ReqLoginDto;
import com.educarte.dto.ResponseEstudianteDto;
import com.educarte.dto.ResponseLoginDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.model.Login;

public interface ILoginService {

    ResponseLoginDto saveLogin(ReqLoginDto login);
    Login findById (Long Id);
    boolean findByEmail (String email);
    ResponseProfesorDto findByEmailAndPassword(String email, String password);
    ResponseEstudianteDto findEstByEmailAndPassword(String email, String password);
}
