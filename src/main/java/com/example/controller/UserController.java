package com.example.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.demo.EmployeeService;
import com.example.demo.Employees2;
import com.example.demo.LoginCred;
import com.example.demo.LoginService;

@RestController
@RequestMapping("/UserLogin")
public class UserController {
	
    @Autowired
    EmployeeService service;
    @Autowired
    LoginService services;
    @RequestMapping("login")
    public String tests() {
    	return "test login controller";
    }
    
    @RequestMapping("/getlogin/{username},{userpassword}")
    public ResponseEntity<LoginCred> findOne(@PathVariable(value="username")String username,@PathVariable(value="userpassword")String userpassword) {
    	try {
    		List<LoginCred> log=services.findByusername(username);
    	if(log !=null) {
    		LoginCred logpass=services.findByuserpassword(userpassword);
    		if (logpass !=null) {
    			
    			System.out.println("valid");
    			return new ResponseEntity<LoginCred>(logpass,HttpStatus.FOUND);
    		}
    		
    	}
    	
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	}catch(Exception ex) {
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
		return null;}
    
    @RequestMapping("/getEmployee/{id}")
    public ResponseEntity<Employees2> findOne(@PathVariable(value="id")Integer id) {
    	try {
    	Employees2 emp=service.findById(id);
    	if(emp !=null) {
    		return new ResponseEntity<>(emp,HttpStatus.OK);
    		
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    
@PutMapping("/update")
public ResponseEntity<LoginCred> updatepass(@RequestBody LoginCred l){
	try{
		services.update(l,l.getUsername());
	
	return new ResponseEntity<LoginCred>(l,HttpStatus.OK);
}catch (Exception ex) {
	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
}}

}