package com.nashss.se.simple_plan.dynamodb.models;

public class BudgetModel {
    private String budgetName;
    private double monthlyIncome;
    private double totalExpenses;
    private double fundsAvailable;


    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getFundsAvailable() {
        return fundsAvailable;
    }

    public void setFundsAvailable(double fundsAvailable) {
        this.fundsAvailable = fundsAvailable;
    }

}
