package com.bolsaideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	/* por defecto es GET */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
//	@GetMapping("/index")
//	@GetMapping(value = "/index")
//	public String index() {
//		return "index";
//	}
//	Se puede mapear a varias a la vez
//	@GetMapping({"/index", "/", "/home"})
//	public String index2() {
//		return "index";
//	}
}
