package com.nashss.se.simple_plan.models;

import com.nashss.se.simple_plan.dynamodb.models.Category;

import java.util.Objects;

public class CategoryModel {

    private String categoryName;

    private double budgetedAmount;

    private boolean goalToSave;

    public CategoryModel(Category category) {
        this.categoryName = category.getCategoryName();
        this.budgetedAmount = category.getBudgetedAmount();
        this.goalToSave = category.getGoalToSave();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getBudgetedAmount() {
        return budgetedAmount;
    }

    public boolean getGoalToSave() {
        return goalToSave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CategoryModel that = (CategoryModel) o;
        return Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(budgetedAmount, that.budgetedAmount) &&
                Objects.equals(goalToSave, that.goalToSave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, budgetedAmount, goalToSave);
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryName='" + categoryName + '\'' +
                ", budgetedAmount='" + budgetedAmount + '\'' +
                ", goalToSave='" + goalToSave + '\'' +
                '}';
    }
}
