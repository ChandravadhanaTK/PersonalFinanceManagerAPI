package com.javaj2eefsd.workshop.api;

import io.swagger.annotations.ApiParam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;
import com.javaj2eefsd.workshop.service.SettingsService;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
@CrossOrigin(origins = { "*" })
public class SettingsApiController implements SettingsApi {

    private static final Logger log = LoggerFactory.getLogger(SettingsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SettingsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
   @Autowired
   SettingsService settingsServiceImpl;
   
    public ResponseEntity<UserSettingsByEmailId> getSettings(@ApiParam(value = "Get User Profile Settings by email id",required=true) @PathVariable("emailId") String emailId) throws Exception {
        String accept = request.getHeader("Accept");
        UserSettingsByEmailId userSettings=null;
        if (accept != null && accept.contains("application/json")) {
        	try {
        		userSettings= settingsServiceImpl.getSettings(emailId);
        		
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserSettingsByEmailId>(userSettings,HttpStatus.OK);
    }

}
