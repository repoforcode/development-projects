package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Product;
import com.springboot.repository.ProductRepository;

@RestController
public class HomeController {
	@Autowired
	ProductRepository repo;

	@RequestMapping(value = "/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("homepage");
		List<Product> list = new ArrayList<>();
		list.addAll(repo.findAll());
		mav.addObject("product", list);
		return mav;
	}

	@RequestMapping(value = "/getForm")
	public ModelAndView getForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		ModelAndView mav = new ModelAndView("createProductForm");
		return mav;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView createProduct(@ModelAttribute("product") Product product) {
		repo.save(product);
		ModelAndView mav = new ModelAndView("Success");
		return mav;
	}
	
	
	
	
}
