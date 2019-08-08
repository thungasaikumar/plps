package com.capg.dao;

import com.capg.model.Bank;

public interface BankDao {

	Bank create(Bank b);

	String show(long acnum);

	void deposit1(long acn, double m);

	void withdraw1(long acno2, double m1);

	double transfer1(long facno, long tacno, long m2);

}
