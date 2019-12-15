package com.educarte.dto;

public class ReqRegisterEstudianteDto {
    private String nombreEstDto;
    private String apellidoEstDto;
    private String passwordEstDto;
    private String emailEstDto;
    private Long idCourseDto;

    public String getNombreEstDto() {
        return nombreEstDto;
    }

    public void setNombreEstDto(String nombreEstDto) {
        this.nombreEstDto = nombreEstDto;
    }

    public String getApellidoEstDto() {
        return apellidoEstDto;
    }

    public void setApellidoEstDto(String apellidoEstDto) {
        this.apellidoEstDto = apellidoEstDto;
    }

    public String getPasswordEstDto() {
        return passwordEstDto;
    }

    public void setPasswordEstDto(String passwordEstDto) {
        this.passwordEstDto = passwordEstDto;
    }

    public String getEmailEstDto() {
        return emailEstDto;
    }

    public void setEmailEstDto(String emailEstDto) {
        this.emailEstDto = emailEstDto;
    }

    public Long getIdCourseDto() {
        return idCourseDto;
    }

    public void setIdCourseDto(Long idCourseDto) {
        this.idCourseDto = idCourseDto;
    }
}
