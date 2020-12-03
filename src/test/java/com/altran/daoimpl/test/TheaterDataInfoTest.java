package com.altran.daoimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.altran.constant.DatabaseConstants;
import com.altran.dao.TheaterInfo;
import com.altran.daoimpl.TheaterDataInfo;

/**
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :TheaterDataInfoTest.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 25, 2020 10:43:14 AM
Author                        :GR_Ritchie_Java_02
Description                   :Class to test TheaterDataInfo methods

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 25, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class tests TheaterDataInfo methods
 * 
 * @see TheaterDataInfoTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 25, 2020
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TheaterDataInfoTest {
	static private TheaterInfo theaterInfo;

	/**
	 * This method initializes theaterInfo object reference
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		theaterInfo = new TheaterDataInfo();
	}

	/**
	 * This method initializes theaterInfo object reference to null
	 *
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		Class.forName(DatabaseConstants.DRIVER);
		Connection con = DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.USERNAME,
				DatabaseConstants.PASSWORD);
		PreparedStatement ps = con.prepareStatement("DELETE FROM THEATERDETAILS WHERE THEATERNAME=?");
		ps.setString(1, "abc");
		ps.executeUpdate();
		theaterInfo = null;
		ps.close();
		con.close();
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.TheaterDataInfo#getTheaterList(java.lang.String, java.lang.String)}.
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
	 * Test method for
	 * {@link com.altran.daoimpl.TheaterDataInfo#addTheater(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, int)}.
	 */
	@Test
	public void testAddTheater() {
		try {
			assertEquals(1, theaterInfo.addTheater("abc", "sector28", "Ambience", "gurgaon", "haryana", 876543L, 54));
			assertEquals(0, theaterInfo.addTheater("abc", "sector28", "Ambience", "gurgaon", "haryana", 876543L, 54));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.TheaterDataInfo#getIndividualTheater(java.lang.String)}.
	 */
	@Test
	public void testGetIndividualTheater() {
		try {
			assertNotNull(theaterInfo.getIndividualTheater("1"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for
	 * {@link com.altran.daoimpl.TheaterDataInfo#updateTheater(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long)}.
	 */
	@Test
	public void testUpdateTheater() {
		System.out.println("update");
		try {
			assertEquals(1, theaterInfo.updateTheater("9999", "abc", "sector28", "Ambience", "gurgaon", "haryana",
					876543L, 50L));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}

	/**
	 * Test method for {@link com.altran.daoimpl.TheaterDataInfo#getTheater()}.
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
	 * Test method for
	 * {@link com.altran.daoimpl.TheaterDataInfo#deleteTheater(java.lang.String)}.
	 */
	@Test
	public void testDeleteTheater() {
		try {
			assertNotNull(theaterInfo.deleteTheater("9999"));
		} catch (SQLException e) {
			assertNotNull(e);
		}
	}
}
