package com.shoppingModel;

public class ProductDetails 
{
	private int id;
	private String name;
	private String category;
	private String brand;
	private int quantity;
	private double price;
	private double discount;
	public ProductDetails(int id,String name, String category, String brand, int quantity, double price, double discount) {
		this.id=id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", category=" + category + ", brand=" + brand
				+ ", quantity=" + quantity + ", price=" + price + ", discount=" + discount + "]";
	}
	
}
	
