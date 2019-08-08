package com.capg.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.capg.exception.BalanceException;
import com.capg.model.BankAccount;

public class BankDaoImpl implements BankDao 
{
	
	static List<BankAccount> li=new ArrayList();
	static
	{
		BankAccount a1=new BankAccount("9876", "Thunga", "9177506437", "9857",40000,"9881");
		BankAccount a2=new BankAccount("9831", "Giri", "9705503491", "3658",30000 ,"9771");
		BankAccount a3=new BankAccount("1234", "saikuamr", "9647356781", "9374",20000,"9661");
		li.add(a1);
		li.add(a2);
		li.add(a3);
	}
	public String dateAndTime()
	{
		DateFormat dt=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d=new Date();
		return dt.format(d);
	}
	@Override
	public boolean saveAccount(BankAccount a) 
	{
		return li.add(a);
	}

	@Override
	public long viewBalance(String accountNo, String pin) 
	{
		Iterator<BankAccount> itr=li.iterator();
		BankAccount a=null;
		String acNo;
		long acBal;
		while(itr.hasNext())
		{
			a=itr.next();
			if(a.getAccountNo().contentEquals(accountNo) && a.getPin().contentEquals(pin))
			{
				return a.getAccountBalance();
			}
		}
		return -1;
	}

	@Override
	public long depositCash(String accountNo,long amount) {
		Iterator<BankAccount> itr=li.iterator();
		while(itr.hasNext())
		{
			BankAccount a=itr.next();
			if(a.getAccountNo().equals(accountNo))
			{
				a.setAccountBalance(a.getAccountBalance()+amount);
				a.tl.add(dateAndTime()+" Deposit      "+amount+"       "+a.getAccountBalance());
				return a.getAccountBalance();
			}
		}
		
		return -1;
	}

	@Override
	public long withdrawCash(String accountNo, String pin,long amount) throws BalanceException {
		Iterator<BankAccount> itr=li.iterator();
		while(itr.hasNext())
		{
			BankAccount a=itr.next();
			if(a.getAccountNo().equals(accountNo) && a.getPin().equals(pin))
			{
				if(a.getAccountBalance()>=amount)
				{
				  a.setAccountBalance(a.getAccountBalance()-amount);
				  a.tl.add(dateAndTime()+" Withdraw     "+amount+"       "+a.getAccountBalance());
				  return a.getAccountBalance();
				}
				else throw new BalanceException("Insufficient Balance");
			}
		}
		return -1;
	}

	@Override
	public boolean tranferMoney(String sourceAcNo, String destAcNo, long amount,String pin) throws BalanceException {
		Iterator<BankAccount> itr=li.iterator();
		while(itr.hasNext())
		{
			BankAccount a=itr.next();
			if(a.getAccountNo().equals(sourceAcNo) && a.getPin().equals(pin))
			{
				if(a.getAccountBalance()>=amount)
				{
				 a.setAccountBalance(a.getAccountBalance()-amount);
				 a.tl.add(dateAndTime()+" Transfer      "+amount+"       "+a.getAccountBalance());
				 return true;
				}
				else throw new BalanceException("Insufficient Balance");
					
			}
 		}
		return false;
	}

	@Override
	public List<String> showTransactions(String accountNo,String pin) 
	{
		BankAccount a=null;
		Iterator<BankAccount> itr=li.iterator();
		while(itr.hasNext())
		{
			a=itr.next();
			if(a.getAccountNo().equals(accountNo) && a.getPin().equals(pin))
				break;
			
		}
		return a.tl;
	}
}
