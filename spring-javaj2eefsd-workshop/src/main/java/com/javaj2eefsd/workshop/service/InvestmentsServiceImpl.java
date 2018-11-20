package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.dao.InvestmentsDao;
import com.javaj2eefsd.workshop.model.Investments;

/**
 * @author Nagarjuna - InvestmentsService interface used to validate the business logic and help to call the dao layer
 */
@Service
public class InvestmentsServiceImpl implements InvestmentsService {
	// logger instance
    private static final Logger log = LoggerFactory.getLogger(InvestmentsServiceImpl.class);
    
	@Autowired
	InvestmentsDao investmentsDaoImpl;
	
	/**
     * getInvestments method used to retrieve the Investments data from db
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
    public Investments getInvestments(String investmentsId, String userId) throws Exception {
    	log.info("[getInvestments] start getInvestments in Service");
		return investmentsDaoImpl.getInvestments(investmentsId, userId);
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
		log.info("[getInvestmentsAll] start getInvestmentsAll in Service");
		return investmentsDaoImpl.getInvestmentsAll(userId);
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
    	log.info("[createInvestments] start createInvestments in Service");
    	investmentsObj.setCreatedDate(OffsetDateTime.now());
    	investmentsObj.setUpdatedDate(OffsetDateTime.now());
    	investmentsObj.setCreatedBy("1");
    	investmentsObj.setUpdatedBy(investmentsObj.getCreatedBy());
    	investmentsObj.setIsDelete(false);
    	log.info("[IncomeServiceImpl] [createInvestments] update some fields before save");
        return investmentsDaoImpl.createInvestments(investmentsObj);
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
    	log.info("[deleteInvestments] start deleteInvestments in Service");
    	investmentsDaoImpl.deleteInvestments(investmentsId, userId);
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
    	log.info("[updateInvestments] start updateInvestments in Service");
    	investmentsObj.setUpdatedDate(OffsetDateTime.now());
    	investmentsObj.setCreatedBy("1");
    	log.info("[IncomeServiceImpl] [updateInvestments] update some fields before update");
        return investmentsDaoImpl.updateInvestments(investmentsObj, userId);
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
    	log.info("[searchInvestments] start searchInvestments in Service");
    	return investmentsDaoImpl.searchInvestments(investmentsKey, userId);
    }
}
