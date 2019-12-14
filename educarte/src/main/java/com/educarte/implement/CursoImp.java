package com.educarte.implement;

import com.educarte.dto.ReqCursoDto;
import com.educarte.mapping.MappingCurso;
import com.educarte.model.Curso;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import com.educarte.repository.CursoRepository;
import com.educarte.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoImp implements ICursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfesorImp profesorImp;

    @Autowired
    private MappingCurso mappingCurso;

    @Override
    public List<Curso> findByIdProfesor(Long idProfesor) {
        List <Curso> listaCursosProfesor = new ArrayList<Curso>();
        try{
            listaCursosProfesor = cursoRepository.findByProfesor_IdProfesor(idProfesor);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return listaCursosProfesor;
    }

    @Override
    public Curso findById(Long idCurso) {
        Curso curso = new Curso();
        try{
            curso = mappingCurso.transformarOptionalCurso(cursoRepository.findById(idCurso));
            if(null == curso){
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return curso;
    }

    @Override
    public Curso saveCurso(ReqCursoDto reqCursoDto) {
        Curso cursoLocal = new Curso();
        try{
            Profesor profesorCurso = profesorImp.findById(reqCursoDto.getIdProfesor());
            cursoLocal.setNombreCurso(reqCursoDto.getNombreCurso());
            cursoLocal.setProfesor(profesorCurso);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try {
            cursoLocal = cursoRepository.save(cursoLocal);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return cursoLocal;
    }

    @Override
    public boolean eliminarCurso(Long idCurso) {
        try{
            cursoRepository.deleteById(idCurso);
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Curso buscarCurso(Long idCurso) {
        return null;
    }
}
