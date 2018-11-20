package com.javaj2eefsd.workshop.api;

import com.javaj2eefsd.workshop.model.Budget;
import com.javaj2eefsd.workshop.model.DateRange;
import com.javaj2eefsd.workshop.service.IBudgetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
@CrossOrigin(origins = { "*" })
public class BudgetApiController implements BudgetApi {

    private static final Logger log = LoggerFactory.getLogger(BudgetApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    IBudgetService budgetServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public BudgetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    @Override
    //public ResponseEntity<List<Budget>> getByDate(@ApiParam(value = "Returns a income, expense, investments over the dateRange." ,required=true )  @Valid @RequestBody final DateRange body) throws Exception {
    public ResponseEntity<JSONArray> getByDate(@ApiParam(value = "Returns a income, expense, investments over the dateRange." ,required=true )  @Valid @RequestBody final DateRange body) throws Exception {
    	final String accept = request.getHeader("Accept");
    	//List<Budget> budgetList = null;
    	JSONArray budgetList = null;
        if (accept != null && accept.contains("application/json")) {
            try {
            	budgetList = budgetServiceImpl.getBudgetByDate(body);
                //return new ResponseEntity<List<Budget>>(objectMapper.readValue("{  \"Expense\" : [ {    \"create_by\" : \"create_by\",    \"login_id\" : \"login_id\",    \"expenseAmount\" : 0.8008281904610115,    \"expenseType\" : \"expenseType\",    \"expense_name\" : \"expense_name\",    \"expenseId\" : \"expenseId\",    \"created_date\" : \"2000-01-23T04:56:07.000+00:00\",    \"updated_date\" : \"2000-01-23T04:56:07.000+00:00\",    \"upd_by\" : \"upd_by\",    \"expenseDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"is_delete\" : true  }, {    \"create_by\" : \"create_by\",    \"login_id\" : \"login_id\",    \"expenseAmount\" : 0.8008281904610115,    \"expenseType\" : \"expenseType\",    \"expense_name\" : \"expense_name\",    \"expenseId\" : \"expenseId\",    \"created_date\" : \"2000-01-23T04:56:07.000+00:00\",    \"updated_date\" : \"2000-01-23T04:56:07.000+00:00\",    \"upd_by\" : \"upd_by\",    \"expenseDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"is_delete\" : true  } ],  \"Investments\" : [ {    \"investmentsAmount\" : 0.8008281904610115,    \"investmentsDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"investmentsId\" : \"investmentsId\",    \"investmentsType\" : \"investmentsType\"  }, {    \"investmentsAmount\" : 0.8008281904610115,    \"investmentsDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"investmentsId\" : \"investmentsId\",    \"investmentsType\" : \"investmentsType\"  } ],  \"Income\" : [ {    \"incomeId\" : \"incomeId\",    \"incomeType\" : \"incomeType\",    \"incomeAmount\" : 0.8008281904610115,    \"incomeDate\" : \"2000-01-23T04:56:07.000+00:00\"  }, {    \"incomeId\" : \"incomeId\",    \"incomeType\" : \"incomeType\",    \"incomeAmount\" : 0.8008281904610115,    \"incomeDate\" : \"2000-01-23T04:56:07.000+00:00\"  } ]}", Budget.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        //return new ResponseEntity<Budget>(HttpStatus.NOT_IMPLEMENTED);
        //return new ResponseEntity<Budget>(HttpStatus.OK);
        return new ResponseEntity<JSONArray>(budgetList, HttpStatus.OK);
    }

}

