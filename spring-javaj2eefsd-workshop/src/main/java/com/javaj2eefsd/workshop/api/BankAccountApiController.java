package com.javaj2eefsd.workshop.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
import com.javaj2eefsd.workshop.model.BankAccount;
import com.javaj2eefsd.workshop.service.BankAccountService;
import com.javaj2eefsd.workshop.util.PFMConstants;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
@CrossOrigin(origins = { "*" })
public class BankAccountApiController implements BankAccountApi {

    private static final Logger log = LoggerFactory.getLogger(BankAccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    BankAccountService bankAccountServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public BankAccountApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ApiResponseMessage> addBankAccount(
    		@ApiParam(value = "Bank Account object that needs to be added to the store" ,required=true )  @Valid @RequestBody BankAccount body)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	bankAccountServiceImpl.createBankAccount(body);
            }
            catch (final IOException e) {
            	
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            } catch (final Exception e) {
            	
            	log.error(e.getMessage());
            	return new ResponseEntity<ApiResponseMessage>(
            			new ApiResponseMessage(PFMConstants.ERROR_CODE, PFMConstants.UNKNOWN_EXCEPTION),
            			HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        return new ResponseEntity<ApiResponseMessage>(new ApiResponseMessage(
        		PFMConstants.OK_CODE, PFMConstants.SUCCESS_BANKACCOUNT_ADD),
        		HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseMessage> deleteBankAccount(
    		@ApiParam(value = "Bank Account id to delete",required=true) @PathVariable("bankAccountId") String bankAccountId)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        try {
        	//TODO: add user model instead of hard coding
            final String userId = "1";
        	bankAccountServiceImpl.deleteBankAccount(bankAccountId, userId);
        }
        catch (final ApiException e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(e.getCode(), e.getMessage()),
        			HttpStatus.BAD_REQUEST);
        } catch (final Exception e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(PFMConstants.ERROR_CODE, PFMConstants.UNKNOWN_EXCEPTION),
        			HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<ApiResponseMessage>(new ApiResponseMessage(
        		PFMConstants.OK_CODE, PFMConstants.SUCCESS_BANKACCOUNT_DELETE),
        		HttpStatus.OK);
    }
    
    public ResponseEntity<?> getBankAccount(
    		@ApiParam(value = "id to search for bankAccount",required=true) @PathVariable("bankAccountId") String bankAccountId)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        BankAccount bankAccountObj = null;
        
        try {
        	//TODO: add user model instead of hard coding
            final String userId = "1";
            bankAccountObj = bankAccountServiceImpl.getBankAccount(bankAccountId, userId);
            return new ResponseEntity<BankAccount>(bankAccountObj, HttpStatus.OK);
        } catch (final IOException e) {
        	
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (final ApiException e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(e.getCode(), e.getMessage()),
        			HttpStatus.BAD_REQUEST);
        } catch (final Exception e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(PFMConstants.ERROR_CODE, PFMConstants.UNKNOWN_EXCEPTION),
        			HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getBankAccountByKey(
    		@NotNull @ApiParam(value = "Key to search for Bank Accounts", required = true) @Valid @RequestParam(value = "bankAccountKey", required = true) String bankAccountKey)
    		throws Exception {

        final String accept = request.getHeader("Accept");
        List<BankAccount> bankAccountList = null;
        
    	try {
            //TODO: add user model instead of hard coding
            final String userId = "1";
            if(bankAccountKey == null || bankAccountKey.isEmpty())
            	bankAccountList = bankAccountServiceImpl.getBankAccountAll(userId);
            else
            	bankAccountList = bankAccountServiceImpl.searchBankAccount(bankAccountKey, userId);
        }
    	catch (final IOException e) {
        	
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (final ApiException e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(e.getCode(), e.getMessage()),
        			HttpStatus.BAD_REQUEST);
        } catch (final Exception e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(PFMConstants.ERROR_CODE, PFMConstants.UNKNOWN_EXCEPTION),
        			HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<BankAccount>>(bankAccountList, HttpStatus.OK);
    }

    public ResponseEntity<?> getBankAccountsList() throws Exception {
    	
    	final String accept = request.getHeader("Accept");
        List<BankAccount> bankAccountList = null;
        
    	try {
    		//TODO: add user model instead of hard coding
            final String userId = "1";
            bankAccountList = bankAccountServiceImpl.getBankAccountAll(userId);
        }
    	catch (final IOException e) {
        	
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (final ApiException e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(e.getCode(), e.getMessage()),
        			HttpStatus.BAD_REQUEST);
        } catch (final Exception e) {
        	
        	log.error(e.getMessage());
        	return new ResponseEntity<ApiResponseMessage>(
        			new ApiResponseMessage(PFMConstants.ERROR_CODE, PFMConstants.UNKNOWN_EXCEPTION),
        			HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<BankAccount>>(bankAccountList, HttpStatus.OK);
    }

}
