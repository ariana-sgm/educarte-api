package com.educarte.dto;

import java.util.List;

public class ResponseMateriaCursoDto {

    private List<ResponseMateriaInfoDto> listaMateriasCursoDto;

    public List<ResponseMateriaInfoDto> getListaMateriasCursoDto() {
        return listaMateriasCursoDto;
    }

    public void setListaMateriasCursoDto(List<ResponseMateriaInfoDto> listaMateriasCursoDto) {
        this.listaMateriasCursoDto = listaMateriasCursoDto;
    }
}
