package com.nashss.se.simple_plan.activity.results;

import com.nashss.se.simple_plan.dynamodb.models.Category;
import com.nashss.se.simple_plan.models.CategoryModel;

public class CreateCategoryResult {

    private final CategoryModel categoryModel;

    private CreateCategoryResult(Category category) {
        this.categoryModel = new CategoryModel(category);
    }

    public CategoryModel getCategory() {
        return categoryModel;
    }

    @Override
    public String toString() {
        return "CreateCategoryResult{" +
                "category=" + categoryModel +
                "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Category category;

        public Builder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public  CreateCategoryResult build() {
            return new CreateCategoryResult(category);
        }
    }
}
