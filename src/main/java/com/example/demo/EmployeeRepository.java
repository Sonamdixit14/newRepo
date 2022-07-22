package com.example.demo;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employees2,Integer>{
	long countBydepartment(String emp_deartment);
}
