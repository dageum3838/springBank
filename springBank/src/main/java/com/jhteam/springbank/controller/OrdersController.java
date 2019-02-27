package com.jhteam.springbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhteam.springbank.vo.Orders;

@Controller
public class OrdersController {
	
	@PostMapping("/goodsOrder")
	public String goodsOrder(Orders orders) {
		System.out.println(orders.toString());
		
		
		return "redirect:/index";
	}

}
