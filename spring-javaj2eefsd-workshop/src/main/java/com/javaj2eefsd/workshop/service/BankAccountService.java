package com.javaj2eefsd.workshop.service;

import java.util.List;
import com.javaj2eefsd.workshop.model.BankAccount;

/**
 * @author Nagarjuna - BankAccountService interface used to validate the business logic and help to call the dao layer
 */
public interface BankAccountService {
	/**
     * getBankAccount method used to retrieve the BankAccount data from db
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
    BankAccount getBankAccount(String bankAccountId, String userId) throws Exception;
    
	/**
     * getBankAccountAll method used to retrieve the BankAccount data from db
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
    List<BankAccount> getBankAccountAll(String userId) throws Exception;

    /**
     * createBankAccount method used to create new BankAccount data in db
     *
     * @param BankAccountObj
     * @return
     * @throws Exception
     */
    BankAccount createBankAccount(BankAccount bankAccountObj) throws Exception;

    /**
     * deleteBankAccount method used to delete the BankAccount data based on user input
     *
     * @param BankAccountId
     * @return
     * @throws Exception
     */
    void deleteBankAccount(String bankAccountId, String userId) throws Exception;

    /**
     * searchBankAccount method used to search the BankAccount data based on user inputs
     *
     * @param BankAccountKey
     * @return
     * @throws Exception
     */
    List<BankAccount> searchBankAccount(String bankAccountKey, String userId) throws Exception;
}
