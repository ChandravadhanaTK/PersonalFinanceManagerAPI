package com.javaj2eefsd.workshop.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserSettingsByEmailId
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document(collection = "user")
public class UserSettingsByEmailId   {
  @Indexed(unique=true)
  @JsonProperty("emailId")
  @Email
  private String emailId = null;
  
  @Field(value="password")
  @JsonProperty("password")
  private String password = null;
  
  @Field(value="currency")
  @JsonProperty("currency")
  private String currency = null;

  public UserSettingsByEmailId emailId(String emailId) {
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

  public UserSettingsByEmailId password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserSettingsByEmailId currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserSettingsByEmailId userSettingsByEmailId = (UserSettingsByEmailId) o;
    return Objects.equals(this.emailId, userSettingsByEmailId.emailId) &&
        Objects.equals(this.password, userSettingsByEmailId.password) &&
        Objects.equals(this.currency, userSettingsByEmailId.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailId, password, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserSettingsByEmailId {\n");
    
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

