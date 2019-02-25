package com.jhteam.springbank.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.jhteam.springbank.vo.Customer;
import com.jhteam.springbank.vo.Management;

@Mapper
public interface BankAccountMapper {
	// member별 office 정보 
	Management selectOffice(String officeCode);
	// 계좌신청시 비번확인
	Customer selectCustomerConfirm (Customer customer);
	// 계좌신청요청
	int insertAccount(Map<String,Object> map);
}
