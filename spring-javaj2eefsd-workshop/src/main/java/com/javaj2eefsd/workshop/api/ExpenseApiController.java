package com.javaj2eefsd.workshop.api;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.Expense;
import com.javaj2eefsd.workshop.service.IExpenseService;
import io.swagger.annotations.ApiParam;


@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
/***
 * @author sathsubramanian This is ExpenseApiController this class connect with expense module end point who where calld
 *         in webservice give the response for create ,update.delete,retrieve and search the expense details.
 */
@Controller
@CrossOrigin(origins = { "*" })
public class ExpenseApiController implements ExpenseApi {

    private static final Logger log = LoggerFactory.getLogger(ExpenseApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    // object for expense service
    @Autowired
    IExpenseService expenseServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public ExpenseApiController(final ObjectMapper objectMapper, final HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    /***
     * addExpense method help to create new expense getting data from front end and call the expense service to create
     * new expense data in db
     */
    @Override
    public ResponseEntity<Void> addExpense(
            @ApiParam(value = "Expense object that needs to be added to the store", required = true) @Valid @RequestBody final Expense body)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                // futhure we will get the user id session
                body.setLoginId("1");
                expenseServiceImpl.expenseCreatePost(body);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            catch (final IOException | RuntimeException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     * deleteExpense method help to delete expense data based on user inputs and this only soft deleted the expense data
     * and call the expense service to delete the data in db
     */
    @Override
    public ResponseEntity<Void> deleteExpense(
            @ApiParam(value = "Expense id to delete", required = true) @PathVariable("expenseId") final String expenseId)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                expenseServiceImpl.expenseDeleteDelete(expenseId);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (final IOException | RuntimeException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     * getExpenseByKey this method used to search the expense data based on user inputs and call the expense service to
     * retrieve the data in db
     *
     * @throws Exception
     */
    @Override
    public ResponseEntity<List<Expense>> getExpenseByKey(
            @NotNull @ApiParam(value = "ExpenseKey of expense to return", required = true) @Valid @RequestParam(value = "expenseKey", required = true) final String expenseKey)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                // make the value in session
                final String userId = "1";
                final List<Expense> searchList = expenseServiceImpl.expenseSearchGet(expenseKey, userId);
                return new ResponseEntity<>(searchList, HttpStatus.OK);

            }
            catch (final IOException | RuntimeException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    /***
     * getExpenseList this method used to get the login user expense data and non-deleted data and call the expense
     * service to retrieve the expense data
     */
    @Override
    public ResponseEntity<List<Expense>> getExpenseList()
            throws Exception {
        final String accept = request.getHeader("Accept");
        List<Expense> expenceList = null;
        if (accept != null && accept.contains("application/json")) {
            try {
                // make the value in session
                final String id = "1";
                expenceList = expenseServiceImpl.expenseAllGet(id);
                return new ResponseEntity<>(expenceList, (HttpStatus.OK));
            }
            catch (final IOException | RuntimeException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(expenceList, (HttpStatus.UNSUPPORTED_MEDIA_TYPE));
    }

    /***
     * updateExpense is used to update the expense data based on user action and call the expense service to update the
     * expense data
     */
    @Override
    public ResponseEntity<Void> updateExpense(
            @ApiParam(value = "Expense object that needs to be updated to the store", required = true) @Valid @RequestBody final Expense body)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                expenseServiceImpl.expenseUpdatePost(body);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            catch (final IOException | RuntimeException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @Override
    public ResponseEntity<Expense> getExpense(
            @ApiParam(value = "id to search for expense", required = true) @PathVariable("expenseId") final String expenseId)
            throws Exception {
        final String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                final Expense expenseObj = expenseServiceImpl.getExpense(expenseId);
                return new ResponseEntity<>(expenseObj, HttpStatus.OK);
            }
            catch (final IOException | RuntimeException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

}
