package com.javaj2eefsd.workshop.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.keycloak.RSATokenVerifier;
import org.keycloak.representations.AccessToken;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaj2eefsd.workshop.model.Income;
import com.javaj2eefsd.workshop.service.IncomeService;
import com.javaj2eefsd.workshop.util.PFMConstants;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Controller
@CrossOrigin(origins = { "*" })
public class IncomeApiController implements IncomeApi {

    private static final Logger log = LoggerFactory.getLogger(IncomeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    IncomeService incomeServiceImpl;

    @org.springframework.beans.factory.annotation.Autowired
    public IncomeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ApiResponseMessage> addIncome(
    		@ApiParam(value = "Income object that needs to be added to the store" ,required=true )  @Valid @RequestBody Income body,
    		@RequestHeader(value="Authorization") String token)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	AccessToken accessToken = RSATokenVerifier.create(token.replace("Bearer ","")).getToken();
                final String userId = accessToken.getSubject();
            	incomeServiceImpl.createIncome(body, userId);
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
        		PFMConstants.OK_CODE, PFMConstants.SUCCESS_INCOME_ADD),
        		HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseMessage> deleteIncome(
    		@ApiParam(value = "Income id to delete",required=true) @PathVariable("incomeId") String incomeId,
    		@RequestHeader(value="Authorization") String token)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        try {
        	AccessToken accessToken = RSATokenVerifier.create(token.replace("Bearer ","")).getToken();
            final String userId = accessToken.getSubject();
        	incomeServiceImpl.deleteIncome(incomeId, userId);
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
        		PFMConstants.OK_CODE, PFMConstants.SUCCESS_INCOME_DELETE),
        		HttpStatus.OK);
    }
    
    public ResponseEntity<?> getIncome(
    		@ApiParam(value = "id to search for income",required=true) @PathVariable("incomeId") String incomeId,
    		@RequestHeader(value="Authorization") String token)
    		throws Exception {
    	
    	final String accept = request.getHeader("Accept");
    	Income incomeObj = null;
    	
        try {
        	AccessToken accessToken = RSATokenVerifier.create(token.replace("Bearer ","")).getToken();
            final String userId = accessToken.getSubject();
        	incomeObj = incomeServiceImpl.getIncome(incomeId, userId);
        	return new ResponseEntity<Income>(incomeObj, HttpStatus.OK);
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

    public ResponseEntity<?> getIncomeByKey(
    		@NotNull @ApiParam(value = "Key to search for income", required = true) @Valid @RequestParam(value = "incomeKey", required = true) String incomeKey,
    		@RequestHeader(value="Authorization") String token)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        List<Income> incomeList = null;
        
    	try {
    		AccessToken accessToken = RSATokenVerifier.create(token.replace("Bearer ","")).getToken();
            final String userId = accessToken.getSubject();
            if(incomeKey == null || incomeKey.isEmpty())
            	incomeList = incomeServiceImpl.getIncomeAll(userId);
            else
            	incomeList = incomeServiceImpl.searchIncome(incomeKey, userId);
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

        return new ResponseEntity<List<Income>>(incomeList, HttpStatus.OK);
    }

    public ResponseEntity<?> getIncomeList(@RequestHeader(value="Authorization") String token) throws Exception {
    	
        final String accept = request.getHeader("Accept");
        List<Income> incomeList = null;
        
    	try {
    		AccessToken accessToken = RSATokenVerifier.create(token.replace("Bearer ","")).getToken();
            final String userId = accessToken.getSubject();
            incomeList = incomeServiceImpl.getIncomeAll(userId);
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

        return new ResponseEntity<List<Income>>(incomeList, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseMessage> updateIncome(
    		@ApiParam(value = "Income object that needs to be updated to the store" ,required=true )  @Valid @RequestBody Income body,
    		@RequestHeader(value="Authorization") String token)
    		throws Exception {
    	
        final String accept = request.getHeader("Accept");
        
        if (accept != null && accept.contains("application/json")) {
            try {
            	AccessToken accessToken = RSATokenVerifier.create(token.replace("Bearer ","")).getToken();
                final String userId = accessToken.getSubject();
            	incomeServiceImpl.updateIncome(body, userId);
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
        } else {
        	return new ResponseEntity<>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        }
        
        return new ResponseEntity<ApiResponseMessage>(new ApiResponseMessage(
        		PFMConstants.OK_CODE, PFMConstants.SUCCESS_INCOME_UPDATE),
        		HttpStatus.OK);
    }

}
