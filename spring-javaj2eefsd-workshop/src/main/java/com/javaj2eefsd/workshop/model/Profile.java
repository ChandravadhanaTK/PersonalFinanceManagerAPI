package com.javaj2eefsd.workshop.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Profile
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document(collection="user")
public class Profile   {

	
	
  @Field(value="firstName")
  @JsonProperty("firstName")
  private String firstName = null;

  @Field(value="lastName")
  @JsonProperty("lastName")
  private String lastName = null;

  @Field(value="emailId")
  @JsonProperty("emailId")
  private String emailId = null;

  @Field(value="mobileNumber")
  @JsonProperty("mobileNumber")
  private String contactNumber = null;

  @Field(value="companyName")
  @JsonProperty("companyName")
  private String companyName = null;

  @Field(value="profileImage")
  @JsonProperty("profileImage")
  private String profileImage = null;

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Profile lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Profile emaiId(String emaiId) {
    this.emailId = emaiId;
    return this;
  }

  /**
   * Get emaiId
   * @return emaiId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmaiId() {
    return emailId;
  }

  public void setEmaiId(String emaiId) {
    this.emailId = emaiId;
  }

  public Profile contactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
    return this;
  }

  /**
   * Get contactNumber
   * @return contactNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public Profile companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  /**
   * Get companyName
   * @return companyName
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public Profile profileImage(String profileImage) {
    this.profileImage = profileImage;
    return this;
  }

  /**
   * Get profileImage
   * @return profileImage
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getProfileImage() {
    return profileImage;
  }

  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profile profile = (Profile) o;
    return Objects.equals(this.firstName, profile.firstName) &&
        Objects.equals(this.lastName, profile.lastName) &&
        Objects.equals(this.emailId, profile.emailId) &&
        Objects.equals(this.contactNumber, profile.contactNumber) &&
        Objects.equals(this.companyName, profile.companyName) &&
        Objects.equals(this.profileImage, profile.profileImage);
    
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, emailId, contactNumber, companyName, profileImage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profile {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    emaiId: ").append(toIndentedString(emailId)).append("\n");
    sb.append("    contactNumber: ").append(toIndentedString(contactNumber)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    profileImage: ").append(toIndentedString(profileImage)).append("\n");
    
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

