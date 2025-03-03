package com.shoppingModel;

import java.sql.Date;

public class CustomerDetails 
{
	private int id;
	private String name;
	private String emailid;
	private String adress;
	private String password;
	private Date dob;
	private long mobileNumber;
	private String gender;
	
	public CustomerDetails()
	{
		
	}
	public CustomerDetails( int id,String name, String emailid, String adress, String password, Date dob, long mobileNumber,
			String gender) 
	{
		this.id=id;
		this.name = name;
		this.emailid = emailid;
		this.adress = adress;
		this.password = password;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobilenumber) {
		this.mobileNumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", name=" + name + ", emailid=" + emailid + ", adress=" + adress
				+ ", password=" + password + ", dob=" + dob + ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ "]";
	}
	
}
