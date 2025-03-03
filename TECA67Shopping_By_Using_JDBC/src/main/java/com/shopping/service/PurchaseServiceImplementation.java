package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.DAO.OrderDAO;
import com.shopping.DAO.OrderDAOImplementation;
import com.shopping.DAO.PaymentDAO;
import com.shopping.DAO.PaymentDAOImplementation;
import com.shoppingModel.PaymentDetails;
import com.shoppingModel.ProductDetails;

public class PurchaseServiceImplementation implements PurchaseService
{
	Scanner s=new Scanner(System.in);
	OrderDAO orderDAO=new OrderDAOImplementation();
	PaymentDAO paymentDAO=new PaymentDAOImplementation();
	String paymenttype;
	@Override
	public void toPurchaseProduct(ProductDetails productDetails, int customerid) {
		
		double price=productDetails.getPrice();
		int quantity=productDetails.getQuantity();
		double discount=productDetails.getDiscount();
		double discountvalue=price*discount/100;
		double totalprice=(price-discountvalue)*quantity;
		System.out.println("Product Name :"+ productDetails.getName());
		System.out.println("Product Brand :"+ productDetails.getBrand());
		System.out.println("Product Quantity :"+ productDetails.getQuantity());
		System.out.println("Product Price :"+ productDetails.getPrice());
		System.out.println("Saved Amount :"+ quantity*discountvalue);
		System.out.println("Total Amount Should be paid :"+totalprice);
		System.out.println("Select Payment Method \n 1.By UPI \n 2.By Card \n 3.Cash On Delivery");
		switch(s.nextInt())
		{
		case 1:
			paymenttype="UPI";
		break;
		case 2:
			paymenttype="Card";
		break;
		case 3:
			paymenttype="Cash On Devivery";
		break;
		default:
			System.out.println("Invalid Payment Method");
			break;
		}
		System.out.println("Enter Amount :");
		double useramount=s.nextDouble();
		if(useramount==totalprice)
		{
			// Payment_type, Product_price, Product_id, Customer_id, Payment_date
			PaymentDetails paymentDetails=new PaymentDetails();
			paymentDetails.setPaymenttype(paymenttype);
			paymentDetails.setPrice(totalprice);
			paymentDetails.setProductid(productDetails.getId());
			paymentDetails.setCustomerid(customerid);
			paymentDetails.setPaymentdate(LocalDate.now());
			System.out.println(paymenttype);
			System.out.println("Order Placed");
			orderDAO.insertOrderDetails(productDetails.getId(),customerid);
			paymentDAO.insertpaymentDetails(paymentDetails);
			
		}
		else {
			System.out.println("Order Pending");
			
		}
	}
}
