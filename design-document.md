# Design Document

## _$imple Plan Budgeting App_ Design

## 1. Problem Statement

Many people struggle to manage their finances and stay within a budget. They often have a difficult time keeping track of their income and expenses, and as a result, they may overspend or miss important bills. This app aims to solve this problem by providing a simple and easy-to-use platform for creating and managing a budget.

This design document describes the main use cases and functionality of Simple Plan Budgeting App, a new, basic budgeting tool that will provide users a hastle free way to allocate funds and manage their finances. It is designed to implement various AWS tools to provide a secure login and will require user input of their finances.  There will not be a direct link to personal accounts or bank data so the information stored doesn't require other forms of security.


## 2. Top Questions to Resolve in Review

_List the most important questions you have about your design, or things that you are still debating internally that you might like help working through._

1. Should the user be allowed to access multiple templates or would that be confusing and make saving information inefficient?
2. Should the ability to link credit cards be an option to monitor payments as part of expenses?
3. Should reminders in U5 be able to be sent via email or sms?
4. Should there be a total end of year type report that would display totals for each category, savings?


## 3. Use Cases

_This is where we work backwards from the customer and define what our customers would like to do (and why). You may also include use cases for yourselves (as developers), or for the organization providing the product to customers._

U1. As a user, I want to be able to create a new budget template and assign different catoegories of expenditures.

U2. As a user, I want to be able to input and adjust my monthly income as needed.

U3. As an user, I want to be able to track my expenses and see how much funds are available.

U4. As a user I want to be able to set and/or delete monthly goals for my expenses and savings.

U5. As a user I want to be able to set reminders for bills and upcoming expenses.

U6. As a user, I want to be able to view my progress towards goals by some type of bar or pie chart.

U7. As a user I want to be able to make a note about an expense if description is needed.

U8. As a user, I want to be able to view a status bar of available funds per category.

U9. As a user, I want to be able to view total savings and expenses over the calendar year.

*U10. As a user, I want to be able to export my budget data in CSV or excel


*EXTRA FEATURES


## 4. Project Scope

_Clarify which parts of the problem you intend to solve. It helps reviewers know what questions to ask to make sure you are solving for what you say and stops discussions from getting sidetracked by aspects you do not intend to handle in your design._


### 4.1. In Scope

_Which parts of the problem defined in Sections 1 and 2 will you solve with this design? This should include the base functionality of your product. What pieces are required for your product to work?_

* Adding, updating, and retrieving incomes and expenses
* Modifying an allocation sliding scale by inputing percentages on monthly income
* Retrieve previous months expenses
* (EXTRA FEATURE) Ability to send email or text of reminders

### 4.2. Out of Scope

_Based on your problem description in Sections 1 and 2, are there any aspects you are not planning to solve? Do potential expansions or related problems occur to you that you want to explicitly say you are not worrying about now? Feel free to put anything here that you think your team can't accomplish in the unit, but would love to do with more time._

* Allowing the user to share their budget interactively with another user.
* Allowing the user to modify previously completed expense reports
* This simplet application doesn't allow for the conversion of currency, strictly USD.

# 5. Proposed Architecture Overview

_Describe broadly how you are proposing to solve for the requirements you described in Section 2. This may include class diagram(s) showing what components you are planning to build. You should argue why this architecture (organization of components) is reasonable. That is, why it represents a good data flow and a good separation of concerns. Where applicable, argue why this architecture satisfies the stated requirements._

This initial iteration will provide the minimum viable product (MVP) including adding, retrieving, and updating a simple budget plan application. Upon initial launch and login the dashboard will display their current budget, expenses, and available funds.

We will use API Gateway and Lambda to create multiple endpoints, ExpenseTracker, GetExpenses, GetBudgetGoals, GetMonthlyIncome, Get Profile, UpdateExpenses,) that will handle the creation, updating, and retrieval of budget information as well as profile information to satisfy our requirements.

We will store Dashboard Items, Categories, Expenses in separate tables in DynamoDB.

Simple Plan Budgeting App will provide a main web page providing a variety of options to add, modify and view the set plan.


# 6. API

## 6.1. Public Models

_Define the data models your service will expose in its responses via your *`-Model`* package. These will be equivalent to the *`PlaylistModel`* and *`SongModel`* from the Unit 3 project._

```


// ExpenseModel

String category;
double amout;
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
Double BudgetedAmoutForCategory;

```
```
// UserModel

String username;
String password;
String email;

```
```

*The below information is strictly for reference


## 6.2. _GetProfile Endpoint_

* Accepts `GET` requests to `/employee/:id`
* Accepts an employeeID and returns the corresponding EmployeeModel.
    * If the given employee ID is not found, will throw a
      `EmployeeNotFoundException`

![Client sends get employee form to Website View Employee Page. Website
View Employee page sends a get request to GetEmployeeActivity.
GetEmployeeActivity loads employee from contacts
database and returns.](images/UpdateEmployeeSd.png)

## 6.3 _GetContactGlobal Endpoint_

* Accepts `GET` requests to `/employee`
* Returns all the employees in all the departments in the EmployeeModel format.
    * If there is no data found, will throw a
      `NoDataFoundException`

## 6.4. GetContactsByDepartment Endpoint

* Accepts `GET` requests to `/employee/:deptId`
* Returns all the employees in the requested departments in the EmployeeModel format.
    * If there is no department found, will throw a
      `InvalidDepartmentException`

## 6.5. _UpdateEmployee Endpoint_

* Accepts `PUT` requests to `/employee/:id`
* Accepts data to update a contact including an updated
  firstName, lastName, jobTitle, deptId , dateOfBirth , email, and      
  phoneNumber. Returns the updated contact.
* If the employeeID or name is not found, will throw a   
  `EmployeeNotFoundException`
* For security concerns, we will validate the provided employee name does not
  contain invalid characters: `" ' \`
* If the employee name contains invalid characters, will throw an
  `InvalidAttributeValueException` 

![Client sends submit update employee form to Website Update/Add page. Website
Update/Add page sends an update request to UpdateEmployeeActivity.
UpdateEmployeeActivity saves updates to the contacts
database.](images/UpdateEmployeeSd.png)

## 6.6. _AddEmployee Endpoint_

* Accepts `POST` requests to `/employee/`
* Accepts data to create a new employee which includes their
  firstName, lastName, jobTitle, deptId , dateOfBirth , email, and      
  phoneNumber. Returns the new employee.
* For security concerns, we will validate the provided employee name does not
  contain invalid characters: `" ' \`
* If the employee name contains invalid characters, will throw an
  `InvalidAttributeValueException`

## 6.7 _AdvancedSearch Endpoint_

* Accepts the following parameters departmentId (REQUIRED), firstName,
  lastName, and employeeID to perform a search on the database
* Returns a list of results based on the entered search criteria.
* A departmentID is required as this is the partition key.
* If there is no data found, will throw a
  `NoDataFoundException`
* If there is no department found, will throw a
  `InvalidDepartmentException`
* For security concerns, we will validate the provided employee name does not
  contain invalid characters: `" ' \`
* If the employee name contains invalid characters, will throw an
  `InvalidAttributeValueException`

## 6.8 GetDeptGlobal 
* Accepts `GET` requests to `/department`
* Returns all the departments in the DepartmentTable format.
  * If there is no data found, will throw a
    `NoDataFoundException`

# 7. Tables

_Define the DynamoDB tables you will need for the data your service will use. It may be helpful to first think of what objects your service will need, then translate that to a table structure, like with the *`Playlist` POJO* versus the `playlists` table in the Unit 3 project._

* EmployeeTable
  - employeeId // partition key, string
  - firstName // string
  - lastName // string
  - jobTitle // string
  - Email // string
  - deptId // string (GSI Partition Key)
  - hireDate // string
  - phoneNumber // string
  - dateOfBirth // string

* DepartmentTable
  * deptId // partition key, string
  * deptName // string
   

# 8. Pages

https://www.figma.com/file/5rmM0IQhuG0wefUsezsCud/Purple-Haze?node-id=0%3A1

