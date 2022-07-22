package com.example.demo;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LoginRepository extends JpaRepository<LoginCred,Integer>{

	LoginCred getByUsername(String username);

	void deleteByUsername(String username);

	LoginCred getByUserpassword(String userpassword);
	
}
