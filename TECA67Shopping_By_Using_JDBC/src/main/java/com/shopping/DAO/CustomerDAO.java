package com.shopping.DAO;

import java.util.List;

import com.shoppingModel.CustomerDetails;

public interface CustomerDAO 
{
	void insertCustomerDetails(CustomerDetails customerDetails);
	List<CustomerDetails> getAllCustomerDetails();
	CustomerDetails selectCustomerDetaulsByUsingEmailidAndPassword(String emailid,String password);	
}
