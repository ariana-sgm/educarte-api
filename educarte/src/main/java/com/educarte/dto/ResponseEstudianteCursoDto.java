package com.educarte.dto;

import java.util.List;

public class ResponseEstudianteCursoDto {
    private List<ResponseEstudianteDto> listaEStudiantesCurso;

    public List<ResponseEstudianteDto> getListaEStudiantesCurso() {
        return listaEStudiantesCurso;
    }

    public void setListaEStudiantesCurso(List<ResponseEstudianteDto> listaEStudiantesCurso) {
        this.listaEStudiantesCurso = listaEStudiantesCurso;
    }
}
