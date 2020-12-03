package com.altran.model.test;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.altran.model.User;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :UserTest.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 24, 2020
Author                     :GR_Ritchie_Java_02
Description                :Test Class to test all methods of User
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 24, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/
/**
 * Test Class to test all getters and setters of User
 * 
 * @see UserTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class UserTest {
	// User object reference
	private User user;

	/**
	 * This method initializes user object reference and test setters
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setUsername("JohnDavid123");
		user.setFirstName("John");
		user.setLastName("David");
		user.setEmail("john56@gamil.com");
		user.setPassword("Djohn123#");
		user.setContactNumber(8965742235l);
	}

	/**
	 * This method test getter methods
	 */
	@Test
	public void testUserGetters() {
		assertEquals("JohnDavid123", user.getUsername());
		assertEquals("John", user.getFirstName());
		assertEquals("David", user.getLastName());
		assertEquals("john56@gamil.com", user.getEmail());
		assertEquals("Djohn123#", user.getPassword());
		assertEquals(8965742235l, user.getContactNumber(), 1);
	}

	/**
	 * This method initializes user object to null
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		user = null;
	}

}
