package com.javaj2eefsd.workshop.dao;

import com.javaj2eefsd.workshop.model.User;

public interface RegisterDao {
	public User registerUser(User registeruser) throws Exception;
	public void activateUser(String emailId, Integer otp) throws Exception;
	

}
