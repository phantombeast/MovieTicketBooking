package com.altran.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.altran.dao.MovieTimingData;
import com.altran.model.MovieTimings;
import com.altran.serviceimpl.ConnectionDB;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieTimingsDataInfo.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 4:20:40 PM
Author                        :GR_Ritchie_Java_02
Description                   :add movie timings,update movie timings, delete movie timings and fetch movie timings

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class add movie timings, fetch movie timings, delete movie timing or
 * update movie timings
 * 
 * @see MovieTimingsDataInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class MovieTimingsDataInfo implements MovieTimingData {

	// logger constant
	private static Logger logger = Logger.getLogger(MovieTimingsDataInfo.class.getName());
	// Connection object reference
	private Connection con = null;
	// Prepared Statement object reference
	PreparedStatement ps = null;

	/**
	 * 
	 * Constructor for MovieTimingsDataInfo to initialize jdbc driver and connection
	 * object and to create movie timings table if it does not exists
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public MovieTimingsDataInfo() throws ClassNotFoundException, SQLException {
		logger.info("*****inside MovieTimingsDataInfo ******");
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(
				"CREATE TABLE IF NOT EXISTS MOVIETIMINGS(MOVIETIMEID INT AUTO_INCREMENT,THEATREID VARCHAR(10) NOT NULL,"
						+ "MOVIEID VARCHAR(10) NOT NULL," + "MOVIEDATE DATE NOT NULL,"
						+ "MOVIETIME VARCHAR(30) NOT NULL," + "MOVIETICKETCOST VARCHAR(30) NOT NULL,"
						+ "TOTALTICKETBOOKED INT DEFAULT 0, PRIMARY KEY(MOVIETIMEID))");
		ps.executeUpdate();
	}

	/**
	 * 
	 * This method a new movie timings into the database
	 *
	 * @param movieTime
	 *            : MovieTime object reference
	 * @return added in the database or not
	 * @throws SQLException
	 */
	public int addMovieTimings(MovieTimings movieTime) throws SQLException {
		logger.info("*****inside addMovieTimings ******");
		if (checkMovieTiming(movieTime) == 0) {
			ps = con.prepareStatement(
					"INSERT INTO MOVIETIMINGS(THEATREID,MOVIEID,MOVIEDATE,MOVIETIME,MOVIETICKETCOST) VALUES(?,?,?,?,?)");
			ps.setString(1, movieTime.getTheatreId());
			ps.setString(2, movieTime.getMovieId());
			ps.setString(3, movieTime.getMovieDate());
			ps.setString(4, movieTime.getMovieTiming());
			ps.setDouble(5, movieTime.getMovieTicketCost());
			logger.info("*****exiting from addMovieTimings ******");
			return ps.executeUpdate();
		}
		return 0;
	}

	/**
	 * This method checks if movie timing details already exist or no
	 * 
	 * @param movieTimings
	 * @return record exist or not
	 * @throws SQLException
	 */
	private int checkMovieTiming(MovieTimings movieTimings) throws SQLException {
		logger.info("*****inside check Movie Timing ******");
		ps = con.prepareStatement("SELECT 1 from movietimings where THEATREID=? AND MOVIEID=? AND MOVIEDATE=?"
				+ " AND MOVIETIME=? AND MOVIETICKETCOST=?");
		ps.setString(1, movieTimings.getTheatreId());
		ps.setString(2, movieTimings.getMovieId());
		ps.setString(3, movieTimings.getMovieDate());
		ps.setString(4, movieTimings.getMovieTiming());
		ps.setDouble(5, movieTimings.getMovieTicketCost());
		logger.info("*****exiting from check Movie Timing ******");
		return ps.executeQuery().next() ? 1 : 0;

	}

	/**
	 * 
	 * This method is used to get timing of movies of a particular theater id
	 *
	 * @param theaterId
	 * @param date
	 * @return movie timings record
	 * @throws SQLException
	 */

	public ResultSet getTiming(String theaterId, String date) throws SQLException {
		logger.info("*****inside getTiming******");
		ps = con.prepareStatement("Select * from MOVIETIMINGS where theatreid = ? and moviedate=?");
		ps.setString(1, theaterId);
		ps.setDate(2, Date.valueOf(date));
		logger.info("*****exiting from getTiming******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method is used to get list of theater Id and theater name
	 *
	 * @return Theater detail record
	 * @throws SQLException
	 */
	public ResultSet getTheatreId() throws SQLException {
		logger.info("*****inside getTheatreId******");
		ps = con.prepareStatement("select theaterId,theaterName from theaterdetails");
		logger.info("*****exiting from getTheatreId******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method is used to fetch list get movie id and movie name
	 *
	 * @return movie record
	 * @throws SQLException
	 */
	public ResultSet getMovieId() throws SQLException {
		logger.info("*****inside getMovieId******");
		ps = con.prepareStatement("select movieId,movieName from movie");
		logger.info("*****exiting from getMovieId******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method is used to get list of movie timings
	 *
	 * @return movie timings record
	 * @throws SQLException
	 */
	public ResultSet getMovieTimings() throws SQLException {
		logger.info("*****inside getMovieTimings******");
		ps = con.prepareStatement("Select * from MOVIETIMINGS");
		logger.info("*****exiting from getMovieTimings******");
		return ps.executeQuery();
	}

	/**
	 * This method is used to fetch timing of a particular movie
	 * 
	 * @param movieTimeId
	 * @return MovieTimings record
	 * @throws SQLException
	 */
	public ResultSet getMovieTimings(int movieTimeId) throws SQLException {
		logger.info("*****inside getMovieTimings******");
		ps = con.prepareStatement("Select * from MOVIETIMINGS where movieTimeId=?");
		ps.setInt(1, movieTimeId);
		logger.info("*****exiting from getMovieTimings******");
		return ps.executeQuery();
	}

	/**
	 * This method is used to fetch cities
	 * 
	 * @return cities record
	 * @throws SQLException
	 */
	public ResultSet getCity() throws SQLException {
		logger.info("*****inside get City******");
		ps = con.prepareStatement("select distinct(city) from theaterdetails");
		logger.info("*****exiting from get City******");
		return ps.executeQuery();
	}

	/**
	 * This method is used to fetch timings of movies
	 * 
	 * @return timings record
	 * @throws SQLException
	 */

	public ResultSet getTime() throws SQLException {
		logger.info("*****inside get Time******");
		ps = con.prepareStatement("select distinct(movietime) from movietimings");
		logger.info("*****exiting from get Time******");
		return ps.executeQuery();
	}

	/**
	 * This method is used to get list of timings
	 * 
	 * @return MovieTimings record
	 * @throws SQLException
	 */

	public ResultSet getTiming() throws SQLException {
		logger.info("*****inside get Timing******");
		ps = con.prepareStatement("Select * from MOVIETIMINGS ");
		logger.info("*****exiting from get Timing******");
		return ps.executeQuery();
	}

	/**
	 * This method is used to update the movie timings
	 * 
	 * @param theatreId
	 *            : theater id to be updated
	 * @param movieId
	 *            : movie id to be updated
	 * @param movieDate
	 *            : movie date to be updated
	 * @param movieTime
	 *            : movie time to be updated
	 * @param ticketCost
	 *            : ticket cost to be updated
	 * @param ticketBooked
	 *            : ticket booking count to be updated
	 * @param movieTimingId
	 *            : Movie timing Id to be updated
	 * @return record updated or not
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public int updateMovieTimings(String theatreId, String movieId, Date movieDate, String movieTime, Double ticketCost,
			int ticketBooked, String movieTimingId) throws NumberFormatException, SQLException {
		logger.info("*****inside get update MovieTimings******");
		ps = con.prepareStatement(
				"UPDATE MOVIETIMINGS SET THEATREID=?,MOVIEID=?,MOVIEDATE=?,MOVIETIME=?,MOVIETICKETCOST=?,TOTALTICKETBOOKED=? WHERE MOVIETIMEID=?");
		ps.setInt(1, Integer.parseInt(theatreId));
		ps.setInt(2, Integer.parseInt(movieId));
		ps.setDate(3, movieDate);
		ps.setString(4, movieTime);
		ps.setDouble(5, ticketCost);
		ps.setInt(6, ticketBooked);
		ps.setInt(7, Integer.parseInt(movieTimingId));
		logger.info("*****exiting from get update MovieTimings******");
		return ps.executeUpdate();
	}

	/**
	 * This method delete the movie timing record
	 * 
	 * @param movieTimingId
	 *            : movie Timing to be deleted
	 * @return record deleted or not
	 * @throws SQLException
	 */
	public int deleteMovieTimings(String movieTimingId) throws SQLException {
		logger.info("*****inside delete MovieTimings******");
		ps = con.prepareStatement("DELETE FROM MOVIETIMINGS WHERE MOVIETIMEID=?");
		ps.setInt(1, Integer.parseInt(movieTimingId));
		logger.info("*****exiting from delete MovieTimings******");
		return ps.executeUpdate();
	}
}
