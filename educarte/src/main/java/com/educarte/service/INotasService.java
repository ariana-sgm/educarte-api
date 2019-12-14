package com.educarte.service;

import com.educarte.model.Curso;
import com.educarte.model.Notas;

import java.util.List;

public interface INotasService {
    List<Notas> buscarListaNotas(Long idMateria);
    Notas saveNota(Notas notas);
    Notas actualizarNotas(Notas notas);
    Notas buscarNotas(Long idEstudiante, Long idMateria);
}
