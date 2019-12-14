package com.educarte.dto;

public class ReqProfesorDto {
    private Long idLoginDto;
    private String nombreProfesorDto;
    private String apellidoProfesorDto;

    public Long getIdLoginDto() {
        return idLoginDto;
    }

    public void setIdLoginDto(Long idLoginDto) {
        this.idLoginDto = idLoginDto;
    }

    public String getNombreProfesorDto() {
        return nombreProfesorDto;
    }

    public void setNombreProfesorDto(String nombreProfesorDto) {
        this.nombreProfesorDto = nombreProfesorDto;
    }

    public String getApellidoProfesorDto() {
        return apellidoProfesorDto;
    }

    public void setApellidoProfesorDto(String apellidoProfesorDto) {
        this.apellidoProfesorDto = apellidoProfesorDto;
    }
}
