package com.educarte.dto;

import com.educarte.model.Notas;

import java.util.List;

public class ResponseNotasEstDto {
    private List<RespInfoNotasEstDto> listaNotasEstudiante;

    public List<RespInfoNotasEstDto> getListaNotasEstudiante() {
        return listaNotasEstudiante;
    }

    public void setListaNotasEstudiante(List<RespInfoNotasEstDto> listaNotasEstudiante) {
        this.listaNotasEstudiante = listaNotasEstudiante;
    }
}
