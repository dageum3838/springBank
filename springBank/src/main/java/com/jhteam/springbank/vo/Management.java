package com.jhteam.springbank.vo;

public class Management {
	private String officeCode;
	private String officeName;
	private String office_manager;
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getOffice_manager() {
		return office_manager;
	}
	public void setOffice_manager(String office_manager) {
		this.office_manager = office_manager;
	}
	@Override
	public String toString() {
		return "Management [officeCode=" + officeCode + ", officeName=" + officeName + ", office_manager="
				+ office_manager + "]";
	}
	
	

}
