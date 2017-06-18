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

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("/admin")
public class PersonController {
	@Autowired
	public OrderService orderService;
	@Autowired
	public PersonService personService;

	@GetMapping({ "/createPerson" })
	public ModelAndView createProductPage() {
		ModelAndView modelAndView = new ModelAndView("createPerson");
		Person person = new Person();
		modelAndView.addObject(person);
		return modelAndView;
	}

	@RequestMapping("/savePerson")
	public ModelAndView saveProductPage(@ModelAttribute(value = "person") Person person) {
		personService.savePerson(person);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin");
		return modelAndView;
	}

	@RequestMapping("/listPersons")
	public ModelAndView listProductPage(Map<String, Object> map) {
		List<Person> findAllPersons = personService.findAllPersons();
		map.put("persons", findAllPersons);
		ModelAndView modelAndView = new ModelAndView("listPersons");
		return modelAndView;
	}
	@RequestMapping("/listOrder")
	public ModelAndView listOrderPage(Map<String, Object> map) {
		List<Order> orders = orderService.findAll();
		map.put("orders", orders);
		ModelAndView modelAndView = new ModelAndView("listOrders");
		return modelAndView;
	}

	@RequestMapping("/updatePerson/{id}")
	public ModelAndView updateProductsPage(@PathVariable("id") long id, Map<String, Object> map) {
		Person person = personService.findById(id);
		map.put("person", person);
		ModelAndView modelAndView = new ModelAndView("updatePerson");
		return modelAndView;
	}
	@ModelAttribute
	public void getProduct(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if(id != null){
			map.put("person",personService.findById(Long.valueOf(id)));
		}
	}
	@RequestMapping("/updatePersonAndSave")
	public ModelAndView updatePersonAndSavePage(Person person) {
		personService.savePerson(person);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/listPersons");
		return modelAndView;
	}
}
