package com.nashss.se.simple_plan.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.nashss.se.simple_plan.converters.LocalDateConverter;

import java.time.LocalDate;
import java.util.Date;

/**
 * Represents an expense in the expenses table.
 */
@DynamoDBTable(tableName = "expenses")
public class Expense {

    public static final String CATEGORY_GSI = "CategoryExpenseIdIndex";

    public static final String EXPENSE_DATE_GSI = "DateOfExpensesIndex";

    private String expenseId;

    private String category;

    private double amount;

    private LocalDate date;

    private String note;

    @DynamoDBAttribute(attributeName = "expenseID")
    public String getExpenseId() {
        return expenseId;
    }
    public void setExpenseID(String expenseId) {
        this.expenseId = expenseId;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName= CATEGORY_GSI)
    @DynamoDBAttribute(attributeName = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @DynamoDBRangeKey(attributeName = "amount")
    public double  getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @DynamoDBHashKey(attributeName = "date")
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @DynamoDBAttribute(attributeName = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
