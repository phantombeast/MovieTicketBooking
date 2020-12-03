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

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altran.constant.DatabaseConstants;
import com.altran.serviceimpl.TheaterInfo;

/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :TheaterInfoTest.java
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
 * @see TheaterInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 */
public class TheaterInfoTest {
	// TheaterInfo object reference
	static private TheaterInfo theaterInfo;

	/**
	 * This method initializes theaterInfo object refernce
	 */
	@BeforeClass
	public static void setUp() {
		try {
			theaterInfo = new TheaterInfo();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for add Theater
	 */
	@Test
	public void testAddTheater() {
		try {
			assertEquals(1, theaterInfo.addTheater("test", "Gaur City", "Mall", "Noida", "UP", 7867566L, 50));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for get Theater
	 */
	@Test
	public void testGetTheater() {
		try {
			assertNotNull(theaterInfo.getTheater());
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for deleteTheater
	 */
	@Test
	public void testDeleteTheater() {
		try {
			assertNotNull(theaterInfo.deleteTheater("9999"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for updateTheater
	 */
	@Test
	public void testUpdateTheater() {
		try {
			assertNotNull(theaterInfo.updateTheater("9999", "PVR", "Gaur City", "Mall", "Noida", "UP", 7867566L, 700L));
		} catch (SQLException | URISyntaxException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getTheaterList
	 */
	@Test
	public void testGetTheaterList() {
		try {
			assertNotNull(theaterInfo.getTheaterList("3", "2020-02-28"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for getTheaterIndividual
	 */
	@Test
	public void testGetTheaterIndividual() {
		try {
			assertNotNull(theaterInfo.getTheaterIndividual("1"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * This method initializes theaterInfo object to null and delete added details
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@AfterClass
	public static void tearDown() throws SQLException, ClassNotFoundException {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM THEATERDETAILS WHERE THEATERNAME=?");
		ps.setString(1, "test");
		ps.executeUpdate();
		theaterInfo = null;
		ps.close();
		con.close();
	}
}
