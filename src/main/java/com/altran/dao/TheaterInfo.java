package com.altran.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
Date of First Release         :Feb 19, 2020 3:41:50 PM
Author                        :GR_Ritchie_Java_02
Description                   :Fetch theater details, update theater , delete theater or add theater

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This interface provide methods to fetch theater details, update theater ,
 * delete theater or add theater
 * 
 * @see TheaterInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public interface TheaterInfo {
	/**
	 * 
	 * This method is used to fetch theater list
	 *
	 * @param movieId
	 *            : movie id to be searched
	 * @param date
	 *            :date to be searched
	 * @return list of theaters
	 * @throws SQLException
	 */
	public List<ResultSet> getTheaterList(String movieId, String date) throws SQLException;

	/**
	 * 
	 * This method add a new theater in the database
	 *
	 * @param theaterName
	 *            : theater name to be added
	 * @param theaterAddress1
	 *            : theater address 1 to be added
	 * @param theaterAddress2
	 *            : theater address 2 to be added
	 * @param city
	 *            : city to be added
	 * @param region
	 *            : region to be added
	 * @param pinCode
	 *            : pin code to be added
	 * @param totalSeats
	 *            : total seats to be added
	 * @return theater added or not
	 * @throws SQLException
	 */
	public int addTheater(String theaterName, String theaterAddress1, String theaterAddress2, String city,
			String region, Long pinCode, int totalSeats) throws SQLException;

	/**
	 * 
	 * This method is used to get the individual theater
	 *
	 * @param theaterId
	 *            : theaterId of theater ro be searched
	 * @return theater record
	 * @throws SQLException
	 */
	public ResultSet getIndividualTheater(String theaterId) throws SQLException;

	/**
	 * 
	 * This method update a theater
	 *
	 * @param theaterId
	 *            : theater id of theater to be updated
	 * @param theaterName
	 *            : new theater name
	 * @param theaterAddress1:
	 *            new address line 1
	 * @param theaterAddress2
	 *            : new address line 2
	 * @param city
	 *            : city to be updated
	 * @param region
	 *            : region to be updated
	 * @param pinCode
	 *            :pin code to be updated
	 * @param totalSeats
	 *            : total seats to be updated
	 * @return theater updated or not
	 * @throws SQLException
	 */
	public int updateTheater(String theaterId, String theaterName, String theaterAddress1, String theaterAddress2,
			String city, String region, Long pinCode, Long totalSeats) throws SQLException;

	/**
	 * 
	 * This method is used to theater records
	 *
	 * @return theater record
	 * @throws SQLException
	 */
	public ResultSet getTheater() throws SQLException;

	/**
	 * 
	 * This method is used to delete a theater
	 *
	 * @param theaterId
	 *            : theater id of theater to be deleted
	 * @return theater deleted or not
	 * @throws SQLException
	 */
	public int deleteTheater(String theaterId) throws SQLException;

}
