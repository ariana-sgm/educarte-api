package com.educarte.controller;

import com.educarte.dto.ReqLoginDto;
import com.educarte.dto.ReqProfesorDto;
import com.educarte.implement.LoginImp;
import com.educarte.implement.ProfesorImp;
import com.educarte.model.Login;
import com.educarte.model.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/profesors")
public class ProfesorController {

    @Autowired
    private ProfesorImp profesorImp;

    @Autowired
    private LoginImp loginImp;

    @RequestMapping(method = RequestMethod.POST)
    public Profesor saveProfesor(@RequestBody ReqProfesorDto profesorDto) {
        ReqProfesorDto profesor = profesorDto;
        Profesor profesorController = new Profesor();
        try {
            profesorController = profesorImp.saveProfesor(profesor);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return profesorController;
    }

}
