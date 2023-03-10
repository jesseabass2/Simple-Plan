package com.nashss.se.simple_plan.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.simple_plan.dynamodb.models.Budget;

import javax.inject.Inject;

public class BudgetDao {
    private final DynamoDBMapper dyanDynamoDBMapper;

    @Inject
    public BudgetDao(DynamoDBMapper dyanDynamoDBMapper) {
        this.dyanDynamoDBMapper = dyanDynamoDBMapper;
    }

    public void saveBudget(Budget newBudget) {
    }
}
