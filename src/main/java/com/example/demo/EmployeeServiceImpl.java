package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;
	
	@Override
	public void saveEmployee(Employees2 e) {
		repo.save(e);
	}
	@Override
	public List<Employees2>fetchEmployeeList(){
		List<Employees2> list= repo.findAll();
		return list;
	}
	@Override
	public Employees2 updateEmployee(Employees2 e ,int id) {
		Employees2 er=repo.getById(id);
		er.setEmp_name(e.getEmp_name());
		er.setEmp_department(e.getEmp_department());
		er.setEmp_designation(e.getEmp_designation());
		//er.setEmp_phoneno(e.getEmp_phoneno());
		er.setEmp_email(e.getEmp_email());
		er.setEmp_salary(e.getEmp_salary());
		er.setEmp_manager(e.getEmp_manager());
	    repo.save(er);
	    return er;
	
	}
	@Override
	public Employees2 deleteEmployeeById(int id) {
		repo.deleteById(id);
		return null;
	}
	@Override
	public Employees2 findById(int id) {
		Employees2 p= repo.getById(id);
		return p;
	}
	@Override
	public List<Employees2> SortEmployeeByName(){
		List<Employees2> list=repo.findAll();
		return list.stream().sorted(Comparator.comparing(Employees2::getEmp_name)).collect(Collectors.toList());
		
	}
	
	@Override
	public List<Employees2>SortEmployeeBySalary(){
		List<Employees2> l=repo.findAll();
		return l.stream().sorted(Comparator.comparingInt(Employees2::getEmp_salary).reversed()).collect(Collectors.toList());
		
	}
	@Override
	public long countBydept(String department) {
	    return repo.countBydepartment(department);
	}
	



}

