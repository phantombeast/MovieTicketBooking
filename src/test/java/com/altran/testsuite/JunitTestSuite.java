package com.altran.testsuite;

import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.altran.controller.test.MovieControllerTest;
import com.altran.controller.test.TheaterControllerTest;
import com.altran.controller.test.UserControllerTest;
import com.altran.daoimpl.test.MovieDataInfoTest;
import com.altran.daoimpl.test.MovieTimingsDataInfoTest;
import com.altran.daoimpl.test.TheaterDataInfoTest;
import com.altran.daoimpl.test.UserRegisterInfoTest;
import com.altran.model.test.MovieTest;
import com.altran.model.test.MovieTimingsTest;
import com.altran.model.test.SessionTest;
import com.altran.model.test.TheaterTest;
import com.altran.model.test.UserTest;
import com.altran.serviceimpl.test.MovieInfoTest;
import com.altran.serviceimpl.test.MovieTimingInfoTest;
import com.altran.serviceimpl.test.TheaterInfoTest;
import com.altran.serviceimpl.test.UserInfoTest;


/***********************************************************************
Aricent Technologies Proprietary

This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

File Name				   :JunitTestSuite.java
Principal Author		   :GR_Ritchie_Java_02
Subsystem Name             :Core Java Training
Module Name                :Online Movie Ticket Booking System
Date of First Release      :Feb 24, 2020
Author                     :GR_Ritchie_Java_02
Description                :Run test methods of daoimpl, serviceimpl, model and controller
Change History
Version                    :1.0
Date(DD/MM/YYYY)           :Feb 24, 2020
Modified by                :GR_Ritchie_Java_02
Description of change 	   :Initial Version

***********************************************************************/

@RunWith(Suite.class)
@SuiteClasses({ MovieInfoTest.class, MovieTimingInfoTest.class, TheaterInfoTest.class, UserInfoTest.class,
		MovieTest.class, MovieTimingsTest.class, SessionTest.class, TheaterTest.class, UserTest.class,
		MovieDataInfoTest.class, MovieTimingsDataInfoTest.class, TheaterDataInfoTest.class, UserRegisterInfoTest.class,
		MovieControllerTest.class, TheaterControllerTest.class, UserControllerTest.class })
/**
 * Run test methods of daoimpl, serviceimpl, model and controller
 * 
 * @see JunitTestSuite
 * @version 1.0
 * @author GR_Ritchie_Java_02
 * @since Feb 26, 2020
 */
public class JunitTestSuite {
}
