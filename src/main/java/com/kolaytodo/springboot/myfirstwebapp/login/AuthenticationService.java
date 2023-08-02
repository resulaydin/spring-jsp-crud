package com.kolaytodo.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username,String password) {
		boolean isUsername = username.equalsIgnoreCase("resul");
		boolean isPassword = password.equalsIgnoreCase("1234");
		
		return isUsername && isPassword;
		
	}

}
