package com.capg.model;

import java.util.ArrayList;
import java.util.List;

public class BankAccount 
{
  String accountNo;
  String name;
  String mobileNo;
  String aadharNo;
  long accountBalance;
  public List<String> tl=new ArrayList();
  String pin;
  public BankAccount() {
	super();
  }
  public BankAccount(String accountNo, String name, String mobileNo, String aadharNo, long accountBalance, String pin) {
	super();
	this.accountNo = accountNo;
	this.name = name;
	this.mobileNo = mobileNo;
	this.aadharNo = aadharNo;
	this.accountBalance = accountBalance;
	this.pin = pin;
}
public String getAccountNo() {
	return accountNo;
}
public void setAccountNo(String accountNo) {
	this.accountNo = accountNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getAadharNo() {
	return aadharNo;
}
public void setAadharNo(String aadharNo) {
	this.aadharNo = aadharNo;
}
public long getAccountBalance() {
	return this.accountBalance;
}
public void setAccountBalance(long accountBalance) {
	this.accountBalance = accountBalance;
}
public String getPin() {
	return pin;
}
public void setPin(String pin) {
	this.pin = pin;
}
@Override
public String toString() {
	return "BankAccount [accountNo=" + accountNo + ", name=" + name + ", mobileNo=" + mobileNo + ", aadharNo="
			+ aadharNo + ", accountBalance=" + accountBalance + ", pin=" + pin + "]";
} 
}
