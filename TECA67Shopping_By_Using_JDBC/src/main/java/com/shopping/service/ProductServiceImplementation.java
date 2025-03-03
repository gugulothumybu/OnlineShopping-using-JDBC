package com.shopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shopping.DAO.ProductDAO;
import com.shopping.DAO.ProductDAOImplementation;
import com.shoppingModel.ProductDetails;

public class ProductServiceImplementation implements ProductService {
	ProductDAO ProductDAO = new ProductDAOImplementation();
	Scanner s = new Scanner(System.in);

	@Override
	public void addProductDetails() {
		List<ProductDetails> li = new ArrayList<ProductDetails>();
		System.out.println("Enter the Product Brand");
		String brand = s.next();
		System.out.println("Enter No Of Products Are Added Related To " + brand + "Brand");
		int num = s.nextInt();
		for (int i = 0; i < num; i++) {
			ProductDetails productDetails = new ProductDetails();
			String count[] = { "First", "Second", "Third", "Fourth" };
			System.out.println("Enter " + count[i] + "Product Details");
			System.out.println("Enter the Product name");
			String name = s.next();
			productDetails.setName(name);
			System.out.println("Enter the Product Category");
			String category = s.next();
			productDetails.setCategory(category);
			System.out.println("Enter the Product Quantity");
			int quantity = s.nextInt();
			productDetails.setQuantity(quantity);
			System.out.println("Enter the Product Price");
			double price = s.nextDouble();
			productDetails.setPrice(price);
			System.out.println("Enter the Product Discount");
			double discount = s.nextDouble();
			productDetails.setDiscount(discount);
			productDetails.setBrand(brand);
			li.add(productDetails);
		}
		ProductDAO.insertproductDetails(li);
		System.out.println(li);
	}
	
}
