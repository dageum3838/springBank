package com.jhteam.springbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	@GetMapping("/index")
	public String Index() {
		return "index";
	}
}
