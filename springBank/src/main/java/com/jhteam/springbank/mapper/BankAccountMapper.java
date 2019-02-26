package com.jhteam.springbank.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import com.jhteam.springbank.vo.BankAccount;
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
	// 고객별 계좌정보
	List<BankAccount> selectCustomerAccount(Customer customer);
	// 예수금입금 처리
	int selectUpdateDeposit(BankAccount bankaccount);
}
