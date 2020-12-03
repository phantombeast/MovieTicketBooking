package com.altran.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.altran.dao.MovieData;
import com.altran.model.Movie;
import com.altran.serviceimpl.ConnectionDB;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieDataInfo.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 4:48:09 PM
Author                        :GR_Ritchie_Java_02
Description                   :add movie, update movie, delete movie, book movie

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class add provide methods to add movie, update movie, delete movie, book
 * movie
 * 
 * @see MovieDataInfo
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */

public class MovieDataInfo implements MovieData {

	// logger constant
	private static Logger logger = Logger.getLogger(MovieDataInfo.class.getName());

	// Connection object reference
	Connection con = null;
	// Prepared Statement object reference
	PreparedStatement ps = null;

	/**
	 * Constructor for MovieDataInfo to initialize jdbc driver and connection object
	 * and to create movie table if it does not exists
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public MovieDataInfo() throws ClassNotFoundException, SQLException {
		con = ConnectionDB.getConnection();

		logger.info("*****inside MovieDataInfo ******");
		// create table if it does not exist
		ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS MOVIE (" + "movieId INT AUTO_INCREMENT,"
				+ "movieName varchar(30)," + "movieSynopsis varchar(1000) not null," + "movieReleaseDate DATE,"
				+ "movieDuration FLOAT not null," + "sliderImagePath varchar(250)," + "posterImagePath varchar(250),"
				+ "PRIMARY KEY(movieId))");
		ps.executeUpdate();
	}

	/**
	 * 
	 * This method add a new movie
	 *
	 * @param movieName
	 *            : movie name to be added
	 * @param movieSynopsis
	 *            : movie synopsis to be added
	 * @param movieReleaseDate
	 *            : movie release date to be added
	 * @param movieDuration
	 *            : movie duration to be added
	 * @return movie added or not
	 * @throws SQLException
	 */
	public int addMovie(Movie movie) throws SQLException {
		logger.info("*****inside add Movie ******");
		// insert movie details into database
		if (checkMovieExist(movie) == 1) {
			ps = con.prepareStatement(
					"insert into movie(movieName,movieSynopsis,movieReleaseDate,movieDuration) values(?, ?, ?, ?)");
			ps.setString(1, movie.getMovieName());
			ps.setString(2, movie.getMovieSynopsis());
			ps.setDate(3, movie.getMovieReleaseDate());
			ps.setString(4, movie.getMovieDuration());
			return ps.executeUpdate();
		}
		logger.info("*****exiting from add Movie ******");
		return 0;
	}

	/**
	 * This method checks if movie details already exist or not
	 * 
	 * @param movie
	 * @return movie exist or not
	 * @throws SQLException
	 */

	private int checkMovieExist(Movie movie) throws SQLException {
		logger.info("*****inside check Movie Exist ******");
		ps = con.prepareStatement("Select 1 from movie where movieName=? AND movieSynopsis=?"
				+ "AND movieReleaseDate=? AND movieDuration=?");
		ps.setString(1, movie.getMovieName());
		ps.setString(2, movie.getMovieSynopsis());
		ps.setDate(3, movie.getMovieReleaseDate());
		ps.setString(4, movie.getMovieDuration());
		logger.info("*****exiting from check Movie Exist ******");
		return ps.executeQuery().next() ? 0 : 1;
	}

	/**
	 * 
	 * This method update a movie
	 *
	 * @param movieId
	 *            : movieId to be updated
	 * @param movieName
	 *            : movie name to be updated
	 * @param movieSynopsis
	 *            : movieSynopsis to be updated
	 * @param movieReleaseDate
	 *            : movieReleaseDate to be updated
	 * @param movieDuration
	 *            : movieDuration to be updated
	 * @return movie updated or not
	 * @throws SQLException
	 */
	public int updateMovie(Movie movie) throws SQLException {
		logger.info("*****inside update Movie******");
		// update movie details
		ps = con.prepareStatement(
				"update movie set movieName=?," + "movieSynopsis=?,movieReleaseDate=?,movieDuration=? where movieId=?");
		ps.setString(1, movie.getMovieName());
		ps.setString(2, movie.getMovieSynopsis());
		ps.setDate(3, movie.getMovieReleaseDate());
		ps.setString(4, movie.getMovieDuration());
		ps.setInt(5, movie.getMovieId());
		logger.info("*****exiting from update Movie******");
		return ps.executeUpdate();
	}

	/**
	 * 
	 * This method is used to get list of movie
	 *
	 * @return movie record
	 * @throws SQLException
	 */
	public ResultSet getMovie() throws SQLException {
		logger.info("*****inside get Movie******");
		// fetch all movies
		ps = con.prepareStatement("Select * from movie");
		logger.info("*****exiting from get Movie******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method add slider path for a movie
	 *
	 * @param path
	 *            : slider path to be saved
	 * @return added or not
	 * @throws SQLException
	 */
	public int addSliderPath(String path) throws SQLException {
		logger.info("*****inside add Slider Path******");
		// select maximum movie id
		ps = con.prepareStatement("Select max(movieId) from movie");
		ResultSet rs = ps.executeQuery();
		rs.next();
		// update movie slider path
		ps = con.prepareStatement("update movie set " + "sliderImagePath=? " + "where movieId=?");
		ps.setString(1, path);
		ps.setString(2, rs.getString(1));
		logger.info("*****exiting from add Slider Path******");
		return ps.executeUpdate();
	}

	/**
	 * 
	 * This method add poster path for a movie
	 *
	 * @param path
	 *            : poster path to be saved
	 * @return added or not
	 * @throws SQLException
	 */
	public int addPosterPath(String path) throws SQLException {
		logger.info("*****inside add Poster Path******");
		// select maximum movie id
		ps = con.prepareStatement("Select max(movieId) from movie");
		ResultSet rs = ps.executeQuery();
		rs.next();
		// update movie poster path
		ps = con.prepareStatement("update movie set " + "posterImagePath=? " + "where movieId=?");
		ps.setString(1, path);
		ps.setString(2, rs.getString(1));
		logger.info("*****exiting from add Poster Path******");
		return ps.executeUpdate();
	}

	/**
	 * 
	 * This method is used to get a particular movie based on the movie id
	 *
	 * @param movieId
	 *            : movie to be returned
	 * @return Movie object reference
	 * @throws SQLException
	 */
	public ResultSet getIndividualMovie(int movieId) throws SQLException {
		logger.info("*****inside get Individual Movie******");
		// fetch movie based on movie id
		ps = con.prepareStatement("Select * from movie where movieId = ?");
		ps.setInt(1, movieId);
		logger.info("*****exiting from get Individual Movie******");
		return ps.executeQuery();
	}

	/**
	 * 
	 * This method delete a movie
	 *
	 * @param movieId
	 *            : movie to be deleted
	 * @return deleted or not
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public int deleteMovie(int movieId) throws SQLException {
		logger.info("*****inside delete Movie******");
		// delete movie details based on movie id
		ps = con.prepareStatement("Delete from movie where movieId=?");
		ps.setInt(1, movieId);
		logger.info("*****exiting from delete Movie******");
		return ps.executeUpdate();
	}

	/**
	 * 
	 * This method is used to book a ticket
	 *
	 * @param movieId
	 *            : movie id to be booked
	 * @param date
	 *            : date on which movie to be booked
	 * @param movieTime
	 *            : show time for which movie is to be booked
	 * @param theaterId
	 *            : theater at which movie is to be booked
	 * @param totalTicket
	 *            : total number of ticket
	 * @param cost
	 *            : cost of 1 ticket
	 * @return booked or not
	 * @throws SQLException
	 */
	public int bookTicket(int movieTimeId, int totalTicket) throws SQLException {
		logger.info("*****inside bookTicket******");
		ps = con.prepareStatement("select totalticketbooked,THEATREID from movietimings where movieTimeId=?");
		ps.setInt(1, movieTimeId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int bookedTicket = rs.getInt(1);
		// if ticket is available
		if (checkAvailability(rs.getInt(2), bookedTicket + totalTicket)) {
			ps = con.prepareStatement("update movietimings set totalticketbooked=? where movieTimeId=?");
			ps.setInt(1, bookedTicket + totalTicket);
			ps.setInt(2, movieTimeId);
			logger.info("*****exiting from bookTicket when ticket is available******");
			return ps.executeUpdate();
		}
		logger.info("*****exiting from bookTicket when ticket is unavailable******");
		// if ticket is not available
		return 0;
	}

	/**
	 * This method checks the availability of ticket
	 * 
	 * @param theaterId
	 *            : theater id to check
	 * @param totalTicketBooked
	 *            : total ticket to be booked
	 * @return available or not
	 * @throws SQLException
	 */
	private boolean checkAvailability(int theaterId, int totalTicketBooked) throws SQLException {
		logger.info("*****inside checkAvailability******");
		ps = con.prepareStatement("Select totalseats from theaterdetails where theaterid=?");
		ps.setInt(1, theaterId);
		ResultSet rs = ps.executeQuery();
		rs.next();
		logger.info("*****exiting from checkAvailability******");
		return rs.getInt(1) >= totalTicketBooked ? true : false;
	}

	/**
	 * This method is used to get details of a movie
	 * 
	 * @param movieName
	 *            : details of movie to be fetch
	 * @return movie record
	 */
	public ResultSet getMovie(String movieName) throws SQLException {
		logger.info("*****inside get Movie******");
		ps = con.prepareStatement("select * from movie where movieName like '%" + movieName + "%'");
		logger.info("*****exiting from get Movie******");
		return ps.executeQuery();
	}

	/**
	 * This method is used to get movies list in a city
	 * 
	 * @param city
	 *            : city to be searched
	 * @return movie record
	 * @throws SQLException
	 */
	public ResultSet getMovieByCity(String city) throws SQLException {
		logger.info("*****inside  getMovieByCity******");
		ps = con.prepareStatement(
				"Select * from movie where movieId in( Select movieId from movietimings where THEATREID IN ( SELECT theaterId FROM theaterdetails where city=?))");
		ps.setString(1, city);
		logger.info("*****exiting from  getMovieByCity******");
		return ps.executeQuery();
	}

	/**
	 * This method is used to get movies list at a particular time slot
	 * 
	 * @param time
	 *            : time to be searched
	 * @return movies record
	 * @throws SQLException
	 */
	public ResultSet getMovieByTime(String time) throws SQLException {
		logger.info("*****inside  getMovieByTime******");
		ps = con.prepareStatement(
				"Select * from movie where movieId in( Select movieId from movietimings where THEATREID IN ( SELECT theaterId FROM theaterdetails where MOVIETIME=?))");
		ps.setString(1, time);
		logger.info("*****exiting from   getMovieByTime******");
		return ps.executeQuery();
	}
}
