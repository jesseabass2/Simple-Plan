package com.nashss.se.simple_plan.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

/**
 * Represents a category in the categories table.
 */
@DynamoDBTable(tableName = "categories")
public class Category {

    private String categoryName;

    private double budgetedAmount;

    private Boolean goalToSave;

    @DynamoDBHashKey(attributeName = "category_name")
    public String getCategoryName() {return categoryName;}

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @DynamoDBAttribute(attributeName = "budgeted_amount")
    public double getBudgetedAmount() {
        return budgetedAmount;
    }

    public void setBudgetedAmount(double budgetedAmount) {
        this.budgetedAmount = budgetedAmount;
    }

    @DynamoDBAttribute(attributeName = "goal_to_save")
    public boolean getGoalToSave() {
        return goalToSave;
    }

    public void setGoalToSave(boolean goalToSave) {
        this.goalToSave = goalToSave;
    }
}
