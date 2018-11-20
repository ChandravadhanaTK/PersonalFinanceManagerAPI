package com.javaj2eefsd.workshop.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;


/**
 * Expense
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T07:36:56.089+05:30")
@Document
public class Expense {
    @Id
    @JsonProperty("expense_id")
    private String expenseId = null;

    @JsonProperty("expense_amount")
    private Double expenseAmount = null;

    @JsonProperty("expense_type")
    private String expenseType = null;

    @JsonProperty("expense_date")
    private OffsetDateTime expenseDate = null;

    @JsonProperty("created_date")
    private OffsetDateTime createdDate = null;

    @JsonProperty("updated_date")
    private OffsetDateTime updatedDate = null;

    @JsonProperty("is_delete")
    private Boolean isDelete = null;

    @JsonProperty("create_by")
    private String createBy = null;

    @JsonProperty("update_by")
    private String updateBy = null;

    @JsonProperty("login_id")
    private String loginId = null;

    @JsonProperty("expense_name")
    private String expenseName = null;

    public Expense expenseId(final String expenseId) {
        this.expenseId = expenseId;
        return this;
    }

    /**
     * Get expenseId
     *
     * @return expenseId
     **/
    @ApiModelProperty(value = "")

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(final String expenseId) {
        this.expenseId = expenseId;
    }

    public Expense expenseAmount(final Double expenseAmount) {
        this.expenseAmount = expenseAmount;
        return this;
    }

    /**
     * Get expenseAmount
     *
     * @return expenseAmount
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(final Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Expense expenseType(final String expenseType) {
        this.expenseType = expenseType;
        return this;
    }

    /**
     * Get expenseType
     *
     * @return expenseType
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(final String expenseType) {
        this.expenseType = expenseType;
    }

    public Expense expenseDate(final OffsetDateTime expenseDate) {
        this.expenseDate = expenseDate;
        return this;
    }

    /**
     * Get expenseDate
     *
     * @return expenseDate
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public OffsetDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(final OffsetDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Expense createdDate(final OffsetDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     **/
    @ApiModelProperty(value = "")

    @Valid

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Expense updatedDate(final OffsetDateTime updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    /**
     * Get updatedDate
     *
     * @return updatedDate
     **/
    @ApiModelProperty(value = "")

    @Valid

    public OffsetDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(final OffsetDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Expense isDelete(final Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    /**
     * Get isDelete
     *
     * @return isDelete
     **/
    @ApiModelProperty(value = "")

    public Boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(final Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Expense createBy(final String createBy) {
        this.createBy = createBy;
        return this;
    }

    /**
     * Get createBy
     *
     * @return createBy
     **/
    @ApiModelProperty(value = "")

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(final String createBy) {
        this.createBy = createBy;
    }

    public Expense updateBy(final String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    /**
     * Get updBy
     *
     * @return updBy
     **/
    @ApiModelProperty(value = "")

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(final String updateBy) {
        this.updateBy = updateBy;
    }

    public Expense loginId(final String loginId) {
        this.loginId = loginId;
        return this;
    }

    /**
     * Get loginId
     *
     * @return loginId
     **/
    @ApiModelProperty(value = "")

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(final String loginId) {
        this.loginId = loginId;
    }

    public Expense expenseName(final String expenseName) {
        this.expenseName = expenseName;
        return this;
    }

    /**
     * Get expenseName
     *
     * @return expenseName
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(final String expenseName) {
        this.expenseName = expenseName;
    }

    @Override
    public boolean equals(final java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Expense expense = (Expense) o;
        return Objects.equals(expenseId, expense.expenseId) &&
                Objects.equals(expenseAmount, expense.expenseAmount) &&
                Objects.equals(expenseType, expense.expenseType) &&
                Objects.equals(expenseDate, expense.expenseDate) &&
                Objects.equals(createdDate, expense.createdDate) &&
                Objects.equals(updatedDate, expense.updatedDate) &&
                Objects.equals(isDelete, expense.isDelete) &&
                Objects.equals(createBy, expense.createBy) &&
                Objects.equals(updateBy, expense.updateBy) &&
                Objects.equals(loginId, expense.loginId) &&
                Objects.equals(expenseName, expense.expenseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseId, expenseAmount, expenseType, expenseDate, createdDate, updatedDate, isDelete,
                createBy, updateBy, loginId, expenseName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class Expense {\n");

        sb.append("    expenseId: ").append(toIndentedString(expenseId)).append("\n");
        sb.append("    expenseAmount: ").append(toIndentedString(expenseAmount)).append("\n");
        sb.append("    expenseType: ").append(toIndentedString(expenseType)).append("\n");
        sb.append("    expenseDate: ").append(toIndentedString(expenseDate)).append("\n");
        sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
        sb.append("    updatedDate: ").append(toIndentedString(updatedDate)).append("\n");
        sb.append("    isDelete: ").append(toIndentedString(isDelete)).append("\n");
        sb.append("    createBy: ").append(toIndentedString(createBy)).append("\n");
        sb.append("    updBy: ").append(toIndentedString(updateBy)).append("\n");
        sb.append("    loginId: ").append(toIndentedString(loginId)).append("\n");
        sb.append("    expenseName: ").append(toIndentedString(expenseName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(final java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
