package com.altran.model;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :Session.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 19, 2020 2:50:50 PM
Author                        :GR_Ritchie_Java_02
Description                   :Manages session of a user

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 19, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class provides variables and methods to manage session of a user
 * 
 * @see Session
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 19, 2020
 */
public class Session {
	// instance variable to store session id
	private static int sessionId;
	// instance variable to store user name
	private static String userName;

	/**
	 * This method is used to get the sessionId
	 *
	 * @return the sessionId
	 */
	public static int getSessionId() {
		return sessionId;
	}

	/**
	 * @return the userName
	 */
	public static String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public static void setUserName(String userName) {
		Session.userName = userName;
	}

	/**
	 * This method is used to set the sessionId
	 *
	 * @param sessionId
	 *            the sessionId to set
	 */
	public static void setSessionId(int sessionId) {
		Session.sessionId = sessionId;
	}

}
