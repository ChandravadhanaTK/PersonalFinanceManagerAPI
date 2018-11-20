package com.javaj2eefsd.workshop.model;

import java.util.Objects;
import javax.validation.Valid;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Income
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document
public class Income {
  @Id
  @JsonProperty("incomeId")
  private String incomeId = null;

  @JsonProperty("incomeAmount")
  private Double incomeAmount = null;

  @JsonProperty("incomeType")
  private String incomeType = null;

  @JsonProperty("incomeDate")
  private OffsetDateTime incomeDate = null;
  
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

  public Income incomeId(String incomeId) {
    this.incomeId = incomeId;
    return this;
  }

  /**
   * Get incomeId
   * @return incomeId
  **/
  @ApiModelProperty(value = "")


  public String getIncomeId() {
    return incomeId;
  }

  public void setIncomeId(String incomeId) {
    this.incomeId = incomeId;
  }

  public Income incomeAmount(Double incomeAmount) {
    this.incomeAmount = incomeAmount;
    return this;
  }

  /**
   * Get incomeAmount
   * @return incomeAmount
  **/
  @ApiModelProperty(value = "")


  public Double getIncomeAmount() {
    return incomeAmount;
  }

  public void setIncomeAmount(Double incomeAmount) {
    this.incomeAmount = incomeAmount;
  }

  public Income incomeType(String incomeType) {
    this.incomeType = incomeType;
    return this;
  }

  /**
   * Get incomeType
   * @return incomeType
  **/
  @ApiModelProperty(value = "")


  public String getIncomeType() {
    return incomeType;
  }

  public void setIncomeType(String incomeType) {
    this.incomeType = incomeType;
  }

  public Income incomeDate(OffsetDateTime incomeDate) {
    this.incomeDate = incomeDate;
    return this;
  }

  /**
   * Get incomeDate
   * @return incomeDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getIncomeDate() {
    return incomeDate;
  }

  public void setIncomeDate(OffsetDateTime incomeDate) {
    this.incomeDate = incomeDate;
  }
  
  public Income createdBy(String createdBy) {
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
  
  public Income updatedBy(String updatedBy) {
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
  
  public Income isDelete(Boolean isDelete) {
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

  public Income createdDate(OffsetDateTime createdDate) {
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

  public Income updatedDate(OffsetDateTime updatedDate) {
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
    Income income = (Income) o;
    return Objects.equals(this.incomeId, income.incomeId) &&
        Objects.equals(this.incomeAmount, income.incomeAmount) &&
        Objects.equals(this.incomeType, income.incomeType) &&
        Objects.equals(this.incomeDate, income.incomeDate) &&
        Objects.equals(this.createdBy, income.createdBy) &&
        Objects.equals(this.updatedBy, income.updatedBy) &&
        Objects.equals(this.isDelete, income.isDelete) &&
        Objects.equals(this.createdDate, income.createdDate) &&
        Objects.equals(this.updatedDate, income.updatedDate);
  }

  @Override
  public int hashCode() {
	return Objects.hash(incomeId, incomeAmount, incomeType, incomeDate, createdBy, createdDate, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Income {\n");
    
    sb.append("    incomeId: ").append(toIndentedString(incomeId)).append("\n");
    sb.append("    incomeAmount: ").append(toIndentedString(incomeAmount)).append("\n");
    sb.append("    incomeType: ").append(toIndentedString(incomeType)).append("\n");
    sb.append("    incomeDate: ").append(toIndentedString(incomeDate)).append("\n");
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

