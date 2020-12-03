package com.altran.controller;

import java.net.URI;

import java.net.URISyntaxException;
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
import com.altran.serviceimpl.TheaterInfo;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :TheaterController.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 2:40:20 PM
Author                        :GR_Ritchie_Java_02
Description                   :add theater, delete theater,update theater, fetch theater details

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provides method to add theater, delete theater,update theater,
 * fetch theater details
 * 
 * @see TheaterController
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
@Path("/admin")
public class TheaterController {
	// logger constant
	private static Logger logger = Logger.getLogger(TheaterController.class.getName());
	// TheaterInfo object reference
	private TheaterInfo theaterInfo;

	/**
	 * 
	 * Constructor for TheaterController to initialize theater info object reference
	 *
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public TheaterController() {
		try {
			theaterInfo = new TheaterInfo();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			logger.warning(e.getMessage());
		}
	}

	/**
	 * 
	 * This method add theater details
	 * 
	 * @param theaterName
	 *            : theater name to be added
	 * @param addressLine1
	 *            : theater address line 1 to be added
	 * @param addressLine2
	 *            : theater address line 2 to be added
	 * @param city
	 *            : theater city to be added
	 * @param region
	 *            : theater region to be added
	 * @param postalCode
	 *            : theater postal code to be added
	 * @param totalSeats
	 *            : theater total seats to be added
	 * @return details added or not
	 * @throws URISyntaxException
	 */
	@POST
	@Path("/addTheater")
	public Response addTheater(@FormParam("theaterName") String theaterName,
			@FormParam("addressLine1") String addressLine1, @FormParam("addressLine2") String addressLine2,
			@FormParam("city") String city, @FormParam("region") String region,
			@FormParam("postalCode") String postalCode, @FormParam("totalSeats") int totalSeats)
			throws URISyntaxException {
		try {
			logger.info("****inside add theater controller****");
			// checking theater added or not
			if (theaterInfo.addTheater(theaterName, addressLine1, addressLine2, city, region,
					Long.parseLong(postalCode), totalSeats) == 1) {
				logger.info("****theater added successfully****");
			} else {
				logger.info("****theater can not be added****");
				return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/addTheater.jsp?msg=1"))
						.build();
			}
		} catch (NumberFormatException | SQLException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****Exiting add theater controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewtheater.jsp")).build();
	}

	/**
	 * 
	 * This method
	 *
	 * @param theaterId
	 * @return
	 * @throws URISyntaxException
	 */
	@Path("/deleteTheater")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteTheater(@QueryParam("theaterId") String theaterId) throws URISyntaxException {
		try {
			logger.info("****inside delete theater controller****");
			// checking theater deleted or not
			if (theaterInfo.deleteTheater(theaterId) == 1)
				logger.info("****theater deleted successfully****");
			else
				logger.info("****theater can not be deleted****");
		} catch (SQLException | NumberFormatException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting delete theater controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewtheater.jsp")).build();
	}

	/**
	 * 
	 * This method update theater details
	 *
	 * @param theaterId
	 *            : theater id to be updated
	 * @param theaterName
	 *            : theater name to be updated
	 * @param addressLine1
	 *            : theater address line 1 to be updated
	 * @param addressLine2
	 *            : theater address line 2 to be updated
	 * @param city
	 *            : theater city to be updated
	 * @param region
	 *            : theater region to be updated
	 * @param postalCode
	 *            : theater postal code to be updated
	 * @param totalSeats
	 *            : theater total seats to be updated
	 * @return details updated or not
	 * @throws URISyntaxException
	 */
	@POST
	@Path("/updateTheater")
	public Response updateTheater(@FormParam("theaterId") String theaterId,
			@FormParam("theaterName") String theaterName, @FormParam("addressLine1") String addressLine1,
			@FormParam("addressLine2") String addressLine2, @FormParam("city") String city,
			@FormParam("region") String region, @FormParam("postalCode") Long postalCode,
			@FormParam("totalSeats") Long totalSeats) throws URISyntaxException {
		try {
			logger.info("****Inside update theater controller****");
			// checking if theater updated successfully or not
			if (theaterInfo.updateTheater(theaterId, theaterName, addressLine1, addressLine2, city, region, postalCode,
					totalSeats) == 1)
				logger.info("****theater updated successfully****");
			else
				logger.info("****theater can not be updated****");
		} catch (SQLException | NumberFormatException e) {
			logger.warning(e.getMessage());
		}
		logger.info("****exiting update theater controller****");
		return Response.seeOther(new URI("http://localhost:8080/MovieTicketBooking/jsp/viewtheater.jsp")).build();
	}
}
