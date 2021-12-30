package com.example.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.database.CustomUserDetails;
import com.example.database.bean.User;
import com.example.database.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException("Email id does not exsist");
		}
		
		return new CustomUserDetails(user);
	}

}
