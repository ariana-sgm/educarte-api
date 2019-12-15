package com.educarte.implement;

import com.educarte.dto.*;
import com.educarte.mapping.MappingMateria;
import com.educarte.model.Curso;
import com.educarte.model.Materia;
import com.educarte.model.Profesor;
import com.educarte.repository.LoginRepository;
import com.educarte.repository.MateriaRepository;
import com.educarte.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaImp implements IMateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private CursoImp cursoImp;

    @Autowired
    private MappingMateria mappingMateria;

    @Override
    public List<Materia> findByIdCurso(Long idCurso) {
        List <Materia> listaMateriasProfesor = new ArrayList<Materia>();
        try{
            listaMateriasProfesor = materiaRepository.findByCurso_IdCurso(idCurso);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return listaMateriasProfesor;
    }

    @Override
    public Materia findById(Long idMateria) {
        Materia materia = new Materia();
        try{
            materia = mappingMateria.transformarOptionalMateria(materiaRepository.findById(idMateria));
            if(null == materia){
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return materia;
    }

    @Override
    public ResponseMateriaCursoDto listarMateriasCurso(Long idCurso) {
        List<Materia> listaMateriasCurso = new ArrayList<>();
        List<ResponseMateriaInfoDto> listaNombreId = new ArrayList<>();
        try {
            listaMateriasCurso = this.findByIdCurso(idCurso);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        for(Materia materia : listaMateriasCurso){
            ResponseMateriaInfoDto info = new ResponseMateriaInfoDto();
            info.setIdMateriaDto(materia.getIdMateria());
            info.setNombreMateriaDto(materia.getNombreMateria());
            listaNombreId.add(info);
        }
        ResponseMateriaCursoDto response = new ResponseMateriaCursoDto();
        response.setListaMateriasCursoDto(listaNombreId);
        return response;
    }

    @Override
    public Materia saveMateria(ReqMateriaDto reqMateriaDto) {
        Materia materiaLocal = new Materia();
        try{
            Curso cursoMateria = cursoImp.findById(reqMateriaDto.getIdCursoDto());
            if (cursoMateria == null) return null;
            materiaLocal.setNombreMateria(reqMateriaDto.getNombreMateriaDto());
            materiaLocal.setCurso(cursoMateria);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try {
            materiaLocal = materiaRepository.save(materiaLocal);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return materiaLocal;
    }

    @Override
    public boolean eliminarMateria(Long idMateria) {
        try{
            materiaRepository.deleteById(idMateria);
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
