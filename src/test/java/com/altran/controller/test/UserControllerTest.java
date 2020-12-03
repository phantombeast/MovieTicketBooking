package com.altran.controller.test;

import static org.junit.Assert.assertEquals;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altran.constant.DatabaseConstants;
import com.altran.controller.UserController;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserControllerTest.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 4:31:32 PM
Author                        :GR_Ritchie_Java_02
Description                   :Test methods of UserController

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class Test methods of UserController
 * 
 * @see UserControllerTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
public class UserControllerTest {
	// user controller object reference
	private static UserController userController;

	/**
	 * This class initializes the userController object reference
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		userController = new UserController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM USERDETAILS WHERE USERNAME=?");
		ps.setString(1, "monib123");
		ps.executeUpdate();
		userController = null;
		ps.close();
		con.close();
	}

	/**
	 * Test method for
	 * {@link com.altran.controller.UserController#signUp(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testSignUp() {
		Response response = null;

		try {

			response = userController.signUp("monib123", "Pulkit", "Rajpal", "pulkit123456@gmail.com", "Movie123",
					"7503204641");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		try {
			response = userController.signUp("abcde123", "Pulkit", "Rajpal", "monib@gmail.com", "Movie123",
					"7503204641");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		try {
			response = userController.signUp("moni123", "Pulkit", "Rajpal", "pulkit123456@gmail.com", "Movie123",
					"7835892348");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		try {
			response = userController.signUp("abcd444abcd444abcd444abcd444", "Pulkit", "Rajpal", "aaa@gmail.com",
					"Movie123", "7654392829");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		try {
			response = userController.signUp("abc123", "Pulkit", "Rajpal", "abcde6@gmail.com", "Movie123",
					"7503204640");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}

		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * Test method for
	 * {@link com.altran.controller.UserController#logIn(java.lang.String, java.lang.String)}.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testLogIn() {
		Response response = null;
		try {
			response = userController.logIn("Gaurav123", "Gaur12@");
			response = userController.logIn("Gaurav123", "Gaur123@");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * Test method for
	 * {@link com.altran.controller.UserController#checkUserValidity(java.lang.String, java.lang.String)}.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testResetPassword() {
		Response response = null;
		try {
			response = userController.resetPassword("mishragaurav921@gmail.com", "9690927128");
			response = userController.resetPassword("monibsssasa@gmail.com", "7835892343");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * Test method for
	 * {@link com.altran.controller.UserController#updatePassword(java.lang.String, java.lang.String)}.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testUpdatePassword() {
		Response response = null;
		try {
			response = userController.updatePassword("Gaurav123", "Gaur12@");
			response = userController.updatePassword("Gaurav1235678", "Gaur12@");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * Test method for
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testChangePassword() {
		Response response = null;
		try {
			response = userController.changePassword("Gaurav123", "Gaur12@", "Gaur12@", "Gaur12@");
			response = userController.changePassword("monib123", "abc123", "abcd", "abcd");
		} catch (URISyntaxException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}
}
