package com.capg.service;

import java.util.List;

import com.capg.dao.BankDao;
import com.capg.dao.BankDaoImpl;
import com.capg.exception.BalanceException;
import com.capg.model.BankAccount;

public class BankServiceImpl implements BankService {

	BankDao bankdao=new BankDaoImpl();
	@Override
	public boolean createAccount(String accountNo, String name, String mobileNo, String aadharNo,
			String pin) {
		BankAccount a=new BankAccount(accountNo, name, mobileNo, aadharNo,10000, pin);
				return bankdao.saveAccount(a);
	}

	@Override
	public long showBalance(String accountNo, String pin) {
		return bankdao.viewBalance(accountNo, pin);
	}

	@Override
	public long deposit(String accountNo, long amount) {
		
		return bankdao.depositCash(accountNo, amount);
	}

	@Override
	public long withdraw(String accountNo, String pin,long amount) throws BalanceException {
	 
		return bankdao.withdrawCash(accountNo, pin, amount);
	}

	@Override
	public boolean fundTranfer(String sourceAcNo, String destAcNo, long amount,String pin) throws BalanceException {
		return bankdao.tranferMoney(sourceAcNo, destAcNo, amount,pin);
	}

	@Override
	public List<String> printTransactions(String accountNo,String pin) {
		return bankdao.showTransactions(accountNo,pin);
	}
	@Override
	public boolean validateAccountNumber(String accNo)
	{
		if(accNo.matches("[1-9][0-9]{3}"))
			return true;
		System.err.println("Please Enter Valid 4 Digit Account Number");
		return false;
	}
	@Override
	public boolean validatePin(String pin)
	{
		if(pin.matches("[0-9]{4}"))
			return true;
		System.err.println("Please Enter Valid 4 Digit Pin");
		return false;
	}
	@Override
    public boolean validateName(String name)
    {
    	if(name.matches("[A-Z][a-z]*"))
    		return true;
    	System.err.println("Please Enter Valid Name");
		return false;
    }
	@Override
    public boolean validateMobileNumber(String moNo)
    {
    	if(moNo.matches("[9|8|7|6][0-9]{9}"))
    		return true;
    	System.err.println("Please Enter Valid Mobile Number");
		return false;
    }
	@Override
    public boolean validateAadharNumber(String aaNo)
    {
    	if(aaNo.matches("[0-9]{4}"))
    		return true;
    	System.err.println("Please Enter Valid Aadhar Number");
    	return false;
    }
}
