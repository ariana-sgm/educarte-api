package com.educarte.dto;

import com.educarte.model.Curso;

import java.util.List;

public class ResponseCursoProfesorDto {
    private List <List<String>>listaCursosProfesor;

    public List<List<String>> getListaCursosProfesor() {
        return listaCursosProfesor;
    }

    public void setListaCursosProfesor(List<List<String>> listaCursosProfesor) {
        this.listaCursosProfesor = listaCursosProfesor;
    }
}
