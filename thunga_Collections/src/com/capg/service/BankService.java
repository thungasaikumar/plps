package com.capg.service;

import java.util.List;

import com.capg.exception.BalanceException;

public interface BankService 
{
  boolean createAccount(String accountNo, String name, String mobileNo, String aadharNo,String pin);
  long showBalance(String accountNo,String pin);
  long deposit(String accountNo,long amount);
  long withdraw(String accountNo,String pin,long amount) throws BalanceException;
  boolean fundTranfer(String sourceAcNo,String destAcNo,long amount,String pin) throws BalanceException;
  List<String> printTransactions(String accountNo,String pin);
  boolean validateAccountNumber(String accNo);
  boolean validateName(String name);
  boolean validateMobileNumber(String mobileNo);
  boolean validateAadharNumber(String aadharNo);
  boolean validatePin(String pin);
}
