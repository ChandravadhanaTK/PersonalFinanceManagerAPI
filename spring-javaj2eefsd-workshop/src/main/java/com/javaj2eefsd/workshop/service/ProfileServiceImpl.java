package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaj2eefsd.workshop.dao.ProfileDao;
import com.javaj2eefsd.workshop.model.Profile;

/**
 * 
 * @author Kumar - ProfileServiceImpl class is used to validate the business logic and to call the Profile layer Database Access Object for profile to connect with Database
 * to view and update the user profile data.
 */

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileDao profileDao;
	
	/**
     * getProfileDetails method used to retrieve the profile data from Database
     *
     * @param emailId
     * @return
     * @throws Exception
     */
	
	@Override
	public Profile getProfileDetails(String emailId) throws Exception {
		return profileDao.getProfileDetails(emailId);
	}
	
	/**
     * updateProfileDetails method used to retrieve the profile data from Database
     *
     * @param profileObj
     * @return
     * @throws Exception
     */
	@Override
	public Profile updateProfileDetails(Profile profileObj) throws Exception {
		
		return profileDao.updateProfileDetails(profileObj);
	}

	
	
}
