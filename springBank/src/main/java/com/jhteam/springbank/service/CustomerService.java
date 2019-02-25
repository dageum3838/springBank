package com.jhteam.springbank.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhteam.springbank.mapper.BankAccountMapper;
import com.jhteam.springbank.mapper.CustomerMapper;
import com.jhteam.springbank.vo.BankAccount;
import com.jhteam.springbank.vo.Customer;
import com.jhteam.springbank.vo.Management;

/*
 * @file CustomerService.java
 * @brief CustomerService
 * @author ksmart30 JDG HSY
 */


@Service			// service 계층 
@Transactional		// transaction(ACID 처리)
public class CustomerService {
	//자동 DI : DAO 클래스(CustomerMapper.java)
	@Autowired private CustomerMapper customermapper;
	@Autowired private BankAccountService bankaccountservice;
	
	/* -대리점 list처리- 
	 * @brief  주입된 객체(customermapper)의 selectOfficeList()메서드 호출 (대리점 리스트)
	 * @return  customermapper.selectOfficeList()(Management 객체 주소)
	 */
	public List<Management> selectOfficeList() {
		
		return customermapper.selectOfficeList();
	}
	
	/* -회원가입 처리-
	 * @param Customer customer
	 * @brief 주입된 객체(customermapper)의 selectOfficeList()메서드 호출 (customer <-view 통해 입력받은 값이 담겨있는 vo)
	 * @return customermapper.insertCustomer(customer)(int)
	 */
	public int CustomerAdd(Customer customer) {
		return customermapper.insertCustomer(customer);
	}
	
	/* -로그인 처리-
	 * @param  Customer customer, HttpSession session
	 * @brief  customermapper.selectCustomerLogin(customer) (customer <-view 통해 입력받은 값이 담겨있는 vo)
	 * @return result(String) <-- 로그인의 결과
	 */
	public String customerLogin(Customer customer, HttpSession session) {
		customer = customermapper.selectCustomerLogin(customer);
		String result="로그인실패";	// 로그인 처리전 초깃값
		
		// 주어진정보의 값이 officeCode를 가지고 있다면 로그인성공
		// session영역에 변수를 선언하고 해당값을 저장한다.
		if(customer.getOfficeCode() !=null) {
			result = "로그인성공";		// 로그인 성공시 
			
			session.setAttribute("SID", customer.getMemberId());
			session.setAttribute("SNAME", customer.getMemberName());
			session.setAttribute("SOFFICECODE", customer.getOfficeCode());
			
			int count=0;	//계좌별 예수금의 확인 초깃값
			
			// 회원별로 계좌가져오기
			List<BankAccount> list = bankaccountservice.CustomerAccount(customer);
			
			// 회원 계좌별로 예수금 확인 체크
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getAccountDeposit() >= 1) {
					count++;
				}
			}
			// view부분에서 예수금을 신청하기 버튼 활성화여부를 가리키는  count
			session.setAttribute("SACCOUNTRECOGNIZE", count);
		}
		return result;
	}
	
	/* -로그아웃 처리-
	 * @brief  session.invalidate(); 세션영역을 비운다.
	 * @return void
	 */
	public void customerLogout(HttpSession session) {
		session.invalidate();
	}
}
