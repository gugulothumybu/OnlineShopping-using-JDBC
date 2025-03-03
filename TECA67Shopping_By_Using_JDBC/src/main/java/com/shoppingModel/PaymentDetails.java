package com.shoppingModel;

import java.time.LocalDate;

public class PaymentDetails 
{
	private int id;
	private String paymenttype;
	private double price;
	private int productid;
	private int customerid;
	private LocalDate paymentdate;
	
	public PaymentDetails()
	{
		
	}
	public PaymentDetails(int id, String paymenttype, double price, int productid, int customerid,
			LocalDate paymentdate) {
		this.id = id;
		this.paymenttype = paymenttype;
		this.price = price;
		this.productid = productid;
		this.customerid = customerid;
		this.paymentdate = paymentdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public LocalDate getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(LocalDate paymentdate) {
		this.paymentdate = paymentdate;
	}
	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", paymenttype=" + paymenttype + ", price=" + price + ", productid="
				+ productid + ", customerid=" + customerid + ", paymentdate=" + paymentdate + "]";
	}
	
}
