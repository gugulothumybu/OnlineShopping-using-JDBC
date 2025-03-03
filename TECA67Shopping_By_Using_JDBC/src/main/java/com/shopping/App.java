package com.shopping;
import java.util.Scanner;

import com.shopping.DAO.AdminDAO;
import com.shopping.DAO.ProductDAO;
import com.shopping.DAO.ProductDAOImplementation;
import com.shopping.service.AdminService;
import com.shopping.service.AdminServiceImplementation;
import com.shopping.service.CustomerService;
import com.shopping.service.CustomerServiceImplimentation;
import com.shopping.service.ProductService;
import com.shopping.service.ProductServiceImplementation;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args)
	{
		CustomerService customerService = new CustomerServiceImplimentation();
		AdminService adminService=new AdminServiceImplementation();
		ProductService productService=new ProductServiceImplementation();
		ProductDAO productDAO=new ProductDAOImplementation();
		Scanner scan = new Scanner(System.in);
		while (true) 
		{
			customerService.tosleep("***--Welcome to TECA67Shopping---***");
			System.out.println("\n Enter \n1. For Customer Registration \n2. For Customer Login \n3. For Admin Login");
			switch (scan.nextInt()) 
			{
			case 1:
				customerService.tosleep("***---Customer Registration ---***");
				customerService.customerRegistration();
				break;
			case 2:
				customerService.tosleep("***---Customer Login ---***");
				customerService.customerLogin();
				break;
			case 3:
				customerService.tosleep("***---Admin Login ---***");
				adminService.adminLogin();
				break;
			default:
				System.out.println("Invalid option! Please try again.");
			}
			System.out.print("\nDo you want to Continue...???  \n YES \n NO ");
			String status = scan.next();
			if (status.equalsIgnoreCase("no"))
			{
				System.out.println("****----Thank YOU visit again***----");
				break;
			}	 
		}
	}
}
