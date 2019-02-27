package com.jhteam.springbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhteam.springbank.service.CustomerService;
import com.jhteam.springbank.vo.Customer;
import com.jhteam.springbank.vo.Management;

/*
 * @file CustomerController.java
 * @brief Customer controller
 * @author ksmart30 JDG HSY
 */

@Controller
public class CustomerController {
	// 자동DI : service계층 클래스 (CustomerService.java)
	@Autowired private CustomerService customerservice;

	
	// login 페이지 요청
    /* @brief  "http://localhost/login" 주소분기(get방식)
	 * 		   template폴더에 있는 login.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	// login 페이지 요청
	/* @param  Customer customer(커맨드객체), 
	 * 		   HttpSession session
	 * @brief  "http://localhost/login" 주소분기(post방식)
	 * 		       아이디와 비번확인 후 로그인 처리 서비스 호출
	 * 			template폴더에 있는 login.html redirect
	 * @return String(view이름)
	 */
	@PostMapping("/login")
	public String login(Customer customer, HttpSession session) {
		System.out.println(customer.toString());
		System.out.println(customerservice.customerLogin(customer, session));
		return "redirect:/index";
	}
	
	// logout 페이지 요청
    /* @param  HttpSession session 
     * @brief  "http://localhost/logout" 주소분기(get방식)
     *		      로그아웃 처리 서비스 호출
	 * 		   template폴더에 있는 login.html redirect
	 * @return String(view이름)
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		customerservice.customerLogout(session);
		return "redirect:/index";
	}
	
	// register 페이지 요청
    /* @param  Model model 
     * @brief  "http://localhost/register" 주소분기(get방식)
	 * 		       대리점 리스트의 주소값을 model객체를 통해 view전달
	 * 			template폴더에 있는 register.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/register")
	public String register(Model model) {
		List<Management> officeList = customerservice.selectOfficeList();
		model.addAttribute("officeList", officeList);
		return "register";
	}
	
	// register 페이지 요청
    /* @param   Customer customer (커맨드객체)
     * @brief  "http://localhost/register" 주소분기(post방식)
     * 			회원가입 처리 서비스 호출
	 * 		   template폴더에 있는 index.html redirect
	 * @return String(view이름)
	 */
	@PostMapping("/register")
	public String register(Customer customer) {
		System.out.println(customer.toString()+"<-customer");
		customerservice.CustomerAdd(customer);
		return "redirect:/index";
	}
	
	
	// account 페이지 요청
    /* @brief  "http://localhost/account" 주소분기(get방식)
	 * 		   template폴더에 있는 account.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/account")
	public String account() {
		return "account";
	}
	
}
