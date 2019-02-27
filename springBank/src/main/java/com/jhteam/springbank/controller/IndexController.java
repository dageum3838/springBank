package com.jhteam.springbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhteam.springbank.service.BankAccountService;
import com.jhteam.springbank.vo.BankAccount;
import com.jhteam.springbank.vo.Customer;

/*
 * @file IndexController.java
 * @brief Index controller
 * @author ksmart30 JDG HSY
 */

@Controller
public class IndexController {
	@Autowired private BankAccountService bankaccountservice;
	// index 페이지 요청
    /* @brief  "http://localhost/index" 주소분기(get방식)
	 * 		   template폴더에 있는 index.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/index")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("SID")!=null) {
			Customer customer = new Customer();
			customer.setMemberId((String)session.getAttribute("SID"));
			List<BankAccount> list = bankaccountservice.CustomerAccount(customer);
			model.addAttribute("list", list);
		}
		return "index";
	}
	
	// financialIssues 페이지 요청
    /* @brief  "http://localhost/financialIssues" 주소분기(get방식)
     * 			계좌번호 리스트->model->view전달
	 * 		   template폴더에 있는 financialIssues.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/financialIssues")
	public String financialIssues(Model model, HttpSession session) {
		if(session.getAttribute("SID")!=null) {
			Customer customer = new Customer();
			customer.setMemberId((String)session.getAttribute("SID"));
			List<BankAccount> list = bankaccountservice.CustomerAccount(customer);
			model.addAttribute("list", list);
		}
		return "financialIssues";
	}
}
