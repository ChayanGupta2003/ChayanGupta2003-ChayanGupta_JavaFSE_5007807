### WEEK 2 (SPRING CORE MAVEN)
**Library Management System**

**Steps:**

1. **Create Maven Project:**
   - Created a Maven project named `LibraryManagement`.
   - Added Spring Core dependencies in the `pom.xml` file.

2. **Configure Spring Beans:**
   - Created an XML configuration file named `applicationContext.xml` in the `src/main/resources` directory.
   - Defined beans for `BookService` and `BookRepository` in the XML file.

3. **Create Packages and Classes:**
   - Created a package `com.library.service` and added a class `BookService`.
   - Created a package `com.library.repository` and added a class `BookRepository`.

4. **Run the Application:**
   - Detailed instructions on running the application are provided.

---

### WEEK 2 (PL/SQL)
**Bank Database Management Project**

This project involves creating and managing a bank database using PL/SQL. It covers various aspects such as control structures, error handling, stored procedures, functions, triggers, cursors, and packages.

**Exercises:**

**Exercise 1: Control Structures**

1. **Discount for Senior Customers:**
   - Loop through customers and apply a 1% discount to loan interest rates for those above 60 years old.

2. **VIP Status:**
   - Set `IsVIP` flag to TRUE for customers with a balance over $10,000.

3. **Loan Due Reminders:**
   - Fetch loans due in the next 30 days and print reminders.

**Exercise 2: Error Handling**

1. **Safe Fund Transfers:**
   - Create a procedure to transfer funds between accounts with error handling.

2. **Update Employee Salaries:**
   - Handle errors when updating employee salaries if the employee ID doesn't exist.

3. **Add New Customer:**
   - Handle exceptions when inserting a new customer if the customer ID already exists.

**Exercise 3: Stored Procedures**

1. **Process Monthly Interest:**
   - Calculate and update the balance of all savings accounts by applying a 1% interest rate.

2. **Employee Bonus Scheme:**
   - Update employee salaries by adding a bonus percentage.

3. **Fund Transfers Between Accounts:**
   - Transfer funds between accounts after checking the source account balance.

**Exercise 4: Functions**

1. **Calculate Customer Age:**
   - Function to calculate age from the date of birth.

2. **Monthly Loan Installment:**
   - Function to compute the monthly installment for a loan.

3. **Check Sufficient Balance:**
   - Function to check if an account has a sufficient balance for a transaction.

**Exercise 5: Triggers**

1. **Update LastModified Column:**
   - Trigger to update the `LastModified` column whenever a customer's record is updated.

2. **Log Transactions:**
   - Trigger to log transactions into an `AuditLog` table.

3. **Ensure Valid Transactions:**
   - Trigger to ensure withdrawals do not exceed the balance and deposits are positive.

**Exercise 6: Cursors**

1. **Generate Monthly Statements:**
   - PL/SQL block with an explicit cursor to generate statements for all customers.

2. **Apply Annual Fee:**
   - PL/SQL block with an explicit cursor to deduct an annual fee from all accounts.

3. **Update Loan Interest Rates:**
   - PL/SQL block with an explicit cursor to update loan interest rates based on a new policy.

**Exercise 7: Packages**

1. **Customer Management Package:**
   - Group procedures for adding, updating customers, and getting customer balance.

2. **Employee Management Package:**
   - Group procedures for hiring, updating employees, and calculating annual salary.

3. **Account Operations Package:**
   - Group procedures for opening, closing accounts, and getting the total balance across all accounts.

**Database Schema:**
- The database schema includes tables for Customers, Accounts, Transactions, Loans, and Employees.
- Sample data is provided for testing the PL/SQL blocks.

**How to Use:**

1. **Create Tables:**
   - Run the provided schema to create the necessary tables.

2. **Insert Sample Data:**
   - Use the sample data scripts to populate the tables.

3. **Execute PL/SQL Blocks:**
   - Write and execute the PL/SQL blocks for each scenario.

4. **Verify Results:**
   - Check the results in the database tables to ensure correctness.

This project helps in understanding and implementing various PL/SQL features to manage a bank's database effectively.
