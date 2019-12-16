package com.educarte.mapping;

import com.educarte.dto.ResponseEstudianteDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.model.Estudiante;
import com.educarte.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingEstudiante {

    public ResponseEstudianteDto transformarEstudianteResponseDto(Estudiante estudiante){
        ResponseEstudianteDto response = new ResponseEstudianteDto();
            try{
            response.setIdLogin(estudiante.getLogin().getIdLogin());
            response.setApellidoDto(estudiante.getApellidoEstudiante());
            response.setNombreDto(estudiante.getNombreEstudiante());
            response.setIdEstudiante(estudiante.getIdEstudiante());
            response.setIdCurso(estudiante.getCurso().getIdCurso());
            response.setEmailDto(estudiante.getLogin().getEmail());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    public Estudiante transformarOptionalEstudiante(Optional<Estudiante> estudianteOptional) throws Exception {
        Estudiante estudiante = null;
        try {
            if(estudianteOptional.isPresent()){
                estudiante = new Estudiante();
                estudiante.setNombreEstudiante(estudianteOptional.get().getNombreEstudiante());
                estudiante.setApellidoEstudiante(estudianteOptional.get().getApellidoEstudiante());
                estudiante.setIdEstudiante(estudianteOptional.get().getIdEstudiante());
                estudiante.setLogin(estudianteOptional.get().getLogin());
                estudiante.setCurso(estudianteOptional.get().getCurso());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return estudiante;
    }
}
