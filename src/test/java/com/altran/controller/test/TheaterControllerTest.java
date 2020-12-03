package com.altran.controller.test;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.altran.constant.DatabaseConstants;
import com.altran.controller.TheaterController;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :TheaterControllerTest.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 4:22:54 PM
Author                        :GR_Ritchie_Java_02
Description                   :Test Theater Controller methods

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class test theater controller methods
 * 
 * @see TheaterControllerTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
public class TheaterControllerTest {
	// logger constant
	private static Logger logger = Logger.getLogger(TheaterControllerTest.class.getName());
	// Theater object reference
	private static TheaterController theaterController;

	/**
	 * This class initializes theater controller object reference
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		theaterController = new TheaterController();
	}

	/**
	 * This class initializes theater controller object reference to null and delete
	 * the value added
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		theaterController = null;
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM THEATERDETAILS WHERE THEATERNAME = ?");
		ps.setString(1, "TEST");
		ps.executeUpdate();
		ps.close();
		con.close();
	}

	/**
	 * Test method for
	 * {@link com.altran.controller.TheaterController#addTheater(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testAddTheater() {

		Response response = null;
		try {
			response = theaterController.addTheater("TEST", "Pacific Mall", "Subhash Nagar", "New Delhi", "Delhi",
					"110027", 48);
			response = theaterController.addTheater("TEST", "Pacific Mall", "Subhash Nagar", "New Delhi", "Delhi",
					"110027", 48);
			response = theaterController.addTheater("PVR GoldPVR GoldPVR GoldPVR Gold", "Pacific Mall", "Subhash Nagar",
					"New Delhi", "Delhi", "110027", 48);
		} catch (URISyntaxException e) {

			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * Test method for
	 * {@link com.altran.controller.TheaterController#deleteTheater(java.lang.String)}.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testDeleteTheater() {
		Response response = null;
		try {
			response = theaterController.deleteTheater("9999");
			response = theaterController.deleteTheater("ss");
		} catch (URISyntaxException e) {

			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

	/**
	 * Test method for
	 * {@link com.altran.controller.TheaterController#updateTheater(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long)}.
	 * 
	 * @throws URISyntaxException
	 */
	@Test
	public void testUpdateTheater() {
		Response response = null;
		try {
			response = theaterController.updateTheater("9999", "PVR Vegas", " Vegas Mall, 3rd floor", "Dwarka",
					"New Delhi", "Delhi", 110078L, 56L);
			response = theaterController.updateTheater("ss", "PVR Vegas", " Vegas Mall, 3rd floor", "Dwarka",
					"New Delhi", "Delhi", 110078L, 56L);
		} catch (URISyntaxException e) {

			logger.warning(e.getMessage());
		}
		assertEquals(Response.Status.SEE_OTHER.getStatusCode(), response.getStatus());
	}

}
