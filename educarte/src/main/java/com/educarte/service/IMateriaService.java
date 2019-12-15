package com.educarte.service;

import com.educarte.dto.ReqCursoDto;
import com.educarte.dto.ReqMateriaDto;
import com.educarte.dto.ResponseCursoProfesorDto;
import com.educarte.dto.ResponseMateriaCursoDto;
import com.educarte.model.Curso;
import com.educarte.model.Materia;

import java.util.List;

public interface IMateriaService {
    List <Materia> findByIdCurso(Long idCurso);
    Materia findById(Long idMateria);
    ResponseMateriaCursoDto listarMateriasCurso(Long idCurso);
    Materia saveMateria(ReqMateriaDto reqMateriaDto);
    boolean eliminarMateria(Long idMateria);
}
