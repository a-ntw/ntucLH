SGUS - MTA: Database
===
[top]: topOfThePage

#### Microsoft Visual Studio 2008
### Lesson
* [LESSON 1: Understanding Core Database Concepts](#lesson-1)
* [LESSON 2: Creating Database Objects](#lesson-2)
* [LESSON 3: Manipulating Data](#lesson-3)
* [LESSON 4: Understanding Data Storage](#lesson-4)
* [LESSON 5: Administering a Database](#lesson-5)

---

##### Lesson 1
## Lesson 1: Understanding Core Database Concepts

### Understand how data is stored in tables.

### Understand relational database concepts.

### Understand data manipulation language (DML).

### Understand data definition language (DDL).

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* A database (db) is an organized collection of data, typically stored in electronic format. It allows you to input, organize, and retrieve data quickly.
* Microsoft SQL Server uses three types of files to store databases. Primary data files, with an .mdf extension, are the first files created in a database and can contain user-defined objects, such as tables and views, as well as system tables required by SQL Server to keep track of the database.
* If a database gets too large and you run out of room on your first hard disk, you can create secondary data files, with an .ndf extension, on separate physical hard disks to give your database more room.
* The third type of file used by SQL Server is a transaction log file. Transaction log files use an .ldf extension and don’t contain any objects such as tables or views.
* To retrieve data within a database, you run a database query. In other words, a query is used to ask for information from the database and data is then returned.

* A database index is a data structure that improves the speed of data retrieval operations on a database table.
* Most users do not access databases directly. Instead, they use a database management system (DBMS) to access them indirectly.
* A flat-type database is simplistic in design. These databases are most commonly used in plain-text formats, and their purpose is to hold one record per line, making access and queries very rapid.
* Tables, used to store data, are two-dimensional objects consisting of rows and columns.
* A hierarchical database is similar to a tree structure (such as a family tree). Each parent table can have multiple children, but each child table can have only one parent.

* A relational database is similar to a hierarchical database in that data is stored in tables and any new information is automatically added to the table without the need to reorganize the table itself. Unlike tables in a hierarchical database, however, a table in a relational database can have multiple parents.
* Databases are often put on database servers so that they can be accessed by multiple users and provide a higher level of performance. One popular database server is Microsoft SQL Server.
* Constraints are limitations or rules placed on a field or column to ensure that data that is considered invalid is not entered.
* SQL Server Management Studio (SSMS) is the primary tool to manage a server and its databases using a graphical interface.
* Data Manipulation Language (DML) is the language element that allows you to use the core statements INSERT , UPDATE , DELETE , and MERGE to manipulate data in any SQL Server tables.

* Data Definition Language (DDL) is a subset of the Transact-SQL language; it deals with creating database objects like tables, constraints, and stored procedures.

#### Fill in the Blank
Complete the following sentences by writing the correct word or words in the blanks provided.

1. Database objects are divided into two categories: **storage** and **programmability**.

2. Tables created using the **CREATE** statement are used to store data. 

3.  Constraints can define entity relationships between tables on a continual basis. They are also referred to as **Foreign Key** constraints. 

4. In order to use the views object to view a data set, you must use the **SELECT** Transact-SQL statement to show data from underlying tables. 

5. DDL influences **DATA**, whereas **DML** influences actual data stored in tables. 

6. The Microsoft database server that hosts relational databases is called **SQL Server**.

7. The core DDL statements are **USE**, **CREATE**, **ALTER**, **DROP**, **TRUNCATE** and **DELETE**.

8. The core DML statements are **SELECT**, **INSERT**, **UPDATE**, **DELETE** and **MERGE**.

9. System views belong to the **sys schema**.

10. The foreign key constraint is a **relationship** identifier. 

#### Multiple Choice
Circle the letter that corresponds to the best answer.

1. Which of the following is not a DDL statement? b. MERGE
- a. CREATE
- **b. MERGE**
- c. ALTER
- d. DROP

2. Which of the following is not a column constraint? c. Range
- a. Default
- b. Check
- **c. Range**
- d. Unique

3. What are limitations or rules placed on a field or column to ensure that data that is considered invalid is not entered? d. constraint
- a. Primary key
- b. index
- c. Foreign key
- **d. constraint**

4. Which of the following is not a DML statement? a. REMOVE
- **a. REMOVE**
- b. INSERT
- c. DELETE
- d. TRUNCATE

5. Select all of the following statements that are true: a:, b:
- **a. Indexes should only be created on columns that are frequently searched.**
- **b. A self-reference arises when a foreign key constraint references a column in the same table.**
- c. A single INSERT statement can be used to add rows to multiple tables.
- d. Multiple primary keys can be added to a table.

6. Which of the following actions is not supported by ALTER ? d.
- a. Adding a new column to a table.
- b. Deleting multiple columns from an existing table.
- c. Modifying the data type of an existing column.
- **d. Changing the identity constraint of an existing column.**

7. Which of the following is not a constraint? a. (will be NOT NULL)
- **a. Null**
- b. Unique
- c. Check
- d. Primary

8. What does SQL stand for? b.
- a. Structured Question Language
- **b. Structured Query Language**
- c. Strong Question Language
- d. Specific Query Language

9. Which of the following SQL statements is used to extract data from a database? a.
- **a. SELECT**
- b. OPEN
- c. EXTRACT
- d. GET

10. Which SQL statement is used to update data in a database? d.
- a. SAVE
- b. MODIFY
- c. SAVE AS
- **d. UPDATE**


---
[:top: Top](#top)
##### Lesson 2
## Lesson 2: Creating Database Objects

### Choose data types

### Understand tables and how to create them.

### Create views.

### Create stored procedures and functions.

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* A data type is an attribute that specifies the type of data an object can hold, as well as how many bytes each data type takes up.
* As a general rule, if you have two data types that differ only in how many bytes each uses, the one with more bytes has a larger range of values and/or increased precision.
* Microsoft SQL Server includes a wide range of predefined data types called built-in data types. Most of the databases you will create or use will employ only these data types.
* Exact numeric data types are the most common SQL Server data types used to store numeric information.
* int is the primary integer (whole number) data type.

* Precision (p ) is the maximum total number of decimal digits that can be stored in a numeric data type, both to the left and to the right of the decimal point; this value must be at least 1 and at most 38. The default precision number is 18.
* money and smallmoney are Transact-SQL data types you would use to represent monetary or currency values. Both data types are accurate to 1/10,000th of the monetary units they represent.
* Approximate numeric data types are not as commonly used as other SQL Server data types.
If you need more precision (more decimal places) than is available with the exact numeric data types, you should use the float or real data types, both of which typically take additional bytes of storage.
* The date and time data types, of course, deal with dates and times. These data types include date , datetime2 , datetime , datetimeoffset , smalldatetime , and time .
* SQL Server supports implicit conversions, which can occur without specifying the actual callout function (cast or convert). Explicit conversions require you to use the functions cast or convert specifically.

* A regular character uses one byte of storage for each character, which allows you to define one of 256 possible characters; this accommodates English and some European languages.
* A Unicode character uses two bytes of storage per character so that you can represent one of 65,536 characters. This added capacity means that Unicode can store characters from almost any language.
* When you use a VAR element, SQL Server will preserve space in the row in which this element resides on the basis of on the column’s defined size and not the actual number of characters in the character string itself.
* The Unicode character strings nchar and nvarchar can either be fixed or variable, like regular character strings; however, they use the UNICODE UCS-2 character set.
* The purpose of a table is to provide a structure for storing data within a relational database.

* A view is simply a virtual table that consists of different columns from one or more tables. Unlike a table, a view is stored in a database as a query object; therefore, a view is an object that obtains its data from one or more tables.
* A stored procedure is a previously written SQL statement that has been stored or saved into a database.
* A SQL injection is an attack in which malicious code is inserted into strings that are later passed on to instances of SQL Server for parsing and execution.

#### Fill in the Blank
Complete the following sentences by writing the correct word or words in the blanks provided.

1. Each **column**, **local variable**, expression, and **parameter** always has a related data type.

2. A bit is a Transact-SQL integer data type that can take a **value** of 1, 0, or NULL.

3. When you are defining the cost of a product, it is best to use the **money** data type.

4. It is important to consider your use of **date** data sets when building tables dependent on daylight saving time.

5. SQL Server supports **implicit** conversions without using actual callout functions (`cast` or `convert` ).

6. A regular character uses **one** byte(s) of storage for each character, whereas a Unicode character requires **two** byte(s) of storage.

7. The data set `char` is of **fixed-** length and has a length of **n** bytes.

8. The purpose of a table is to provide a(n) **structure** for storing data within a relational database.

9. When creating a view, be sure to consider **database performance** in your design.

10. When querying a database, you can obtain faster results from properly **index** tables and views.

#### Multiple Choice
Circle the letter that corresponds to the best answer.

1. Which of the following is not a data type? c.
- a. Exact numerics
- b. Approximate numerics
- **c. ANSI string**
- d. Spatial

2. What do you call when a data type is converted automatically to another data type? a.
- **a. implicit conversion**
- b. explicit conversion
- c. dynamic conversion
- d. static conversion

3. Which of the following is not true about the int data type? c.
- a. int is an integer.
- b. bigint is used when the value will exceed int data type’s range.
- **c. An Integer uses 8 bytes to store data.**
- d. Functions will return bigint only if the original expression has the same data type.

4. Do implicit conversions require an actual callout feature (i.e., cast or convert )? b.
- a. Yes
- **b. No**

5. Select all of the following statements that are false: c.
- a. A table provides structure to store data.
- b. A database retrieves data from different tables and views.
- c. A database cannot parse out redundant data.
- d. A table can be created both in a graphical interface and by using syntax.

6. Which of the following statements best describes the importance of creating views? e.
- a. Views give users the ability to access underlying tables.
- b. Views allow you to limit the type of data users can access.
- c. Views reduce the complexity for end users so they don’t need to learn complex SQL queries.
- d. Both a and b
- **e. Both b and c**
- f. All of the above

7. Which of the following statements does not accurately a view? c.
- a. A view is a virtual table.
- b. A view is meant to serve as a security mechanism.
- **c. Views should not be used for granting access.**
- d. A view simplifies query execution.

8. What is the Transact-SQL statement to create a view? b.
- a. CREATE VIEW
- **b. CREATE VIEW view_name**
- c. CREATE VIEW view_name *

9. Which statement is used to suppress the ‘(1 row(s) affected)’ after executing query statements? b.
- a. SET NO COUNT
- **b. SET NOCOUNT ON**
- c. SET NO COUNTING
- d. SET NO COUNTING ON

10. Which is not a regular data type? c.
- a. CHAR
- b. NCHAR
- **c. TEXT**
- d. VARCHAR

---
[:top: Top](#top)
##### Lesson 3
## Lesson 3: Manipulating Data

### Select data.

### Insert data

### Update data.

### Delete data.

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* he SQL command for retrieving any data from a database is SELECT .
* There are only three things you need to identify in your statement in order to form a proper SELECT query: what columns to retrieve, what tables to retrieve them from, and what conditions, if any, the data must satisfy.
* A BETWEEN clause allows you to specify the range to be used in a “between x and y” query format.
* The NOT keyword is used to search data in terms of what you don’t want in your output.
* The UNION clause allows you to combine the results of any two or more queries into a resulting single set that will include all the rows belonging to the query in that union.

* The EXCEPT clause returns any distinct values from the left query that are not also found on the right query, whereas the INTERSECT clause returns any distinct values not found on both the left and right sides of this operand.
* The JOIN clause allows you to combine related data from multiple table sources.
* To insert data, you can use SSMS or the INSERT statement.
* The function of the UPDATE statement is to change data in a table or a view.
* The DELETE statement removes rows from a table or a view.

* The TRUNCATE TABLE statement removes data from within a table but leaves the table structure in place for future use.
* An entire table can be removed with the DROP TABLE command. The best way to avoid the accidental deletion of entire tables is to use referential integrity. Referential integrity does not allow deletion of tables unless all of the related tables are deleted using a cascading delete.

---
#### True ir False
1. The SELECT statement is limited to querying data from a single table. **False** join and union

2. The INSERT statement can be used to insert multiple rows at a time. **True**

3. The TRUNCATE statement is used to delete a table. **False**

4. An INNER JOIN condition is the same as a CROSS JOIN and a WHERE condition. **True**

5. The order of the columns in a SELECT statement must match the order in which the columns were created when the table was made. **False**

#### FILL In the Blank
Complete the following sentences by writing the correct word or words in the blanks provided.
1. The SELECT statement is used to query and combine data from one or more **orview??**.

2. The WHERE clause of a SELECT statement contains one or more **conditions** for filtering the data being queried.

3. Using the **TRUNCATE** statement is the most efficient way to delete all rows from a table.

4. To combine the results of two queries, use the **UNION** operator.

5. Use the **UPDATE** statement to modify one or more rows in a table.

6. By using the **BEGIN TRAN** and a **COMMIT** or **ROLLBACK** while performing maintenance tasks, you will catch most accidents before they happen.

7. The removal of an entire table can be accomplished using the **DROP TABLE** and **tabel name** syntax.

8. To select a single column for your query, identify the name of the column by typing it between the **SELECT** and **FROM** words in the query statement.

9. You can **combine** several conditions in one query statement to satisfy your requirements.

10. The **UNION** clause allows you to combine the results of any two or more queries into a resulting single set that will include all the rows belonging to the query.

#### Multiple Choice
Circle the letter that corresponds to the best answer.

1. Which of the following conditions is invalid?
- a. salary <> 50000
- b. salary != 50000
- **c. salary NOT EQUAL 50000**
- d. NOT salary = 50000

2. Which of the following operators is not supported when combining results between SELECT statements?
- a. UNION
- b. EXCEPT
- c. INTERSECT
- **d. AND**

3. Which of the following range conditions would generate a syntax error?
- a. salary <= 50000 and salary >= 10000
- **b. salary between (10000 and 50000) and (60000 and 90000)**
- c. salary >= 10000 and salary <= 50000
- d. salary between 10000 and 50000

4. Which of the following will combine the results of two or more queries into a resulting single set that includes all the rows belonging to the query?
- **a. UNION**
- b. EXCEPT
- c. INTERSECT
- d. AND

5. Which of the following is used to prevent accidental deletion of data in a table?
- a. Transactions
- b. Null values
- c. Inner joins
- **d. Referential integrity**


---
[:top: Top](#top)
##### Lesson 4
## Lesson 4: Understanding Data Storage

### Understand normalization.

### Understand primary, foreign, and composite keys.

### Understand indexes.

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* Normalization, in a nutshell, is the elimination of redundant data to save space.
* In the first normalized form (1NF), the data is in an entity format, which basically means that the following three conditions must be met: the table must have no duplicate records, the table must not have multi-valued attributes, and the entries in the column or attribute must be of the same data type.
* The second normal form (2NF) ensures that each attribute does in fact describe the entity.
* The third normal form (3NF) checks for transitive dependencies. A transitive dependency is similar to a partial dependency in that they both refer to attributes that are not fully dependent on a primary key.
* The fourth normal form (4NF) involves two independent attributes brought together to form a primary key along with a third attribute.

* The fifth normal form (5NF) provides the method for designing complex relationships involving multiple (usually three or more) entities.
* Three different types of constraints available within SQL Server can help you maintain database integrity: primary keys, foreign keys, and composite (unique) keys.
* A unique key constraint allows you to enforce the uniqueness property of columns, in addition to a primary key within a table.
* Perhaps the most important concept in designing any database table is that it has a primary key—an attribute or set of attributes that can be used to uniquely identify each row.
* Every table must have a primary key; without a primary key, it’s not a valid table. By definition, a primary key must be unique and must have a value that is not null.

* In order to connect two tables, the primary key is replicated from the primary to secondary table, and all the key attributes duplicated from the primary table are known as the foreign key.
* A composite primary key occurs when you define more than one column as your primary key.
* The primary drawbacks to using indexes are the time it takes to build the indexes and the storage space the indexes require.
* When you begin implementing indexes, it is important to remember that each table can have only one clustered index that defines how SQL Server will sort the data stored inside it, because that data can be sorted in only one way.
* A non-clustered index contains the non-clustered index key values, and each of those keys has a pointer to a data row that contains the key value.

#### Knowledge Assessment
**True** or **False**
1. Creating a primary key satisfies the first normal form. **True**

2. Tables in a database must satisfy all five normal forms in order to maximize performance. **False** True

3. A primary key can contain NULL values. **False*

4. A clustered index usually improves performance when inserting data. **True**

5. A table can contain only one clustered index. **False**

#### Fill in the Blank
Complete the following sentences by writing the correct word or words in the blanks provided.

1. Normalization is the elimination of redundant data to save **space**.

2. The value of a primary key must be **Unique**.

3. A foreign key works in conjunction with primary key or unique constraints to enforce **referential integrity** between tables.

4. Add an index to one or more columns to speed up data **retrieval**.

5. Values in a clustered index are **sorted**.

#### Multiple Choice
Circle the letter that corresponds to the best answer.

1. Which of the following is not a constraint? d.
- a. CHECK
- b. DEFAULT
- c. UNIQUE
- **d. INDEX**

2. Which of the following things can help speed data retrieval? c.
- a. A DEFAULT constraint
- b. A primary key constraint
- **c. A clustered index**
- d. A foreign key constraint

3. Which of the following statements are true? a. & c.
- **a. A greater number of narrow tables (with fewer columns) is a characteristic of a normalized database.**
- b. A few wide tables (with more columns) are characteristic of a normalized database.
- **c. Indexes allow faster data retrieval.**
- d. Optimal database performance can be achieved by indexing every column in a table.

4. Which of the following statements is not true with regard to foreign keys? d.
- a. A foreign key is a combination of one or more columns used to establish and enforce a link between the data in two tables.
- b. You can create a foreign key by defining a foreign key constraint when you create or alter a table.
- c. A foreign key enforces referential integrity by ensuring only valid data is stored.
- **d. A table can contain only one foreign key.**

5. Consider using a clustered index when: a. b. d.
- **a. Columns contain a large number of distinct values**
- **b. Columns are accessed sequentially**
- c. Columns undergo frequent changes
- **d. Queries return large result sets**

6. Which normal form ensures that each attribute describes the entity? b.
- a. 1NF
- **b. 2NF**
- c. 3NF
- d. 4NF

7. Which of the following could not be used as a primary key? b.
- a. A Social Security number
- **b. An address**
- c. An employee number
- d. The serial number of an electronic component

8. How many clustered indexes can you have for a table? a.
- **a. 1**
- b. 2
- c. 4
- d. 8

9. What is the name for the situation in which more than one columns act as a primary key? a.
- **a. Composite primary key**
- b. Escalating key
- c. Foreign key
- d. Constraint key

10. When you define a primary key, you have met the criteria for: a.
- **a. 1NF**
- b. 2NF
- c. 3NF
- d. 4NF

---
[:top: Top](#top)
##### Lesson 5
### Lesson 5: Administering a Database

### Understand database security concepts.

### Understand database backups and restores.

#### IN THIS LESSON, YOU LEARNED THE FOLLOWING:
* The end result of database security is to ensure that the rights and responsibilities given to users are enforced.
* A permission is used to grant an entity (such as a user) access to an object (such as another user or a database).
* A login or logon is the process by which individual access to a computer system is controlled by identification of the user using credentials provided by the user. The most common login method involves supplying a username and password.
* A user account is a logical representation of a person within an electronic system.
* Even though a user may belong to a fixed database role and have certain administrativelevel permissions, a user still cannot access data without first being granted permission to the database object themselves (e.g., tables, stored procedures, views, functions).

* Each object’s permission is assigned by granting, revoking, or denying user login permissions.
* Authentication is the act of establishing or confirming a user or system identity.
* Windows Authentication mode is superior to mixed mode because users don’t need to learn yet another password and because it leverages the security design of the network.
* The sa account is the built-in SQL administrator account associated with SQL authentication.
* SQL Server includes fixed, predefined server roles. Primarily, these roles grant permission to perform certain server-related administrative tasks.

* The sysadmin role can perform any activity in the SQL Server installation, regardless of any other permission setting. The sysadmin role even overrides denied permissions on an object.
* The public role is a fixed role, but it can have object permissions like a standard role. Every user is automatically a member of the public role and cannot be removed, so the public role serves as a baseline or minimum permission level.
* Users must be explicitly granted access to any user database.
* The db_owner is a special role that has all permissions in the database.
* An application role is a database-specific role intended to allow an application to gain access regardless of the user.

* The purpose of a database backup is to have something to restore if data is lost during a business’s daily routine.
* A full backup contains all the data in a specific database or set of filegroups or files to allow recovering that data.
* Differential backup only backs up data since the last full backup.
* Incremental backup only backs up data since the last full or incremental backup.
* When you restore from differential backup, you must first restore the preceding full backup and then restore the last differential backup.

* When you restore from an incremental backup, you must first restore the preceding full backup and then restore each incremental backup since the full backup in order.

#### True or False
Circle T if the statement is true or F if the statement is false

1. A user must have permissions to access the files that make up a database in order to use the database. **False**

2. Use the CREATE LOGIN statement to allow a Windows account to access SQL-Server. **True**

3. Any DENY permission always overrides a granted permission. **True**

4. Use the CREATE ROLE statement to create new roles within a database. **True**

5. Multiple differential backups must be restored in the same order as originally created. **False**

#### Fill in the Blank
Complete the following sentences by writing the correct word or words in the blanks provided.

1. SQL Server uses Windows **authentication** to verify that a user is valid before access is allowed.

2. A differential backup contains only the data that has **changed** since the differential base.

3. All users are automatically a member of the **public standard** database role.

4. Use the **grant** command to allow users to access objects within the database.

5. Use the **restore** command to recover data that was accidentally deleted by a user.

#### Multiple Choice
Circle the letter that corresponds to the best answer.

1. Which of the following is not a Transact-SQL command to manage permissions? c.
- a. GRANT
- b. REVOKE
- **c. PERMIT
- d. DENY

2. Which of the following is not a level of security supported by SQL Server? d.
- a. Server
- b. Database
- c. Table
- **d. Task

3. Which of the following is not a database permission that can be applied to objects? a.
- **a. DROP
- b. SELECT
- c. INSERT
- d. UPDATE

4. Which of the following are supported database restore scenarios? a. c. d.
- **a. Restore an entire database from a full backup.
- b. Restore an entire database from a series of partial backups.
- **c. Restore part of a database using partial backups.
- **d. Restore specific files used by the database.

5. Which of the following is not a type of backup supported by SQL Server? d.
- a. Full
- b. Differential
- c. File
- **d. Device

6. What is a built-in SQL account used in mixed mode that has full access to the SQL server? d.
- a. fulladmin
- b. sa
- c. admin
- **d. administrator

7. You just hired a new database administrator and you want to give her full access to your SQL server. What role should you assign? c.
- a. diskadmin
- b. securityAdmin
- **c. sysadmin
- d. db_owner

8. What role gives full access to an individual database? b.
- a. db_owner
- **b. db_accessadmin
- c. db_securityadmin
- d. db_ddladmin

9. The best method of data recovery is to: a.
- **a. backup, backup, backup
- b. use RAID
- c. use UPS
- d. use redundant NICs

10. What mode allows both Windows and SQL account logins? d.
- a. Any
- b. Full
- c. Shared
- **d. Mixed

---
[:top: Top](#top)
### some Note
From David Papkin to Everyone:  09:32 AM   
https://davidpapkin.net/mta-database-fundamentals-by-david-papkin/

https://davidpapkin.net/wp-content/uploads/2020/09/TopUp-Contents-for-PPS_with_template.pdf

From Kiat Leong Chua to Everyone:  10:09 AM   
alh.learnondemand.net

window at SQL2008_R2

From David Papkin to Everyone:  12:07 PM    
https://www.w3schools.com/sql/sql_constraints.asp

https://www.essentialsql.com/what-is-the-difference-between-a-join-and-a-union/

https://docs.microsoft.com/en-us/sql/t-sql/language-elements/comment-transact-sql?view=sql-server-ver15

https://www.sqlshack.com/what-is-database-normalization-in-sql-server/

https://en.wikipedia.org/wiki/Database_normalization

What are the two ways to access/manage a SQL DB? Transact & SSMS

Which authentication mode is more secure? windows or mixed mode and why?  Window authentication

So if you wanted to display status information about the sql server.:  `Select * from sys.dm_server_services`

email to dpapkin@gmail.com  
https://davidpapkin.net/mta-database-fundamentals-by-david-papkin/

---
[:top: Top](#top)
