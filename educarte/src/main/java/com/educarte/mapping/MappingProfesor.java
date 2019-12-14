package com.educarte.mapping;

import com.educarte.dto.ResponseLoginDto;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingProfesor {

    public Profesor transformarOptionaProfesor(Optional<Profesor> profesorOptional) throws Exception {
        Profesor profesor = null;
        try {
            if(profesorOptional.isPresent()){
                profesor = new Profesor();
                profesor.setIdLogin(profesorOptional.get().getIdLogin());
                profesor.setApellidoProfesor(profesorOptional.get().getApellidoProfesor());
                profesor.setNombreProfesor(profesorOptional.get().getNombreProfesor());
                profesor.setIdProfesor(profesorOptional.get().getIdProfesor());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return profesor;
    }

}
