package edu.mum.coffee.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("/user")
public class OrderController {
	
	@Autowired
	public PersonService personService;
	@Autowired
	public OrderService orderService;

	@GetMapping({ "/createOrder" })
	public ModelAndView createProductPage() {
		ModelAndView modelAndView = new ModelAndView("createOrder");
		Order order = new Order();
		order.setOrderDate(new Date());
		modelAndView.addObject(order);
		return modelAndView;
	}

	@RequestMapping("/saveOrder")
	public ModelAndView saveProductPage(@ModelAttribute(value = "order") Order order) {
		orderService.save(order);
		ModelAndView modelAndView = new ModelAndView("redirect:/user");
		return modelAndView;
	}
	@RequestMapping("/profile")
	public ModelAndView profilePage(Map<String,Object> map) {
		List<Person> findByEmail = personService.findByEmail("user@gmail.com");
		map.put("person", findByEmail.get(0));
		ModelAndView modelAndView = new ModelAndView("profile");
		return modelAndView;
	}

	@ModelAttribute
	public void getProduct(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if(id != null){
			map.put("person",personService.findById(Long.valueOf(id)));
		}
	}
	@RequestMapping("/updateProfile")
	public ModelAndView updatePersonAndSavePage(Person person) {
		personService.savePerson(person);
		ModelAndView modelAndView = new ModelAndView("redirect:/user");
		return modelAndView;
	}
}
