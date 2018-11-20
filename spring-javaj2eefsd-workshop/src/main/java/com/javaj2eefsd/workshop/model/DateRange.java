package com.javaj2eefsd.workshop.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DateRange
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

public class DateRange   {
  @JsonProperty("fromExpenseDate")
  private OffsetDateTime fromExpenseDate = null;

  @JsonProperty("toExpenseDate")
  private OffsetDateTime toExpenseDate = null;
  
  @JsonProperty("budgetType")
  private String budgetType = null;

  public String getBudgetType() {
	return budgetType;
}

public void setBudgetType(String budgetType) {
	this.budgetType = budgetType;
}

public DateRange fromExpenseDate(OffsetDateTime fromExpenseDate) {
    this.fromExpenseDate = fromExpenseDate;
    return this;
  }

  /**
   * Get fromExpenseDate
   * @return fromExpenseDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getFromExpenseDate() {
    return fromExpenseDate;
  }

  public void setFromExpenseDate(OffsetDateTime fromExpenseDate) {
    this.fromExpenseDate = fromExpenseDate;
  }

  public DateRange toExpenseDate(OffsetDateTime toExpenseDate) {
    this.toExpenseDate = toExpenseDate;
    return this;
  }

  /**
   * Get toExpenseDate
   * @return toExpenseDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getToExpenseDate() {
    return toExpenseDate;
  }

  public void setToExpenseDate(OffsetDateTime toExpenseDate) {
    this.toExpenseDate = toExpenseDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DateRange dateRange = (DateRange) o;
    return Objects.equals(this.fromExpenseDate, dateRange.fromExpenseDate) &&
        Objects.equals(this.toExpenseDate, dateRange.toExpenseDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromExpenseDate, toExpenseDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DateRange {\n");
    
    sb.append("    fromExpenseDate: ").append(toIndentedString(fromExpenseDate)).append("\n");
    sb.append("    toExpenseDate: ").append(toIndentedString(toExpenseDate)).append("\n");
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

