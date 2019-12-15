package com.educarte.dto;

import com.educarte.model.Curso;

import java.util.List;

public class ResponseCursoProfesorDto {
    private List <ResponseCursoInfoDto>listaCursosProfesor;

    public List<ResponseCursoInfoDto> getListaCursosProfesor() {
        return listaCursosProfesor;
    }

    public void setListaCursosProfesor(List<ResponseCursoInfoDto> listaCursosProfesor) {
        this.listaCursosProfesor = listaCursosProfesor;
    }
}
