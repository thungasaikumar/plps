package com.capg.service;

import com.capg.model.Bank;

public interface BankService {

	Bank createAccount();

	String showBal(long acnum);

	void deposit(long acn, double m);

	void withdraw(long acno2, double m1);

	double tranfer(long facno, long tacno, long m2);

}
