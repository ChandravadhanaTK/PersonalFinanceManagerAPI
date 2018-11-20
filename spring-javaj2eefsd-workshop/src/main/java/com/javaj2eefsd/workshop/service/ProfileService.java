package com.javaj2eefsd.workshop.service;

import com.javaj2eefsd.workshop.model.Profile;

public interface ProfileService {

	/**
     * getIncomeAll method used to retrieve the income data from db
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
	Profile getProfileDetails(String emailId) throws Exception;
	
	/**
	 * updateProfileDetails - this method is to update the user profile in Database
	 * 
	 *  @param prfoleObj
	 *  @return
	 *  @throws Exception
	 */
	
	Profile updateProfileDetails(Profile profileObj) throws Exception;

}
