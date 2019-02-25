package com.jhteam.springbank.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhteam.springbank.mapper.BankAccountMapper;
import com.jhteam.springbank.vo.BankAccount;
import com.jhteam.springbank.vo.Customer;
import com.jhteam.springbank.vo.Management;

/*
 * @file BankAccountService.java
 * @brief BankAccount service
 * @author ksmart30 JDG HSY
 */

@Service			// service 계층 
@Transactional		// transaction(ACID 처리)
public class BankAccountService {
	// 자동DI : DAO계층 클래스 (BankAccountMapper.java)
	@Autowired private BankAccountMapper bankaccountmapper;
	
	/* -대리점 list처리- 
	 * @brief  주입된 객체(bankaccountmapper)의 selectOffice()메서드 호출 (대리점 리스트)
	 * @return  bankaccountmapper.selectOffice()(Management 객체 주소)
	 */
	public Management selectOffice(HttpSession session) {
		String officeCode = (String)session.getAttribute("SOFFICECODE");
		System.out.println(officeCode+"<--오피스코드");
		return bankaccountmapper.selectOffice(officeCode);
	}
	
	
	// 계좌신청 페이지 요청
    /* @param  HttpSession session, Customer customer 
     * @brief  계좌번호 생성과 계좌신청
	 * @return String(view이름)
	 */
	public void addAccount(HttpSession session, Customer customer) {
		//비번확인
		customer.setMemberId((String)session.getAttribute("SID"));
		System.out.println(customer.toString());
		
		customer = bankaccountmapper.selectCustomerConfirm(customer);
		Management management = bankaccountmapper.selectOffice((String)session.getAttribute("SOFFICECODE"));
		
		if(customer.getMemberPhone() != null) {
						
			//계좌번호 logic
			//현재 날짜 시간 초 구하기
			Calendar calendar = Calendar.getInstance();
	        Date date = calendar.getTime();
	        String today = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));
	        String officeCode = (String)session.getAttribute("SOFFICECODE");
        
	        //계좌번호(추후 count계좌테이블 일렬번호 추가)
	        String accountNo = today + "-" + officeCode.substring(6);
	        System.out.println(accountNo + " <--계좌번호");
	        
	        //회원아이디
	        String memberId = customer.getMemberId();
	        //계좌명
	        String accountName = customer.getMemberName();
	        //계좌개설 지점
	        String accountOffice = management.getOfficeName();
	        //계좌담당자
	        String accountManager = management.getOfficeManager();
	        
	        // mybatis map으로 값을 받는지 여부 확인(공부)
	        Map<String,Object> map = new HashMap<String, Object>();
	        map.put("accountNo", accountNo);
	        map.put("memberId", memberId);
	        map.put("accountName", accountName);
	        map.put("accountOffice", accountOffice);
	        map.put("accountManager", accountManager);
	        
	        System.out.println(map.toString());
	        
	        //계좌신청처리
	        bankaccountmapper.insertAccount(map);
		}
	}
	//고객별 계좌정보List 가져오기
	public List<BankAccount> CustomerAccount(Customer customer) {
		
		return bankaccountmapper.selectCustomerAccount(customer);
	}
}
