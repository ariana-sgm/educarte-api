package com.educarte.service;

import com.educarte.dto.ReqCursoDto;
import com.educarte.model.Curso;

import java.util.List;


public interface ICursoService {
    List <Curso> findByIdProfesor(Long idProfesor);
    Curso findById(Long idCurso);
    Curso saveCurso(ReqCursoDto reqCursoDto);
    boolean eliminarCurso(Long idCurso);
    Curso buscarCurso(Long idCurso);

}
