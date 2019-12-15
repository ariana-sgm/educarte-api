package com.educarte.dto;

public class ReqMateriaDto {
    private String nombreMateriaDto;
    private Long idCursoDto;

    public String getNombreMateriaDto() {
        return nombreMateriaDto;
    }

    public void setNombreMateriaDto(String nombreMateriaDto) {
        this.nombreMateriaDto = nombreMateriaDto;
    }

    public Long getIdCursoDto() {
        return idCursoDto;
    }

    public void setIdCursoDto(Long idCursoDto) {
        this.idCursoDto = idCursoDto;
    }
}
