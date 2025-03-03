package com.shopping.DAO;

import java.util.List;

import com.shoppingModel.CustomerDetails;
import com.shoppingModel.ProductDetails;

public interface ProductDAO 
{
	void insertproductDetails(List<ProductDetails>list);
	List<ProductDetails> getAllProductDetails();
}
