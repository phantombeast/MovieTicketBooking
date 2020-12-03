package com.altran.model;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieTimings.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 2:48:40 PM
Author                        :GR_Ritchie_Java_02
Description                   :Store details about movie timings

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class store details about movie timings
 * 
 * @see MovieTimings
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class MovieTimings {
	// instance variable to store theater id
	private String theatreId;
	// instance variable to store movie id
	private String movieId;
	// instance variable to store movie date
	private String movieDate;
	// instance variable to store movie timing
	private String movieTiming;
	// instance variable to store movie cost
	private double movieTicketCost;
	// instance variable to store total ticket booked
	private int ticketBooked;
	// instance variable to store movie timing id
	private int movieTimingId;

	/**
	 * This method is used to get the movieTimingId
	 *
	 * @return the movieTimingId
	 */
	public int getMovieTimingId() {
		return movieTimingId;
	}

	/**
	 * This method is used to set the movieTimingId
	 *
	 * @param movieTimingId
	 *            the movieTimingId to set
	 */
	public void setMovieTimingId(int movieTimingId) {
		this.movieTimingId = movieTimingId;
	}

	/**
	 * This method is used to get the theatreId
	 *
	 * @return the theatreId
	 */
	public String getTheatreId() {
		return theatreId;
	}

	/**
	 * This method is used to set the theatreId
	 *
	 * @param theatreId
	 *            the theatreId to set
	 */
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	/**
	 * This method is used to get the movieId
	 *
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * This method is used to set the movieId
	 *
	 * @param movieId
	 *            the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * This method is used to get the movieDate
	 *
	 * @return the movieDate
	 */
	public String getMovieDate() {
		return movieDate;
	}

	/**
	 * This method is used to set the movieDate
	 *
	 * @param movieDate
	 *            the movieDate to set
	 */
	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	/**
	 * This method is used to get the movieTiming
	 *
	 * @return the movieTiming
	 */
	public String getMovieTiming() {
		return movieTiming;
	}

	/**
	 * This method is used to set the movieTiming
	 *
	 * @param movieTiming
	 *            the movieTiming to set
	 */
	public void setMovieTiming(String movieTiming) {
		this.movieTiming = movieTiming;
	}

	/**
	 * This method is used to get the movieTicketCost
	 *
	 * @return the movieTicketCost
	 */
	public double getMovieTicketCost() {
		return movieTicketCost;
	}

	/**
	 * This method is used to set the movieTicketCost
	 *
	 * @param movieTicketCost
	 *            the movieTicketCost to set
	 */
	public void setMovieTicketCost(double movieTicketCost) {
		this.movieTicketCost = movieTicketCost;
	}

	/**
	 * This method is used to get the ticketBooked
	 *
	 * @return the ticketBooked
	 */
	public int getTicketBooked() {
		return ticketBooked;
	}

	/**
	 * This method is used to set the ticketBooked
	 *
	 * @param ticketBooked
	 *            the ticketBooked to set
	 */
	public void setTicketBooked(int ticketBooked) {
		this.ticketBooked = ticketBooked;
	}
}
