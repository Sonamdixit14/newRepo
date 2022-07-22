package com.example.demo;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository repo;
	
	@Override
	public void saveLogin(LoginCred l) {
		repo.save(l);
	}
	
	@Override
	public LoginCred  update(LoginCred l ,String username) {
		LoginCred lc=repo.getByUsername(username);
		lc.setUserpassword(l.getUserpassword());
		repo.save(lc);
	    return lc;
	
	}
	
	@Override
	public List<LoginCred> findByusername(String username) {
		List<LoginCred> u= repo.findAll();
		u=u.stream().filter(s->s.getUsername().contains(username)).collect(Collectors.toList());
	return u;
	}
	public LoginCred findByuserpassword(String userpassword) {
		LoginCred u= repo.getByUserpassword(userpassword);
		return u;
	}
}