package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/home"})
	public String homePage() {
		return "home";
	}
	@GetMapping({ "/index"})
	public String indexPage() {
		return "index";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	@RequestMapping("/user")
	public String toUserPage(){
		return "userPage";
	}
	@RequestMapping("/admin")
	public String toAdminPage(){
		return "adminPage";
	}
	
	@RequestMapping("/logout")
	public String toLoginPage(){
		return "login";
	}
	
}
