package com.capg.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capg.exception.BalanceException;
import com.capg.service.BankService;
import com.capg.service.BankServiceImpl;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		BankService bankservice=new BankServiceImpl();
		String acNo,name,mobileNo,aadharNo,pin;
		int choice;
		long accountBalance;
		String i;
		do
		{
		  System.out.println("Enter your choice\n1.Create Account\n2.Show Balance\n3.Deposit\n4.Withdraw\n5.Fund Transfer\n6.Print Transactions");
		  choice=sc.nextInt();
		  switch(choice)
		  {
		   case 1:System.out.println("Enter Account no");
		          acNo=sc.next();
		          if(bankservice.validateAccountNumber(acNo))
		          {
		           System.out.println("Enter account Name");
		           name=sc.next();
		           if(bankservice.validateName(name))
		           {
		            System.out.println("Enter Mobolie no");
		            mobileNo=sc.next();
		            if(bankservice.validateMobileNumber(mobileNo))
			        {
		             System.out.println("Enter Aadhar ");
		             aadharNo=sc.next();
		             if(bankservice.validateAadharNumber(aadharNo))
		             {
		              System.out.println("Set pin");
		              pin=sc.next();
		              if(bankservice.validatePin(pin))
		              {
		               boolean created=bankservice.createAccount(acNo, name, mobileNo, aadharNo, pin);
		               if(created)
		        	    System.out.println("Account created successfully");
		               else
		        	    System.out.println("Account failed to create");
		              }
		             }
		            }
		           }
		          }
			      break;
		   case 2:System.out.println("Enter Account Number");
	              acNo=sc.next();
	              if(bankservice.validateAccountNumber(acNo))
	              {
	               System.out.println("Enter pin");
	               pin=sc.next();
	               if(bankservice.validatePin(pin))
	               {   
	                accountBalance=bankservice.showBalance(acNo, pin);
	                if(accountBalance>=0)
	            	  System.out.println("Account Balance :"+accountBalance);
	                else
	            	   System.out.println("Something went wrong");
	               }
	              }
			      break;
		   case 3:System.out.println("Enter Account Number");
		          acNo=sc.next();
		          if(bankservice.validateAccountNumber(acNo))
		          {
		           System.out.println("Enter Amount to Deposit");
		           long damount=sc.nextLong();
		           accountBalance=bankservice.deposit(acNo, damount);
		           if(accountBalance>=0)
		           {
	                System.out.println(" Deposited Successfully");  
		            System.out.println("Account Balance:"+accountBalance);
		           }
		           else
		           {
	            	 System.out.println("invalid account number");
	            	 System.out.println("Something went wrong");
		           }
		          }
			      break;
		   case 4:System.out.println("Enter Account Number");
		          acNo=sc.next();
		          if(bankservice.validateAccountNumber(acNo))
		          {
		           System.out.println("Enter Pin");
		           pin=sc.next();
		           if(bankservice.validatePin(pin))
		           {
		            System.out.println("Enter Amount to withdraw");
		            long wamount=sc.nextLong();
			        try {
				     accountBalance=bankservice.withdraw(acNo,pin,wamount);
				     if(accountBalance>=0)
		             {
		        	  System.out.println(" Withdrawn Successfully");
          	          System.out.println("Account  Balance :"+accountBalance);
                     }
				     else
                     {
          	          System.out.println("Withdraw Failed");
          	          System.out.println("Something went wrong");
                     }
			        } catch (BalanceException e) {
			         System.err.println("Insufficient account balance");	
			         e.printStackTrace();
				     
			        }
		           }
		          }
			      break;
		   case 5:System.out.println("Enter fuser Account Number");
		          String sacNo=sc.next();
		          if(bankservice.validateAccountNumber(sacNo))
		          {
		           System.out.println("Enter pin");
		           pin=sc.next();
		           if(bankservice.validatePin(pin))
		           {
		            System.out.println("Enter tuser Account Number");
		            String dacNo=sc.next();
		            System.out.println("Enter amount to transfer");
		            long tamount=sc.nextLong();
			        boolean transfered;
			        try {
				     transfered = bankservice.fundTranfer(sacNo, dacNo, tamount,pin);
				    if(transfered)
			         System.out.println("Amount Transfered Successfully");
			        else
			        {
			         System.out.println("Transfered Failed");
			         System.out.println("Went Wrong");
			        }
			       } catch (BalanceException e) {
					 System.err.println(" Insufficient Money");
					 e.printStackTrace();
			       }
		          }
			      }
			      break;
		   case 6:System.out.println("Enter Account Number");
		          acNo=sc.next();
		          if(bankservice.validateAccountNumber(acNo))
		          {
		           System.out.println("Enter Pin");
		           pin=sc.next();
		           if(bankservice.validatePin(pin))
		           {
			        List<String> transList=bankservice.printTransactions(acNo,pin);
			        if(transList.size()>0)
			        {
			         System.out.println("Transaction  For The Account Number:"+acNo);
			         System.out.println("Date       Time     Process   Balance    RemainingBalance");
			         Iterator<String> it=transList.iterator();
			         while(it.hasNext())
			         {
		              System.out.println(it.next());
			         }
			         System.out.println("");
			        }
			        else
			        	System.out.println("No Transactions done..");
		           }
		          }
			      break;
		   default:System.out.println("Please Enter a Valid Choice");
		  }
		  System.out.println("Do you want to continue : yes or no");
		  i=sc.next();
		}while(i.equalsIgnoreCase("yes"));
	}
}
