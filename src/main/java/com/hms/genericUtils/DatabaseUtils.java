package com.hms.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class DatabaseUtils {
	Connection con = null;
	/**
	 * to connect to the database 
	 * @author Dev
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DBUserName, IpathConstants.DBPassword);
	}
	/**
	 * to execute the query 
	 * @author Dev
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @throws SQLException
	 */
	public void executeAndGetData(String query,int colIndex, String expData) throws SQLException 
	{
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actualData = result.getString(colIndex);
			if(actualData.equalsIgnoreCase(actualData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
			{
				System.out.println("--- data is present---");
			}
		else
			{
				System.out.println("--- data is not present---");
			}
	}
	/**
	 * to update or store the data into database
	 * @author Dev
	 * @param query
	 * @throws SQLException
	 */
	public void updateData(String query) throws SQLException 
	{
		Statement state = con.createStatement();
		int result = state.executeUpdate(query);
	}
	/**
	 * to close the connection of database 
	 * @throws SQLException
	 */
	public void disconnectDB() throws SQLException
	{
		con.close();
	}

}
