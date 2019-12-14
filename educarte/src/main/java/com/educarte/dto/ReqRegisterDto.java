package com.educarte.dto;

public class ReqRegisterDto {
    private String emailDto;
    private String passwordDto;
    private String nombreProfesorDto;
    private String apellidoProfesorDto;

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
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
