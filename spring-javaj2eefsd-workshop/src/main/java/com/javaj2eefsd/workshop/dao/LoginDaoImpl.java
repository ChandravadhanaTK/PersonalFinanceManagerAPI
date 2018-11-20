package com.javaj2eefsd.workshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.javaj2eefsd.workshop.api.ApiException;
import com.javaj2eefsd.workshop.model.UserDetail;
import com.javaj2eefsd.workshop.util.PFMConstants;
import com.javaj2eefsd.workshop.util.PasswordHasher;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserDetail getLogin(final UserDetail userdetail) throws Exception {
    	UserDetail loginuser = null;
    	try {
            final Query query = new Query();
            query.addCriteria(
                    Criteria.where("emailId").is(userdetail.getEmailId()));
            loginuser = mongoTemplate.findOne(query, UserDetail.class);
        }
        catch (final Exception e) {
            throw new Exception(e.getMessage());
        }
    	
    	if (loginuser == null)
            throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_EMAILID_PASSWORD);
    	else if(!PasswordHasher.checkPassword(userdetail.getPassword(), loginuser.getPassword()))
    		throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_EMAILID_PASSWORD);
        else if (loginuser.getUserStatus() == false)
        	throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.USER_NOT_ACTIVE);

        return userdetail;
    }

}
