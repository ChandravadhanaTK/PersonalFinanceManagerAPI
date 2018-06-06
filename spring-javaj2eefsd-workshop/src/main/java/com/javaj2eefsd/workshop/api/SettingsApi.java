/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Api(value = "settings", description = "the settings API")
public interface SettingsApi {

    @ApiOperation(value = "find a unique user settings.", nickname = "getSettings", notes = "retrieve the user settings by specifying an emailId.", response = UserSettingsByEmailId.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "settings", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User profile settings successfully retrieved.", response = UserSettingsByEmailId.class),
        @ApiResponse(code = 404, message = "User profile settings failed to be retrieved.") })
    @RequestMapping(value = "/settings/{emailId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserSettingsByEmailId> getSettings(@ApiParam(value = "Get User Profile Settings by email id",required=true) @PathVariable("emailId") String emailId);

}
