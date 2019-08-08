
  package com.capg.model;

public class Bank {
	
	
	private String aname;
	private long anum;
	private double bal;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public long getAnum() {
		return anum;
	}
	public void setAnum(long anum) {
		this.anum = anum;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public Bank(String aname, long anum, double bal) {
		super();
		this.aname = aname;
		this.anum = anum;
		this.bal = bal;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [aname=" + aname + ", anum=" + anum + ", bal=" + bal + "]";
	}
	
	

}
