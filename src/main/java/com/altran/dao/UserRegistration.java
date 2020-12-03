package com.altran.dao;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.altran.model.User;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserRegistration.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 4:03:26 PM
Author                        :GR_Ritchie_Java_02
Description                   :login,sign up, check user duplication

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provides method to login,sign up, check user duplication
 * 
 * @see UserRegistration
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
public interface UserRegistration {

	/**
	 * 
	 * This method store user details into database
	 *
	 * @param user
	 *            : user object reference
	 * @return details saved or not
	 * @throws SQLException
	 */
	public int signUp(User user) throws SQLException;

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
	public ResultSet logIn(String userName, String password) throws SQLException;

	/**
	 * 
	 * This method check if the user name already exists in the database or not
	 *
	 * @param userName
	 *            : user name to be checked
	 * @return user name exists or not
	 * @throws SQLException
	 */
	public boolean checkUserName(String userName) throws SQLException;

	/**
	 * 
	 * This method check if the email already exists in the database or not
	 *
	 * @param email
	 *            : email to be checked
	 * @return email exists or not
	 * @throws SQLException
	 */
	public boolean checkEmail(String email) throws SQLException;

	/**
	 * 
	 * This method check if the contact number already exists in the database or not
	 *
	 * @param contactNumber
	 *            : contact number to be checked
	 * @return contact number exists or not
	 * @throws SQLException
	 */
	public boolean checkContactNumber(String contactNumber) throws SQLException;

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
	public ResultSet checkUserValidity(String email, String contactNumber) throws SQLException;

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
	public int updatePassword(String userName, String password) throws SQLException;

	/**
	 * This method check if user name already exists or not
	 * 
	 * @param userName
	 *            : user name to check
	 * @return password record
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	public ResultSet checkUserExist(String userName) throws SQLException;
}
