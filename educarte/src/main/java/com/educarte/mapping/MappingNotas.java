package com.educarte.mapping;

import com.educarte.dto.RespInfoNotasEstDto;
import com.educarte.dto.RespInfoNotasMatDto;
import com.educarte.dto.ResponseMateriaInfoDto;
import com.educarte.model.Curso;
import com.educarte.model.Materia;
import com.educarte.model.Notas;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MappingNotas {

    public Notas transformarOptionalNotas(Optional<Notas> notasOptional) throws Exception {
        Notas notas = null;
        try {
            if(notasOptional.isPresent()){
                notas = new Notas();
                notas.setMateria(notasOptional.get().getMateria());
                notas.setEstudiante(notasOptional.get().getEstudiante());
                notas.setIdNotas(notasOptional.get().getIdNotas());
                notas.setNota1(notasOptional.get().getNota1());
                notas.setNota2(notasOptional.get().getNota2());
                notas.setNota3(notasOptional.get().getNota3());
                notas.setNota4(notasOptional.get().getNota4());
                notas.setControl1(notasOptional.get().getControl1());
                notas.setControl2(notasOptional.get().getControl2());
                notas.setControl3(notasOptional.get().getControl3());
                notas.setControl4(notasOptional.get().getControl4());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return notas;
    }

    public RespInfoNotasMatDto transformarNotasResponseInfoMatDto(Notas notas){
        RespInfoNotasMatDto responseInfo = new RespInfoNotasMatDto();
        try{
            responseInfo.setIdNotas(notas.getIdNotas());
            responseInfo.setNombreEstudiante(notas.getEstudiante().getNombreEstudiante());
            responseInfo.setN1(notas.getNota1());
            responseInfo.setN2(notas.getNota2());
            responseInfo.setN3(notas.getNota3());
            responseInfo.setN4(notas.getNota4());
            responseInfo.setC1(notas.getControl1());
            responseInfo.setC2(notas.getControl2());
            responseInfo.setC3(notas.getControl3());
            responseInfo.setC4(notas.getControl4());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return responseInfo;
    }

    public RespInfoNotasEstDto transformarNotasResponseInfoEstDto(Notas notas){
        RespInfoNotasEstDto responseInfo = new RespInfoNotasEstDto();
        try{
            responseInfo.setIdNotas(notas.getIdNotas());
            responseInfo.setNombreMateria(notas.getMateria().getNombreMateria());
            responseInfo.setN1(notas.getNota1());
            responseInfo.setN2(notas.getNota2());
            responseInfo.setN3(notas.getNota3());
            responseInfo.setN4(notas.getNota4());
            responseInfo.setC1(notas.getControl1());
            responseInfo.setC2(notas.getControl2());
            responseInfo.setC3(notas.getControl3());
            responseInfo.setC4(notas.getControl4());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return responseInfo;
    }
}
