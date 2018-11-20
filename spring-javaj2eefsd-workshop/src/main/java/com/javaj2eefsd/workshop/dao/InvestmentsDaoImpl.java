package com.javaj2eefsd.workshop.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.api.ApiException;
import com.javaj2eefsd.workshop.model.Investments;
import com.javaj2eefsd.workshop.util.PFMConstants;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * @author Nagarjuna - InvestmentsDao class is used to connect java code in database and create,
 *         update, delete, retrieve and search income data.
 */
@Repository
public class InvestmentsDaoImpl implements InvestmentsDao {
	// logger instance
    private static final Logger log = LoggerFactory.getLogger(InvestmentsDaoImpl.class);
    
	@Autowired
    MongoTemplate mongoTemplate;
	
	/**
     * getInvestments method used to retrieve the Investments data from db
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
	@Override
	public Investments getInvestments(String investmentsId, String userId) throws Exception {
		log.info("[getInvestments] Start getInvestments method in DAO");
		Investments investmentsObj = null;
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("investmentsId").is(investmentsId));
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            investmentsObj = mongoTemplate.findOne(query, Investments.class);
            log.info("[getInvestments] Successfully executed query");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
		
		Optional.ofNullable(investmentsObj).orElseThrow(() -> new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_INVESTMENTSID));
		return investmentsObj;
	}
	
	/**
     * getInvestmentsAll method used to retrieve the Investments data from db
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
	@Override
    public List<Investments> getInvestmentsAll(String userId) throws Exception {
		log.info("[getInvestmentsAll] Start getInvestmentsAll method in DAO");
		List<Investments> investmentsList = null;
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            investmentsList = mongoTemplate.find(query, Investments.class);
            log.info("[getInvestmentsAll] Successfully executed query");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        
        return investmentsList;
    }

    /**
     * createInvestments method used to create new Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
	@Override
    public Investments createInvestments(Investments investmentsObj) throws Exception {
		log.info("[createInvestments] Start createInvestments method in DAO");
		try {
            mongoTemplate.save(investmentsObj);
            log.info("[createInvestments] Successfully saved data");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
		
        return investmentsObj;
	}

    /**
     * deleteInvestments method used to delete the Investments data based on user input
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
	@Override
    public void deleteInvestments(String investmentsId, String userId) throws Exception {
		log.info("[deleteInvestments] Start deleteInvestments method in DAO");
		final UpdateResult result;
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("investmentsId").is(investmentsId));
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            final Update update = new Update();
            update.set("isDelete", true);
            result = mongoTemplate.updateFirst(query, update, Investments.class);
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
		
		if (!result.isModifiedCountAvailable()) {
            log.info("[deleteInvestments] Somthing is wrong throwing exception");
            throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_INVESTMENTSID);
        }
        log.info("[deleteInvestments] Successfully deleted data");
	}

    /**
     * updateInvestments method used to update the Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
	@Override
    public Investments updateInvestments(Investments investmentsObj, String userId) throws Exception {
		log.info("[updateInvestments] Start updateInvestments method in DAO");
		final UpdateResult result;
		try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("investmentsId").is(investmentsObj.getInvestmentsId()));
            query.addCriteria(Criteria.where("isDelete").is(false));
            query.addCriteria(Criteria.where("createdBy").is(userId));
            final Update update = new Update();
            update.set("investmentsAmount", investmentsObj.getInvestmentsAmount());
            update.set("investmentsType", investmentsObj.getInvestmentsType());
            update.set("investmentsDate", investmentsObj.getInvestmentsDate());
            update.set("updatedDate", investmentsObj.getUpdatedDate());
            update.set("updatedBy", investmentsObj.getUpdatedBy());
            result = mongoTemplate.updateFirst(query, update, Investments.class);
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
		
		if (!result.isModifiedCountAvailable()) {
            log.info("[updateInvestments] Somthing is wrong throwing exception");
            throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_INVESTMENTSID);
        }
        log.info("[updateInvestments] Successfully updated data");
		
        return investmentsObj;
	}

    /**
     * searchInvestments method used to search the Investments data based on user inputs
     *
     * @param InvestmentsKey
     * @return
     * @throws Exception
     */
	@Override
    public List<Investments> searchInvestments(String investmentsKey, String userId) throws Exception {
		log.info("[searchInvestments] Start searchInvestments method in DAO");
		List<Investments> searchList = null;
        int amount = 0;
        // check the key is number or not
        if (investmentsKey.matches("-?\\d+(\\.\\d+)?")) {
            amount = Integer.parseInt(investmentsKey);
        }
        log.info("[searchInvestments] Validate the search key field");
        try {
            final Query query = new Query();
            query.addCriteria(Criteria.where("isDelete").is(false).andOperator(Criteria.where("createdBy").is(userId))
                    .orOperator(Criteria.where("investmentsAmount").is(amount),
                            Criteria.where("investmentsType").is(investmentsKey),
                            Criteria.where("investmentsDate").is(investmentsKey)));
            query.with(new Sort(Sort.Direction.DESC, "investmentsId"));
            searchList = mongoTemplate.find(query, Investments.class);
            log.info("[searchInvestments] Successfully executed query");
        }
        catch (final Exception e) {
        	log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        
        if (searchList.isEmpty() || searchList.size() == 0) {
        	throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_SEARCHKEY);
        }
        
        return searchList;
	}
}
