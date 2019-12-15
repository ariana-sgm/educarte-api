package com.educarte.service;

import com.educarte.dto.ReqCursoDto;
import com.educarte.dto.ResponseCursoInfoDto;
import com.educarte.dto.ResponseCursoProfesorDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.model.Curso;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface ICursoService {
    List <Curso> findByIdProfesor(Long idProfesor);
    Curso findById(Long idCurso);
    Curso saveCurso(ReqCursoDto reqCursoDto);
    boolean eliminarCurso(Long idCurso);
    ResponseCursoProfesorDto listarCursosProfesor(Long idProfesor);

}
