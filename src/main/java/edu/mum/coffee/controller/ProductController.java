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

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.ProductService;

@RestController
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	public ProductService productService;

	@GetMapping({ "/createProduct" })
	public ModelAndView createProductPage() {
		ModelAndView modelAndView = new ModelAndView("createProduct");
		Product product = new Product();
		modelAndView.addObject(product);
		modelAndView.addObject("productType", ProductType.values());
		return modelAndView;
	}

	@RequestMapping("/saveProduct")
	public ModelAndView saveProductPage(@ModelAttribute(value = "product") Product product) {
		productService.save(product);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin");
		return modelAndView;
	}

	@RequestMapping("/listProducts")
	public ModelAndView listProductPage(Map<String, Object> map) {
		List<Product> allProduct = productService.getAllProduct();
		map.put("products", allProduct);
		ModelAndView modelAndView = new ModelAndView("listProduct");
		return modelAndView;
	}

	@RequestMapping("/deleteProducts/{id}")
	public ModelAndView deleteProductPage(@PathVariable("id") int id) {
		Product product = productService.getProduct(id);
		productService.delete(product);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/listProducts");
		return modelAndView;
	}

	@RequestMapping("/updateProducts/{id}")
	public ModelAndView updateProductsPage(@PathVariable("id") int id, Map<String, Object> map) {
		Product product = productService.getProduct(id);
		map.put("product", product);
		map.put("productType", ProductType.values());
		ModelAndView modelAndView = new ModelAndView("updateProduct");
		return modelAndView;
	}

	@ModelAttribute
	public void getProduct(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			map.put("product", productService.getProduct(id));
		}
	}

	@RequestMapping("/updateProductAndSave")
	public ModelAndView updateProductsPage(Product product) {
		productService.save(product);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/listProducts");
		return modelAndView;
	}
}
