package com.javaj2eefsd.workshop.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.javaj2eefsd.workshop.model.Expense;
import com.javaj2eefsd.workshop.model.Income;
import com.javaj2eefsd.workshop.model.Investments;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Budget
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")

public class Budget   {
  @JsonProperty("Expense")
  @Valid
  private List<Expense> expense = null;

  @JsonProperty("Income")
  @Valid
  private List<Income> income = null;

  @JsonProperty("Investments")
  @Valid
  private List<Investments> investments = null;

  public Budget expense(List<Expense> expense) {
    this.expense = expense;
    return this;
  }

  public Budget addExpenseItem(Expense expenseItem) {
    if (this.expense == null) {
      this.expense = new ArrayList<Expense>();
    }
    this.expense.add(expenseItem);
    return this;
  }

  /**
   * Get expense
   * @return expense
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Expense> getExpense() {
    return expense;
  }

  public void setExpense(List<Expense> expense) {
    this.expense = expense;
  }

  public Budget income(List<Income> income) {
    this.income = income;
    return this;
  }

  public Budget addIncomeItem(Income incomeItem) {
    if (this.income == null) {
      this.income = new ArrayList<Income>();
    }
    this.income.add(incomeItem);
    return this;
  }

  /**
   * Get income
   * @return income
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Income> getIncome() {
    return income;
  }

  public void setIncome(List<Income> income) {
    this.income = income;
  }

  public Budget investments(List<Investments> investments) {
    this.investments = investments;
    return this;
  }

  public Budget addInvestmentsItem(Investments investmentsItem) {
    if (this.investments == null) {
      this.investments = new ArrayList<Investments>();
    }
    this.investments.add(investmentsItem);
    return this;
  }

  /**
   * Get investments
   * @return investments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Investments> getInvestments() {
    return investments;
  }

  public void setInvestments(List<Investments> investments) {
    this.investments = investments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Budget budget = (Budget) o;
    return Objects.equals(this.expense, budget.expense) &&
        Objects.equals(this.income, budget.income) &&
        Objects.equals(this.investments, budget.investments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expense, income, investments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Budget {\n");
    
    sb.append("    expense: ").append(toIndentedString(expense)).append("\n");
    sb.append("    income: ").append(toIndentedString(income)).append("\n");
    sb.append("    investments: ").append(toIndentedString(investments)).append("\n");
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

