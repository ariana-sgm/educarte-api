package com.educarte.implement;

import com.educarte.model.Login;
import com.educarte.repository.LoginRepository;
import com.educarte.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio que sera llamado desde el controller
@Service
public class LoginImp implements ILoginService {

    //Evita hacer instancia
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login saveLogin(Login login) {
        Login loginLocal = null;
        try{
            loginLocal = loginRepository.save(login);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return loginLocal;
    }

    @Override
    public Login findById(Long id) {
        Login loginLocal = null;
        try{
            //loginLocal
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return loginLocal;
    }

    @Override
    public boolean findByEmailAndPassword(String email, String password) {
        boolean existUser = false;
        Login loginLocal = null;
        try{
            loginLocal = loginRepository.findByEmailAndPassword(email, password);
            if(null != loginLocal){
                existUser = true;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return existUser;
    }
}
