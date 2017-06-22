package edu.mum.coffee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.User;
import edu.mum.coffee.service.UserService;

@RestController
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	public UserService userService;

	@GetMapping({ "/createUser" })
	public ModelAndView createProductPage() {
		ModelAndView modelAndView = new ModelAndView("createUser");
		User user = new User();
		modelAndView.addObject(user);
		return modelAndView;
	}
	
	@ModelAttribute
	public void getProduct(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if(id != null){
			map.put("user",userService.findById(Long.valueOf(id)));
		}
	}
	
	@RequestMapping("/saveUser")
	public ModelAndView saveProductPage(@ModelAttribute(value = "user") User user) {
		userService.saveUser(user);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin");
		return modelAndView;
	}
}
