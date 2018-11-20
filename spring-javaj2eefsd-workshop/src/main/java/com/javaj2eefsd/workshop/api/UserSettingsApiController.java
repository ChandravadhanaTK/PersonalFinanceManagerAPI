package com.javaj2eefsd.workshop.api;

import io.swagger.annotations.ApiParam;

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
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;
import com.javaj2eefsd.workshop.service.SettingsService;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
@CrossOrigin(origins = { "*" })
public class UserSettingsApiController implements UserSettingsApi {

    private static final Logger log = LoggerFactory.getLogger(UserSettingsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserSettingsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Autowired
    SettingsService settingsSeriveImpl;
    
    public ResponseEntity<UserSettingsByEmailId> userCurrencyUpdate(@ApiParam(value = "User Profile Settings - Change Currency." ,required=true )  @Valid @RequestBody UserCurrency usercurrencymodel) throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	settingsSeriveImpl.updateCurrency(usercurrencymodel);  
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.OK);
    }

    public ResponseEntity<UserSettingsByEmailId> userPasswordUpdate(@ApiParam(value = "User Profile Settings - Change Password." ,required=true )  @Valid @RequestBody UserPassword userpasswordmodel) throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	settingsSeriveImpl.updatePassword(userpasswordmodel);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserSettingsByEmailId>(HttpStatus.OK);
    }



}
