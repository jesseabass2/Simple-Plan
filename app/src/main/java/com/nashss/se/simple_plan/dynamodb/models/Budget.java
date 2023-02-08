package com.nashss.se.simple_plan.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

/**
 * Represents a given budget in the budgets table.
 */
@DynamoDBTable(tableName = "budgets")
public class Budget {
    private String budgetName;
    private double totalIncome;
    private double totalExpenses;
    private double totalBudgeted;
    private double fundsAvailable;


    @DynamoDBHashKey(attributeName = "budgetName")
    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    @DynamoDBAttribute(attributeName = "totalIncome")
    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    @DynamoDBAttribute(attributeName = "totalExpenses")
    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    @DynamoDBAttribute(attributeName = "totalBudgeted")
    public double getTotalBudgeted() {
        return totalBudgeted;
    }

    public void setTotalBudgeted(double totalBudgeted) {
        this.totalBudgeted = totalBudgeted;
    }

    @DynamoDBAttribute(attributeName = "fundsAvailable")
    public double getFundsAvailable() {
        return fundsAvailable;
    }

    public void setFundsAvailable(double fundsAvailable) {
        this.fundsAvailable = fundsAvailable;
    }

}
