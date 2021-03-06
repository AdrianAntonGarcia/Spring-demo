package com.bolsaideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	/**
	 * Ejemplo de llamada:
	 * http://localhost:8080/params/string?texto=Hola%20adri%C3%A1n
	 * 
	 * @param textoOtro valor introducido como parametro de la url que se llamará
	 *                  texto (definido en el value)
	 * @param model     modelo de la vista
	 * @return retornamos el nombre del archivo html que va a pintar esta vista, en
	 *         este caso la estamos metiendo dentro de una carpeta llamada params,
	 *         el archivo se llama ver
	 */
	@GetMapping("/string")
	public String param(
			@RequestParam(value = "texto", required = false, defaultValue = "no ha entrado texto") String textoOtro,
			Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + textoOtro);
		return "params/ver";
	}

	/**
	 * Enviando varios parámetros
	 * 
	 * @param saludo
	 * @param numero
	 * @param model
	 * @return
	 */
	@GetMapping("/mix-param")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El salud enviado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

	/**
	 * Usando el HttpServletRequest
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("resultado", "El salud enviado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

	@GetMapping("/")
	public String index() {
		return "params/index";
	}
}
