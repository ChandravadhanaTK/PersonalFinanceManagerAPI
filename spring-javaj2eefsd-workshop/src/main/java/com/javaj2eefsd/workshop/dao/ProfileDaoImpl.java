package com.javaj2eefsd.workshop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.EditorAwareTag;

import com.javaj2eefsd.workshop.model.Profile;

/**
 * 
 * @author Kumar - ProfileDaoImpl class is Database Access Object for profile to connect with Database
 * to view and update the user profile data.
 */

@Repository
public class ProfileDaoImpl implements ProfileDao{

	@Autowired
	MongoTemplate profileMongoTemplate;
	
	/**
     * getProfileDetails method used to retrieve the profile data from Database
     *
     * @param emailId
     * @return
     * @throws Exception
     */
	@Override
	public Profile getProfileDetails(String emailId) throws Exception {
		Profile profileDetails = null;
		//List <Profile> profileList = null;
		try {
			Query query = new Query();
//			query.addCriteria(Criteria.where("isDelete").is(false));
			query.addCriteria(Criteria.where("emailId").is(emailId));
//			profileDetails = profileMongoTemplate.find(query, Profile.class);
			System.out.println(" Query :"+ query);
			//profileDetails = (Profile) profileMongoTemplate.findOne(query, Profile.class);
			profileDetails = profileMongoTemplate.findOne(query, Profile.class);
			if(profileDetails==null || profileDetails.getEmaiId().isEmpty()){	
				throw new Exception("Email is invalid");
			}
			System.out.println(" profileDetails :" + profileDetails);
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
		return profileDetails;
	}
	 
	/**
     * updateProfileDetails method used to update/edit the profile data inside Database
     *
     * @param profileObj
     * @return
     * @throws Exception
     */
	
	@Override
	public Profile updateProfileDetails(Profile profileObj) throws Exception{
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("emailId").is(profileObj.getEmaiId()));
			Update update = new Update();
			update.set("firstName", profileObj.getFirstName());
			update.set("lastName", profileObj.getLastName());
			update.set("emailId", profileObj.getEmaiId());
			update.set("mobileNumber", profileObj.getContactNumber());
			update.set("companyName", profileObj.getCompanyName());
			update.set("profileImage", profileObj.getProfileImage());
			
			profileMongoTemplate.updateFirst(query, update, Profile.class);
			System.out.println("Ayush Query"+query);
			System.out.println("Ayush update"+update);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
		return profileObj;
	}
}
