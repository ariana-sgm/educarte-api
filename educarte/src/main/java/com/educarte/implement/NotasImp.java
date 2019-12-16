package com.educarte.implement;

import com.educarte.dto.*;
import com.educarte.mapping.MappingNotas;
import com.educarte.model.*;
import com.educarte.repository.NotasRepository;
import com.educarte.service.INotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotasImp implements INotasService {

    @Autowired
    private NotasRepository notasRepository;

    @Autowired
    private MappingNotas mappingNotas;

    @Autowired
    private MateriaImp materiaImp;

    @Autowired
    private EstudianteImp estudianteImp;

    @Override
    public List<Notas> findByIdEstudiante(Long idEstudiante) {
        List <Notas> listaNotasEstudiante = new ArrayList<Notas>();
        try{
            listaNotasEstudiante = notasRepository.findByEstudiante_idEstudiante(idEstudiante);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return listaNotasEstudiante;
    }

    @Override
    public List<RespInfoNotasMatDto> findByIdMateria(Long idMateria) {
        List <Notas> listaNotasMateria = new ArrayList<Notas>();
        List<RespInfoNotasMatDto> response = new ArrayList<>();
        try{
            listaNotasMateria = notasRepository.findByMateria_idMateria(idMateria);
            for (Notas notas : listaNotasMateria){
                RespInfoNotasMatDto resp = mappingNotas.transformarNotasResponseInfoMatDto(notas);
                response.add(resp);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    public Notas findById(Long idNotas) {
        Notas notas = new Notas();
        try{
            notas = mappingNotas.transformarOptionalNotas(notasRepository.findById(idNotas));
            if(null == notas){
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return notas;
    }

    @Override
    public Notas saveNotas(ReqNotasDto reqNotasDto) {
        Notas notasLocal = new Notas();
        try{
            Materia materia = materiaImp.findById(reqNotasDto.getIdMateria());
            if (materia == null) return null;
            Estudiante estudiante = estudianteImp.findById(reqNotasDto.getIdEstudiante());
            if (estudiante == null) return null;
            notasLocal.setEstudiante(estudiante);
            notasLocal.setMateria(materia);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            notasLocal = notasRepository.save(notasLocal);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return notasLocal;
    }

    @Override
    public RespInfoNotasMatDto actualizarNotas(RespInfoNotasMatDto infoNotasMatDto) {
        RespInfoNotasMatDto actualizadas = new RespInfoNotasMatDto();
        try{
            Notas notas = findById(infoNotasMatDto.getIdNotas());
            if(null != infoNotasMatDto && null!= infoNotasMatDto.getIdNotas()){
                notas.setNota1(infoNotasMatDto.getN1());
                notas.setNota2(infoNotasMatDto.getN2());
                notas.setNota3(infoNotasMatDto.getN3());
                notas.setNota4(infoNotasMatDto.getN4());
                notas.setControl1(infoNotasMatDto.getC1());
                notas.setControl2(infoNotasMatDto.getC2());
                notas.setControl3(infoNotasMatDto.getC3());
                notas.setControl4(infoNotasMatDto.getC4());
                actualizadas = mappingNotas.transformarNotasResponseInfoMatDto(notasRepository.save(notas));
            } else {
                return null;
            }
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return actualizadas;
    }

    @Override
    public ResponseNotasMateriaDto listarNotasMateria(Long idMateria) {
        List<RespInfoNotasMatDto> listaNotasIds = new ArrayList<>();
        try {
            listaNotasIds = this.findByIdMateria(idMateria);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        ResponseNotasMateriaDto response = new ResponseNotasMateriaDto();
        response.setListaNotasMateria(listaNotasIds);
        return response;
    }

    @Override
    public ResponseNotasEstDto listarNotasEstudiante(Long idEstudiante) {
        List<Notas> listaNotasEstudiante = new ArrayList<>();
        List<RespInfoNotasEstDto> listaNotasIds = new ArrayList<>();
        try {
            listaNotasEstudiante = this.findByIdEstudiante(idEstudiante);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        for(Notas notas : listaNotasEstudiante){
            RespInfoNotasEstDto info = new RespInfoNotasEstDto();
            info = mappingNotas.transformarNotasResponseInfoEstDto(notas);
            listaNotasIds.add(info);
        }
        ResponseNotasEstDto response = new ResponseNotasEstDto();
        response.setListaNotasEstudiante(listaNotasIds);
        return response;
    }

    @Override
    public RespInfoNotasEstDto buscarNotas(Long idMateria, Long idEstudiante) {
        RespInfoNotasEstDto responseNotasDto = null;
        Notas notasLocal = null;
        try{
            Materia materia = materiaImp.findById(idMateria);
            Estudiante estudiante = estudianteImp.findById(idEstudiante);
            notasLocal = notasRepository.findByMateriaAndEstudiante(materia, estudiante);
            if(null != notasLocal){
                responseNotasDto = mappingNotas.transformarNotasResponseInfoEstDto(notasLocal);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return responseNotasDto;
    }
}
