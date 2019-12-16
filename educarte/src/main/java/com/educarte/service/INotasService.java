package com.educarte.service;

import com.educarte.dto.*;
import com.educarte.model.Curso;
import com.educarte.model.Notas;

import java.util.List;

public interface INotasService {
    List <Notas> findByIdEstudiante(Long idEstudiante);
    List<RespInfoNotasMatDto> findByIdMateria(Long idMateria);
    Notas findById(Long idNotas);
    Notas saveNotas(ReqNotasDto reqNotasDto);
    RespInfoNotasMatDto actualizarNotas(RespInfoNotasMatDto infoNotasMatDto);
    ResponseNotasMateriaDto listarNotasMateria(Long idMateria);
    ResponseNotasEstDto listarNotasEstudiante(Long idEstudiante);
    RespInfoNotasEstDto buscarNotas(Long idMateria, Long idEstudiante);
}
