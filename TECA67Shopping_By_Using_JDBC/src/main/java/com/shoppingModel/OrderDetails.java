package com.shoppingModel;

public class OrderDetails 
{
	private int id;
	private int productid;
	private int customerid;
	public OrderDetails()
	{
		
	}
	public OrderDetails(int id, int productid, int customerid) {
		this.id = id;
		this.productid = productid;
		this.customerid = customerid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", productid=" + productid + ", customerid=" + customerid + "]";
	}
	

}
