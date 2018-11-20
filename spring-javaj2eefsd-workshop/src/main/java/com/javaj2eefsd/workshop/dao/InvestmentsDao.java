package com.javaj2eefsd.workshop.dao;

import java.util.List;
import com.javaj2eefsd.workshop.model.Investments;

/**
 * @author Nagarjuna - InvestmentsDao interface is used to connect java code in database and create,
 *         update, delete, retrieve and search income data.
 */
public interface InvestmentsDao {
	/**
     * getInvestments method used to retrieve the Investments data from db
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
    Investments getInvestments(String investmentsId, String userId) throws Exception;
    
	/**
     * getInvestmentsAll method used to retrieve the Investments data from db
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
    List<Investments> getInvestmentsAll(String userId) throws Exception;

    /**
     * createInvestments method used to create new Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
    Investments createInvestments(Investments investmentsObj) throws Exception;

    /**
     * deleteInvestments method used to delete the Investments data based on user input
     *
     * @param InvestmentsId
     * @return
     * @throws Exception
     */
    void deleteInvestments(String investmentsId, String userId) throws Exception;

    /**
     * updateInvestments method used to update the Investments data in db
     *
     * @param InvestmentsObj
     * @return
     * @throws Exception
     */
    Investments updateInvestments(Investments investmentsObj, String userId) throws Exception;

    /**
     * searchInvestments method used to search the Investments data based on user inputs
     *
     * @param InvestmentsKey
     * @return
     * @throws Exception
     */
    List<Investments> searchInvestments(String investmentsKey, String userId) throws Exception;
}
