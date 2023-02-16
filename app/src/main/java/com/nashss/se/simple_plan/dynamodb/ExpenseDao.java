package com.nashss.se.simple_plan.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.simple_plan.dynamodb.models.Expense;

import javax.inject.Inject;

public class ExpenseDao {

    private final DynamoDBMapper dynamoDBMapper;

    private static final int PAGE_SIZE = 20;

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

    public void saveExpense(Expense newExpense) {
        this.dynamoDBMapper.save(newExpense);

    }

//    public List<Expense> getAllExpenses(String expenseId, String category, Date date, Boolean forward) {
//        Map<String, AttributeValue> startKeyMap = new HashMap<>();
//        Map<String, AttributeValue> valueMap = new HashMap<>();
//
//
//        DynamoDBQueryExpression<Expense> queryExpression = new DynamoDBQueryExpression<Expense>()
//                .withScanIndexForward(forward)
//                .withLimit(PAGE_SIZE)
//                .withExclusiveStartKey(startKeyMap)
//                .withExpressionAttributeValues(valueMap)
//                .withConsistentRead(false);
//
//        if (category != null) {
//            startKeyMap.put("category", new AttributeValue().withS(category));
//            valueMap.put(":category", new AttributeValue().withS(category));
//
//            queryExpression.setIndexName(Expense.CATEGORY_GSI);
//            queryExpression.setKeyConditionExpression("category = :category");
//        } else {
//            startKeyMap.put("expenseId", new AttributeValue().withS(expenseId));
//
//        }
//        startKeyMap.put("expenseId", new AttributeValue().withS(expenseId));
//        String newExpenseId = (expenseId.length() < 7) ? "0" :
//                expenseId.substring(expenseId.length() - 5);
//        startKeyMap.put("employeeId", new AttributeValue().withS(newExpenseId));
//
//
//        return dynamoDBMapper.queryPage(Expense.class, queryExpression).getResults();
//
//
//    }

}