package com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shoppingModel.CustomerDetails;

public class CustomerDAOImplementation implements CustomerDAO
{
	private static final String url="jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=12345";
	private static final String insert_customer_details=" insert into customer_details( Customer_Name, Customer_Emailid, Customer_Password, "
			+ "Customer_Mobile_Number, "
			+ "Customer_Gender, Customer_Address, Customer_Date_Of_Birth) values (?,?,?,?,?,?,?)";
	private static final  String select_all="select * from customer_details";
	private static final String user_login="select * from customer_details where Customer_Emailid=? and Customer_Password=?";
	@Override
	public void insertCustomerDetails(CustomerDetails customerDetails) 
	{
		try
		{
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert_customer_details);
			preparedStatement.setString(1,customerDetails.getName());
			preparedStatement.setString(2,customerDetails.getEmailid());
			preparedStatement.setString(3,customerDetails.getPassword());
			preparedStatement.setLong(4,customerDetails.getMobileNumber());
			preparedStatement.setString(5,customerDetails.getGender());
			preparedStatement.setString(6,customerDetails.getAdress());
			preparedStatement.setDate(7,customerDetails.getDob());
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				System.out.println("Registration successful");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public List<CustomerDetails> getAllCustomerDetails() 
	{
		try 
		{
			Connection con=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=con.prepareStatement(select_all);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<CustomerDetails> list=new ArrayList<CustomerDetails>();
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					CustomerDetails customerDetails=new CustomerDetails();
//				    customerDetails.setId(resultSet.getInt("Customer_id"));
//     				customerDetails.setId(resultSet.getInt("product_id"));
					customerDetails.setName(resultSet.getString("Customer_Name"));
					customerDetails.setEmailid(resultSet.getString("Customer_Emailid"));
					customerDetails.setMobileNumber(resultSet.getLong("Customer_Mobile_Number"));
					customerDetails.setPassword(resultSet.getString("Customer_Password"));
					list.add(customerDetails);
				}
				return list;
			}
			else
			{
				return null;
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public CustomerDetails selectCustomerDetaulsByUsingEmailidAndPassword(String emailid, String password) 
	{
		try 
		{
			Connection con=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=con.prepareStatement(user_login);
			preparedStatement.setString(1,emailid);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				CustomerDetails customerDetails=new CustomerDetails();
				customerDetails.setId(resultSet.getInt("customer_id"));
				customerDetails.setName(resultSet.getString("Customer_Name"));
				customerDetails.setGender(resultSet.getString("Customer_Gender"));
				return customerDetails;
			}
			else {
				return null;
			}
//			else
//			{
//				System.out.println("Invalid EmailId and password");
//			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return null;	
	}
}
