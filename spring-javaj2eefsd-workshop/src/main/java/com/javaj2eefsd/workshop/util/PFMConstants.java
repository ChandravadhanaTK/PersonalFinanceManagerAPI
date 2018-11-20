package com.javaj2eefsd.workshop.util;

public class PFMConstants {
	//codes
	public static final int ERROR_CODE = 1;
	public static final int OK_CODE = 4;
    
	public static final String UNKNOWN_EXCEPTION = "Unknown exception";
	public static final String SEARCHKEYISNULL = "Search key is empty";
    public static final String INVALID_SEARCHKEY = "No data found for the given keywords";
    
	//Income messages
	public static final String INVALID_INCOMEID = "Invalid income id";
	public static final String SUCCESS_INCOME_ADD = "Successfully added income data";
	public static final String SUCCESS_INCOME_UPDATE = "Successfully updated income data";
	public static final String SUCCESS_INCOME_DELETE = "Successfully delete income data";
    
    //Investments messages
  	public static final String INVALID_INVESTMENTSID = "Invalid investments id";
  	public static final String SUCCESS_INVESTMENTS_ADD = "Successfully added investments data";
	public static final String SUCCESS_INVESTMENTS_UPDATE = "Successfully updated investments data";
	public static final String SUCCESS_INVESTMENTS_DELETE = "Successfully delete investments data";
  	
  	//Bank Account messages
  	public static final String INVALID_BANKACCOUNTID = "Invalid bank account id";
  	public static final String SUCCESS_BANKACCOUNT_ADD = "Successfully added bank account data";
	public static final String SUCCESS_BANKACCOUNT_DELETE = "Successfully delete bank account data";
	
	//Login messages
	public static final String INVALID_EMAILID_PASSWORD = "Invalid email address or password";
	public static final String USER_NOT_ACTIVE = "User not verified, Please verify your email address";
	
	//activate user
	public static final String INVALID_EMAILID = "Invalid email address";
	public static final String INVALID_OTP = "Invalid otp";
	public static final String SUCCESS_USER_ACTIVATED = "Successfully activated user";
	
	//register user
	public static final String INVALID_USER_EXISTS = "User exists with provided email address";
	public static final String SUCCESS_USER_CREATED = "Successfully created user";
}
