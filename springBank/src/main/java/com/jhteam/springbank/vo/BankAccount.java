package com.jhteam.springbank.vo;

public class BankAccount extends Customer{
	private String accountNo;
	private String memberId;
	private String accountName;
	private int accountDeposit;
	private String accountOffice;
	private String accountManager;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountDeposit() {
		return accountDeposit;
	}
	public void setAccountDeposit(int accountDeposit) {
		this.accountDeposit = accountDeposit;
	}
	public String getAccountOffice() {
		return accountOffice;
	}
	public void setAccountOffice(String accountOffice) {
		this.accountOffice = accountOffice;
	}
	public String getAccountManager() {
		return accountManager;
	}
	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", memberId=" + memberId + ", accountName=" + accountName
				+ ", accountDeposit=" + accountDeposit + ", accountOffice=" + accountOffice + ", accountManager="
				+ accountManager + "]";
	}
	
	
	
	
}
