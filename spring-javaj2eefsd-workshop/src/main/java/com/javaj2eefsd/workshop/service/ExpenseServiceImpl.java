/**
 *
 */
package com.javaj2eefsd.workshop.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;
import com.javaj2eefsd.workshop.dao.IExpenseDao;
import com.javaj2eefsd.workshop.model.Expense;


/**
 * @author sathsubramanian ExpenseService class used to validate the business logic and help to call the dao layer
 */
@Service
public class ExpenseServiceImpl implements IExpenseService {
    // logger instance
    private static final Logger log = LoggerFactory.getLogger(ExpenseServiceImpl.class);

    // create object from IExpenseDao
    @Autowired
    IExpenseDao expenseDaoImpl;

    /**
     * expenseAllGet method used to retrieve the login user data and non-deleted data help to call dao methods
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public List<Expense> expenseAllGet(final String userId) throws Exception {
        log.info("start expenseAllGet service");
        return expenseDaoImpl.expenseAllGet(userId);
    }

    /**
     * expenseCreatePost method used to create new expense data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public Expense expenseCreatePost(final Expense expenseObj) throws Exception {
        log.info("start expenseCreatePost in service ");
        expenseObj.setCreatedDate(OffsetDateTime.now());
        expenseObj.setUpdatedDate(OffsetDateTime.now());
        expenseObj.setCreateBy("sathish");
        expenseObj.setUpdateBy("sathish");
        expenseObj.setIsDelete(false);
        log.info("update the some field in  expenseCreatePost method in  service ");
        return expenseDaoImpl.expenseCreatePost(expenseObj);
    }

    /**
     * expenseDeleteDelete method used to delete the expense data based on user input
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public void expenseDeleteDelete(final String id) throws Exception {
        log.info("start expenseDeleteDelete in service ");
        expenseDaoImpl.expenseDeleteDelete(id);

    }

    /**
     * expenseUpdatePost method used to update the expense data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public Expense expenseUpdatePost(final Expense expenseObj) throws Exception {
        log.info("start expenseUpdatePost in service ");
        expenseObj.setUpdatedDate(OffsetDateTime.now());
        return expenseDaoImpl.expenseUpdatePost(expenseObj);
    }

    /**
     * expenseSearchGet method used to search the expense data based on user inputs
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    @Override
    public List<Expense> expenseSearchGet(final String key, final String userId) throws Exception {
        log.info("start expenseSearchGet in service ");
        return expenseDaoImpl.expenseSearchGet(key, userId);
    }

    @Override
    public Expense getExpense(final String expenseId) throws Exception {
        log.info("start getExpense in service ");
        return expenseDaoImpl.getExpense(expenseId);
    }

}
