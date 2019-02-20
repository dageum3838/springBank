package com.jhteam.springbank.vo;

public class Management {
	private String officeCode;
	private String officeName;
	private String officeManager;
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
	public String getOfficeManager() {
		return officeManager;
	}
	public void setOfficeManager(String officeManager) {
		this.officeManager = officeManager;
	}
	@Override
	public String toString() {
		return "Management [officeCode=" + officeCode + ", officeName=" + officeName + ", officeManager="
				+ officeManager + "]";
	}
}
