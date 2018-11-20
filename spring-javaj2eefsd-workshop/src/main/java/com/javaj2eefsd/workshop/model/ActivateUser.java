package com.javaj2eefsd.workshop.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Validated
@Document(collection="user")
public class ActivateUser {
	@Indexed(unique=true)
	@JsonProperty("emailId")
	@Email
	private String emailId = null;
	
	@JsonProperty("otp")
	private int otp;
	
	public ActivateUser emailId(String emailId) {
		this.emailId = emailId;
		return this;
	}
	
	/**
	 * Get emailId
	 * @return emailId
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public ActivateUser otp(int otp) {
		this.otp=otp;
		return this;
	}

	/**
	 * Get otp
	 * @return otp
	 **/
	@ApiModelProperty(required = true, value = "")
	@NotNull
	@Valid

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ActivateUser activateUser = (ActivateUser) o;
		return  Objects.equals(this.emailId, activateUser.emailId) &&
				Objects.equals(this.otp, activateUser.otp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, otp);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ActivateUser {\n");

		sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
		sb.append("    otp: ").append(toIndentedString(otp)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
