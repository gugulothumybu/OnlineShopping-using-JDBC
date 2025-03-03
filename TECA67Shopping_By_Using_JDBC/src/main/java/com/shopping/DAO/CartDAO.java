package com.shopping.DAO;

import java.util.List;

import com.shoppingModel.CartDetails;

public interface CartDAO {
	void insertCartDetails(int customerid,int productid);
	List<CartDetails> getAllCartDetails();

}
