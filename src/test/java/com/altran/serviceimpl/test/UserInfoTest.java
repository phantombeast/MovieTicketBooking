/**
 * 
 */
package com.altran.serviceimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.altran.constant.DatabaseConstants;
import com.altran.exception.DuplicateContactException;
import com.altran.exception.DuplicateEmailException;
import com.altran.exception.DuplicateUserException;
import com.altran.exception.InvalidPasswordException;
import com.altran.serviceimpl.UserInfo;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :UserInfoTest.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 24, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of Company class.
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 24, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of Company class.
 * 
 * @see UserInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class UserInfoTest {
	// user info object reference
	private UserInfo userInfo;

	/**
	 * This class initializes user info object reference
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		userInfo = new UserInfo();
	}

	/**
	 * Test method for sign up
	 */
	@Test
	public void testSignUp() {
		try {
			assertEquals(1,
					userInfo.signUp("Krati1", "Krati", "Gupta", "Krati123@gmail.com", "Krati123@", "8967564534"));
		} catch (URISyntaxException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for admin login
	 */
	@Test
	public void testAdminLogin() {
		try {
			assertEquals(1, userInfo.logIn("admin", "admin"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for UserLogin
	 */
	@Test
	public void testSuccessUserLogin() {
		try {
			assertEquals(1, userInfo.logIn("Gaurav123", "Gaur12@"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for UserLogin
	 */
	@Test
	public void testFailureUserLogin() {
		try {
			assertEquals(0, userInfo.logIn("Monib123", "Rupa123@"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for checkUserLogin
	 */
	@Test
	public void testCheckUserValidity() {
		try {
			assertEquals("krati123", userInfo.checkUserValidity("krati123@gmail.com", "7835892348"));
		} catch (SQLException | URISyntaxException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for resetPassword
	 */
	@Test
	public void testSuccessResetPassword() {
		try {
			assertEquals(true, userInfo.resetPassword("krati123", "kRATI1@", "abc123", "abc123"));
			assertEquals(true, userInfo.resetPassword("krati123", "monib123", "monib123", "monib123"));
		} catch (InvalidPasswordException | SQLException e) {
			assertNotNull(e);
		}
		try {
			assertEquals(true, userInfo.resetPassword("krati123", "abc123", "monib123", "monib12"));
		} catch (InvalidPasswordException | SQLException e) {
			assertNotNull(e);
		}

	}

	/**
	 * Test method for update password
	 */
	@Test
	public void testUpdatePassword() {
		try {
			assertEquals(1, userInfo.updatePassword("krati123", "kRATI1@"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for isDuplicateUserName
	 */
	@Test
	public void testIsDuplicateUserName() {
		try {
			assertEquals(true, userInfo.checkUser("monib123", "Rupa123@", "8000000000"));
		} catch (DuplicateUserException | DuplicateEmailException | DuplicateContactException | SQLException e) {
			assertNotNull(e);
		}

	}

	/**
	 * Test method for isDuplicateEmail
	 */
	@Test
	public void testIsDuplicateEmail() {
		try {
			assertEquals(true, userInfo.checkUser("Rupa123", "monib@gmail.com", "8000000000"));
		} catch (DuplicateUserException | DuplicateEmailException | DuplicateContactException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for isDuplicateContactNumber
	 */
	@Test
	public void testIsDuplicateContactNumber() {
		try {
			assertEquals(true, userInfo.checkUser("Rupa123", "Rupa123@", "7835892348"));
		} catch (DuplicateUserException | DuplicateEmailException | DuplicateContactException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for checkUserExist
	 */
	@Test
	public void testCheckUserExist() {
		try {
			assertEquals("kRATI1@", userInfo.checkUserExist("krati123"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for checkUser
	 */
	@Test
	public void testCheckUser() {
		try {
			assertEquals(true, userInfo.checkUser("abc", "abc@gmail.com", "9999999999"));
			assertEquals(true, userInfo.checkUser("krati123", "abc@gmail.com", "9999999999"));
		} catch (DuplicateUserException | DuplicateEmailException | DuplicateContactException | SQLException e) {
			assertNotNull(e);
		}
		try {
			assertEquals(true, userInfo.checkUser("abc", "Krati123@gmail.com", "9999999999"));
		} catch (DuplicateUserException | DuplicateEmailException | DuplicateContactException | SQLException e) {
			assertNotNull(e);
		}
		try {
			assertEquals(true, userInfo.checkUser("abc", "abc@gmail.com", "8000000000"));
		} catch (DuplicateUserException | DuplicateEmailException | DuplicateContactException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * This method initializes userInfo to null and delete added data
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@After
	public void tearDown() throws SQLException, ClassNotFoundException {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM USERDETAILS WHERE USERNAME=?");
		ps.setString(1, "Krati1");
		ps.executeUpdate();
		userInfo = null;
		ps.close();
		con.close();
	}
}
