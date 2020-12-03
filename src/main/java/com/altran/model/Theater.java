package com.altran.model;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :Theater.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 2:50:50 PM
Author                        :GR_Ritchie_Java_02
Description                   :Store details about theater 

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class store details of theater such as theater id, theater name,
 * address,city,region,pin code and total seats and provide setter and getter
 * methods
 * 
 * @see Theater
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class Theater {
	// instance variable to store theater id
	private String theaterId;
	// instance variable to store theater name
	private String theaterName;
	// instance variable to store address line 1
	private String addressLine1;
	// instance variable to store address line 2
	private String addressLine2;
	// instance variable to store city
	private String city;
	// instance variable to store region
	private String region;
	// instance variable to store pin code
	private Long pinCode;
	// instance variable to store total seats
	private int totalSeats;

	/**
	 * This method is used to get the theaterId
	 *
	 * @return the theaterId
	 */
	public String getTheaterId() {
		return theaterId;
	}

	/**
	 * This method is used to set the theaterId
	 *
	 * @param theaterId
	 *            the theaterId to set
	 */
	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	/**
	 * This method is used to get the theaterName
	 *
	 * @return the theaterName
	 */
	public String getTheaterName() {
		return theaterName;
	}

	/**
	 * This method is used to set the theaterName
	 *
	 * @param theaterName
	 *            the theaterName to set
	 */
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	/**
	 * This method is used to get the addressLine1
	 *
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * This method is used to set the addressLine1
	 *
	 * @param addressLine1
	 *            the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * This method is used to get the addressLine2
	 *
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * This method is used to set the addressLine2
	 *
	 * @param addressLine2
	 *            the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * This method is used to get the city
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * This method is used to set the city
	 *
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * This method is used to get the region
	 *
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * This method is used to set the region
	 *
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * This method is used to get the pinCode
	 *
	 * @return the pinCode
	 */
	public Long getPinCode() {
		return pinCode;
	}

	/**
	 * This method is used to set the pinCode
	 *
	 * @param pinCode
	 *            the pinCode to set
	 */
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * This method is used to get the totalSeats
	 *
	 * @return the totalSeats
	 */
	public int getTotalSeats() {
		return totalSeats;
	}

	/**
	 * This method is used to set the totalSeats
	 *
	 * @param totalSeats
	 *            the totalSeats to set
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

}
