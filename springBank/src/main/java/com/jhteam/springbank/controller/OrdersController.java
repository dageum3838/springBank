package com.jhteam.springbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhteam.springbank.service.OrdersService;
import com.jhteam.springbank.vo.Orders;

@Controller
public class OrdersController {
	@Autowired private OrdersService orderservice;
	
	@PostMapping("/goodsOrder")
	public String goodsOrder(Orders orders, HttpSession session) {
		orders.setMemberId((String)session.getAttribute("SID"));
		System.out.println(orders.toString());
		System.out.println(orderservice.orderCustomer(orders));
		
		return "redirect:/index";
	}

}
