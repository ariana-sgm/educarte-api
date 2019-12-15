package com.educarte.controller;

import com.educarte.dto.ReqLoginDto;
import com.educarte.dto.ReqProfesorDto;
import com.educarte.dto.ResponseLoginDto;
import com.educarte.dto.ResponseProfesorDto;
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
    public ResponseProfesorDto saveProfesor(@RequestBody ReqProfesorDto profesorDto) {
        ReqProfesorDto profesor = profesorDto;
        ResponseProfesorDto response = new ResponseProfesorDto();
        try {
            response = profesorImp.saveProfesor(profesor);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/finds", method = RequestMethod.GET)
    public ResponseProfesorDto findByIdLogin(@RequestBody ReqLoginDto reqLoginDto) {
        ResponseProfesorDto responseProfesorDto = new ResponseProfesorDto();
        try {
            responseProfesorDto = loginImp.findByEmailAndPassword(reqLoginDto.getEmailDto(), reqLoginDto.getPasswordDto());

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return responseProfesorDto;
    }
}
