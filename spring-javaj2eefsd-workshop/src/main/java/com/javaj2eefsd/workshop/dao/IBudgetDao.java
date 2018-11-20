package com.javaj2eefsd.workshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import com.javaj2eefsd.workshop.model.Budget;
import com.javaj2eefsd.workshop.model.DateRange;

public interface IBudgetDao {

	//List<Budget> getAllBudget(DateRange body) throws Exception;
	JSONArray getAllBudget(DateRange body) throws Exception;

}
