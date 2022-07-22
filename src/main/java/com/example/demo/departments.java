package com.example.demo;
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
public class departments {
@Id
int depid;
String department;
String depmanager;
public int getDepid() {
	return depid;
}
public void setDepid(int depid) {
	this.depid = depid;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getDepmanager() {
	return depmanager;
}
public void setDepmanager(String depmanager) {
	this.depmanager = depmanager;
}
@Override
public String toString() {
	return "departments [depid=" + depid + ", department=" + department + ", depmanager=" + depmanager + "]";
}


}
