package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.dao.IncomeDao;
import com.javaj2eefsd.workshop.model.Income;

/**
 * @author Nagarjuna - IncomeService interface used to validate the business logic and help to call the dao layer
 */
@Service
public class IncomeServiceImpl implements IncomeService {
	// logger instance
    private static final Logger log = LoggerFactory.getLogger(IncomeServiceImpl.class);
    
	@Autowired
    IncomeDao incomeDaoImpl;
	
	/**
     * getIncome method used to retrieve the income data from db
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
	@Override
	public Income getIncome(String incomeId, String userId) throws Exception {
		log.info("[getIncome] start getIncome in Service");
		return incomeDaoImpl.getIncome(incomeId, userId);
	}
	
	/**
     * getIncomeAll method used to retrieve the income data from db
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
	@Override
    public List<Income> getIncomeAll(String userId) throws Exception {
		log.info("[getIncomeAll] start getIncomeAll in Service");
		return incomeDaoImpl.getIncomeAll(userId);
    }

    /**
     * createIncome method used to create new income data in db
     *
     * @param incomeObj
     * @return
     * @throws Exception
     */
    @Override
    public Income createIncome(Income incomeObj, String userId) throws Exception {
    	log.info("[createIncome] start createIncome in Service");
    	incomeObj.setCreatedDate(OffsetDateTime.now());
    	incomeObj.setUpdatedDate(OffsetDateTime.now());
    	incomeObj.setCreatedBy(userId);
    	incomeObj.setUpdatedBy(incomeObj.getCreatedBy());
    	incomeObj.setIsDelete(false);
    	log.info("[createIncome] update some fields before save");
        return incomeDaoImpl.createIncome(incomeObj);
    }

    /**
     * deleteIncome method used to delete the income data based on user input
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
    @Override
    public void deleteIncome(String incomeId, String userId) throws Exception {
    	log.info("[deleteIncome] start deleteIncome in Service");
    	incomeDaoImpl.deleteIncome(incomeId, userId);
    }

    /**
     * updateIncome method used to update the income data in db
     *
     * @param incomeObj
     * @return
     * @throws Exception
     */
    @Override
    public void updateIncome(Income incomeObj, String userId) throws Exception {
    	log.info("[updateIncome] start updateIncome in Service");
    	incomeObj.setUpdatedDate(OffsetDateTime.now());
    	incomeObj.setCreatedBy("1");
    	log.info("[updateIncome] update some fields before update");
    	incomeDaoImpl.updateIncome(incomeObj, userId);
    }

    /**
     * searchIncome method used to search the income data based on user inputs
     *
     * @param incomeKey
     * @return
     * @throws Exception
     */
    @Override
    public List<Income> searchIncome(String incomeKey, String userId) throws Exception {
    	log.info("[searchIncome] start searchIncome in Service");
    	return incomeDaoImpl.searchIncome(incomeKey, userId);
    }
}
