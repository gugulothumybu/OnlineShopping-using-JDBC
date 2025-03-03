package com.shopping.service;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.shopping.DAO.CartDAO;
import com.shopping.DAO.CartDAOImplementation;
import com.shopping.DAO.CustomerDAO;
import com.shopping.DAO.CustomerDAOImplementation;
import com.shopping.DAO.OrderDAO;
import com.shopping.DAO.OrderDAOImplementation;
import com.shopping.DAO.ProductDAO;
import com.shopping.DAO.ProductDAOImplementation;
import com.shopping.exeception.CustomerException;
import com.shoppingModel.CartDetails;
import com.shoppingModel.CustomerDetails;
import com.shoppingModel.OrderDetails;
import com.shoppingModel.ProductDetails;

public class CustomerServiceImplimentation implements CustomerService {
	Scanner s = new Scanner(System.in);
	CustomerDAO customerDAO = new CustomerDAOImplementation();
	ProductDAO productDAO = new ProductDAOImplementation();
	PurchaseService purchaseService=new PurchaseServiceImplementation();
	OrderDAO orderDAO=new OrderDAOImplementation();
	CustomerDetails customerDetails = new CustomerDetails();
	CartDAO cartDAO=new CartDAOImplementation();
	@Override
	public void customerRegistration() {
		List<CustomerDetails> allCustomerDetails = customerDAO.getAllCustomerDetails();

		System.out.println("Enter the Customer Name");
		String name = s.next();
		customerDetails.setName(name);

		boolean status = true;
		while (status) {
			System.out.println("Enter the Customer Emailid");
			String emailid = s.next();
			int emailidcount = 0;
			try {
				for (CustomerDetails customerDetails2 : allCustomerDetails) {
					if (customerDetails2.getEmailid().equals(emailid)) {
						emailidcount++;
					}
				}
				if (emailidcount > 0) {
					throw new CustomerException("Email id Already existed");
				} else {
					customerDetails.setEmailid(emailid);
					status = false;
				}
			} catch (CustomerException e) {
				System.out.println(e.getExeceptionmsg());

			}
		}
		boolean status1 = true;
		while (status1) {
			System.out.println("Enter the Customer Mobile number");
			long mobilenumber = s.nextLong();
			int mobileNumberCount = 0;
			try {
				for (CustomerDetails customerDetails2 : allCustomerDetails) {
					if (customerDetails2.getMobileNumber() == mobilenumber) {
						mobileNumberCount++;
					}
				}
				if (mobileNumberCount > 0) {
					throw new CustomerException("MobileNumber Already existed");
				} else {
					customerDetails.setMobileNumber(mobilenumber);
					status1 = false;
				}
			} catch (CustomerException e) {
				System.out.println(e.getExeceptionmsg());

			}
		}
		boolean status2 = true;
		while (status2) {
			System.out.println("Enter the Customer Password");
			String password = s.next();
			int passwordcount = 0;
			try {
				for (CustomerDetails customerDetails2 : allCustomerDetails) {
					if (customerDetails2.getPassword().equals(password)) {
						passwordcount++;
					}
				}
				if (passwordcount > 0) {
					throw new CustomerException("Password Already existed");
				} else {
					customerDetails.setPassword(password);
					status2 = false;
				}
			} catch (CustomerException e) {
				System.out.println(e.getExeceptionmsg());

			}
		}
		System.out.println("Enter the Customer Gender");
		String gender = s.next();
		customerDetails.setGender(gender);
		System.out.println("Enter the Customer Adress");
		String adress = s.next();
		customerDetails.setAdress(adress);
		System.out.println("Enter the Customer Date Of Birth");
		String dob = s.next();
		customerDetails.setDob(Date.valueOf(dob));

		customerDAO.insertCustomerDetails(customerDetails);
	}

	@Override
	public void tosleep(String value) {
		for (int i = 0; i < value.length(); i++) {
			System.out.print(value.charAt(i));
			try {
				Thread.sleep(100); // Sleep after printing each character
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	@Override
	public void customerLogin() {
		Random random = new Random();
		String captcha = "";
		String a[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
				"T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
				"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
				"9" };
		while (true) {
			for (int i = 0; i < 6; i++) {
				int index = random.nextInt(a.length);
				String cap = a[index];
				captcha = captcha + cap;
			}
			System.out.println("Enter Customer EmailId");
			String emailid = s.next();
			System.out.println("Enter Customer Password");
			String password = s.next();
			CustomerDetails loginuserDetails = customerDAO.selectCustomerDetaulsByUsingEmailidAndPassword(emailid,
					password);
			if (loginuserDetails != null) {
				System.out.println("Enter Below capcha");
				System.out.println(captcha);
				String usercap = s.next();
				if (usercap.equals(captcha)) {
					if (loginuserDetails.getGender().equalsIgnoreCase("Male")) {
						System.out.println("Hello Mr :" + loginuserDetails.getName());
						customerFunctionalities(loginuserDetails);
					}
					if (loginuserDetails.getGender().equalsIgnoreCase("Female")) {
						System.out.println("Hello Miss :"+loginuserDetails.getName());
						customerFunctionalities(loginuserDetails);
					}
				} else 
				{
					System.out.println("Invalid Captcha");
				}
			} else {
				System.out.println("Invalid EmailId and Password");
			}
		}
	}

	@Override
	public void customerFunctionalities(CustomerDetails loginuserDetails) {
		boolean status = true;
		while (status) {
			System.out.println(
					"Enter \n 1.To get All Product Details \n 2.To get All Cart Details \n 3. To get All Order Details");
			switch (s.nextInt()) {
			case 1:
			
				tosleep("****----All Product Details-------****");
				List<ProductDetails> allProductDetails = productDAO.getAllProductDetails();

				for (ProductDetails productDetails : allProductDetails) {
					int no = allProductDetails.indexOf(productDetails) + 1;
					System.out.println("S.No: " + no);
					System.out.println("Product Name :" + productDetails.getName());
					System.out.println("Product Brand :" + productDetails.getBrand());
					System.out.println("Product Category :" + productDetails.getCategory());
					System.out.println("Product Price :" + productDetails.getPrice());
					System.out.println("Product Discount :" + productDetails.getDiscount());
					int quantity = productDetails.getQuantity();
					if (quantity <= 5) {
						System.out.println("Product Quantity :" + quantity);
					}
				}
				System.out.println("******-------------*********");
				System.out.println("Enter S.No To select the Product");
				int sno = s.nextInt();
				ProductDetails selectedProduct = allProductDetails.get(sno - 1);
				System.out.println("Enter Quantity to be Purchased");
				int quantity = s.nextInt();
				if (quantity < selectedProduct.getQuantity()) {
					System.out.println(selectedProduct);
					System.out.println("Enter \n 1.To Add To Cart \n 2.To Purchase");
					switch (s.nextInt()) {
					case 1:
						System.out.println("Add To Cart");
                          cartDAO.insertCartDetails(loginuserDetails.getId(),selectedProduct.getId());
						break;
					case 2:
						System.out.println("To Purchase");
						purchaseService.toPurchaseProduct(selectedProduct,loginuserDetails.getId());
						break;
					default:
						break;
					}
				} else {
					System.out.println("Insufficient Quantity");
				}
				break;
			case 2:
				tosleep("*****----All Cart Details-------****");
				List<CartDetails> allCartDetails = cartDAO.getAllCartDetails();
				for (CartDetails cartDetails : allCartDetails) {
					System.out.println("Cart id :"+cartDetails.getId());
					System.out.println("Customer id :" +cartDetails.getCustomerid());
					System.out.println("Product id :" +cartDetails.getProductid());
				}
				break;
			case 3:
				tosleep("***-------All OrderDetails-------****");
				List<OrderDetails> allOrderDetails = orderDAO.getAllOrderDetails();
				for (OrderDetails orderDetails : allOrderDetails) {
					System.out.println("Cart id :"+orderDetails.getId());
					System.out.println("Customer id :" +orderDetails.getCustomerid());
					System.out.println("Product id :" +orderDetails.getProductid());
				}

				break;
			}
			System.out.println("Do you want to continue...???\n Yes \n No");
			if (s.next().equalsIgnoreCase("yes")) {

			} else {
				status = false;
			}
		}
	}
}
