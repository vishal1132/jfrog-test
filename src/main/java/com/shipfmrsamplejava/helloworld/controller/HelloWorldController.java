package com.shipfmrsamplejava.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC, ";

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");

		String environment = System.getenv("ENVIRONMENT");
		System.out.println("for new commit 2");
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("environment", environment);
    if (name == "") {
			mv.addObject("name", "World");
		} else {
			mv.addObject("name", name);
		}
		return mv;
	}
}
