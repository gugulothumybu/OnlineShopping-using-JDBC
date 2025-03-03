package com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingModel.CartDetails;
import com.shoppingModel.OrderDetails;
import com.shoppingModel.ProductDetails;

public class OrderDAOImplementation implements OrderDAO {
	private static final String insert_order_details = "insert into order_details  ( Customer_id, Product_id)values(?,?)";
	private static final String url = "jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=12345";
	private static final String select_all_order_details = "select * from order_details";


	@Override
	public void insertOrderDetails(int productid,int customerid) {
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insert_order_details);
			preparedStatement.setInt(1,customerid);
			preparedStatement.setInt(2,productid);
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println("Order Placed");
			}
			else {
				System.out.println("Order Not Placed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() 
	{
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(select_all_order_details);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<OrderDetails> list = new ArrayList<OrderDetails>();
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					OrderDetails orderDetails = new OrderDetails();
					orderDetails.setId(resultSet.getInt("order_id"));
					orderDetails.setCustomerid(resultSet.getInt("Customer_id"));
					orderDetails.setProductid(resultSet.getInt("Product_id"));
					list.add(orderDetails);
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
