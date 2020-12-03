package com.altran.testsuite;

import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.altran.controller.test.UserControllerTest;

/**
 * 
*********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				      :UserControllerTest.java 
Principal Author			  :GR_Ritchie_Java_02
Subsystem Name                :Core Java Training
Module Name                   :Online Movie Ticket Booking System
Date of First Release         :Feb 26, 2020 4:31:32 PM
Author                        :GR_Ritchie_Java_02
Description                   :Runner class to run test suite

Version                       :1.0
Date(DD/MM/YYYY)              :Feb 26, 2020
Modified by                   :GR_Ritchie_Java_02
Description of change         :Initial Version

***********************************************************************/
/**
 * This class is a runner class to run test suite
 * 
 * @see UserControllerTest
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
public class TestRunner {

	// logger constant
	private static Logger logger = Logger.getLogger(TestRunner.class.getName());

	/**
	 * This method runs the test suite class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// local variable to store result
		Result result = JUnitCore.runClasses(JunitTestSuite.class);
		// checking results which are passed
		for (Failure failure : result.getFailures()) {
			logger.warning(failure.toString());
		}
		logger.info("****" + result.wasSuccessful() + "****");
	}
}