package com.nashss.se.simple_plan.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.simple_plan.dynamodb.models.Category;

import javax.inject.Inject;

public class CategoryDao {
    private final DynamoDBMapper dynamoDBMapper;

//    private static final int PAGE_SIZE = 10;

    @Inject
    public CategoryDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
    

    public void saveCategory(Category category) {
        this.dynamoDBMapper.save(category);
    }
}
