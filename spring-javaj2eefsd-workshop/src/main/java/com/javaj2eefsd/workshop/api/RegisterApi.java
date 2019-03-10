/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.javaj2eefsd.workshop.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaj2eefsd.workshop.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Api(value = "register", description = "the register API")
public interface RegisterApi {

    @ApiOperation(value = "Register user.", nickname = "registerUser", notes = "Register user to the database. All fields are required fields. Password must be encrypted.", response = User.class, tags={ "register", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User information successfully added to database.", response = User.class),
        @ApiResponse(code = 404, message = "User Registration Failed.") })
    @RequestMapping(value = "/register/new",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ApiResponseMessage> registerUser(@ApiParam(value = "User registration." ,required=true )  @Valid @RequestBody User body) throws Exception;

}
