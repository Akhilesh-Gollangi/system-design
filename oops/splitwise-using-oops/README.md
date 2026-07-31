# Splitwise Using OOP

This is a simple Java project. It shows how we can make a small Splitwise app using OOP.

Splitwise helps friends share money.

Example:

- Alice pays 300 for food.
- Alice, Bob, and Charlie eat the food.
- Bob and Charlie need to give money to Alice.

## What is OOP?

OOP means we make different classes for different things.

For example:

- A `User` class is for a person.
- A `Group` class is for a group of people.
- An `Expense` class is for a bill.

This makes the code easy to understand and manage.

## Classes in this project

### User

`User` means one person.

Why do we need it?

- We need to know who is in the group.
- We need to know who paid the bill.
- We need to know who has to pay money.

It stores a user's ID and name.

Example: Alice is a user.

### Group

`Group` means a group of people sharing money.

Why do we need it?

- A group keeps all members together.
- A group keeps all bills together.
- A group keeps information about who owes money.

Example: Alice, Bob, and Charlie can be in one "Trip" group.

### Expense

`Expense` means one bill or payment.

Why do we need it?

- It stores what the bill is for.
- It stores the total bill amount.
- It stores who paid the bill.
- It helps split the bill between people.

Example: Alice pays 300 for dinner. This is an expense.

### Split

`Split` means money that one person needs to give to another person.

Why do we need it?

- It tells us who will get money.
- It tells us who will pay money.
- It tells us how much money needs to be paid.

Example: Bob gives 100 to Alice.

### Splitwise

`Splitwise` is the main class of this project.

Why do we need it?

- It creates users.
- It creates groups.
- It saves users and groups.

## Types of expenses

### EqualsExpense

Everyone pays the same amount.

Example: A 300 bill is shared by 3 people. Each person pays 100.

### ExactAmountExpense

Each person pays a fixed amount.

Example: Alice pays 100 and Bob pays 200.

### PercentageExpense

Each person pays a percentage of the bill.

Example: Alice pays 60% and Bob pays 40%.

## Simple flow

1. Create users.
2. Create a group.
3. Add users to the group.
4. Add a bill.
5. Split the bill.
6. Check who needs to pay and who needs to receive money.

## Folder structure

```text
src/
└── splitwise/
    ├── User.java
    ├── Group.java
    ├── Expense.java
    ├── Split.java
    ├── Splitwise.java
    └── typesofexpenses/
        ├── EqualsExpense.java
        ├── ExactAmountExpense.java
        └── PercentageExpense.java
```

## Important note

This project is not fully finished yet.

- The code for splitting money is not written yet.
- There is no `main` method to run the project yet.
- Group lists need to be created before adding members or bills.

## Compile the code

Use Java 9 or later.

Run this command inside the project folder:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object FullName)
```
