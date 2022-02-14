package com.bolsaideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;	
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bolsaideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	/* por defecto es GET */

	@RequestMapping(value = { "/index", "", "/", "home" }, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo", "hola spring framework con modelAndView!");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Adrián");
		usuario.setApellido("Antón");
		usuario.setEmail("adrtler@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Guzmán", "andres@correo.com"),
				new Usuario("Adrián", "Antón", "adrian@correo.com"), new Usuario("Ana", "Romeu", "ana@correo.com"),
				new Usuario("Tornado", "Roe", "roe@correo.com"));
//		usuarios.add(new Usuario("Andres", "Guzmán", "andres@correo.com"));
//		usuarios.add(new Usuario("Adrián", "Antón", "adrian@correo.com"));
//		usuarios.add(new Usuario("Ana", "Romeu", "ana@correo.com"));
		model.addAttribute("titulo", "Listado de usuarios: ");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	// Diferentes formas de hacer lo mismo
//	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
//	public String index(Map<String, Object> model) {
//		model.put("titulo", "hola spring framework con map!");
//		return "index";
//	}
//	

//	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
//	public String index(ModelMap model) {
//		model.addAttribute("titulo", "hola spring framework dato");
//		return "index";
//	}

	///////////////////////////

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
