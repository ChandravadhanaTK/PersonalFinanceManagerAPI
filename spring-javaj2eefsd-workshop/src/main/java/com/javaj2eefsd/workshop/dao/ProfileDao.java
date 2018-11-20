package com.javaj2eefsd.workshop.dao;

import java.util.List;
import com.javaj2eefsd.workshop.model.Profile;

/**
 * 
 * @author Kumar - ProfileDao interface is Database Access Object for profile to connect with Database
 * to view and update the user profile data.
 */

public interface ProfileDao {

	/**
	 * getProfileDetails - this method is to retrieve the user profile from Database 
	 *
	 * @param emailId
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
