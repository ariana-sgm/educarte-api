package com.educarte.service;

import com.educarte.model.Login;

public interface ILoginService {

    Login saveLogin(Login login);
    Login findById(Long id);
    boolean findByEmailAndPassword(String email, String password);
}
