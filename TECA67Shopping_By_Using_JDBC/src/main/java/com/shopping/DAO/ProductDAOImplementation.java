package com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingModel.CustomerDetails;
import com.shoppingModel.ProductDetails;

public class ProductDAOImplementation implements ProductDAO {
	private static final String url = "jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=12345";

	private static final String insert_product_details = "insert into product_details ( Product_name, Product_brand, Product_category,"
			+ " Product_quantity, Product_price, Product_discount)values(?,?,?,?,?,?)";
	private static final String select_all_product_details = "select * from product_details";

	@Override
	public void insertproductDetails(List<ProductDetails> list) {
		int result = 0;
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insert_product_details);
			for (ProductDetails productDetails : list) {
				preparedStatement.setString(1, productDetails.getName());
				preparedStatement.setString(2, productDetails.getBrand());
				preparedStatement.setString(3, productDetails.getCategory());
				preparedStatement.setInt(4, productDetails.getQuantity());
				preparedStatement.setDouble(5, productDetails.getPrice());
				preparedStatement.setDouble(6, productDetails.getDiscount());
				result = preparedStatement.executeUpdate();
			}
			if (result > 0) {
				System.out.println("Product Details Inserted");
			} else {
				System.out.println("Data not inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<ProductDetails> getAllProductDetails() {
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(select_all_product_details);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<ProductDetails> list = new ArrayList<ProductDetails>();
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					ProductDetails productDetails = new ProductDetails();
					productDetails.setId(resultSet.getInt("Product_id"));
					productDetails.setName(resultSet.getString("Product_name"));
					productDetails.setBrand(resultSet.getString("product_brand"));
					productDetails.setCategory(resultSet.getString("product_category"));
					productDetails.setQuantity(resultSet.getInt("product_quantity"));
					productDetails.setPrice(resultSet.getDouble("product_price"));
					productDetails.setDiscount(resultSet.getInt("product_discount"));
					list.add(productDetails);
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
