package com.educarte.implement;

import com.educarte.dto.ReqEstudianteDto;
import com.educarte.dto.ResponseEstudianteDto;
import com.educarte.dto.ResponseProfesorDto;
import com.educarte.mapping.MappingEstudiante;
import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import com.educarte.repository.EstudianteRepository;
import com.educarte.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteImp implements IEstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    MappingEstudiante mappingEstudiante;

    @Autowired
    LoginImp loginImp;

    @Override
    public List<Estudiante> buscarListaEstudiante(Long idCurso) {
        return null;
    }

    @Override
    public ResponseEstudianteDto saveEstudiante(ReqEstudianteDto estudianteDto) {
        ResponseEstudianteDto response = new ResponseEstudianteDto();
        Estudiante estudianteLocal = new Estudiante();
        Profesor provisional = new Profesor();
        try{
            Login login = loginImp.findById(estudianteDto.getIdLogin());
            estudianteLocal.setLogin(login);
            estudianteLocal.setApellidoEstudiante(estudianteDto.getApellidoDto());
            estudianteLocal.setNombreEstudiante(estudianteDto.getNombreDto());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            estudianteLocal = estudianteRepository.save(estudianteLocal);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        response = mappingEstudiante.transformarEstudianteResponseDto(estudianteLocal);
        return response;
    }

    @Override
    public boolean eliminarEstudiante(Long idEstudiante) {
        try{
            estudianteRepository.deleteById(idEstudiante);
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Estudiante findById(Long idEstudiante) {
        Estudiante estudiante = new Estudiante();
        try{
            estudiante = mappingEstudiante.transformarOptionalEstudiante(estudianteRepository.findById(idEstudiante));
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return estudiante;
    }

    @Override
    public ResponseEstudianteDto findByIdLogin(Login login) {
        ResponseEstudianteDto response = new ResponseEstudianteDto();
        Estudiante estudianteLocal = new Estudiante();
        try{
            estudianteLocal = estudianteRepository.findByLogin(login);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        return response = mappingEstudiante.transformarEstudianteResponseDto(estudianteLocal);
    }


}
