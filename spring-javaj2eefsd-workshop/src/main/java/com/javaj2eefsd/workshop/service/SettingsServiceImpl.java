package com.javaj2eefsd.workshop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaj2eefsd.workshop.dao.SettingsDao;
import com.javaj2eefsd.workshop.errormessageconfig.SettingsErrorMassage;
import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;


@Service
public class SettingsServiceImpl implements SettingsService{
	// logger instance
	private static final Logger log = LoggerFactory.getLogger(SettingsServiceImpl.class);

	@Autowired
	SettingsDao settingsDaoImpl;
	@Override
	public UserSettingsByEmailId getSettings(String emailId) throws Exception {
		log.info("start UserSettingsByEmailId service");

		return settingsDaoImpl.getSettings(emailId);
	}
	@Override
	public void updateCurrency(UserCurrency usercurrencymodel)

			throws Exception {
		log.info("start updateCurrency service");

		String emailId = usercurrencymodel.getEmailId();
		String newCurrency = usercurrencymodel.getNewCurrency();
		String oldCurrency = usercurrencymodel.getOldCurrency();
		UserSettingsByEmailId currentsettings=null;
		try{
			currentsettings=settingsDaoImpl.getSettings(emailId);
			String CurrentCurrency=currentsettings.getCurrency();
		
	    if(newCurrency==CurrentCurrency)
		{
			throw new Exception(SettingsErrorMassage.SAMECURRENCY);		
		}
		else if(newCurrency==null)
		{
			throw new Exception(SettingsErrorMassage.INVALIDCURRENCY);		
		}
		else if(emailId==null)
		{
			throw new Exception(SettingsErrorMassage.INVALIDEMAILID);		
		}
		else{

			settingsDaoImpl.updateCurrency(usercurrencymodel);
		}
		}
		catch(Exception e){
			log.error("could not able to proceed updateCurrency services");
		}
		
		
	}


	@Override
	public void updatePassword(UserPassword userpasswordmodel)
			throws Exception {
		log.info("start updatePassword service");
		String emailId1 = userpasswordmodel.getEmailId();
		String newPassword = userpasswordmodel.getNewPassword();
		String confirmPassword = userpasswordmodel.getConfirmPassword();
		UserSettingsByEmailId currentsettings=null;

		try{
			currentsettings=settingsDaoImpl.getSettings(emailId1);
			String CurrentPassword=currentsettings.getPassword();


			if(emailId1==null)
			{
				throw new Exception(SettingsErrorMassage.INVALIDEMAILID);		
			}

			else if(CurrentPassword==newPassword)
			{
				throw new Exception(SettingsErrorMassage.SAMEPASSWORD);	 
			}

			else if(newPassword==confirmPassword)
			{
				throw new Exception(SettingsErrorMassage.PASSCNFMPASS);	 
			}

			else
			{
				settingsDaoImpl.updatePassword(userpasswordmodel);
			}
		}

		catch(Exception e){
			log.error("could not able to proceed updatePassword services");
		}
	}

}
