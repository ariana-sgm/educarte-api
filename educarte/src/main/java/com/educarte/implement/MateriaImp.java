package com.educarte.implement;

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

    @Override
    public List<Materia> buscarListaMateria(Long idCurso) {
        return null;
    }

    /*
    public List<Materia> buscarListaMateria(Long idCurso) {
        List<Materia> listaMateriasLocal= new ArrayList<>();
        try {
            for (Materia materia : Materia){

            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return listaMateriasLocal;
    }
    */


    @Override
    public Materia saveMateria(Materia materia) {
        return null;
    }

    @Override
    public boolean eliminarMateria(Long id) {
        return false;
    }

    @Override
    public Materia buscarMateria(Long id) {
        return null;
    }
}
