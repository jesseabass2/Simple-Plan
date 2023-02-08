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

    private Double budgetedAmountForCategory;

    private Boolean goalToSave;

    @DynamoDBHashKey(attributeName = "category_name")
    public String getCategoryName() {return categoryName;}

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }






}
