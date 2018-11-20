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
 * Investments
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document
public class Investments {
  @Id
  @JsonProperty("investmentsId")
  private String investmentsId = null;

  @JsonProperty("investmentsAmount")
  private Double investmentsAmount = null;

  @JsonProperty("investmentsType")
  private String investmentsType = null;

  @JsonProperty("investmentsDate")
  private OffsetDateTime investmentsDate = null;
  
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

  public Investments investmentsId(String investmentsId) {
    this.investmentsId = investmentsId;
    return this;
  }

  /**
   * Get investmentsId
   * @return investmentsId
  **/
  @ApiModelProperty(value = "")


  public String getInvestmentsId() {
    return investmentsId;
  }

  public void setInvestmentsId(String investmentsId) {
    this.investmentsId = investmentsId;
  }

  public Investments investmentsAmount(Double investmentsAmount) {
    this.investmentsAmount = investmentsAmount;
    return this;
  }

  /**
   * Get investmentsAmount
   * @return investmentsAmount
  **/
  @ApiModelProperty(value = "")


  public Double getInvestmentsAmount() {
    return investmentsAmount;
  }

  public void setInvestmentsAmount(Double investmentsAmount) {
    this.investmentsAmount = investmentsAmount;
  }

  public Investments investmentsType(String investmentsType) {
    this.investmentsType = investmentsType;
    return this;
  }

  /**
   * Get investmentsType
   * @return investmentsType
  **/
  @ApiModelProperty(value = "")


  public String getInvestmentsType() {
    return investmentsType;
  }

  public void setInvestmentsType(String investmentsType) {
    this.investmentsType = investmentsType;
  }

  public Investments investmentsDate(OffsetDateTime investmentsDate) {
    this.investmentsDate = investmentsDate;
    return this;
  }

  /**
   * Get investmentsDate
   * @return investmentsDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getInvestmentsDate() {
    return investmentsDate;
  }

  public void setInvestmentsDate(OffsetDateTime investmentsDate) {
    this.investmentsDate = investmentsDate;
  }
  
  public Investments createdBy(String createdBy) {
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
  
  public Investments updatedBy(String updatedBy) {
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
  
  public Investments isDelete(Boolean isDelete) {
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

  public Investments createdDate(OffsetDateTime createdDate) {
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

  public Investments updatedDate(OffsetDateTime updatedDate) {
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
    Investments investments = (Investments) o;
    return Objects.equals(this.investmentsId, investments.investmentsId) &&
        Objects.equals(this.investmentsAmount, investments.investmentsAmount) &&
        Objects.equals(this.investmentsType, investments.investmentsType) &&
        Objects.equals(this.investmentsDate, investments.investmentsDate) &&
        Objects.equals(this.createdBy, investments.createdBy) &&
        Objects.equals(this.updatedBy, investments.updatedBy) &&
        Objects.equals(this.isDelete, investments.isDelete) &&
        Objects.equals(this.createdDate, investments.createdDate) &&
        Objects.equals(this.updatedDate, investments.updatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(investmentsId, investmentsAmount, investmentsType, investmentsDate, createdBy, createdDate, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Investments {\n");
    
    sb.append("    investmentsId: ").append(toIndentedString(investmentsId)).append("\n");
    sb.append("    investmentsAmount: ").append(toIndentedString(investmentsAmount)).append("\n");
    sb.append("    investmentsType: ").append(toIndentedString(investmentsType)).append("\n");
    sb.append("    investmentsDate: ").append(toIndentedString(investmentsDate)).append("\n");
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

