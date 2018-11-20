package com.javaj2eefsd.workshop.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.time.format.DateTimeFormatter;
import java.text.ParseException; 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.logging.Level; 
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.model.Budget;
import com.javaj2eefsd.workshop.model.DateRange;
import com.javaj2eefsd.workshop.model.Expense;
import com.javaj2eefsd.workshop.model.Income;
import com.javaj2eefsd.workshop.model.Investments;

@Repository
public class BudgetDaoImpl implements IBudgetDao {
	
	// create object from MongoTemplate
    @Autowired
    MongoTemplate mongoTemplate;
	private List<Expense> expenseList;
	private List<Income> incomeList;
	private List<Investments> investmentsList;
	private List<Budget> budgetList;

	HashMap <Long, Double> expenseMap = new HashMap <Long, Double> ();
	HashMap <Long, Double> incomeMap = new HashMap <Long, Double> ();
	HashMap <Long, Double> investmentMap = new HashMap <Long, Double> ();
	HashMap <Long, Double> budgetMap = new HashMap <Long, Double> ();
	double TotalIncome = 0.0;
	double TotalInvestment = 0.0;
	double TotalExpense = 0.0;
	@Override
	//public List<Budget> getAllBudget(DateRange body) throws Exception {
	public JSONArray getAllBudget(DateRange body) throws Exception {
		ArrayList investmentLists = new ArrayList<>();
		ArrayList incomeLists = new ArrayList<>();	
		ArrayList expenseLists = new ArrayList<>();
		ArrayList MoneyFlowLists = new ArrayList<>();
		
		budgetList = null;
		Date dateFromDate = new Date(body.getFromExpenseDate().toInstant().toEpochMilli());
		Date dateToDate = new Date(body.getToExpenseDate().toInstant().toEpochMilli());
		try {
			final Query query = new Query();
            //query.addCriteria(Criteria.where("isDelete").is(false));
            //query.addCriteria(Criteria.where("loginId").is(body));	
            query.addCriteria(
            		Criteria.where("isDelete").is(false).andOperator(
            	        Criteria.where("createdDate.dateTime").gte(dateFromDate),
            	        Criteria.where("createdDate.dateTime").lte(dateToDate)
            	    )
            	);
            expenseList = mongoTemplate.find(query, Expense.class);
            incomeList = mongoTemplate.find(query, Income.class);
            investmentsList = mongoTemplate.find(query, Investments.class);
            budgetList = (List)expenseList;            
        	
            System.out.println("Investment List");
        	for (int i = 0; i < investmentsList.size(); i++) {
        		long Tdate = convertDateFormat(investmentsList.get(i).getCreatedDate().toLocalDate().toString());
        		System.out.println("postconversion Date: " + Tdate );
        		Double Amount = investmentsList.get(i).getInvestmentsAmount();
        		investmentMap.put( Tdate, investmentMap.containsKey(Tdate) ? (investmentMap.get(Tdate) + Amount) : Amount);
        		System.out.println(investmentMap);
        	}
        	
            for (HashMap.Entry <Long, Double> entry : investmentMap.entrySet()) 
            {
            	ArrayList dummy = new ArrayList<>();
                Long key = entry.getKey();
                Object value = entry.getValue();
                dummy.add(key); dummy.add(value);
                TotalInvestment+= (double) value;
                System.out.println("[" + key + "," + value +"]");
                investmentLists.add(dummy);
            }
            investmentMap.clear();
            
        	System.out.println("Income List");
        	for (int i = 0; i < incomeList.size(); i++) {
        		long Tdate = convertDateFormat(incomeList.get(i).getCreatedDate().toLocalDate().toString());
        		System.out.println("postconversion Date: " + Tdate );
        		Double Amount = incomeList.get(i).getIncomeAmount();
        		incomeMap.put( Tdate, incomeMap.containsKey(Tdate) ? (incomeMap.get(Tdate) + Amount) : Amount);
        		System.out.println(incomeMap);
        	}
        	
            for (HashMap.Entry <Long, Double> entry : incomeMap.entrySet()) 
            {
            	ArrayList dummy = new ArrayList<>();
                Long key = entry.getKey();
                Object value = entry.getValue();
                dummy.add(key); dummy.add(value);
                TotalIncome += (double) value;
                System.out.println("[" + key + "," + value +"]");
                incomeLists.add(dummy);
            }
            incomeMap.clear();

        	System.out.println("Expense List");
        	for (int i = 0; i < expenseList.size(); i++) {
        		long Tdate = convertDateFormat(expenseList.get(i).getCreatedDate().toLocalDate().toString());
        		System.out.println("postconversion Date: " + Tdate );
        		Double Amount = expenseList.get(i).getExpenseAmount();
        		expenseMap.put( Tdate, expenseMap.containsKey(Tdate) ? (expenseMap.get(Tdate) + Amount) : Amount);
        		System.out.println(expenseMap);
        	}
        	
            for (HashMap.Entry <Long, Double> entry : expenseMap.entrySet()) 
            {
            	ArrayList dummy = new ArrayList<>();
                Long key = entry.getKey();
                Object value = entry.getValue();
                dummy.add(key); dummy.add(value);
                TotalExpense += (double) value;
                System.out.println("[" + key + "," + value +"]");
                expenseLists.add(dummy);
            }
            expenseMap.clear();
        	
     	   
            ArrayList dummy = new ArrayList();
            dummy.add("From");
            dummy.add("To");
            dummy.add("Amount");
            MoneyFlowLists.add(dummy);
            
            ArrayList dummy1 = new ArrayList();
            dummy1.add("Income");
            dummy1.add("Expense");
            dummy1.add(TotalExpense);
            MoneyFlowLists.add(dummy1);
   
            ArrayList dummy2 = new ArrayList();
            dummy2.add("Income");
            dummy2.add("Investement");
            dummy2.add(TotalInvestment);
            MoneyFlowLists.add(dummy2);

            double balance = TotalIncome - TotalExpense + TotalInvestment;
            if (balance > 0)
            {
            	ArrayList dummy3 = new ArrayList();
            	dummy3.add("Income");
                dummy3.add("Balance");
                dummy3.add(balance);
                MoneyFlowLists.add(dummy3);
            }
        	
            System.out.println(TotalIncome);
            System.out.println(TotalInvestment);
            System.out.println(TotalExpense);
            
            TotalIncome = 0;
            TotalInvestment = 0;
            TotalExpense = 0;
            
		} catch(final Exception e) {
			throw new Exception(e.getMessage());
		}

		JSONObject jo = new JSONObject();
		JSONObject jo1 = new JSONObject();
		JSONArray ja = new JSONArray();
		
		System.out.println(body.getBudgetType());
		if(body.getBudgetType().equalsIgnoreCase("Investment")) {
			jo.put("name", "Investment");
			jo.put("data", investmentLists);
			ja.add(jo);
		} else if(body.getBudgetType().equalsIgnoreCase("Income")) {
			jo.put("name", "Income");
			jo.put("data", incomeLists);
			ja.add(jo);
		} else if(body.getBudgetType().equalsIgnoreCase("Expense")) {
			jo.put("name", "Expense");
			jo.put("data", expenseLists);
			ja.add(jo);
			//expenseLists.clear();
		} else if(body.getBudgetType().equalsIgnoreCase("Income Vs Expense")) {
			jo.put("name", "Income");
			jo.put("data", incomeLists);
			ja.add(0, jo);
			jo1.put("name", "Expense");
			jo1.put("data", expenseLists);
			ja.add(1, jo1);
		} else if(body.getBudgetType().equalsIgnoreCase("Income Vs Investment")) {
			jo.put("name", "Income");
			jo.put("data", incomeLists);
			ja.add(0, jo);
			jo1.put("name", "Investment");
			jo1.put("data", investmentLists);
			ja.add(1, jo1);
		} 
		else if(body.getBudgetType().equalsIgnoreCase("Money Flow")) {
			jo.put("data", MoneyFlowLists);
			ja.add(0, jo);	
		}
		return ja;
	}
	
    private static long convertDateFormat (String dateStr)
	{
        String formatStr = "yyyy-MM-dd";
        String format2 = null;
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        
        //String dateStr = "2017/01/31";
        
        try {
            Date formatted = format.parse(dateStr);
            System.out.println("Input Date: " + formatted);
            return formatted.getTime();
            //String formatStr1 = "dd-MM-yyyy";
            //format = new SimpleDateFormat(formatStr1);
            //format2 = format.format(formatted);
            //System.out.println("Output Date: " + format2);
            
            
        } catch (ParseException ex) {
            Logger.getLogger(BudgetDaoImpl.class.getName()).log(Level.SEVERE, ex.getMessage());
            return 0;
        }
        //return format2;

	}

}

