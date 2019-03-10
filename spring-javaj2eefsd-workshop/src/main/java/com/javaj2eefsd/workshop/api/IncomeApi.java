/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.javaj2eefsd.workshop.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.javaj2eefsd.workshop.model.Income;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Api(value = "income", description = "the income API")
public interface IncomeApi {

    @ApiOperation(value = "Create new income", nickname = "addIncome", notes = "Creates new income", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "income", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/income/new",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ApiResponseMessage> addIncome(
    		@ApiParam(value = "Income object that needs to be added to the store" ,required=true )  @Valid @RequestBody Income body)
			throws Exception;


    @ApiOperation(value = "Deletes a income", nickname = "deleteIncome", notes = "Deltes the income", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "income", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Income not found") })
    @RequestMapping(value = "/income/delete/{incomeId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<ApiResponseMessage> deleteIncome(
    		@ApiParam(value = "Income id to delete",required=true) @PathVariable("incomeId") String incomeId)
			throws Exception;
    
    
    @ApiOperation(value = "get income by id", nickname = "getIncome", notes = "Returns the particular income", response = Income.class, authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "income", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Income.class) })
    @RequestMapping(value = "/income/{incomeId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getIncome(
    		@ApiParam(value = "id to search for income",required=true) @PathVariable("incomeId") String incomeId)
    		throws Exception;
    
    
    @ApiOperation(value = "Searches income by incomeKey", nickname = "getIncomeByKey", notes = "Returns all income matching the incomeKey", response = Income.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "income", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Income.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Income not found") })
    @RequestMapping(value = "/income/search",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getIncomeByKey(
    		@NotNull @ApiParam(value = "Key to search for income", required = true) @Valid @RequestParam(value = "incomeKey", required = true) String incomeKey)
    		throws Exception;


    @ApiOperation(value = "incomes list", nickname = "getIncomeList", notes = "Returns the list of all incomes", response = Income.class, responseContainer = "List", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "income", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Income.class, responseContainer = "List") })
    @RequestMapping(value = "/income/all",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getIncomeList() throws Exception;


    @ApiOperation(value = "Update income", nickname = "updateIncome", notes = "Updates the income", authorizations = {
        @Authorization(value = "bearerAuth")
    }, tags={ "income", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Income not found"),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/income/edit",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ApiResponseMessage> updateIncome(
    		@ApiParam(value = "Income object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Income body)
			throws Exception;

}
