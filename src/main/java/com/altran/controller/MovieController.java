package com.altran.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.altran.model.MovieTimings;
import com.altran.serviceimpl.MovieInfo;
import com.altran.serviceimpl.MovieTimingInfo;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :MovieController.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 2:29:22 PM
Author                        :GR_Ritchie_Java_02
Description                   :Book movie ticket, update movie details , fetch movie details, delete movie details

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provide methods to book movie ticket, update movie details , fetch
 * movie details, delete movie details
 * 
 * @see MovieController
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
@Path("/movie")
public class MovieController {
	// logger constant
	private static Logger logger = Logger.getLogger(TheaterController.class.getName());
	// MovieTimingInfo object reference
	private MovieTimingInfo timingMovieInfo;
	// MovieInfo object reference
	MovieInfo movieInfo;

	/**
	 * 
	 * Default Constructor for MovieController
	 *
	 */
	public MovieController() {
		try {
			// Initializing timingMovieInfo and movieInfo object reference
			timingMovieInfo = new MovieTimingInfo();
			movieInfo = new MovieInfo();
		} catch (ClassNotFoundException | SQLException e) {
			logger.warning(e.getMessage());
		}
	}

	/**
	 * 
	 * This method add a new movie in the database
	 *
	 * @param movieName
	 *            : movie name to set
	 * @param movieSynopsis
	 *            : movie synopsis to set
	 * @param movieReleaseDate
	 *            : movie release date to set
	 * @param movieDuration
	 *            : movie duration to set
	 * @return response:
	 * @throws URISyntaxException
	 */
	@POST
	@Path("/add")
	public Response addMovie(@FormParam("movieName") String movieName, @FormParam("movieSynopsis") String movieSynopsis,
			@FormParam("movieReleaseDate") Date movieReleaseDate, @FormParam("movieDuration") String movieDuration)
			throws URISyntaxException {
		try {
			logger.info("****Inside add movie controller****");
			// checking if movie is added or not
			if (movieInfo.addMovie(movieName, movieSynopsis, movieReleaseDate, movieDuration) == 1) {
				logger.info("****Movie Added successfully*****");
			} else {
				logger.info("****Movie can not be added****");
				return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/addMovie.jsp?msg=1"))
						.build();
			}
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****Exiting add movie controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/sliderimage.jsp")).build();
	}

	/**
	 * 
	 * This method update movie details
	 *
	 * @param movieId
	 *            : movie id to update
	 * @param movieName
	 *            : movie name to update
	 * @param movieSynopsis
	 *            : movie synopsis to update
	 * @param movieReleaseDate
	 *            : movie release date to update
	 * @param movieDuration
	 *            : movie duration to update
	 * @return response
	 * @throws URISyntaxException
	 */
	@POST
	@Path("/update")
	public Response updateMovie(@FormParam("movieId") String movieId, @FormParam("movieName") String movieName,
			@FormParam("movieSynopsis") String movieSynopsis, @FormParam("movieReleaseDate") Date movieReleaseDate,
			@FormParam("movieDuration") String movieDuration) throws URISyntaxException {
		try {
			logger.info("****inside update movie controller****");
			// checking if movie is updated or not
			if (movieInfo.updateMovie(movieId, movieName, movieSynopsis, movieReleaseDate, movieDuration) == 1) {
				logger.info("****movie added successfully****");
			} else {
				logger.info("****movie can not be added****");
			}
		} catch (SQLException | NumberFormatException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting update movie controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewmovies.jsp")).build();
	}

	/**
	 * 
	 * This method add movie timings in the database
	 *
	 * @param theatreId
	 *            : theater id to add
	 * @param movieId
	 *            : movie id to add
	 * @param movieDate
	 *            : movie date to add
	 * @param movieTime
	 *            : theater time to add
	 * @param ticketCost
	 *            : ticket cost to add
	 * @return response
	 * @throws URISyntaxException
	 */
	@POST
	@Path("/timings")
	public Response addMovieTiming(@FormParam("theatreId") String theatreId, @FormParam("movieId") String movieId,
			@FormParam("movieDate") String movieDate, @FormParam("movieTime") String movieTime,
			@FormParam("ticketCost") Double ticketCost) throws URISyntaxException {
		try {
			logger.info("****inside add movie timing controller****");
			// checking if movirTimings are added or not
			if (timingMovieInfo.movieTimings(theatreId, movieId, movieDate, movieTime, ticketCost) == 1) {
				logger.info("****movie timings added successfully****");
			} else {
				logger.info("****movie timings can not be added****");
				return Response
						.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/addMovieTimings.jsp?msg=1"))
						.build();
			}
		} catch (SQLException e) {
			logger.warning(e.getMessage());

		}
		logger.info("****exiting movie timings controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewmovietimings.jsp")).build();
	}

	/**
	 * 
	 * This method delete movie from database
	 *
	 * @param movieId
	 *            : id of movie to be deleted
	 * @return response
	 * @throws URISyntaxException
	 */
	@Path("/deleteMovie")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteMovie(@QueryParam("movieId") String movieId) throws URISyntaxException {
		try {
			logger.info("****inside add deleteMovie controller****");
			// checking if movie is deleted successfully or not
			if (movieInfo.deleteMovie(movieId) == 1) {
				logger.info("****movie details deleted successfully****");
			} else {
				logger.info("****movie details can not be deleted****");
			}
		} catch (NumberFormatException | SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting deleteMovie controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewmovies.jsp")).build();
	}

	/**
	 * 
	 * This method update movie timings
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
	 *            : ticket booked to be updated
	 * @param movieTimingId
	 *            : movieTimingsId id to be updated
	 * @return response
	 * @throws URISyntaxException
	 */
	@Path("/updatetime")
	@GET
	public Response updateMovieTimings(@QueryParam("theatreId") String theatreId, @QueryParam("movieId") String movieId,
			@QueryParam("movieDate") Date movieDate, @QueryParam("movieTime") String movieTime,
			@QueryParam("ticketCost") Double ticketCost, @QueryParam("ticketBooked") int ticketBooked,
			@QueryParam("movieTimingId") String movieTimingId) throws URISyntaxException {
		try {
			logger.info("****Inside update time controller****");
			// checking if movie timings are updated successfully or not
			if (timingMovieInfo.updateMovieTimings(theatreId, movieId, movieDate, movieTime, ticketCost, ticketBooked,
					movieTimingId) == 1) {
				logger.info("****movie time updated successfully****");
			} else {
				logger.info("****movie time can not be updated****");
			}
		} catch (NumberFormatException | SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****Exiting movie time controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewmovietimings.jsp")).build();
	}

	/**
	 * 
	 * This method delete movie timings from database
	 *
	 * @param movieTimingId
	 *            : id of movie timings to be deleted
	 * @return response
	 * @throws URISyntaxException
	 */
	@Path("/deletetime")
	@GET
	public Response deleteMovieTimings(@QueryParam("movieTimingId") String movieTimingId) throws URISyntaxException {

		try {
			logger.info("****inside delete time controller****");
			if (timingMovieInfo.deleteMovieTimings(movieTimingId) == 1) {
				logger.info("****movie time deleted successfully****");
			} else {
				logger.info("****movie time can not be deleted****");
			}
		} catch (NumberFormatException | SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting delete time controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewmovietimings.jsp")).build();
	}

	/**
	 * 
	 * This method is use to book ticket
	 *
	 * @param movieTimeId
	 *            : id of show to be booked
	 * @param totalTicket
	 *            " total total to be booked
	 * @return booked or not
	 * @throws URISyntaxException
	 */
	@Path("/bookticket")
	@GET
	public Response bookTicket(@QueryParam("movieTimeId") int movieTimeId, @QueryParam("quantity") int totalTicket)
			throws URISyntaxException {
		logger.info("****inside book tikcet controller****");
		try {
			// checking if ticket is available or not
			if (movieInfo.bookTicket(movieTimeId, totalTicket) == 1) {
				MovieTimings movieTimings = new MovieTimingInfo().getMovieTimings(movieTimeId);
				Double totalCost = movieTimings.getMovieTicketCost() * totalTicket;
				logger.info("****ticket booked successfully****");
				return Response
						.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/booksuccess.jsp?movieTimeId="
								+ movieTimings.getMovieTimingId() + "&cost=" + totalCost))
						.build();
			} else {
				logger.info("****movie can not be bboked****");
				return Response
						.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/bookmovie.jsp?movieTimeId="
								+ movieTimeId + "&message=1"))
						.build();
			}
		} catch (SQLException | ClassNotFoundException | NullPointerException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting book ticket controller****");
		return null;
	}
}
