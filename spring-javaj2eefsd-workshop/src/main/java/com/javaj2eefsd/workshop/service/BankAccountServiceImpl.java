package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.dao.BankAccountDao;
import com.javaj2eefsd.workshop.model.BankAccount;

/**
 * @author Nagarjuna - BankAccountService interface used to validate the business logic and help to call the dao layer
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {
	// logger instance
    private static final Logger log = LoggerFactory.getLogger(BankAccountServiceImpl.class);
	
	@Autowired
	BankAccountDao bankAccountDaoImpl;
	
	/**
     * getBankAccount method used to retrieve the BankAccount data from db
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
    public BankAccount getBankAccount(String bankAccountId, String userId) throws Exception {
    	log.info("[getBankAccount] start getBankAccount in Service");
		return bankAccountDaoImpl.getBankAccount(bankAccountId, userId);
    }
	
	/**
     * getBankAccountAll method used to retrieve the BankAccount data from db
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
	@Override
    public List<BankAccount> getBankAccountAll(String userId) throws Exception {
		log.info("[getBankAccountAll] start getBankAccountAll in Service");
		return bankAccountDaoImpl.getBankAccountAll(userId);
    }

    /**
     * createBankAccount method used to create new BankAccount data in db
     *
     * @param BankAccountObj
     * @return
     * @throws Exception
     */
    @Override
    public BankAccount createBankAccount(BankAccount bankAccountObj) throws Exception {
    	log.info("[createBankAccount] start createBankAccount in Service");
    	bankAccountObj.setCreatedDate(OffsetDateTime.now());
    	bankAccountObj.setUpdatedDate(OffsetDateTime.now());
    	bankAccountObj.setCreatedBy("1");
    	bankAccountObj.setUpdatedBy(bankAccountObj.getCreatedBy());
    	bankAccountObj.setIsDelete(false);
    	log.info("[createBankAccount] update some fields before save");
        return bankAccountDaoImpl.createBankAccount(bankAccountObj);
    }

    /**
     * deleteBankAccount method used to delete the BankAccount data based on user input
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
    @Override
    public void deleteBankAccount(String bankAccountId, String userId) throws Exception {
    	log.info("[deleteBankAccount] start deleteBankAccount in Service");
    	bankAccountDaoImpl.deleteBankAccount(bankAccountId, userId);
    }

    /**
     * searchBankAccount method used to search the BankAccount data based on user inputs
     *
     * @param BankAccountKey
     * @return
     * @throws Exception
     */
    @Override
    public List<BankAccount> searchBankAccount(String bankAccountKey, String userId) throws Exception {
    	log.info("[searchBankAccount] start searchBankAccount in Service");
    	return bankAccountDaoImpl.searchBankAccount(bankAccountKey, userId);
    }
}
