package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
   //save operstion
	void saveLogin(LoginCred l);
	
    //update
	LoginCred update(LoginCred l,String username);
	
	List<LoginCred> findByusername(String username);
	LoginCred findByuserpassword(String userpassword);
}