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

@RestController
@RequestMapping("/api")
public class EmployeeController {
	//static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());
    @Autowired
    EmployeeService service;
    @RequestMapping("/Employee")
    public String tests() {
    	return "test employee controller";
    }
    
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
    
    @GetMapping("/getEmployee")
    List<Employees2> listEmployee() throws Exception{
    	try {
    	List<Employees2> emplist=service.fetchEmployeeList();
        for(Employees2 e:emplist)
        	System.out.println(e+"\n");
        return emplist;
    
    }catch (InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }}
    @PostMapping("/save")
    public ResponseEntity<Employees2> saveEmployee(@RequestBody Employees2 e){
    	try {
    	service.saveEmployee(e);
    	return new ResponseEntity<Employees2>(e,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
   @PutMapping("/update")
    public ResponseEntity<Employees2> updatep(@RequestBody Employees2 e){
    	try{
    		service.updateEmployee(e,e.getEmpid());
    	
    	return new ResponseEntity<Employees2>(e,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Employees2> deleteEmployeeById(@PathVariable("id") int id){
    	try{
    		Employees2 e=service.deleteEmployeeById(id);
    	
    	return new ResponseEntity<Employees2>(e,HttpStatus.OK);
    }catch (Exception ex) {
    	return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }}
    @GetMapping("/getEmployeesortedSalary") 
	   List<Employees2> listEmployeesortedsalary() throws Exception{
    try {
    	List<Employees2> empl=service.SortEmployeeBySalary();
        for(Employees2 e:empl)
        	System.out.println(e+"\n");
        return empl;
    
    }catch(InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }}
    
    @GetMapping("/getEmployeesortedNme")
   public List<Employees2> listEmployeesortedname() throws Exception{
    	try{
    		List<Employees2> emply=service.SortEmployeeByName();
    	
        for(Employees2 e:emply)
        	System.out.println(e+"\n");
        return emply;
    }catch(InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }}
    @GetMapping("/getEmployeecount/{department}")
    public long empgetcount(@PathVariable("department") String department) throws Exception{
    	try{
    		long e=service.countBydept(department);
    	
    	return e;
    }catch(InternalServerError ex) {
    	throw new Exception("INTERNAL_SERVER_ERROR");
    }}
    
    	
    
}
