package com.nashss.se.simple_plan.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;
import java.util.Objects;

/**
 * Represents an expense in the expenses table.
 */
@DynamoDBTable(tableName = "expenses")
public class Expense {

    private String expenseID;

    private String category;

    private double amount;

    private Date date;

    private String note;

    @DynamoDBAttribute(attributeName = "expenseID")
    public String getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    @DynamoDBRangeKey(attributeName = "category")
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
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
