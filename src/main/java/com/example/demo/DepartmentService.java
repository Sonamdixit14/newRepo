package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
	void savedepartment(departments d);
	//read
	List<departments>fetchdepartmentList();
    //update
	departments updatedepartment(departments d,int id) ;
	//delete
	departments deletedepartmentById(int id);
	departments findBydepartment(String department);
}
