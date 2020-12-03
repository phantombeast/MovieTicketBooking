package com.altran.daoimpl;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.altran.dao.UserRegistration;
import com.altran.model.User;
import com.altran.serviceimpl.ConnectionDB;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserRegisterInfo.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 3:06:19 PM
Author                        :GR_Ritchie_Java_02
Description                   :login,sign up, check user duplication

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provide methods to fetch user details for login, store user
 * details into database and to check user duplication
 * 
 * @see UserRegisterInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class UserRegisterInfo implements UserRegistration {

	// logger constant
	private static Logger logger = Logger.getLogger(UserRegisterInfo.class.getName());

	// connection object reference
	Connection con = null;
	// prepared statement object reference
	PreparedStatement ps = null;

	/**
	 * 
	 * Constructor for UserRegisterInfo to initialize jdbc driver and connection
	 * object and to create user details table if it does not exists
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserRegisterInfo() throws ClassNotFoundException, SQLException {
		logger.info("*****inside UserRegisterInfo ******");
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS USERDETAILS(" + "USERNAME VARCHAR(15) PRIMARY KEY, "
				+ "FIRSTNAME VARCHAR(30) NOT NULL," + "LASTNAME VARCHAR(30)," + "EMAIL VARCHAR(30) NOT NULL,"
				+ "USERPASSWORD VARCHAR(50) NOT NULL," + "CONTACTNO LONG NOT NULL)");
		ps.executeUpdate();
	}

	/**
	 * 
	 * This method store user details into database
	 *
	 * @param user
	 *            : user object reference
	 * @return details saved or not
	 * @throws SQLException
	 */
	public int signUp(User user) throws SQLException {
		logger.info("*****inside signUp ******");
		ps = con.prepareStatement("INSERT INTO USERDETAILS VALUES(?,?,?,?,?,?)");
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getFirstName());
		ps.setString(3, user.getLastName());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getPassword());
		ps.setLong(6, user.getContactNumber());
		logger.info("*****exiting from signUp ******");
		return ps.executeUpdate();
	}

	/**
	 * 
	 * This method is used to fetch record which match the user name and password
	 *
	 * @param userName
	 *            : user name to be searched
	 * @param password
	 *            : password to be searched
	 * @return record
	 * @throws SQLException
	 */
	public ResultSet logIn(String userName, String password) throws SQLException {
		logger.info("*****inside logIn ******");
		ps = con.prepareStatement("select USERNAME from USERDETAILS where USERNAME=? AND USERPASSWORD=?");
		ps.setString(1, userName);
		ps.setString(2, password);
		logger.info("*****exiting from logIn******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method check if the user name already exists in the database or not
	 *
	 * @param userName
	 *            : user name to be checked
	 * @return user name exists or not
	 * @throws SQLException
	 */
	public boolean checkUserName(String userName) throws SQLException {
		logger.info("*****inside checkUserName ******");
		ps = con.prepareStatement("SELECT 1 FROM USERDETAILS WHERE USERNAME=?");
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		logger.info("*****exiting from checkUserName******");
		return rs.next();
	}

	/**
	 * 
	 * This method check if the email already exists in the database or not
	 *
	 * @param email
	 *            : email to be checked
	 * @return email exists or not
	 * @throws SQLException
	 */
	public boolean checkEmail(String email) throws SQLException {
		logger.info("*****inside checkEmail ******");
		ps = con.prepareStatement("SELECT 1 FROM USERDETAILS WHERE EMAIL=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		logger.info("*****exiting from checkEmail ******");
		return rs.next();
	}

	/**
	 * 
	 * This method check if the contact number already exists in the database or not
	 *
	 * @param contactNumber
	 *            : contact number to be checked
	 * @return contact number exists or not
	 * @throws SQLException
	 */
	public boolean checkContactNumber(String contactNumber) throws SQLException {
		logger.info("*****inside check ContactNumber ******");
		ps = con.prepareStatement("SELECT 1 FROM USERDETAILS WHERE CONTACTNO=?");
		ps.setString(1, contactNumber);
		ResultSet rs = ps.executeQuery();
		logger.info("*****exiting from check ContactNumber ******");
		return rs.next();
	}

	/**
	 * 
	 * This method check is user is valid or not
	 *
	 * @param email
	 *            : email to be checked
	 * @param contactNumber
	 *            : contact number to be checked
	 * @return User Record
	 * @throws SQLException
	 */
	public ResultSet checkUserValidity(String email, String contactNumber) throws SQLException {
		logger.info("*****inside check  UserValidity ******");
		ps = con.prepareStatement("select USERNAME from USERDETAILS where email=? and contactno=?");
		ps.setString(1, email);
		ps.setString(2, contactNumber);
		logger.info("*****exiting from  check UserValidity ******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method update the password of the user
	 *
	 * @param userName
	 *            : user name of user for which password is to be updated
	 * @param password
	 *            : new password
	 * @return updated or not
	 * @throws SQLException
	 */
	public int updatePassword(String userName, String password) throws SQLException {
		logger.info("*****inside updatePassword ******");
		ps = con.prepareStatement("Update USERDETAILS Set USERPASSWORD=? where USERNAME = ?");
		ps.setString(1, password);
		ps.setString(2, userName);
		logger.info("*****exiting from updatePassword ******");
		return ps.executeUpdate();
	}

	/**
	 * This method check if user name already exists or not
	 * 
	 * @param userName
	 *            : user name to check
	 * @return password record
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	public ResultSet checkUserExist(String userName) throws SQLException {
		logger.info("*****inside checkUserExist ******");
		ps = con.prepareStatement("SELECT userpassword FROM USERDETAILS WHERE USERNAME=?");
		ps.setString(1, userName);
		logger.info("*****exiting from checkUserExist ******");
		return ps.executeQuery();
	}
}
