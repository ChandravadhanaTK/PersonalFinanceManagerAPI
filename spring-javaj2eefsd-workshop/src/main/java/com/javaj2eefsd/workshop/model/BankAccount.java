package com.javaj2eefsd.workshop.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * BankAccount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document
public class BankAccount {
  @Id
  @JsonProperty("bankAccountId")
  private String bankAccountId = null;

  @Indexed(unique=true)
  @JsonProperty("accountNumber")
  private BigDecimal accountNumber = null;

  @JsonProperty("accountHolderName")
  private String accountHolderName = null;

  @JsonProperty("accountType")
  private String accountType = null;

  @JsonProperty("bankName")
  private String bankName = null;

  @JsonProperty("ifscCode")
  private String ifscCode = null;
  
  @JsonProperty("createdBy")
  private String createdBy = null;
  
  @JsonProperty("updatedBy")
  private String updatedBy = null;
  
  @JsonProperty("isDelete")
  private Boolean isDelete = null;

  @JsonProperty("createdDate")
  private OffsetDateTime createdDate = null;

  @JsonProperty("updatedDate")
  private OffsetDateTime updatedDate = null;

  public BankAccount bankAccountId(String bankAccountId) {
    this.bankAccountId = bankAccountId;
    return this;
  }

  /**
   * Get bankAccountId
   * @return bankAccountId
  **/
  @ApiModelProperty(value = "")


  public String getBankAccountId() {
    return bankAccountId;
  }

  public void setBankAccountId(String bankAccountId) {
    this.bankAccountId = bankAccountId;
  }

  public BankAccount accountNumber(BigDecimal accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(BigDecimal accountNumber) {
    this.accountNumber = accountNumber;
  }

  public BankAccount accountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    return this;
  }

  /**
   * Get accountHolderName
   * @return accountHolderName
  **/
  @ApiModelProperty(value = "")


  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

  public BankAccount accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  **/
  @ApiModelProperty(value = "")


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public BankAccount bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  /**
   * Get bankName
   * @return bankName
  **/
  @ApiModelProperty(value = "")


  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public BankAccount ifscCode(String ifscCode) {
    this.ifscCode = ifscCode;
    return this;
  }

  /**
   * Get ifscCode
   * @return ifscCode
  **/
  @ApiModelProperty(value = "")


  public String getIfscCode() {
    return ifscCode;
  }

  public void setIfscCode(String ifscCode) {
    this.ifscCode = ifscCode;
  }
  
  public BankAccount createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Get createdBy
   * @return createdBy
  **/
  @ApiModelProperty(value = "")


  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }
  
  public BankAccount updatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  /**
   * Get updatedBy
   * @return updatedBy
  **/
  @ApiModelProperty(value = "")


  public String getUpdatedBy() {
    return createdBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }
  
  public BankAccount isDelete(Boolean isDelete) {
    this.isDelete = isDelete;
    return this;
  }

  /**
   * Get isDelete
   * @return isDelete
  **/
  @ApiModelProperty(value = "")


  public Boolean getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(Boolean isDelete) {
    this.isDelete = isDelete;
  }

  public BankAccount createdDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public BankAccount updatedDate(OffsetDateTime updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  /**
   * Get updatedDate
   * @return updatedDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(OffsetDateTime updatedDate) {
    this.updatedDate = updatedDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccount bankAccount = (BankAccount) o;
    return Objects.equals(this.bankAccountId, bankAccount.bankAccountId) &&
        Objects.equals(this.accountNumber, bankAccount.accountNumber) &&
        Objects.equals(this.accountHolderName, bankAccount.accountHolderName) &&
        Objects.equals(this.accountType, bankAccount.accountType) &&
        Objects.equals(this.bankName, bankAccount.bankName) &&
        Objects.equals(this.ifscCode, bankAccount.ifscCode) &&
        Objects.equals(this.createdBy, bankAccount.createdBy) &&
        Objects.equals(this.updatedBy, bankAccount.updatedBy) &&
        Objects.equals(this.isDelete, bankAccount.isDelete) &&
        Objects.equals(this.createdDate, bankAccount.createdDate) &&
        Objects.equals(this.updatedDate, bankAccount.updatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankAccountId, accountNumber, accountHolderName, accountType, bankName, ifscCode, createdBy, updatedBy, isDelete, createdDate, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccount {\n");
    
    sb.append("    bankAccountId: ").append(toIndentedString(bankAccountId)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountHolderName: ").append(toIndentedString(accountHolderName)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    ifscCode: ").append(toIndentedString(ifscCode)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    isDelete: ").append(toIndentedString(isDelete)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
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

