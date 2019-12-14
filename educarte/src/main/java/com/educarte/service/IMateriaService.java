package com.educarte.service;

import com.educarte.model.Curso;
import com.educarte.model.Materia;

import java.util.List;

public interface IMateriaService {
    List<Materia> buscarListaMateria(Long idCurso);
    Materia saveMateria(Materia materia);
    boolean eliminarMateria(Long idMateria);
    Materia buscarMateria(Long idMateria);
}
