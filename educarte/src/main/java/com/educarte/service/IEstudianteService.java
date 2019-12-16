package com.educarte.service;

import com.educarte.dto.*;
import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.model.Login;
import com.educarte.model.Profesor;

import java.util.List;

public interface IEstudianteService {
    ResponseEstudianteDto saveEstudiante(ReqEstudianteDto reqEstudianteDto);
    boolean eliminarEstudiante(Long idEstudiante);
    Estudiante findById(Long idEstudiante);
    ResponseEstudianteDto findByIdLogin(Login idLogin);
    List <Estudiante> findByIdCurso(Long idCurso);
    ResponseEstudianteCursoDto listarEstudiantesCurso(Long idCurso);
}
