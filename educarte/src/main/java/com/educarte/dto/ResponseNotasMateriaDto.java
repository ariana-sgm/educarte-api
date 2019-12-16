package com.educarte.dto;

import com.educarte.model.Notas;

import java.util.List;

public class ResponseNotasMateriaDto {
    private List<RespInfoNotasMatDto> listaNotasMateria;

    public List<RespInfoNotasMatDto> getListaNotasMateria() {
        return listaNotasMateria;
    }

    public void setListaNotasMateria(List<RespInfoNotasMatDto> listaNotasMateria) {
        this.listaNotasMateria = listaNotasMateria;
    }
}
