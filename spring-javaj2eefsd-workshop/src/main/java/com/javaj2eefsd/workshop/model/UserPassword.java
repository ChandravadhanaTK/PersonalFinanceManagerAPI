package com.javaj2eefsd.workshop.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserPassword
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document(collection="user")
public class UserPassword   {
  @JsonProperty("emailId")
  private String emailId = null;
  
  @Field(value="password")
  @JsonProperty("newPassword")
  private String newPassword = null;
  @Transient
  @JsonProperty("confirmPassword")
  private String confirmPassword = null;

  public UserPassword emailId(String emailId) {
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

  public UserPassword newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  /**
   * Get newPassword
   * @return newPassword
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public UserPassword confirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }

  /**
   * Get confirmPassword
   * @return confirmPassword
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPassword userPassword = (UserPassword) o;
    return Objects.equals(this.emailId, userPassword.emailId) &&
        Objects.equals(this.newPassword, userPassword.newPassword) &&
        Objects.equals(this.confirmPassword, userPassword.confirmPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailId, newPassword, confirmPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPassword {\n");
    
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
    sb.append("    confirmPassword: ").append(toIndentedString(confirmPassword)).append("\n");
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

