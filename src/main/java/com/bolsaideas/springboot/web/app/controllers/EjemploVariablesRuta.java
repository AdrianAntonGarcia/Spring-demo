package com.bolsaideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRuta {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");
		return "variables/index";
	}

	/**
	 * Los nombres de la variable del pathvariable y el getMapping deben coincidir o
	 * indicarlo con name
	 * 
	 * @param texto
	 * @return
	 */
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable(name = "texto") String textoOtro, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + textoOtro);
		return "variables/ver";
	}

	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable(name = "texto") String textoOtro, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado",
				"El texto enviado en la ruta es: " + textoOtro + " y el número enviado al path es: " + numero);
		return "variables/ver";
	}
}
