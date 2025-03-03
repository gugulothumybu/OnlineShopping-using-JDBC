package com.shopping.exeception;

public class CustomerException extends RuntimeException 
{
	private String execeptionmsg;
	public CustomerException()
	{
		
	}
	public CustomerException(String execeptionmsg) 
	{
	
		this.execeptionmsg = execeptionmsg;
	}
	public String getExeceptionmsg() 
	{
		return execeptionmsg;
	}
	public void setExeceptionmsg(String execeptionmsg) 
	{
		this.execeptionmsg = execeptionmsg;
	}
}
