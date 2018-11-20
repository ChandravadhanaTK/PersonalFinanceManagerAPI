package com.javaj2eefsd.workshop.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserDetail
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

@Document(collection="user")
public class UserDetail   {

  @Indexed(unique=true)
  @JsonProperty("emailId")
  private String emailId = null;
  
  @JsonProperty("password")
  private String password = null;
  
  @JsonProperty("userStatus")
  private boolean userStatus = false;


  public UserDetail emailId(String emailId) {
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

  public UserDetail password(String password) {
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
  
  public UserDetail userStatus(boolean userStatus) {
    this.userStatus = userStatus;
    return this;
  }

  /**
   * Get userStatus
   * @return userStatus
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public boolean getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(boolean userStatus) {
    this.userStatus = userStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDetail userDetail = (UserDetail) o;
    return Objects.equals(this.emailId, userDetail.emailId) &&
        Objects.equals(this.userStatus, userDetail.userStatus) &&
        Objects.equals(this.password, userDetail.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailId, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetail {\n");
    
    sb.append("    emailId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
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

