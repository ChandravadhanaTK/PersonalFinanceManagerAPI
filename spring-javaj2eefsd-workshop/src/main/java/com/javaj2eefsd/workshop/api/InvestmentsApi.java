/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.Investments;
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

@Api(value = "investments", description = "the investments API")
public interface InvestmentsApi {

    @ApiOperation(value = "Create new investments", nickname = "addInvestments", notes = "Creates new investments", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "investments", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/investments/new",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> addInvestments(@ApiParam(value = "Investments object that needs to be added to the store" ,required=true )  @Valid @RequestBody Investments body);


    @ApiOperation(value = "Deletes a investments", nickname = "deleteInvestments", notes = "Deletes the investments", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "investments", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Investments not found") })
    @RequestMapping(value = "/investments/delete/{investmentsId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteInvestments(@ApiParam(value = "Investments id to delete",required=true) @PathVariable("investmentsId") String investmentsId);


    @ApiOperation(value = "Find all Investments matching by investmentsKey", nickname = "getInvestmentsByKey", notes = "Returns investments matching the investmentsKey", response = Investments.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "investments", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Investments.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Investments not found") })
    @RequestMapping(value = "/investments/{investmentsKey}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Investments>> getInvestmentsByKey(@ApiParam(value = "ID of investments to return",required=true) @PathVariable("investmentsKey") String investmentsKey);


    @ApiOperation(value = "investments list", nickname = "getInvestmentsList", notes = "Returns the list of investments", response = Investments.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "investments", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Investments.class, responseContainer = "List") })
    @RequestMapping(value = "/investments/all",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Investments>> getInvestmentsList();


    @ApiOperation(value = "Update investments", nickname = "updateInvestments", notes = "Updates the investments", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "investments", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Investments not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/investments/edit",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> updateInvestments(@ApiParam(value = "Investments object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Investments body);

}
