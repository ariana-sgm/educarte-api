package com.educarte.repository;

import com.educarte.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository <Login, Long> {

    Login findByEmailAndPassword(String email, String password);
    Login findByEmail(String email);

}
