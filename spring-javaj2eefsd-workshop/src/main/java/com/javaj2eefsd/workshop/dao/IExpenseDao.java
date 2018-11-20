package com.javaj2eefsd.workshop.dao;

import java.util.List;
import com.javaj2eefsd.workshop.model.Expense;


/**
 * @author sathsubramanian IExpenseDao interface is used to connect java code in database and create
 *         ,update.delete,retrieve and search expense data.
 */
public interface IExpenseDao {
    /**
     * expenseAllGet method used to retrieve the login user data and non-deleted data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    List<Expense> expenseAllGet(String userId) throws Exception;

    /**
     * expenseCreatePost method used to create new expense data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    Expense expenseCreatePost(Expense expenseObj) throws Exception;

    /**
     * expenseDeleteDelete method used to delete the expense data based on user input
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    void expenseDeleteDelete(String id) throws Exception;

    /**
     * expenseUpdatePost method used to update the expense data in db
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    Expense expenseUpdatePost(Expense expenseObj) throws Exception;

    /**
     * expenseSearchGet method used to search the expense data based on user inputs
     *
     * @param userId
     * @param expenseId
     * @return
     * @throws Exception
     */
    List<Expense> expenseSearchGet(String key, String userId) throws Exception;

    /**
     * This method get the expense data based on expense id
     *
     * @param expenseId
     * @return
     * @throws Exception
     */
    Expense getExpense(String expenseId) throws Exception;
}
