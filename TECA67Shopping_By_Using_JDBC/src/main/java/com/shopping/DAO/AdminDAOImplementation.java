package com.shopping.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImplementation implements AdminDAO 
{
  private static final String admin_login=" select * from admin_details where admin_emailid=? and admin_password=?";
  private static final String url="jdbc:mysql://localhost:3306/teca_67_advance_java?user=root&password=12345";
	@Override
	public void selectAdminDetailsByUsingEmailIdAndPassword(String emailid,String password) 
	{
		try 
		{
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(admin_login);
			preparedStatement.setString(1, emailid);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Login Sucessfull...");
			}
			else 
			{
				System.out.println("Invalid emailid An Password");
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}	
}
