package com.javaj2eefsd.workshop.dao;

import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.javaj2eefsd.workshop.api.ApiException;
import com.javaj2eefsd.workshop.model.User;
import com.javaj2eefsd.workshop.util.PFMConstants;
import com.javaj2eefsd.workshop.util.PasswordHasher;

@Repository
public class RegisterDaoImpl implements RegisterDao {

	// logger instance
	private static final Logger log = LoggerFactory.getLogger(RegisterDaoImpl.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public User registerUser(User registeruser) throws Exception  {
		// TODO Auto-generated method stub
		int otp = generateOTP();
		try {
			registeruser.setPassword(PasswordHasher.hashPassword(registeruser.getPassword().trim()));
			//Setting user status to False
			registeruser.setUserStatus(false);
			registeruser.setOtp(otp);
			mongoTemplate.save(registeruser);
			this.sendEmail(registeruser.getEmailId(),registeruser.getOtp());
		}
		catch (DuplicateKeyException e) {
			throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_USER_EXISTS);
		}

		return registeruser;
	}

	@Override
	public void activateUser(String emailId, Integer otp) throws Exception {
		User registeruser = null;

		log.info(emailId+ "OTP" +otp );
		final Query query = new Query();
		query.addCriteria(Criteria.where("emailId").is(emailId));
		registeruser = mongoTemplate.findOne(query, User.class);
		
		Optional.ofNullable(registeruser).orElseThrow(() -> new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_EMAILID));
		
		if(otp == registeruser.getOtp()) {
			//Updating the user status starts here
			final Update update = new Update();
			update.set("userStatus", true);
			mongoTemplate.updateFirst(query, update, User.class);
		} else {
			throw new ApiException(PFMConstants.ERROR_CODE, PFMConstants.INVALID_OTP);
		}
		
		//Updating the user status ends here
		log.info(" After update :: "+" userId ==> "+emailId + " otp ==> "+otp + registeruser.getOtp()+" "+registeruser.getLastName());
	}

	public void sendEmail(String emailId, Integer otp) throws Exception {
		// TODO Auto-generated method stub

		final String username = "pfmsupp@gmail.com";
		final String password = "pfm@admin";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pfmsupp@gmail"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emailId));
			message.setSubject("Personal Finance Manager - Registration OTP");
			message.setText("Dear User"
					+ "\n\n Welcome to PFM! \n\n Your OTP: "+otp+" \n\n Thanks \n\n PFM Support");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public int generateOTP() {
		Random r = new Random();
		return r.nextInt(999999);
	}

}
