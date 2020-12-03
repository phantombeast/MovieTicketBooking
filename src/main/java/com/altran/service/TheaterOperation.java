package com.altran.service;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.altran.model.Theater;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :TheaterOperation.java 
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
 * This interface provide methods to add theater, update theater, delete theater
 * or fetch theater
 * 
 * @see TheaterOperation
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public interface TheaterOperation {
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
			Long postalCode, int totalSeats) throws SQLException;

	/**
	 * 
	 * This method is used to get list of theaters
	 *
	 * @return list of theaters
	 * @throws SQLException
	 */
	public List<Theater> getTheater() throws SQLException;

	/**
	 * 
	 * This method delete a theater
	 *
	 * @param theaterId
	 *            : theater to be deleted
	 * @return deleted or not
	 * @throws SQLException
	 */
	public int deleteTheater(String theaterId) throws SQLException;

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
			String city, String region, Long postalCode, Long totalSeats) throws SQLException, URISyntaxException;

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
	public List<Theater> getTheaterList(String movieId, String date) throws SQLException;

	/**
	 * 
	 * This method is used to get a particular theater details
	 * 
	 * @param theaterId
	 *            : theater to be matched
	 * @return Theater object reference
	 * @throws SQLException
	 */
	public Theater getTheaterIndividual(String theaterId) throws SQLException;
}
