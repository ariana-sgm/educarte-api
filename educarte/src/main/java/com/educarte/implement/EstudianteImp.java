package com.educarte.implement;

import com.educarte.dto.*;
import com.educarte.mapping.MappingEstudiante;
import com.educarte.model.Curso;
import com.educarte.model.Estudiante;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import com.educarte.repository.EstudianteRepository;
import com.educarte.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteImp implements IEstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    MappingEstudiante mappingEstudiante;

    @Autowired
    LoginImp loginImp;

    @Autowired
    CursoImp cursoImp;

    @Override
    public ResponseEstudianteDto saveEstudiante(ReqEstudianteDto estudianteDto) {
        ResponseEstudianteDto response = new ResponseEstudianteDto();
        Estudiante estudianteLocal = new Estudiante();
        Profesor provisional = new Profesor();
        try{
            Login login = loginImp.findById(estudianteDto.getIdLogin());
            Curso curso = cursoImp.findById(estudianteDto.getIdCurso());
            if (login == null) return  null;
            estudianteLocal.setLogin(login);
            estudianteLocal.setApellidoEstudiante(estudianteDto.getApellidoDto());
            estudianteLocal.setNombreEstudiante(estudianteDto.getNombreDto());
            estudianteLocal.setCurso(curso);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
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

    @Override
    public List<Estudiante> findByIdCurso(Long idCurso) {
        List <Estudiante> listaEstudiantesCurso = new ArrayList<Estudiante>();
        try{
            listaEstudiantesCurso = estudianteRepository.findByCurso_IdCurso(idCurso);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return listaEstudiantesCurso;
    }

    @Override
    public ResponseEstudianteCursoDto listarEstudiantesCurso(Long idCurso) {
        List<Estudiante> listaEstudiantesCurso = new ArrayList<>();
        List<ResponseEstudianteDto> listaNombreId = new ArrayList<>();
        try {
            listaEstudiantesCurso = this.findByIdCurso(idCurso);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        for(Estudiante estudiante : listaEstudiantesCurso){
            ResponseEstudianteDto info = new ResponseEstudianteDto();
            info = mappingEstudiante.transformarEstudianteResponseDto(estudiante);
            listaNombreId.add(info);
        }
        ResponseEstudianteCursoDto response = new ResponseEstudianteCursoDto();
        response.setListaEStudiantesCurso(listaNombreId);
        return response;
    }
}
