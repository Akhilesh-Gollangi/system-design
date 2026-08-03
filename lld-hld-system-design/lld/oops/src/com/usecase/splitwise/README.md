# Splitwise Using OOP

This is a small Java project like Splitwise.

Splitwise helps people share bills.

Example:

- Akhilesh pays 5,000 for a trip.
- Baji, Eshu, and Sandeep also use that money.
- The program finds how much they need to pay Akhilesh.

## What this project does

This project can split a bill in three ways:

- **Equal split**: Everyone pays the same amount.
- **Exact split**: Each person pays a fixed amount.
- **Percentage split**: Each person pays a percentage of the bill.

It also shows how much money a user needs to pay or receive.

## Classes used in this project

### `User`

`User` means one person.

Why do we need it?

- We need to know who is in a group.
- We need to know who paid the bill.
- We need to know who needs to pay money.

It stores the user's ID and name.

Example: Akhilesh is a user.

### `Group`

`Group` means a set of people who share bills.

Why do we need it?

- It keeps the users together.
- It keeps the bills of that group.
- It keeps details about who owes money.

Example: A group can be called `GOA` or `Hackers`.

### `Expense`

`Expense` means one bill.

Why do we need it?

- It stores the bill name, total amount, and person who paid.
- It gives a common way to split every kind of bill.

Example: A bike bill of 10,000 is an expense.

### `Split`

`Split` means money one person needs to give to another person.

Why do we need it?

- It stores the amount.
- It stores who will get the money.
- It stores who will pay the money.

Example: Baji needs to pay 1,000 to Akhilesh.

### `Splitwise`

`Splitwise` is the main manager class.

Why do we need it?

- It creates users.
- It creates groups.
- It keeps all users and groups in one place.
- It finds the total balance of a user from all groups.

### `EqualsExpense`

This class splits a bill equally.

Example: A bill of 300 is shared by 3 people. Each person pays 100.

### `ExactAmountExpense`

This class splits a bill using exact amounts.

Example: One person pays 200 and another person pays 1,800.

### `PercentageExpense`

This class splits a bill using percentages.

Example: One person pays 30%, another person pays 40%, and another person pays 30%.

### `Main`

`Main` is where the program starts.

It creates users, groups, and bills. It then prints the split details and balances.

## Simple flow

1. Create users.
2. Create a group.
3. Add users to the group.
4. Create a bill.
5. Choose how to split the bill.
6. Add the bill to the group.
7. The program creates split records.
8. Check each user's balance.

## OOP concepts used

### Encapsulation

Encapsulation means keeping data safe inside a class.

Where is it used?

- In `User`, `Group`, `Expense`, and `Split`.
- Their data is `private`.
- We use getters and setters to read or change the data.

How does it help?

- It keeps the data organized.
- It stops other classes from changing data directly.

### Inheritance

Inheritance means one class can use another class's common code.

Where is it used?

- `EqualsExpense` extends `Expense`.
- `ExactAmountExpense` extends `Expense`.
- `PercentageExpense` extends `Expense`.

How does it help?

- All expense types use the same common data: description, amount, paid-by user, and ID.
- We do not write the same code again and again.

### Abstraction

Abstraction means showing only the important rule.

Where is it used?

- `Expense` is an abstract class.
- It has the abstract method `calculateSplit()`.

How does it help?

- Every expense type must write its own split logic.
- `Expense` does not need to know the full logic for every split type.

### Polymorphism

Polymorphism means one common type can work with different objects.

Where is it used?

- `Group.addExpense()` receives an `Expense` object.
- That object can be `EqualsExpense`, `ExactAmountExpense`, or `PercentageExpense`.
- The correct `calculateSplit()` method runs based on the actual expense type.

How does it help?

- We can add a new expense type later without changing `Group`.
- The code stays simple and easy to extend.

## Project folders

```text
src/
└── splitwise/
    ├── Main.java
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

## How to run

You need Java 9 or later.

Open PowerShell in the project folder and run:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object FullName)
java -cp out splitwise.Main
```

The program will print the split details and user balances.