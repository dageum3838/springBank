package com.jhteam.springbank.vo;

public class Orders extends BankAccount{
	private String orderDate;
	private String orderNo;
	private String accountNo;
	private String memberId;
	private String orderCode;
	private String orderVolume;
	private String orderPrice;
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
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
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderVolume() {
		return orderVolume;
	}
	public void setOrderVolume(String orderVolume) {
		this.orderVolume = orderVolume;
	}
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	@Override
	public String toString() {
		return "Orders [orderDate=" + orderDate + ", orderNo=" + orderNo + ", accountNo=" + accountNo + ", memberId="
				+ memberId + ", orderCode=" + orderCode + ", orderVolume=" + orderVolume + ", orderPrice=" + orderPrice
				+ "]";
	}
	
	
	
}
