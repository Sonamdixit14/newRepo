package com.example.demo;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
   //save operstion
	void saveEmployee(Employees2 e);
	//read
	List<Employees2>fetchEmployeeList();
    //update
	Employees2 updateEmployee(Employees2 e,int id) ;
	//delete
	Employees2 deleteEmployeeById(int id);
	Employees2 findById(int id);
	List<Employees2> SortEmployeeByName();
	List<Employees2>SortEmployeeBySalary();
	
	long countBydept(String department) ;
	

}
