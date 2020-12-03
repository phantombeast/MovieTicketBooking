package com.altran.controller;

import java.net.URI;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.altran.exception.DuplicateContactException;
import com.altran.exception.DuplicateEmailException;
import com.altran.exception.DuplicateUserException;
import com.altran.exception.InvalidPasswordException;
import com.altran.model.Session;
import com.altran.serviceimpl.UserInfo;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserController.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 2:50:25 PM
Author                        :GR_Ritchie_Java_02
Description                   :sign up,login,change password

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provide methods to sign up,login,change password
 * 
 * @see UserController
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
@Path("/register")
public class UserController {
	// logger constant
	private static Logger logger = Logger.getLogger(UserController.class.getName());
	// user info object reference
	UserInfo userInfo;

	/**
	 * 
	 * Constructor for UserController to initialize userInfo object reference
	 *
	 */
	public UserController() {
		try {
			userInfo = new UserInfo();
		} catch (ClassNotFoundException | SQLException e) {
			logger.warning(e.getMessage());
		}
	}

	/**
	 * 
	 * This method allow a user to sign up
	 *
	 * @param userName
	 *            : user Name of user
	 * @param firstName
	 *            : first Name of user
	 * @param lastName
	 *            : last Name of user
	 * @param email
	 *            : email of user
	 * @param password
	 *            : password of user
	 * @param contactNumber
	 *            : contact number of user
	 * @return details added or not
	 * @throws URISyntaxException
	 */
	@Path("/signUp")
	@POST
	public Response signUp(@FormParam("userName") String userName, @FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("contactNumber") String contactNumber)
			throws URISyntaxException {
		try {
			logger.info("****inside sign up controller****");
			// checking user details are unique or not
			if (userInfo.checkUser(userName, email, contactNumber)) {
				logger.info("****user details are unique****");
				userInfo.signUp(userName, firstName, lastName, email, password, contactNumber);
				Session.setSessionId(1);
				Session.setUserName(userName);
				logger.info("****sign up successful****");
			}
		} catch (SQLException e) {
			logger.warning(e.getMessage());
			return Response
					.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/duplicateuser.jsp?message=0"))
					.build();
		} catch (DuplicateUserException e) {
			logger.warning(e.getMessage());
			return Response
					.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/duplicateuser.jsp?message=1"))
					.build();
		} catch (DuplicateEmailException e) {
			logger.warning(e.getMessage());
			return Response
					.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/duplicateuser.jsp?message=2"))
					.build();
		} catch (DuplicateContactException e) {
			logger.warning(e.getMessage());
			return Response
					.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/duplicateuser.jsp?message=3"))
					.build();
		}
		logger.info("****exiting sign up****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/signupsuccess.jsp")).build();
	}

	/**
	 * 
	 * This method allows user to login
	 *
	 * @param userName
	 *            : user Name of user
	 * @param password
	 *            : password of user
	 * @return login successful or not
	 * @throws URISyntaxException
	 */
	@Path("/logIn")
	@POST
	public Response logIn(@FormParam("userName") String userName, @FormParam("password") String password)
			throws URISyntaxException {
		try {
			logger.info("****inside login controller****");
			// checking login is successful or not
			if (userInfo.logIn(userName, password) == 1)
				logger.info("****log in successful****");
			else
				logger.info("****theater unsuccessful****");
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting login controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/logincheck.jsp")).build();

	}

	/**
	 * 
	 * This method allows user to reset password
	 *
	 * @param email
	 *            : email of user
	 * @param contactNumber
	 *            : contact number of user
	 * @return password updated or not
	 * @throws URISyntaxException
	 */
	@Path("/resetPassword")
	@POST
	public Response resetPassword(@FormParam("email") String email, @FormParam("contactNumber") String contactNumber)
			throws URISyntaxException {
		// local variable to store user name
		logger.info("****inside reset controller****");
		String userName = null;
		try {
			// fetching user name is user is valid
			userName = userInfo.checkUserValidity(email, contactNumber);
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
		if (userName != null) {
			logger.info("****user is valid****");
			logger.info("****exiting reset controller****");
			return Response
					.seeOther(new URI(
							"http://localhost:8080/MovieTicketBooking/jsp/ResetPassword.jsp?username=" + userName))
					.build();
		} else {
			logger.info("****user is not valid****");
			logger.info("****exiting reset controller****");
			return Response
					.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/forgotPassword.jsp?message=1"))
					.build();
		}
	}

	/**
	 * 
	 * This method allows user to update password
	 *
	 * @param username
	 *            : user name of user
	 * @param password
	 *            : password of user
	 * @return password updated or not
	 * @throws URISyntaxException
	 */
	@Path("/updatePassword")
	@POST
	public Response updatePassword(@FormParam("userName") String username, @FormParam("password") String password)
			throws URISyntaxException {
		try {
			logger.info("****inside update password controller****");
			// checking is password is updated or not
			if (userInfo.updatePassword(username, password) == 1) {
				logger.info("****password updated successfully****");
			} else
				logger.info("****password can not be updated****");
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting update password controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/passwordupdated.jsp")).build();
	}

	/**
	 * 
	 * This method change password
	 *
	 * @param userName
	 *            : userName to check
	 * @param oldPassword
	 *            : oldPassword to check
	 * @param newPassword
	 *            : new Password to set
	 * @param confirmPassword
	 *            : confirmPassword to match
	 * @return password changed or not
	 * @throws URISyntaxException
	 */
	@Path("/changepassword")
	@POST
	public Response changePassword(@FormParam("userName") String userName, @FormParam("oldPassword") String oldPassword,
			@FormParam("newPassword") String newPassword, @FormParam("confirmPassword") String confirmPassword)
			throws URISyntaxException {
		try {
			logger.info("****inside change password  controller****");
			// checking password is reset or not
			if (userInfo.resetPassword(userName, oldPassword, newPassword, confirmPassword)) {
				logger.info("****password updated****");
				return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/passwordupdated.jsp"))
						.build();
			}
		} catch (InvalidPasswordException | SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting change password controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/changeunsuccessful.jsp"))
				.build();
	}
}
