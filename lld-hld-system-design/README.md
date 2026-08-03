# Java OOP and Low-Level Design Examples

This project is made for learning Java OOP in small, easy examples.

It has these modules:

1. Inheritance
2. Abstraction
3. Compile-time polymorphism
4. Runtime polymorphism
5. E-commerce discount using an interface
6. Splitwise application
7. Splitwise practice application

The project is only a console program. It prints results in the terminal. It does not have a website, database, login page, payment gateway, or API.

## Before you start

You need Java 9 or a newer version. Java 9 is needed because this project uses `List.of(...)`.

Check Java installation:

```powershell
java -version
javac -version
```

## How to compile the project

Open PowerShell in the main project folder and run:

```powershell
$sources = Get-ChildItem -Path lld\oops\src -Recurse -Filter *.java | ForEach-Object FullName
javac -d out $sources
```

What this command does:

- Finds every Java file inside `lld\oops\src`.
- Compiles the Java files.
- Puts compiled files into the `out` folder.

Run this compile command before running any module.

## Project folders

```text
lld/
  oops/
    src/
      com/
        inheritance/                   # inheritance example
        abstraction/                   # abstraction example
        polymorphism/
          compiletimepolymorphism/     # method overloading example
          runtimepolymorphism/         # method overriding example
        usecase/
          ecommercediscount/           # interface example
          splitwise/                   # main Splitwise project
          practicesplitwise/           # Splitwise practice project
```

---

## 1. Inheritance module

**Folder:** `com.inheritance`  
**Run command:**

```powershell
java -cp out com.inheritance.Main
```

### Simple meaning of inheritance

Inheritance means a child class can use the properties and methods of a parent class.

Real-life example:

```text
German Shepherd is a Dog.
```

So a German Shepherd can use the common behaviour of a Dog.

### Files in this module

#### `Dog.java`

This is the parent class. It has one method:

```java
public void doBark() {
    System.out.println("Bow Bow");
}
```

Any class that extends `Dog` can use `doBark()`.

#### `GermanShepard.java`

This is the child class:

```java
public class GermanShepard extends Dog {
}
```

It has no method of its own. But it can still call `doBark()` because it extends `Dog`.

#### `Main.java`

This file starts the example.

It creates:

- A normal `Dog` object.
- A `GermanShepard` object.

Both objects call `doBark()`. Both print `Bow Bow` because `GermanShepard` uses the method it received from `Dog`.

### What to learn here

- `extends` means one class gets behaviour from another class.
- `GermanShepard` is a child class.
- `Dog` is a parent class.
- We do not need to write the same `doBark()` code again in `GermanShepard`.

---

## 2. Abstraction module

**Folder:** `com.abstraction`  
**Run command:**

```powershell
java -cp out com.abstraction.Main
```

### Simple meaning of abstraction

Abstraction means showing only what is needed and hiding how it works.

For example, when you make a phone call, you only press the call button. You do not need to know how Airtel or Jio connects the call internally.

### Files in this module

#### `Sim.java`

`Sim` is an abstract class.

```java
public abstract class Sim {
    public abstract void calling();
}
```

It says every SIM company must have a `calling()` method. But it does not say what the method should print or how calling works.

You cannot create an object of an abstract class:

```java
// Sim sim = new Sim(); // not allowed
```

#### `Airtel.java`

`Airtel` extends `Sim` and gives its own implementation:

```java
public void calling() {
    System.out.println("Calling from Airtel");
}
```

#### `Jio.java`

`Jio` also extends `Sim`, but prints its own message:

```java
public void calling() {
    System.out.println("Calling from Jio");
}
```

#### `CallerManagement.java`

This class has one method:

```java
public void call(Sim sim) {
    sim.calling();
}
```

It accepts `Sim`, not `Airtel` or `Jio` directly. So it works with both companies.

#### `Main.java`

This file creates both types:

```java
Sim sim = new Airtel();
sim.calling();

Sim sim1 = new Jio();
sim1.calling();
```

It also sends both objects to `CallerManagement`.

### What to learn here

- `Sim` tells us what all SIM companies must do.
- `Airtel` and `Jio` decide how to do it.
- The caller does not need to know the internal implementation.
- One method, `call(Sim sim)`, works for Airtel, Jio, or any future SIM company.

---

## 3. Compile-time polymorphism module

**Folder:** `com.polymorphism.compiletimepolymorphism`  
**Run command:**

```powershell
java -cp out com.polymorphism.compiletimepolymorphism.Main
```

### Simple meaning of compile-time polymorphism

One method name can have different versions. Java chooses the correct version by looking at the values passed to the method. Java makes this choice before the program runs. This is also called **method overloading**.

### Files in this module

#### `Student.java`

This class stores a student's `name` and `age`. It has constructors, getters, and setters.

It also has three methods with the same name, `display`:

```java
display()            // prints the stored name and age
display(String name) // prints only a name
display(int age)     // prints only an age
```

They have the same method name but different inputs. This is overloading.

#### `Main.java`

This file creates a student:

```java
Student student = new Student("akhik", 12);
```

Then it calls all three `display` methods:

```java
student.display();
student.display(20);
student.display("Akkk");
```

Java knows which `display` method to call from the number and type of arguments.

### What to learn here

- Same method name is allowed.
- Parameters must be different.
- `display(20)` calls the `int` method.
- `display("Akkk")` calls the `String` method.
- `display()` calls the no-argument method.

---

## 4. Runtime polymorphism module

**Folder:** `com.polymorphism.runtimepolymorphism`  
**Run command:**

```powershell
java -cp out com.polymorphism.runtimepolymorphism.Main
```

### Simple meaning of runtime polymorphism

Runtime polymorphism happens when a child class changes a parent method. Java chooses the correct method while the program is running. This is also called **method overriding**.

### Files in this module

#### `Dog.java`

This is the parent class. Its `doBark()` method prints:

```text
bhaw bhaw
```

#### `Labrador.java`

This class extends `Dog`, but does not change `doBark()`. Therefore, a Labrador uses the parent `Dog` sound: `bhaw bhaw`.

#### `Pomeranian.java`

This class extends `Dog` and changes the `doBark()` method:

```java
@Override
public void doBark() {
    System.out.println("phaw phaw");
}
```

So a Pomeranian prints `phaw phaw`.

#### `DogSound.java`

This class has:

```java
public void makeSound(Dog dog) {
    dog.doBark();
}
```

It accepts any object that is a `Dog`, such as `Labrador` or `Pomeranian`.

#### `Main.java`

This file shows all cases. The most important line is:

```java
Dog dog = new Pomeranian();
dog.doBark();
```

The variable type is `Dog`, but the real object is `Pomeranian`. Therefore, Java runs `Pomeranian.doBark()` and prints `phaw phaw`.

### What to learn here

- A child class can replace a parent method.
- `@Override` tells Java that a child is replacing a parent method.
- Parent-type variables can hold child objects.
- Java checks the real object at runtime to choose the method.

---

## 5. E-commerce discount module

**Folder:** `com.usecase.ecommercediscount`  
**Run command:**

```powershell
java -cp out com.usecase.ecommercediscount.Discount
```

### Simple meaning of an interface

An interface is like a promise or rule. It says what a class must do, but not how it must do it.

### Files in this module

#### `Idisocunt.java`

This is an interface. The file name has a spelling mistake in the source: `Idisocunt`. It contains:

```java
double discount();
```

Every class that implements this interface must provide a `discount()` method.

#### `CreditcardDiscount.java`

This class implements `Idisocunt` and returns `0.5` from `discount()`.

#### `CouponDiscount.java`

This class also implements `Idisocunt` and returns `0.2` from `discount()`.

#### `Discount.java`

This is the starting class. It creates a `CreditcardDiscount` object using the interface type:

```java
Idisocunt discount = new CreditcardDiscount();
discount.discount();
```

The method is called, but the result is not printed. Therefore this module normally shows no terminal output.

### What to learn here

- Different discount types can follow the same rule.
- Code can use `Idisocunt` without caring whether the real object is a coupon discount or credit-card discount.
- A new discount type can be added by implementing the same interface.

---

## 6. Main Splitwise module

**Folder:** `com.usecase.splitwise`  
**Run command:**

```powershell
java -cp out com.usecase.splitwise.Main
```

### What is Splitwise here?

This module is a small version of Splitwise. It helps friends share bills.

Example: Akhilesh pays 5,000 for a trip. Baji, Eshu, and Sandeep must share this cost. The program creates records showing how much each person owes Akhilesh.

### Important words

- **User:** one person, for example Akhilesh.
- **Group:** a set of people sharing expenses, for example a trip group.
- **Expense:** one bill, for example a hotel bill.
- **Payer:** the user who paid the full bill.
- **Participant:** a user who must pay part of the bill.
- **Split:** one record showing who owes money to whom.
- **Creditor:** the person who should receive money. In this project, this is normally the payer.
- **Debitor:** the person who owes money. The code uses this word; `debtor` is the more common spelling.

### Simple project flow

```text
Create users
     -> Create a group
     -> Add users to the group
     -> Create an expense
     -> Choose a split type
     -> Add expense to group
     -> Program creates split records
     -> Check each user's balance
```

### Files in this module

#### `User.java`

Represents one person.

It stores:

- `id`: unique user ID, such as `u1`.
- `name`: user name, such as `AKHILESH`.

It has getters and setters to read and update these values. Its `toString()` method prints user information in a readable form.

#### `Split.java`

Represents one money relation between two users.

It stores:

- `amount`: money owed.
- `creditor`: user who should receive money.
- `debitor`: user who should pay money.

For example:

```text
Baji owes 1,000 to Akhilesh
amount   = 1000
creditor = Akhilesh
debitor  = Baji
```

Its `toString()` method prints split data in a JSON-like format.

#### `Expense.java`

This is the common parent class for all bill types. It is abstract, so we do not create `new Expense(...)` directly.

It stores common bill details:

- `id`: expense ID.
- `description`: bill name, such as `Weekend`.
- `amount`: total bill amount.
- `paidBy`: user who paid the bill.

It also has this abstract method:

```java
calculateSplit(List<User> members, List<Double> expense)
```

Every expense type must write its own way to calculate the split.

#### `EqualsExpense.java`

This class is used when every participant pays the same amount.

Example:

```text
Bill amount: 5,000
Participants: Baji, Eshu, Sandeep
Each person owes: 5,000 / 3 = 1,666.666...
```

It creates one split for every participant. The `values` argument is not used for an equal split, so `Main.java` sends `null`.

#### `PercentageExpense.java`

This class is used when people pay different percentages.

Example:

```text
Bill amount: 10,000
Baji: 30%  -> 3,000
Akhilesh: 40% -> 4,000
Sandeep: 30% -> 3,000
```

The input percentage list must add up to 100. If it does not, this class throws an `IllegalArgumentException`.

#### `ExactAmountExpense.java`

This class is used when every participant has a fixed amount.

Example:

```text
Bill amount: 2,000
Akhilesh owes: 200
Eshu owes: 1,800
```

The values list gives the exact amount for each participant.

#### `Group.java`

Represents one group, such as `Hackers`, `GOA`, or `Travelling`.

It stores:

- Group ID and name.
- `members`: people in the group.
- `expenses`: bills added to the group.
- `splits`: all money-owed records created for the group.

Important methods:

| Method | Simple explanation |
| --- | --- |
| `addMember(user)` | Adds a person to the group. |
| `addExpense(expense, users, amount)` | Asks the selected expense type to create splits, then saves the expense and splits. |
| `getUserBalance(userId)` | Finds how much one user should receive or pay inside this group. |

When `addExpense` calls `expense.calculateSplit(...)`, Java chooses the right method based on the real expense object. This is runtime polymorphism.

#### `Splitwise.java`

This is the main manager class of this module.

It keeps two maps in memory:

- `users`: user ID -> `User`
- `groups`: group ID -> `Group`

Important methods:

| Method | Simple explanation |
| --- | --- |
| `createUser(id, name)` | Creates and saves a user. |
| `createGroup(id, name)` | Creates and saves a group. |
| `getOverallBalanceofUser(userId)` | Adds that user's balance from every group. |

#### `Main.java`

This file runs the complete example.

It does these steps:

1. Creates four users: Akhilesh, Baji, Eshu, and Sandeep.
2. Creates the `Hackers` group and adds all four users.
3. Adds an equal 5,000 `Weekend` expense paid by Akhilesh.
4. Adds a 10,000 `Bike` expense paid by Eshu with a 30%, 40%, 30% split.
5. Creates a separate `GOA` group and adds a percentage expense.
6. Creates a `Travelling` group with an exact-amount expense.
7. Prints group balance and overall balance for members of the `Hackers` group.

### How balance works

The code checks every split in a group.

- If the user is the **creditor**, their balance increases. They should receive money.
- If the user is the **debitor**, their balance decreases. They owe money.

```text
Positive balance = user should receive money
Negative balance = user should pay money
```

The code does not simplify payments. For example, if A owes B and B owes C, it still keeps two separate records.

---

## 7. Splitwise practice module

**Folder:** `com.usecase.practicesplitwise`  
**Run command:**

```powershell
java -cp out com.usecase.practicesplitwise.Main
```

This is a second, independent attempt at building the same Splitwise idea. It is not connected to the main Splitwise module. It uses similar classes with slightly different names and simpler checks.

### Files in this module

#### `User.java`

Stores a user's ID and name. This works like `User.java` in the main Splitwise module.

#### `Split.java`

Stores amount, creditor, and debitor. Unlike the main version, it also has setters.

#### `Expense.java`

Abstract parent class for practice expenses. It stores ID, description, payer, and amount. Every child class must implement `calculateSplit(...)`.

#### `EqualExpense.java`

Divides the full amount equally among the supplied users.

#### `PercentageExpense.java`

Calculates each user's amount from the supplied percentage list.

#### `ExactExpense.java`

Uses the supplied exact amount for each user.

#### `Group.java`

Stores group ID, name, users, expenses, and splits.

Important methods:

- `addUser(user)`: adds a user to the group.
- `calculateSplits(expense, users, values)`: asks the selected expense type to create splits and saves them.
- `getUserBalance(user)`: calculates one user's balance inside the group.

#### `SplitWise.java`

Creates and stores users and groups. It also has `getOverallBalance(user)`, which adds a user's balance from all created groups.

#### `Main.java`

Creates three users and one `FieldTrip` group. Then it adds:

1. A 1,000 equal `CAB` expense paid by Akhilesh.
2. A 5,000 percentage `HOTEL` expense paid by Eshu with 80% and 20% shares.
3. A 1,000 exact `HOTEL` expense paid by Baji with 200 and 800 shares.

After each step, it prints the full group information and one user's balance.

### Important difference from the main Splitwise module

The practice version does not check whether percentages add to 100 or exact amounts add to the total bill. It is mainly for practising class design and polymorphism.

---

## OOP concepts used in this project

| OOP concept | Very simple meaning | Example in this project |
| --- | --- | --- |
| Encapsulation | Keep data inside a class and access it using methods. | Private fields with getters and setters in `User`, `Group`, `Expense`, and `Split`. |
| Inheritance | A child gets behaviour from a parent. | `GermanShepard extends Dog`; expense classes extend `Expense`. |
| Abstraction | Show what should happen, hide how it happens. | `Sim.calling()` and `Expense.calculateSplit()`. |
| Interface | A rule that classes agree to follow. | `Idisocunt` and its discount classes. |
| Method overloading | Same method name, different input. | Three `Student.display(...)` methods. |
| Method overriding | A child changes a parent method. | `Pomeranian.doBark()` and each expense `calculateSplit()`. |
| Runtime polymorphism | Java chooses the child method while running. | `Expense expense = new PercentageExpense(...)`. |

## Current limitations of the project

This is learning code. These features are not present yet:

- Data is not saved after the program stops.
- No database is used.
- No user login or authentication.
- No API or frontend.
- No payment or settlement feature.
- No automatic checking that every participant belongs to the group.
- No automatic rounding for money values.
- No automated tests.
- The main exact-split code rejects totals greater than the bill, but currently accepts totals smaller than the bill.
- The code uses `double` for money; real payment applications should normally use `BigDecimal`.

## Good next steps for learning

After understanding this project, you can try to add:

1. Input validation for empty users, wrong percentages, and wrong exact amounts.
2. A payment method to mark debts as paid.
3. Debt simplification to reduce the number of payments.
4. `BigDecimal` for money calculation.
5. Unit tests using JUnit.
6. A database to save users, groups, expenses, and splits.
7. A REST API using Spring Boot.

## License

No license file is included in this repository.
