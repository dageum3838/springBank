package com.jhteam.springbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhteam.springbank.vo.Customer;

/*
 * @file BoardController.java
 * @brief board controller
 * @author ksmart30 HSY
 */

@Controller
public class CustomerController {
	// index 페이지 요청
    /* @brief  "http://localhost/index" 주소분기(get방식)
	 * 		   template폴더에 있는 index.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	// login 페이지 요청
    /* @brief  "http://localhost/login" 주소분기(get방식)
	 * 		   template폴더에 있는 login.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	// register 페이지 요청
    /* @brief  "http://localhost/register" 주소분기(get방식)
	 * 		   template폴더에 있는 register.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	// register 페이지 요청
    /* @brief  "http://localhost/register" 주소분기(post방식)
	 * 		   template폴더에 있는 index.html redirect
	 * @return String(view이름)
	 */
	@PostMapping("/register")
	public String register(Customer customer) {
		System.out.println(customer.toString()+"<-customer");
		return "redirect:/index";
	}
}
