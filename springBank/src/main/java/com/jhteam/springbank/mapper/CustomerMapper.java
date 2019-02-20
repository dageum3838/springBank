package com.jhteam.springbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jhteam.springbank.vo.Customer;

@Mapper
public interface CustomerMapper {
	int insertCustomer(Customer customer);
	List<Customer> selectOfficeList();
}
