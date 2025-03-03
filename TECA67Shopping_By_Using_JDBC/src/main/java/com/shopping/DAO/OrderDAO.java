package com.shopping.DAO;

import java.util.List;

import com.shoppingModel.CartDetails;
import com.shoppingModel.OrderDetails;

//import com.shoppingModel.OrderDetails;

public interface OrderDAO 
{
	void insertOrderDetails(int productid,int customerid);
	List<OrderDetails> getAllOrderDetails();
}
