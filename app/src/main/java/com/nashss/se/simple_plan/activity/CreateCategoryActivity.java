package com.nashss.se.simple_plan.activity;

import com.nashss.se.simple_plan.activity.requests.CreateCategoryRequest;
import com.nashss.se.simple_plan.activity.results.CreateCategoryResult;
import com.nashss.se.simple_plan.dynamodb.CategoryDao;
import com.nashss.se.simple_plan.dynamodb.models.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateCategoryActivity {

    private final Logger log = LogManager.getLogger();

    private final CategoryDao  categoryDao;

    @Inject
    public CreateCategoryActivity(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CreateCategoryResult handleCategoryRequest(CreateCategoryRequest createCategoryRequest) {
        log.info("Received Create Category Request {}", createCategoryRequest);

        Category category = new Category();
        category.setCategoryName(createCategoryRequest.getCategoryName());
        category.setBudgetedAmount(createCategoryRequest.getBudgetedAmount());
        category.setGoalToSave(createCategoryRequest.getGoalToSave());

        categoryDao.saveCategory(category);

        return CreateCategoryResult.builder()
                .withCategory(category)
                .build();
    }
}
