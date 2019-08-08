package com.capg.dao;

import java.util.List;

import com.capg.exception.BalanceException;
import com.capg.model.BankAccount;

public interface BankDao 
{
	  boolean saveAccount(BankAccount a);
	  long viewBalance(String accountNo,String pin);
	  long depositCash(String accountNo,long amount);
	  long withdrawCash(String accountNo,String pin,long amount) throws BalanceException;
	  boolean tranferMoney(String sourceAcNo,String destAcNo,long amount,String pin) throws BalanceException;
	  List<String> showTransactions(String accountNo,String pin);
}
