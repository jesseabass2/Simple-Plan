# Design Document

## _$imple Plan Budgeting App_ Design

## 1. Problem Statement

Many people struggle to manage their finances and stay within a budget. They often have a difficult time keeping track of their income and expenses, and as a result, they may overspend or miss important bills. This app aims to solve this problem by providing a simple and easy-to-use platform for creating and managing a budget.

This design document describes the main use cases and functionality of Simple Plan Budgeting App, a new, basic budgeting tool that will provide users a hastle free way to allocate funds and manage their finances. It is designed to implement various AWS tools to provide a secure login and will require user input of their finances.  There will not be a direct link to personal accounts or bank data so the information stored doesn't require other forms of security.


## 2. Top Questions to Resolve in Review
```
1. Should the user be allowed to access multiple templates or would that be confusing and make saving information inefficient?
2. Should the ability to link credit cards be an option to monitor payments as part of expenses?
3. Should reminders in U5 be able to be sent via email or sms?
4. Should there be a total end of year type report that would display totals for each category, savings?
```

## 3. Use Cases
```
U1. As a user, I want to be able to create a new budget template that lists categories with amounts.

U2. As a user, I want to add categories to the budget with amounts(positive for income negative for expenses).

U3. As a user, I want to be able to track individual expenses.

*U4. As a user, I want to be able to set a due date for bills and upcoming expenses.

*U5. As a user, I want to be able to view my progress towards goals by some type of bar or pie chart.

U6. As a user, I want to be able to add a note about an expense if description is needed.

*U7. As a user, I want to be able to view total savings (current month).

*U8. As a user, I want to be able to view total expenses (current month).

*U9. As a user, I want to be able to receive a reminder about an upcoming due date.

*U10. As a user, I want to be able to export my budget data in CSV.


*STRETCH GOALS
```

## 4. Project Scope

### 4.1. In Scope
```
* Adding, updating, and retrieving incomes and expenses
* Modifying an allocation sliding scale by inputting percentages on monthly income
* Retrieve current months expenses and savings.
* Setting reminders for upcoming payments
```

### 4.2. Out of Scope
```
* Allowing the user to share their budget interactively with another user.
* Allowing the user to modify previously completed expense reports.
* Managing reminders via sms or email.
* This simple application doesn't allow for the conversion of currency, strictly USD.
```
# 5. Proposed Architecture Overview

This initial iteration will provide the minimum viable product (MVP) including adding, retrieving, and updating a simple budget plan application. Upon initial launch and login the dashboard will display their current budget, expenses, and available funds.

We will use API Gateway and Lambda to create multiple endpoints (GetExpenses, GetBudget, GetMonthlyIncome, GetProfile, UpdateExpenses) that will handle the creation, updating, and retrieval of budget information as well as profile information to satisfy our requirements.

We will store Dashboard Items, Categories, Expenses in separate tables in DynamoDB.

Simple Plan Budgeting App will provide a main web page providing a variety of options to add, modify and view the set plan.


# 6. API

## 6.1. Public Models
```
// ExpenseModel

String category;
Double amount;
Date date;
String Note;

```
```
// BudgetModel

Double  TotalIncome;
Double TotalExpenses;
Double TotalBudget;
Double FundsAvailable;

```
```
// CategoryModel

String Category;
Double BudgetedAmountForCategory;

```
```
// UserModel

String username;
String password;
String email;

```


*The below information is strictly for reference

## 6.2. _CreateBudgetTemplate Endpoint_

* Accepts `POST` requests to `/budget/`
* Accepts data to create a new budget template to include 
  monthlyIncome, fundsAvailable, categories, and expenses
  for the current month.

## 6.3 _AddCategory Endpoint_

* Accepts `POST` requests to `/category/`
* Accepts data to create a new category and set amount 
  per category.
    * If there is no data found, will throw a
      `NoDataFoundException`

## 6.4. _TrackExpense Endpoint_

* Accepts `GET` requests to `/expense/:amount`
* Returns the expense amount, category and note if available,
  * If there is no expense found, will throw a
    `InvalidExpenseException`

## 6.5. _SetDueDate Endpoint_

* Accepts `PUT` requests to `/expense/:date`
* Accepts data to update a date for an expense
* If the expense is not found, will throw a   
  `ExpenseNotFoundException`

## 6.6. _UpdateNote Endpoint_

* Accepts `PUT` requests to `/expense/:note`
* Accepts data to update the note about the expense.

## 6.7 _GetSavings Endpoint_

* Accepts `GET` requests to `budget/fundsAvailable`
* Returns the available funds after expenses are removed 
  from monthly income

## 6.8 _GetExpenses Endpoint_
* Accepts `GET` requests to `/budget/:totalExpenses`
* Returns all the categories in the Category Table format.
    * If there are no expenses, will throw a
      `NoExpensesFoundException` and display available funds

## 6.9 _GetReminder Endpoint_

* Accepts `GET` requests to `/expenses/:date`
* If date of expense is after *todaysDate*, a reminder 
  with said 'expense' will be returned.


## 6.10 _DeleteExpense Endpoint_
* Accepts `DELETE` request to a `/expense/:id`
* If expense does not exist, will throw a
    `NoExpensesFoundException`.

# 7. Tables

_Define the DynamoDB tables you will need for the data your service will use. It may be helpful to first think of what objects your service will need, then translate that to a table structure, like with the *`Playlist` POJO* versus the `playlists` table in the Unit 3 project._

* ExpenseTable
    - id // partition key, string
    - date // Date
    - total // float
    - categoryName // string (GSI Partition Key)
    - note // string


* CategoryTable
    - categoryId // partition key, string
    - categoryName // string

* BudgetTable
    - budgetName // string
    - totalIncome // float
    - totalExpenses // float
    - fundsAvailable // float


# 8. Pages

**to be added


