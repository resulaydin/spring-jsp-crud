package com.kolaytodo.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {

	private Logger log = LoggerFactory.getLogger(getClass());

	AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value = "login")
	public String loginPage(@RequestParam String username, @RequestParam String password, ModelMap model) {

		log.debug("{}",authenticationService.authenticate(username, password));
		
		if (authenticationService.authenticate(username, password)) {
			model.put("username", username);
			model.put("password", password);
			log.debug("Benim adım {}", username);
			return "redirect:list-todos";
//			return "welcome";
		}
		model.put("errorMessage", "Invalid credentials! Please try again");		
		return "login";
	}
}
