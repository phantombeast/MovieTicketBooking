package com.altran.serviceimpl;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.altran.daoimpl.UserRegisterInfo;
import com.altran.exception.DuplicateContactException;
import com.altran.exception.DuplicateEmailException;
import com.altran.exception.DuplicateUserException;
import com.altran.exception.InvalidPasswordException;
import com.altran.model.Session;
import com.altran.model.User;
import com.altran.service.UserOperation;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserInfo.java 
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
 * This class provides methods to manage login and signup of user
 * 
 * @see UserInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class UserInfo implements UserOperation {
	// UserRegister object reference
	private UserRegisterInfo userRegister;

	// logger constant
	private static Logger logger = Logger.getLogger(UserInfo.class.getName());

	/**
	 * Constructor for UserInfo
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 *
	 */
	public UserInfo() throws ClassNotFoundException, SQLException {
		userRegister = new UserRegisterInfo();

	}

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
			String contactNumber) throws URISyntaxException, SQLException {
		logger.info("*****inside signUp******");
		// User object reference
		User user = new User();
		user.setUsername(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setContactNumber(Long.parseLong(contactNumber));
		logger.info("*****exiting from signUp******");
		return userRegister.signUp(user);
	}

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
	public int logIn(String userName, String password) throws SQLException {
		logger.info("*****inside logIn******");
		// User object reference
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equals("admin")) {
			Session.setSessionId(2);
			Session.setUserName("admin");
			return 1;
		}
		logger.info("*****exiting from Admin logIn******");
		ResultSet rs = null;
		rs = userRegister.logIn(userName, password);
		if (rs.next()) {
			Session.setSessionId(1);
			Session.setUserName(userName);
			logger.info("*****exiting from User logIn******");
			return 1;

		} else {
			Session.setSessionId(0);
			return 0;

		}

	}

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
	public String checkUserValidity(String email, String contactNumber) throws SQLException, URISyntaxException {
		logger.info("*****inside checkUserValidity******");
		ResultSet rs = userRegister.checkUserValidity(email, contactNumber);
		rs.next();
		logger.info("*****exiting from checkUserValidity******");
		return rs.getString(1);
	}

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
	public int updatePassword(String username, String password) throws SQLException {
		logger.info("*****inside updatePassword******");
		logger.info("*****exiting from updatePassword******");
		return userRegister.updatePassword(username, password);

	}

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
			throws DuplicateUserException, DuplicateEmailException, DuplicateContactException, SQLException {
		logger.info("*****inside checkUser******");
		// checking user already exist or not
		if (userRegister.checkUserName(userName)) {
			throw new DuplicateUserException("User Name Already Exists");
			// checking email already exist or not
		} else if (userRegister.checkEmail(email)) {
			throw new DuplicateEmailException("Email Id Already Exists");
			// checking contact number already exist or not
		} else if (userRegister.checkContactNumber(contactNumber))
			throw new DuplicateContactException("Contact Number Already Exists");
		logger.info("*****exiting from checkUser******");
		return true;

	}

	/**
	 * This method check if user name already exists or not
	 * 
	 * @param userName
	 *            : user name to check
	 * @return password of user
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	public String checkUserExist(String userName) throws SQLException {
		logger.info("*****inside checkUserExist******");
		ResultSet rs = userRegister.checkUserExist(userName);
		rs.next();
		logger.info("*****exiting from checkUserExist******");
		return rs.getString(1);
	}

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
			throws InvalidPasswordException, SQLException {
		logger.info("*****inside resetPassword******");
		// local variable to store password of user
		String password = null;
		password = checkUserExist(userName);
		// checking if password is equals to old password
		if (password.equals(oldPassword)) {
			// checking if new password is equals to confirm password
			if (newPassword.equals(confirmPassword)) {
				updatePassword(userName, newPassword);
				logger.info("*****exiting from resetPassword******");
				return true;
			} else
				throw new InvalidPasswordException("New Password do not match with confirm password");
		} else
			throw new InvalidPasswordException("Old Password do not match with current password");

	}
}
