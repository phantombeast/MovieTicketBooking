package com.altran.service;

import java.net.URISyntaxException;
import java.sql.SQLException;

import com.altran.exception.DuplicateContactException;
import com.altran.exception.DuplicateEmailException;
import com.altran.exception.DuplicateUserException;
import com.altran.exception.InvalidPasswordException;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserOperation.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 12:08:09 PM
Author                        :GR_Ritchie_Java_02
Description                   :Manage login and signup of user

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This interface provides methods to manage login and signup of user
 * 
 * @see UserOperation
 * @version 1.0
 * @since Feb 19, 2020
 */
public interface UserOperation {
	/**
	 * 
	 * This method register a user
	 *
	 * @param userName
	 *            : user name to be registered
	 * @param firstName
	 *            : first name to be saved
	 * @param lastName
	 *            : last name to be saved
	 * @param email
	 *            : email to be saved
	 * @param password
	 *            : password to be saved
	 * @param contactNumber
	 *            : contact number to be saved
	 * @return sign up successful or not
	 * @throws URISyntaxException
	 * @throws SQLException
	 */
	public int signUp(String userName, String firstName, String lastName, String email, String password,
			String contactNumber) throws URISyntaxException, SQLException;

	/**
	 * 
	 * This method allows login for a user through username and password
	 *
	 * @param userName
	 *            : user name to be used
	 * @param password
	 *            : password to be used
	 * @return login successful or not
	 * @throws SQLException
	 */
	public int logIn(String userName, String password) throws SQLException;

	/**
	 * 
	 * This method checks if a user is valid or not
	 *
	 * @param email
	 *            : email to be matched
	 * @param contactNumber
	 *            : contact number to be matched
	 * @return : user is valid or not
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	public String checkUserValidity(String email, String contactNumber) throws SQLException, URISyntaxException;

	/**
	 * 
	 * This method update the password of user
	 *
	 * @param username
	 *            : password of user to be changed
	 * @param password
	 *            : new password to be matched
	 * @return password updated or not
	 * @throws SQLException
	 */
	public int updatePassword(String username, String password) throws SQLException;

	/**
	 * 
	 * This method checks if user already exists or not
	 *
	 * @param userName
	 *            : user name to be be checked
	 * @param email
	 *            : email to be checked
	 * @param contactNumber
	 *            : contact number to be checked
	 * @return user already exists or not
	 * @throws DuplicateUserException
	 * @throws DuplicateEmailException
	 * @throws DuplicateContactException
	 * @throws SQLException
	 */
	public boolean checkUser(String userName, String email, String contactNumber)
			throws DuplicateUserException, DuplicateEmailException, DuplicateContactException, SQLException;

	/**
	 * This method check if user name already exists or not
	 * 
	 * @param userName
	 *            : user name to check
	 * @return password of user
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	public String checkUserExist(String userName) throws SQLException, URISyntaxException;

	/**
	 * This method change the password of user
	 * 
	 * @param userName
	 *            : user name of user
	 * @param oldPassword
	 *            : old password of user
	 * @param newPassword
	 *            : new password of user
	 * @param confirmPassword
	 *            : confirm password of user
	 * @return password changed or not
	 * @throws URISyntaxException
	 * @throws InvalidPasswordException
	 * @throws SQLException
	 */
	public boolean resetPassword(String userName, String oldPassword, String newPassword, String confirmPassword)
			throws URISyntaxException, InvalidPasswordException, SQLException;
}
