package com.shoppingModel;

public class CartDetails 
{
	private int id;
	private int customerid;
	private int productid;
	
	public CartDetails()
	{
		
	}

	public CartDetails(int id, int customerid, int productid) {
		this.id = id;
		this.customerid = customerid;
		this.productid = productid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "CartDetails [id=" + id + ", customerid=" + customerid + ", productid=" + productid + "]";
	}
	

}
