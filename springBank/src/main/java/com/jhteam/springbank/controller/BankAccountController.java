package com.jhteam.springbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhteam.springbank.service.BankAccountService;
import com.jhteam.springbank.vo.BankAccount;
import com.jhteam.springbank.vo.Customer;
import com.jhteam.springbank.vo.Management;

/*
 * @file BankAccountController.java
 * @brief BankAccountController
 * @author ksmart30 JDG HSY
 */

@Controller
public class BankAccountController {
	// 자동DI : service계층 클래스 (BankAccountService.java)
	@Autowired private BankAccountService bankaccountservice;
	
	// 계좌신청 페이지 요청
    /* @param  HttpSession session 
     * @brief  "http://localhost/accountRequest" 주소분기(get방식)
     *		   대리점 리스트-> model -> view 전달
	 * 		   template폴더에 있는 accountRequest.html forward
	 * @return String(view이름)
	 */
	@GetMapping("/accountRequest")
	public String accountRequest(HttpSession session, Model model){
		Management office = bankaccountservice.selectOffice(session);
		model.addAttribute("office", office);
		return "accountRequest";
	}
	
	// 계좌신청 페이지 요청
    /* @param  HttpSession session 
     * @brief  "http://localhost/accountRequest" 주소분기(post방식)
     *		   계좌신청처리
	 * 		   template폴더에 있는 accountRequest.html redirect
	 * @return String(view이름)
	 */
	@PostMapping("/accountRequest")
	public String accountRequest(HttpSession session, Customer customer){
		System.out.println(customer.toString());
		bankaccountservice.addAccount(session, customer);
		return "redirect:/index";
	}
	
	@GetMapping("/accountDeposit")
	public String accountDeposit(HttpSession session, Model model) {
		Customer customer = new Customer();
		customer.setMemberId((String)session.getAttribute("SID"));
		List<BankAccount> list = bankaccountservice.CustomerAccount(customer);
		model.addAttribute("list", list);
		return "accountDeposit";
	}
}
