package com.bolsaideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		/**
		 * return "redirect:https://www.google.com"; Con forward no perdemos los
		 * parametros del request return "redirect:/app/index";
		 */
		return "forward:/app/index";
	}
}
