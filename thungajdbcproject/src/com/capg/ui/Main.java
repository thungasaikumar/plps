package com.capg.ui;

import java.util.Scanner;

import com.capg.service.BankService;
import com.capg.service.BankServiceImpl;

public class Main {
	private static BankService service = new BankServiceImpl();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		String ch = "s";
		while(ch.equals("s"))
		{
			System.out.println("Please enter your choice \n\n1. Create Account\n2. Show Balance\n3. Deposit\n4. Withdraw\n5. Fund Transfer\n");
			int choice = sc.nextInt();
			switch(choice)
			{
			
			case 1 : 
				service.createAccount();
				break;
			case 2 :
				System.out.println("Enter Account Number :");
				long acno = sc.nextLong();
				System.out.println("The Account details are:\n"+service.showBal(acno));
				break;
			case 3 :
				System.out.println("Enter Account no to deposited:");
				long acno1 = sc.nextLong();
				System.out.println("Enter amount to deposite");
				double m = sc.nextDouble();
				service.deposit(acno1, m);
				break;
			case 4 :
				System.out.println("Enter Account no to  withdrawn:");
				long acno2 = sc.nextLong();
				System.out.println("Enter Amount to withdraw:");
				double m1 = sc.nextDouble();
				service.withdraw(acno2, m1);
				break;
			case 5 :
				System.out.println("Enter your Account Number:");
				long facno = sc.nextLong();
				System.out.println("Enter receiver Account Number:");
				long tacno = sc.nextLong();
				System.out.println("Enter ammount to be transfered to the receiver account:");
				long m2 = sc.nextLong();
				System.out.println(service.tranfer(facno, tacno,m2));
				break;
			default :
				System.out.println("Please enter a valid choice");
				break;
	
			}
			System.out.println("Do you want to continue the process: s or no");
			ch=sc.next();
		}
	}


}
