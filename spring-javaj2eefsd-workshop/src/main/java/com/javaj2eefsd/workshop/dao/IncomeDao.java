package com.javaj2eefsd.workshop.dao;

import java.util.List;
import com.javaj2eefsd.workshop.model.Income;

/**
 * @author Nagarjuna - IncomeDao interface is used to connect java code in database and create,
 *         update, delete, retrieve and search income data.
 */
public interface IncomeDao {
	/**
     * getIncome method used to retrieve the income data from db
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
    Income getIncome(String incomeId, String userId) throws Exception;
    
	/**
     * getIncomeAll method used to retrieve the income data from db
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
    List<Income> getIncomeAll(String userId) throws Exception;

    /**
     * createIncome method used to create new income data in db
     *
     * @param incomeObj
     * @return
     * @throws Exception
     */
    Income createIncome(Income incomeObj) throws Exception;

    /**
     * deleteIncome method used to delete the income data based on user input
     *
     * @param incomeId
     * @return
     * @throws Exception
     */
    void deleteIncome(String incomeId, String userId) throws Exception;

    /**
     * updateIncome method used to update the income data in db
     *
     * @param incomeObj
     * @return
     * @throws Exception
     */
    void updateIncome(Income incomeObj, String userId) throws Exception;

    /**
     * searchIncome method used to search the income data based on user inputs
     *
     * @param incomeKey
     * @return
     * @throws Exception
     */
    List<Income> searchIncome(String incomeKey, String userId) throws Exception;
}
