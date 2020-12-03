package com.altran.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.altran.dao.TheaterInfo;
import com.altran.serviceimpl.ConnectionDB;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :TheaterDataInfo.java 
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
 * This class provide methods to fetch theater details, update theater , delete
 * theater or add theater
 * 
 * @see TheaterDataInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */

public class TheaterDataInfo implements TheaterInfo {

	// logger constant
	private static Logger logger = Logger.getLogger(TheaterDataInfo.class.getName());

	// Connection object reference
	private Connection con = null;
	// Prepared Statement object reference
	private PreparedStatement ps = null;

	/**
	 * 
	 * Constructor for TheaterDataInfo to initialize jdbc driver and connection
	 * object and to create theater details table if it does not exists
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public TheaterDataInfo()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		logger.info("*****inside TheaterDataInfo ******");
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS THEATERDETAILS (" + "theaterId INT AUTO_INCREMENT,"
				+ "theaterName varchar(30)," + "theaterAddress1 varchar(300) not null,"
				+ "theaterAddress2 varchar(300)," + "city varchar(20) not null," + "region varchar(30),"
				+ "pincode LONG not null," + "totalSeats INT(5)," + "PRIMARY KEY(theaterId))");
		ps.executeUpdate();
	}

	/**
	 * 
	 * This method is used to fetch a particular theater for a given movie id and
	 * date
	 *
	 * @param movieId
	 *            : movie id to be searched
	 * @param date
	 *            : date to be searched
	 * @return Theater record
	 * @throws SQLException
	 */
	private ResultSet getDistinctThteater(String movieId, String date) throws SQLException {
		logger.info("*****inside get DistinctThteater ******");
		ps = con.prepareStatement("Select distinct theatreId from movietimings where movieId=? and movieDate = ?");
		ps.setString(1, movieId);
		ps.setDate(2, Date.valueOf(date));
		logger.info("*****exiting from get DistinctThteater ******");
		return ps.executeQuery();
	}

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
	public List<ResultSet> getTheaterList(String movieId, String date) throws SQLException {
		logger.info("*****inside get TheaterList ******");
		// List of theaters
		List<ResultSet> theaters = new ArrayList<>();
		// Result set to store theaters
		ResultSet rs = getDistinctThteater(movieId, date);
		while (rs.next()) {
			ps = con.prepareStatement("Select * from THEATERDETAILS where theaterId=?");
			ps.setString(1, rs.getString(1));
			theaters.add(ps.executeQuery());
		}
		logger.info("*****exiting from get TheaterList ******");
		return theaters;
	}

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
			String region, Long pinCode, int totalSeats) throws SQLException {
		logger.info("*****inside addTheater ******");
		if (theaterExist(theaterName, theaterAddress1, theaterAddress2, city, region, pinCode, totalSeats) == 0) {
			ps = con.prepareStatement(
					"INSERT INTO THEATERDETAILS(theaterName,theaterAddress1,theaterAddress2,city,region,pincode,totalSeats)"
							+ " VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, theaterName);
			ps.setString(2, theaterAddress1);
			ps.setString(3, theaterAddress2);
			ps.setString(4, city);
			ps.setString(5, region);
			ps.setLong(6, pinCode);
			ps.setInt(7, totalSeats);
			logger.info("*****exiting from addTheater ******");
			return ps.executeUpdate();
		}
		return 0;
	}

	private int theaterExist(String theaterName, String theaterAddress1, String theaterAddress2, String city,
			String region, Long pinCode, int totalSeats) throws SQLException {
		logger.info("*****inside theater Exist ******");
		ps = con.prepareStatement(
				"SELECT 1 FROM THEATERDETAILS WHERE theaterName=? AND theaterAddress1=? AND theaterAddress2=? AND city=? AND"
						+ " region=? AND pincode=? AND totalSeats =?");
		ps.setString(1, theaterName);
		ps.setString(2, theaterAddress1);
		ps.setString(3, theaterAddress2);
		ps.setString(4, city);
		ps.setString(5, region);
		ps.setLong(6, pinCode);
		ps.setInt(7, totalSeats);
		logger.info("*****exiting from theater Exist******");
		return ps.executeQuery().next() ? 1 : 0;
	}

	/**
	 * 
	 * This method is used to get the individual theater
	 *
	 * @param theaterId
	 *            : theaterId of theater ro be searched
	 * @return theater record
	 * @throws SQLException
	 */
	public ResultSet getIndividualTheater(String theaterId) throws SQLException {
		logger.info("*****inside get IndividualTheater ******");
		ps = con.prepareStatement("Select * from THEATERDETAILS where theaterId=?");
		ps.setString(1, theaterId);
		logger.info("*****exiting from get IndividualTheater******");
		return ps.executeQuery();
	}

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
			String city, String region, Long pinCode, Long totalSeats) throws SQLException {
		logger.info("*****inside updateTheater ******");
		ps = con.prepareStatement(
				"UPDATE THEATERDETAILS SET theaterName=?,theaterAddress1=?,theaterAddress2=?,city=?,region=?,pincode=?,totalSeats=? where THEATERID=?");
		ps.setString(1, theaterName);
		ps.setString(2, theaterAddress1);
		ps.setString(3, theaterAddress2);
		ps.setString(4, city);
		ps.setString(5, region);
		ps.setLong(6, pinCode);
		ps.setLong(7, totalSeats);
		ps.setInt(8, Integer.parseInt(theaterId));
		logger.info("*****exiting from updateTheater******");
		System.out.println(ps.executeUpdate());
		return 1;
	}

	/**
	 * 
	 * This method is used to theater records
	 *
	 * @return theater record
	 * @throws SQLException
	 */
	public ResultSet getTheater() throws SQLException {
		logger.info("*****inside getTheater ******");
		ps = con.prepareStatement("Select * from THEATERDETAILS");
		logger.info("*****exiting from getTheater******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method is used to delete a theater
	 *
	 * @param theaterId
	 *            : theater id of theater to be deleted
	 * @return theater deleted or not
	 * @throws SQLException
	 */
	public int deleteTheater(String theaterId) throws SQLException, NumberFormatException {
		logger.info("*****inside deleteTheater ******");
		ps = con.prepareStatement("Delete from THEATERDETAILS where theaterId=?");
		ps.setInt(1, Integer.parseInt(theaterId));
		logger.info("*****exiting from deleteTheater ******");
		return ps.executeUpdate();
	}
}
