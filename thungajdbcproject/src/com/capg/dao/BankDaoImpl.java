package com.capg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.Dbutil.BankDbUtil;
import com.capg.model.Bank;

public class BankDaoImpl implements BankDao {

	private Connection con;
	@Override
	public Bank create(Bank b) {
		con = BankDbUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into thunga values(?,?,?)");
			ps.setLong(1, b.getAnum());
			ps.setString(2, b.getAname());
			ps.setDouble(3, b.getBal());
			int i = ps.executeUpdate();
			if(i>0)
				System.out.println("Acoount created Successfully!!!!");
		}
		catch(SQLException e1)
		{
			System.err.println("Something went wrong");
			e1.printStackTrace();
		}
		return null;
		
	}

	@Override
	public String show(long acnum) {
		
		con = BankDbUtil.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		Bank b=new Bank();
		try {
			ps = con.prepareStatement("select money from thunga where acno = ?");
			ps.setLong(1, acnum);
			rs = ps.executeQuery();
			while(rs.next())
			{
				try {
				return Long.toString(rs.getLong(1));
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}
		catch(SQLException e1)
		{
			System.out.println("No such Account Number");
			e1.printStackTrace();
		}	
		return Double.toString(b.getBal());
	
	}

	@Override
	public void deposit1(long acn, double m) {
		double accBal;
		con = BankDbUtil.getConnection();
		PreparedStatement ps;
		try {
			 ps = con.prepareStatement("select money from thunga where acno = ?");
			ps.setLong(1, acn);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				accBal = rs.getDouble(1);
					ps = con.prepareStatement("update thunga set money = ? where acno = ?");
					ps.setDouble(1, accBal+m);
					ps.setLong(2, acn);
					int i = ps.executeUpdate();
					if(i>0)
					{
						System.out.println("The Balance is: "+(accBal+m));
					}				
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void withdraw1(long acno2, double m1) {
		double accBal;
		con = BankDbUtil.getConnection();
		PreparedStatement ps;
		try {
			 ps = con.prepareStatement("select money from thunga where acno = ?");
			ps.setLong(1, acno2);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				accBal = rs.getDouble(1);
				if(accBal>=m1)
				{
					ps = con.prepareStatement("update thunga set money = ? where acno = ?");
					ps.setDouble(1, accBal-m1);
					ps.setLong(2, acno2);
					int i = ps.executeUpdate();
					if(i>0)
					{
						System.out.println("The Balance is: "+(accBal-m1));
					}
				}
				
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public double transfer1(long facno, long tacno, long m2) {
		double accBal;
		con = BankDbUtil.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select money from thunga where acno = ?");
			ps.setLong(1, facno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				accBal = rs.getDouble(1);
				if(accBal >= m2)
				{
					ps = con.prepareStatement("update thunga set money = ? where acno = ?");
					ps.setDouble(1, accBal-m2);
					ps.setLong(2, facno);
					int i = ps.executeUpdate();
					if(i>0)
					{
						return accBal-m2;
					}
				}
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
