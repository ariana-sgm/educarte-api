package com.educarte.service;

import com.educarte.model.Curso;
import com.educarte.model.Estudiante;

import java.util.List;

public interface IEstudianteService {
    List<Estudiante> buscarListaEstudiante(Long idCurso);
    Estudiante saveEstudiante(Estudiante estudiante);
    boolean eliminarEstudiante(Long idEstudiante);
    Curso buscarEstudiante(Long idEstudiante);
}
