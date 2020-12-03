package com.altran.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import com.altran.constant.DatabaseConstants;

/**
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :ConnectionDB.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 2:29:22 PM
Author                        :GR_Ritchie_Java_02
Description                   :Create and return connection object

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class Create and return connection object
 * 
 * @see ConnectionDB
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */

public class ConnectionDB implements DatabaseConstants {
	// Connection object reference
	private static Connection connection = null;

	// logger constant
	private static Logger logger = Logger.getLogger(ConnectionDB.class.getName());

	/**
	 * private constructor to restrict object creation
	 */
	private ConnectionDB() {

	}

	/**
	 * This method returns the connection object
	 * 
	 * @return connection object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		logger.info("*****inside getConnection******");
		// If connection is null create new connection
		if (connection == null) {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
			PreparedStatement ps = connection.prepareStatement("CREATE DATABASE  IF NOT EXISTS TEST");
			ps.executeUpdate();
			connection.close();
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		logger.info("*****exiting from getConnection******");

		return connection;
	}
}
