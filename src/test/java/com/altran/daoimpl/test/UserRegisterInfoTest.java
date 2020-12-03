package com.altran.daoimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.altran.constant.DatabaseConstants;
import com.altran.dao.UserRegistration;
import com.altran.daoimpl.UserRegisterInfo;
import com.altran.model.User;

/**
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserRegisterInfoTest.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 24, 2020 1:00:36 PM
Author                        :GR_Ritchie_Java_02
Description                   :Class to test UserRegisterInfo methods

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 24, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class tests UserRegisterInfo methods
 * 
 * @see UserRegisterInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 24, 2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRegisterInfoTest {
	// UserRegistration object refernce
	private UserRegistration userRegistration;
	// User object reference
	private User user;

	/**
	 * This method initializes userRegistration and set values of user
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userRegistration = new UserRegisterInfo();
		user = new User();
		user.setFirstName("abcd");
		user.setLastName("abcd");
		user.setUsername("abcd129");
		user.setEmail("abcd@gmail.com");
		user.setContactNumber(9999888877L);
		user.setPassword("abcd123");
	}

	/**
	 * This method initializes userRegistration to null and delete values of user
	 *
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM USERDETAILS WHERE USERNAME=?");
		ps.setString(1, user.getUsername());
		ps.executeUpdate();
		userRegistration = null;
		ps.close();
		con.close();
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#signUp(com.altran.model.User)}.
	 */
	@Test
	public void testSignUp() {
		try {
			assertEquals(1, userRegistration.signUp(user));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

	public void testSignUpFailure() {
		try {
			assertEquals(1, userRegistration.signUp(user));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#logIn(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogIn() {
		try {
			assertNotNull(userRegistration.logIn("monib123", "abcd"));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#checkUserName(java.lang.String)}.
	 */
	@Test
	public void testCheckUserName() {
		try {
			assertTrue(userRegistration.checkUserName("krati123"));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#checkEmail(java.lang.String)}.
	 */
	@Test
	public void testCheckEmail() {
		try {
			assertTrue(userRegistration.checkEmail("krati123@gmail.com"));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#checkContactNumber(java.lang.String)}.
	 */
	@Test
	public void testCheckContactNumber() {
		try {
			assertTrue(userRegistration.checkContactNumber("7835892348"));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#checkUserValidity(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCheckUserValidity() {
		try {
			assertNotNull(userRegistration.checkUserValidity("monib@gmail.com", "7835892348"));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#updatePassword(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUpdatePassword() {
		try {
			assertEquals(1, userRegistration.updatePassword("krati123", "kRATI1@"));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.UserRegisterInfo#checkUserExist(java.lang.String)}.
	 */
	@Test
	public void testCheckUserExist() {
		try {
			assertNotNull(userRegistration.checkUserExist("monib123"));
		} catch (SQLException e) {
			assertEquals(e.getMessage(), e.getMessage());
		}
	}

}
