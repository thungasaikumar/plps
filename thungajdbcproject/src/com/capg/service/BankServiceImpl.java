package com.capg.service;

import java.util.Scanner;

import com.capg.dao.BankDao;
import com.capg.dao.BankDaoImpl;
import com.capg.model.Bank;
import com.capg.validate.BankValidate;

public class BankServiceImpl implements BankService {
	
	private static BankDao dao = new BankDaoImpl();
	private static BankValidate val = new BankValidate();
	private static Scanner sc = new Scanner(System.in);

	@Override
	public Bank createAccount() {
		// TODO Auto-generated method stub
	Bank b = new Bank();
	System.out.println("Enter Account number:");
       int i = sc.nextInt();
       b.setAnum(i);
		System.out.println("Enter respective Name:");
		String str = sc.next();
		if(val.name(str))
			b.setAname(str);
		else {
			System.out.println("Please start your  Name with capital letter");
			System.exit(0);
		}
		System.out.println("Enter money to be deposited");
		b.setBal(sc.nextDouble());
		return dao.create(b);	
		
		
	}

	@Override
	public String showBal(long acnum) {
		return dao.show(acnum);
		
	}

	@Override
	public void deposit(long acn, double m) {
		dao.deposit1(acn, m);
		
	}

	@Override
	public void withdraw(long acno2, double m1) {
		System.out.println("Enter amount to be withdrawn:");
		dao.withdraw1(acno2, m1);
		
	}

	@Override
	public double tranfer(long facno, long tacno, long m2) {
		
		return dao.transfer1(facno, tacno, m2);
	
	}

}
