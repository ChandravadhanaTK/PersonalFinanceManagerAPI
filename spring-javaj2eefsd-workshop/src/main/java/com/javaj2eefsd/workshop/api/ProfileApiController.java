package com.javaj2eefsd.workshop.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.Profile;
import com.javaj2eefsd.workshop.service.ProfileService;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
@CrossOrigin(origins = { "*" })
public class ProfileApiController implements ProfileApi {

    private static final Logger log = LoggerFactory.getLogger(ProfileApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ProfileService profileServiceImpl;
    
    @org.springframework.beans.factory.annotation.Autowired
    public ProfileApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> editProfileByEmailId(@ApiParam(value = "editprofile object to add to database." ,required=true )  @Valid @RequestBody Profile body) 
    				throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	profileServiceImpl.updateProfileDetails(body);
            	System.out.println("Kumar with Ayush "+body);
            
            }
            catch (final IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        return new ResponseEntity<Void>(HttpStatus.OK);
        
    	
    	
//    	String accept = request.getHeader("Accept");
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Profile> getProfileByEmailId(@ApiParam(value = "email id of user for whom information is to be retrieved.",required=true) @PathVariable("emailId") String emailId) {
        String accept = request.getHeader("Accept");
        Profile profileList = null;
        if (accept != null && accept.contains("application/json")) {
            try {
            		profileList = profileServiceImpl.getProfileDetails(emailId);
            		System.out.println("Testing by Sandhya"+profileList);
                //return new ResponseEntity<Profile>(objectMapper.readValue("{  \"profile_image\" : \"profile_image\",  \"emai_id\" : \"emai_id\",  \"company_name\" : \"company_name\",  \"last_name\" : \"last_name\",  \"first_name\" : \"first_name\",  \"contact_number\" : \"contact_number\"}", Profile.class), HttpStatus.NOT_IMPLEMENTED);
            		//return new ResponseEntity<profileList>(HttpStatus.OK);
            	
            		return new ResponseEntity<Profile>(profileList,HttpStatus.OK);
            		
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Profile>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

}
