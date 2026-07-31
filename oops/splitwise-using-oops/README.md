# Splitwise Using OOP

This is a simple Java project that shows how a Splitwise-like application can be designed using Object-Oriented Programming (OOP).

Splitwise is an app used by friends, roommates, or groups to track shared expenses. For example, if one person pays for dinner, the app can record how much the other people need to pay back.

## What this project models

The project contains the basic building blocks of a Splitwise application:

- **User**: a person with an ID and name.
- **Group**: a collection of users, expenses, and money splits.
- **Expense**: an abstract parent class for a payment, such as a dinner bill.
- **Split**: money that one user owes another user.
- **Splitwise**: manages all users and groups.

It also has three expense types:

- **EqualsExpense**: every member pays the same amount.
- **ExactAmountExpense**: every member pays a specified amount.
- **PercentageExpense**: every member pays a specified percentage.

## Project structure

```text
src/
└── splitwise/
    ├── Splitwise.java                 # Creates and stores users and groups
    ├── User.java                      # User details
    ├── Group.java                     # Group members, expenses, and balances
    ├── Expense.java                   # Base class for all expenses
    ├── Split.java                     # A record of who owes whom
    └── typesofexpenses/
        ├── EqualsExpense.java
        ├── ExactAmountExpense.java
        └── PercentageExpense.java
```

## How the design works

1. Create users, for example Alice and Bob.
2. Create a group and add the users to it.
3. Add an expense. One user is the person who paid.
4. Calculate the split based on the expense type.
5. Store each split as:
   - **creditor**: the person who should receive money
   - **debitor**: the person who needs to pay money
6. Check a user's balance:
   - A positive balance means the user should receive money.
   - A negative balance means the user needs to pay money.

For example, Alice pays 600 for dinner shared equally by Alice, Bob, and Charlie. Bob and Charlie each owe Alice 200.

## OOP concepts used

- **Encapsulation**: class fields are private and accessed through methods.
- **Abstraction**: `Expense` defines a common `calculateSplit()` rule.
- **Inheritance**: each expense type extends `Expense`.
- **Polymorphism**: a group can work with any kind of `Expense`.
