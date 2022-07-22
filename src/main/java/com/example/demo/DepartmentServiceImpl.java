package com.example.demo;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository repo;
	
	@Override
	public void savedepartment(departments d) {
		repo.save(d);
	}
	@Override
	public List<departments>fetchdepartmentList(){
		List<departments> list= repo.findAll();
		return list;
	}
	@Override
	public departments updatedepartment(departments d ,int id) {
		departments dr=repo.getById(id);
		dr.setDepartment(d.getDepartment());
		dr.setDepmanager(d.getDepmanager());
	    repo.save(dr);
	    return dr;
	
	}
	@Override
	public departments deletedepartmentById(int id) {
		repo.deleteById(id);
		return null;
	}
	@Override
	public departments findBydepartment(String department) {
		departments d= repo.getByDepartment(department);
		return d;
	}
}