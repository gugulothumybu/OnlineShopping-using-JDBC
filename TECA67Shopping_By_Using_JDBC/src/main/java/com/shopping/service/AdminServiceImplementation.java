package com.shopping.service;

import java.util.Scanner;

import com.shopping.DAO.AdminDAO;
import com.shopping.DAO.AdminDAOImplementation;
import com.shopping.DAO.ProductDAO;
import com.shopping.DAO.ProductDAOImplementation;

public class AdminServiceImplementation implements AdminService 
{
   Scanner s=new Scanner(System.in);
   AdminDAO adminDAO=new AdminDAOImplementation();
   ProductService productService=new ProductServiceImplementation();
   ProductDAO productDAO=new ProductDAOImplementation();
	@Override
	public void adminLogin() 
	{
	System.out.println("Enter Admin Emailid");
	String emailid=s.next();
	System.out.println("Enter Admin Password");
	String password=s.next();
	adminDAO.selectAdminDetailsByUsingEmailIdAndPassword(emailid, password);
	adminFunctionalities();
	}
	@Override
	public void tosleep(String value)
	{
	    for(int i = 0; i < value.length(); i++) 
	    {
	        System.out.print(value.charAt(i));
	        try {
	            Thread.sleep(200); // Sleep after printing each character
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    System.out.println();
	}
	@Override
	public void adminFunctionalities() 
	{
		boolean status =true;
		while(status)
		{
			System.out.println("Enter \n 1. To Add Product Details \n 2. To Get All User Details");
			switch(s.nextInt())
			{
			case 1:
				tosleep("****---- Add product details -----****");
				productService.addProductDetails();
				break;
			case 2:
				tosleep("*****----Get all user Details -----**** \n");
				System.out.println(productDAO.getAllProductDetails());
				break;
			}
			System.out.println("Do you want to continue...??\n Yes \n No");
			if(s.next().equalsIgnoreCase("yes"))
			{
				
			}else 
			{
				System.out.println("***-----Thank you -----***");
				status=false;
			}	
		}	
	}
}
