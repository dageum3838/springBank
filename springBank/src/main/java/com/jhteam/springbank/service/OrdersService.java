package com.jhteam.springbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhteam.springbank.mapper.CustomerMapper;
import com.jhteam.springbank.mapper.OrdersMapper;
import com.jhteam.springbank.vo.Orders;

/*
 * @file CustomerService.java
 * @brief CustomerService
 * @author ksmart30 JDG HSY
 */

@Service			// service 계층 
@Transactional		// transaction(ACID 처리)
public class OrdersService {
	//자동 DI : DAO 클래스(OrdersMapper.java)
	@Autowired private OrdersMapper ordersmapper;
	
	/* -주문 처리-
	 * @param  Orders orders
	 * @brief  ordersmapper.updateCustomerDeposit(orders) (주문 금액에 따라 예수금 차감)
	 * 		   ordersmapper.insertOrdersCustomer(orders); (주문내역추가)
	 * @return result(String) <-- 주문의 결과
	 */
	public String orderCustomer(Orders orders) {
		String result="주문실패";
		//주문번호
		String orderCode = "order001";
		//주문테이블의 row의 갯수
		int rowCount = ordersmapper.ordersCountAll();
		
		//주문테이블의 row의 갯수에 따라 주문번호 자동증가
		if(rowCount>=1) {
			orderCode = "order00" + (++rowCount);
		}
		
		//계산된 주문번호를 Orders(vo)셋팅
		orders.setOrderNo(orderCode);
		
		//주문 금액에 따라 예수금 차감
		ordersmapper.updateCustomerDeposit(orders);
		
		//주문내역추가
		int success= ordersmapper.insertOrdersCustomer(orders);
		
		//1이상일 경우 주문성공
		if(success>=1) {
			result="주문성공";
		}
		
		return result;
		
	}

}
