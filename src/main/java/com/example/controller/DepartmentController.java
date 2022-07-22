package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.demo.DepartmentService;
import com.example.demo.Employees2;
import com.example.demo.departments;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	
    @Autowired
    DepartmentService service;
    @RequestMapping("/test")
    public String tests() {
    	return "test department controller";
    }
    
    @RequestMapping("/getdepartment/{department}")
    public ResponseEntity<departments> findOne(@PathVariable(value="department")String department) {
    	try {
    	departments dep=service.findBydepartment(department);
    	if(dep !=null) {
    		return new ResponseEntity<>(dep,HttpStatus.OK);
    		
    	}
    	else {
    		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    	}
    	
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    
    @GetMapping("/getdepartment")
    List<departments> listEmployee() throws Exception{
    	try {
    	List<departments> deplist=service.fetchdepartmentList();
        for(departments d:deplist)
        	System.out.println(d+"\n");
        return deplist;
    
    }catch (InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }}
    @PostMapping("/savedep")
    public ResponseEntity<departments> savedepartment(@RequestBody departments d){
    	try {
    	service.savedepartment(d);
    	return new ResponseEntity<departments>(d,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
   @PutMapping("/updatedep")
    public ResponseEntity<departments> updatep(@RequestBody departments d){
    	try{
    		service.updatedepartment(d,d.getDepid());
    	
    	return new ResponseEntity<departments>(d,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    @DeleteMapping("/Deletedep/{id}")
    public ResponseEntity<departments> deletedepartmentById(@PathVariable("id") int id){
    	try{
    		departments d=service.deletedepartmentById(id);
    	
    	return new ResponseEntity<departments>(d,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}}