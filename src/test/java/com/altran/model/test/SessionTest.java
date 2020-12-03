package com.altran.model.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.altran.model.Session;

/**
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :SessionTest.java 
Principal Author			  :GUR57580
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 25, 2020 6:27:15 PM
Author                        :GUR57580
Description                   :

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 25, 2020
Modified by                   :GUR57580
Description of change         :Initial Version

***********************************************************************/
/**
 * This class
 * 
 * @see SessionTest
 * @version 1.0
 * @author GUR57580
 * @since Feb 25, 2020
 */
public class SessionTest {
	Session session;

	/**
	 * This method initializes session and test setters
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		session = new Session();
		Session.setUserName("abc");
		Session.setSessionId(1);
	}

	/**
	 * This method set Session values to null
	 *
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Session.setUserName(null);
		Session.setSessionId(0);
	}

	/**
	 * Test method for {@link com.altran.model.Session#getSessionId()}.
	 */
	@Test
	public void testGetSessionId() {
		assertEquals("abc", Session.getUserName());
	}

	/**
	 * Test method for {@link com.altran.model.Session#getUserName()}.
	 */
	@Test
	public void testGetUserName() {
		assertEquals(1, Session.getSessionId());
	}
}
