package com.javaj2eefsd.workshop.service;

import com.javaj2eefsd.workshop.model.User;

public interface RegisterService {
	
	public User registerUser(User registeruser) throws Exception;
	public void activateUser(String emailId, Integer otp) throws Exception;
	public void sendEmail(String emailId, Integer otp) throws Exception;

}
