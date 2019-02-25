package com.jhteam.springbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jhteam.springbank.vo.Customer;
import com.jhteam.springbank.vo.Management;

@Mapper
public interface CustomerMapper {
	int insertCustomer(Customer customer);
	List<Management> selectOfficeList();
	Customer selectCustomerLogin(Customer customer);
}
