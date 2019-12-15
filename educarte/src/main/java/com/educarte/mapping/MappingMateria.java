package com.educarte.mapping;

import com.educarte.dto.ResponseMateriaCursoDto;
import com.educarte.dto.ResponseMateriaInfoDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.model.Curso;
import com.educarte.model.Materia;
import com.educarte.model.Profesor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingMateria {
    public Materia transformarOptionalMateria(Optional<Materia> materiaOptional) throws Exception {
        Materia materia = null;
        try {
            if(materiaOptional.isPresent()){
                materia = new Materia();
                materia.setIdMateria(materiaOptional.get().getIdMateria());
                    materia.setNombreMateria(materiaOptional.get().getNombreMateria());
                    materia.setCurso(materiaOptional.get().getCurso());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return materia;
    }

    public ResponseMateriaInfoDto transformarMateriaResponseInfoDto(Materia materia){
        ResponseMateriaInfoDto responseInfo = new ResponseMateriaInfoDto();
        try{
            responseInfo.setNombreMateriaDto(materia.getNombreMateria());
            responseInfo.setIdMateriaDto(materia.getIdMateria());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return responseInfo;
    }
}
