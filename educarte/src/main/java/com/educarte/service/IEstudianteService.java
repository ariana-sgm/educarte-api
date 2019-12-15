package com.educarte.service;

import com.educarte.dto.ReqEstudianteDto;
import com.educarte.dto.ResponseEstudianteDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.model.Login;
import com.educarte.model.Profesor;

import java.util.List;

public interface IEstudianteService {
    List<Estudiante> buscarListaEstudiante(Long idCurso);
    ResponseEstudianteDto saveEstudiante(ReqEstudianteDto reqEstudianteDto);
    boolean eliminarEstudiante(Long idEstudiante);
    Estudiante findById(Long idEstudiante);
    ResponseEstudianteDto findByIdLogin(Login idLogin);
}
