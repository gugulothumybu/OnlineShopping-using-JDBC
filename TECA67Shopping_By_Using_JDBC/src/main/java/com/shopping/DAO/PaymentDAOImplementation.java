package com.shopping.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shoppingModel.PaymentDetails;

public class PaymentDAOImplementation implements PaymentDAO
{
	private static final String insert = "insert into payment_details(Payment_type, Product_price, Product_id, Customer_id, Payment_date)values(?,?,?,?,?)";
	private static final String url = "jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=12345";

	@Override
	public void insertpaymentDetails(PaymentDetails paymentDetails) 
	{
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setString(1,paymentDetails.getPaymenttype());
			preparedStatement.setDouble(2,paymentDetails.getPrice());
			preparedStatement.setInt(3,paymentDetails.getProductid());
			preparedStatement.setInt(4, paymentDetails.getCustomerid());
			preparedStatement.setDate(5, Date.valueOf(paymentDetails.getPaymentdate()));
			     int result =preparedStatement.executeUpdate();
			     if(result>0) {
			    	 System.out.println("Payment Placed");
			     }
			     else {
			    	 System.out.println("Payment not Placed");
			     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
