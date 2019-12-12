package com.educarte.controller;

import com.educarte.dto.ReqLoginDto;
import com.educarte.implement.LoginImp;
import com.educarte.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginImp loginImp;

    @RequestMapping(method = RequestMethod.POST)
    public Login saveLogin(@RequestBody Login login){
        Login loginController = null;
        try {
            loginController = loginImp.saveLogin(login);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return loginController;
    }

    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public boolean validateLogin(@RequestBody ReqLoginDto loginDto){
        boolean loginController = false;
        try {
            loginController = loginImp.findByEmailAndPassword(loginDto.getEmailDto(), loginDto.getPasswordDto());
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return loginController;
    }

}
