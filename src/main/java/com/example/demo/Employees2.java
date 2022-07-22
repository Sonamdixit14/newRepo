package com.example.demo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Employees2 implements Serializable {
@Id
public int empid;
String emp_name;
String department;
String emp_designation;
//int emp_phoneno;
String emp_email;
int emp_salary;
String emp_manager;
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmp_name() {
	return emp_name;
}
public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}
public String getEmp_department() {
	return department;
}
public void setEmp_department(String department) {
	this.department = department;
}
public String getEmp_designation() {
	return emp_designation;
}
public void setEmp_designation(String emp_designation) {
	this.emp_designation = emp_designation;
}

public String getEmp_email() {
	return emp_email;
}
public void setEmp_email(String emp_email) {
	this.emp_email = emp_email;
}
public int getEmp_salary() {
	return emp_salary;
}
public void setEmp_salary(int emp_salary) {
	this.emp_salary = emp_salary;
}
public String getEmp_manager() {
	return emp_manager;
}
public void setEmp_manager(String emp_manager) {
	this.emp_manager = emp_manager;
}
@Override
public String toString() {
	return "Employees2 [empid=" + empid + ", emp_name=" + emp_name + ", emp_department=" + department
			+ ", emp_designation=" + emp_designation + ", emp_email=" + emp_email
			+ ", emp_salary=" + emp_salary + ", emp_manager=" + emp_manager + "]";
}
}