package com.javaj2eefsd.workshop.service;

import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;

public interface SettingsService {
	UserSettingsByEmailId getSettings(String emailId) throws Exception;
	void  updateCurrency(UserCurrency usercurrencymodel) throws Exception;
	void  updatePassword(UserPassword userpasswordmodel) throws Exception;
	
}
