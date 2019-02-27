package com.jhteam.springbank.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jhteam.springbank.vo.Orders;

@Mapper
public interface OrdersMapper {
	int ordersCountAll();
	int updateCustomerDeposit(Orders orders);
	int insertOrdersCustomer(Orders orders);
}
