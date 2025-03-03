package com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingModel.CartDetails;
import com.shoppingModel.ProductDetails;

public class CartDAOImplementation implements CartDAO {
	private static final String insert = "insert into cart_details( customer_id, product_id)values(?,?)";
	private static final String url = "jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=12345";
	private static final String select_all_cart_details = "select * from cart_details";


	@Override
	public void insertCartDetails(int customerid, int productid) {

		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setInt(1, customerid);
			preparedStatement.setInt(2, productid);
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				System.out.println("Details are added to cart");
			}
			else {
				System.out.println("Invalid Cart  Details");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<CartDetails> getAllCartDetails() 
	{
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(select_all_cart_details);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<CartDetails> list = new ArrayList<CartDetails>();
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					CartDetails cartDetails = new CartDetails();
					cartDetails.setId(resultSet.getInt("cart_id"));
					cartDetails.setCustomerid(resultSet.getInt("customer_id"));
					cartDetails.setProductid(resultSet.getInt("product_id"));
					list.add(cartDetails);
				}
				return list;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
}
