package com.altran.serviceimpl;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.altran.daoimpl.TheaterDataInfo;
import com.altran.model.Theater;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :TheaterInfo.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 12:45:06 PM
Author                        :GR_Ritchie_Java_02
Description                   :add theater, update theater, delete theater or fetch theater

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provide methods to add theater, update theater, delete theater or
 * fetch theater
 * 
 * @see TheaterInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class TheaterInfo {
	// TheaterData Object reference
	private TheaterDataInfo theaterDataInfo;

	// logger constant
	private static Logger logger = Logger.getLogger(TheaterInfo.class.getName());

	/**
	 * Constructor for TheaterInfo
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public TheaterInfo() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		theaterDataInfo = new TheaterDataInfo();
	}

	/**
	 * 
	 * This method add a new theater
	 *
	 * @param theaterName
	 *            : theater name to be added
	 * @param addressLine1
	 *            : address line 1 to be added
	 * @param addressLine2
	 *            : address line 2 to be added
	 * @param city
	 *            : city to be added
	 * @param region
	 *            : region to be added
	 * @param postalCode
	 *            : postal code to be added
	 * @param totalSeats
	 *            : total seats to be added
	 * @return theater added or not
	 * @throws SQLException
	 */
	public int addTheater(String theaterName, String addressLine1, String addressLine2, String city, String region,
			Long postalCode, int totalSeats) throws SQLException {
		logger.info("*****inside addTheater******");
		logger.info("*****exiting from addTheater******");
		return theaterDataInfo.addTheater(theaterName, addressLine1, addressLine2, city, region, postalCode,
				totalSeats);
	}

	/**
	 * 
	 * This method is used to get list of theaters
	 *
	 * @return list of theaters
	 * @throws SQLException
	 */
	public List<Theater> getTheater() throws SQLException {
		logger.info("*****inside getTheater******");
		// List to store Theaters
		List<Theater> theaters = new ArrayList<>();
		// ResultSet to store Theaters
		ResultSet rs = theaterDataInfo.getTheater();
		while (rs.next()) {
			// Theater object reference
			Theater theater = new Theater();
			theater.setTheaterId(rs.getString(1));
			theater.setTheaterName(rs.getString(2));
			theater.setAddressLine1(rs.getString(3));
			theater.setAddressLine2(rs.getString(4));
			theater.setCity(rs.getString(5));
			theater.setRegion(rs.getString(6));
			theater.setPinCode(rs.getLong(7));
			theater.setTotalSeats(rs.getInt(8));
			theaters.add(theater);
		}
		logger.info("*****exiting from getTheater******");
		return theaters;
	}

	/**
	 * 
	 * This method delete a theater
	 *
	 * @param theaterId
	 *            : theater to be deleted
	 * @return deleted or not
	 * @throws SQLException
	 */
	public int deleteTheater(String theaterId) throws SQLException {
		logger.info("*****inside deleteTheater******");
		logger.info("*****exiting from deleteTheater******");
		return theaterDataInfo.deleteTheater(theaterId);
	}

	/**
	 * 
	 * This method update a theater details
	 *
	 * @param theaterId
	 *            : theater to be updated
	 * @param theaterName
	 *            : theater name to be updated
	 * @param addressLine1
	 *            : address line1 to be updated
	 * @param addressLine2
	 *            : address line2 to be updated
	 * @param city
	 *            : city to be updated
	 * @param region
	 *            : region to be updated
	 * @param postalCode
	 *            : postal code to be updated
	 * @param totalSeats
	 *            : total seats to be updated
	 * @return updated or not
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	public int updateTheater(String theaterId, String theaterName, String addressLine1, String addressLine2,
			String city, String region, Long postalCode, Long totalSeats) throws SQLException, URISyntaxException {
		logger.info("*****inside updateTheater******");
		logger.info("*****exiting from updateTheater******");
		return theaterDataInfo.updateTheater(theaterId, theaterName, addressLine1, addressLine2, city, region,
				postalCode, totalSeats);
	}

	/**
	 * 
	 * This method is used to get list of theaters for a particular movie and on a
	 * particular date
	 *
	 * @param movieId
	 *            : movie showing in a theater
	 * @param date
	 *            : date to be matched
	 * @return List of theaters
	 * @throws SQLException
	 */
	public List<Theater> getTheaterList(String movieId, String date) throws SQLException {
		logger.info("*****inside getTheaterList******");
		// List to store theaters
		List<Theater> theaters = new ArrayList<>();
		// ResulSet to store theaters
		List<ResultSet> theater = theaterDataInfo.getTheaterList(movieId, date);
		for (ResultSet rs : theater) {
			if (rs.next()) {
				// Theater object reference
				Theater theater2 = new Theater();
				theater2.setTheaterId(rs.getString(1));
				theater2.setTheaterName(rs.getString(2));
				theater2.setAddressLine1(rs.getString(3));
				theater2.setAddressLine2(rs.getString(4));
				theater2.setCity(rs.getString(5));
				theater2.setRegion(rs.getString(6));
				theater2.setPinCode(rs.getLong(7));
				theater2.setTotalSeats(rs.getInt(8));
				theaters.add(theater2);
			}
		}

		logger.info("*****exiting from getTheaterList******");
		return theaters;
	}

	/**
	 * 
	 * This method is used to get a particular theater details
	 * 
	 * @param theaterId
	 *            : theater to be matched
	 * @return Theater object reference
	 * @throws SQLException
	 */
	public Theater getTheaterIndividual(String theaterId) throws SQLException {
		logger.info("*****inside getTheaterIndividual******");
		// Theater object reference
		Theater theater = new Theater();
		// ResultSet to store theater details
		ResultSet rs = theaterDataInfo.getIndividualTheater(theaterId);
		if (rs.next()) {
			theater.setTheaterId(rs.getString(1));
			theater.setTheaterName(rs.getString(2));
			theater.setAddressLine1(rs.getString(3));
			theater.setAddressLine2(rs.getString(4));
			theater.setCity(rs.getString(5));
			theater.setRegion(rs.getString(6));
			theater.setPinCode(rs.getLong(7));
			theater.setTotalSeats(rs.getInt(8));
		}

		logger.info("*****exiting from getTheaterIndividual******");
		return theater;
	}
}
