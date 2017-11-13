package com.solstice.common.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {

		return "index";
	}

}