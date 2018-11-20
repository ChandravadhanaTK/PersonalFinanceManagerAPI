package com.javaj2eefsd.workshop.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.errormessageconfig.SettingsErrorMassage;
import com.javaj2eefsd.workshop.model.UserCurrency;
import com.javaj2eefsd.workshop.model.UserPassword;
import com.javaj2eefsd.workshop.model.UserSettingsByEmailId;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
@Repository
public class SettingsDaoImpl implements SettingsDao{


	private static final Logger log = LoggerFactory.getLogger(SettingsDaoImpl.class);

	@Autowired
	MongoTemplate mongoTemplate;
	@Override
	public UserSettingsByEmailId getSettings(String emailId) throws Exception {

		UserSettingsByEmailId userSettings = null;

		try {
			final Query query = new Query();
			query.addCriteria(Criteria.where("emailId").is(emailId));
			userSettings = mongoTemplate.findOne(query, UserSettingsByEmailId.class);


			if (userSettings == null) {
				throw new Exception(SettingsErrorMassage.INVALIDEMAILID);
			}
			log.info("successfuly excuted the query for UserSettingsByEmailId services");
		}
		catch (final Exception e) {
			throw new Exception(e.getMessage());
		}
		return userSettings;
	}

	@Override
	public void updateCurrency(UserCurrency usercurrencymodel)
			throws Exception {

		String emailId = usercurrencymodel.getEmailId();
		String newCurrency = usercurrencymodel.getNewCurrency();
		String oldCurrency = usercurrencymodel.getOldCurrency();
		final UpdateResult result;
		

		try {
			UserCurrency usercurrency=null;
			final Query query = new Query();
			query.addCriteria(Criteria.where("emailId").is(emailId));
			usercurrency = mongoTemplate.findOne(query, UserCurrency.class);
			final Update update = new Update();
			//System.out.println("Old currency"+oldCurrency );
			//System.out.println("New currency"+newCurrency);
			update.set("currency",newCurrency);
			result=mongoTemplate.updateFirst(query, update, UserCurrency.class);
			if (!result.isModifiedCountAvailable()) {
				log.info("somthing is wrong going to exception because of invalid values");
				throw new Exception(SettingsErrorMassage.INVALIDKEY);
			}
			
		}


	
	catch (final Exception e) {
		 log.error(e.getMessage());
		throw new Exception(e.getMessage());
	}
	//return new UserCurrency();
}



@Override
public void updatePassword(UserPassword userpasswordmodel)
		throws Exception {
	
	UserSettingsByEmailId currentusersettings=null;
	String emailId1 = userpasswordmodel.getEmailId();
	String newPassword = userpasswordmodel.getNewPassword();
	String confirmPassword = userpasswordmodel.getConfirmPassword();
	final UpdateResult result1;

	try {

		
		UserPassword userpassword=null;
		final Query query = new Query();
		query.addCriteria(Criteria.where("emailId").is(emailId1));
		userpassword = mongoTemplate.findOne(query, UserPassword.class);
		final Update update = new Update();
		System.out.println("new password"+newPassword);
		System.out.println("ConfirmPassword"+confirmPassword);
		update.set("password",newPassword);
		result1=mongoTemplate.updateFirst(query, update, UserPassword.class);
		if (!result1.isModifiedCountAvailable()) {
			log.info("somthing is wrong going to exception because of invalid values");
			throw new Exception(SettingsErrorMassage.INVALIDPASSWORD);
		}
			
			
		

	}
	catch (final Exception e) {

		throw new Exception(e.getMessage());
	}
	//return new UserPassword();
}

}


