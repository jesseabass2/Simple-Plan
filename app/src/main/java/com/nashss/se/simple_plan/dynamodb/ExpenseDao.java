package com.nashss.se.simple_plan.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.simple_plan.dynamodb.models.Expense;

import javax.inject.Inject;

public class ExpenseDao {

    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public ExpenseDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Expense getExpense(String expenseId) {
        Expense expense = dynamoDBMapper.load(Expense.class, expenseId);
        if (expense == null) {
            throw new IllegalArgumentException("does not exist");
        }
        return expense;
    }
}