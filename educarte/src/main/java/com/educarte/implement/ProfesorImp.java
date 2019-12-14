package com.educarte.implement;

import com.educarte.dto.ReqProfesorDto;
import com.educarte.mapping.MappingLogin;
import com.educarte.mapping.MappingProfesor;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import com.educarte.repository.LoginRepository;
import com.educarte.repository.ProfesorRepository;
import com.educarte.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorImp implements IProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private LoginImp loginImp;

    @Autowired
    private MappingProfesor mappingProfesor;

    @Override
    public Profesor saveProfesor(ReqProfesorDto profesorDto) {
        Profesor profesorLocal = new Profesor();
        Profesor provisional = new Profesor();
        try{
            Login login = loginImp.findById(profesorDto.getIdLoginDto());
            provisional.setIdLogin(login);
            provisional.setApellidoProfesor(profesorDto.getApellidoProfesorDto());
            provisional.setNombreProfesor(profesorDto.getNombreProfesorDto());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        try{
            profesorLocal = profesorRepository.save(provisional);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return profesorLocal;
    }

    @Override
    public Profesor findById(Long idProfesor) {
        Profesor profesor = new Profesor();
        try{
            profesor = mappingProfesor.transformarOptionaProfesor(profesorRepository.findById(idProfesor));
            if(null == profesor){
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return profesor;
    }

    @Override
    public Profesor findByIdLogin(Long idLogin) {
        Profesor profesorLocal = null;
        try{
            profesorLocal = profesorRepository.findByIdLogin(idLogin);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return profesorLocal;
    }
}
