LESSON 6 : Understanding Databases

LESSON SKILL MATRIX
SKILLS/CONCEPTS

MTA EXAM OBJECTIVE

MTA EXAM OBJECTIVE NUMBER

Understanding Objects

Understand relational database
management systems

6.1

Understanding Values and
References

Understand database query methods.

6.2

Understanding Encapsulation

Understand database connection
methods.

6.3

KEY TERMS
attribute
DataSet
database
database integrity
database management
system (DBMs)

disconnected applications
slement
entity-relationship
diagrams (ERDs)

first normal form (1NF)
flat files
functional dependence
normalization
parameterized stored
procedures

primary key
processing instructions
relational database

relational database design
second normal form (2NF)
stored procedure
Structured Query Language (SQL)
third normal form (3NF)

Extensible Markup
Language (XML)

You are a software developer for the Northwind Corporation. As part of your work, you interact with and process data about customers, products, suppliers, and orders. Your work involves interacting with relational databases such as Microsoft SQL Server. However, you also work with data stored in other formats, such as flat files, XML files, and in-memory data. To be effective at your work, you need to know how to connect to various data sources and how to retrieve and update data in these sources.

Understanding Relational Database Concepts
THE BOTTOM LINE

A relational database is a collection of interrelated data based on the relational model developed by E. F. Codd. This model defines distinct data entities, their attributes, and relationships among entities.

Understanding Databases
A database is an organized collection of interrelated data that is managed as a single unit.

A database allows you to store, maintain, and retrieve important data. If a database is properly designed, it can be used by multiple applications and by multiple users. A database management system (DBMS), on the other hand, is software that organizes databases and provides features such as storage, data access, security, backup, etc. Examples of popular DBMSs include Microsoft SQL Server, Microsoft Access, Oracle, and MySql.

Database management systems can be implemented based on different models. Of these models, the relational model is most popular. In the relational model, data is organized into tables, each of which can have multiple rows. DBMSs based on relational models are called relational DBMSs (RDBMSs). SQL Server, Access, Oracle, and MySql are all RDBMSs.

Other database management systems are based on different models. For example, object DBMSs (ODBMSs) are based on the object model, in which data is stored as a collection of objects. In this lesson, however, we will focus solely on the more popular relational databases.

Relational DBMSs use Structured Query Language (SQL) to retrieve and manipulate data. Most popular relational database management systems provide some support for the standardized version of SQL, thereby allowing you to use your skills across different relational database systems.

Understanding Relational Database Concepts
A relational database organizes data in two-dimensional tables consisting of columns and rows.

A relational database organizes information into tables. A table is a list of rows and columns that is conceptually similar to a Microsoft Excel worksheet. A row is also called a record or tuple, and a column is sometimes called a field. The column or field specifies the type of data that will stored for each record in the table. For example, customer orders can be stored in an Orders table in which each row represents a unique order. In this table, columns such as OrderDate can be used to specify that a valid value is of the correct data type. A sample Orders table is shown in Figure 6-1.

Figure 6-1 An Orders table in a relational database 

Figure 6-1 An Orders table in a relational database

Understanding Relational Database Design
Relational database design is the process of determining the appropriate relational database structure to satisfy business requirements.

An organization’s data is one of its most important assets. Thus, when you design a database, one of the guiding principles is to ensure database integrity. Integrity means that the data in the database is accurate and consistent at all times.

The database design process consists of the following steps:

1.

Develop a mission statement for the database: Identifies the purpose of the database, how it will be used, and who will use it. This step sets the tone for the rest of the design process.

2.

Determine the data that needs to be stored: Identifies all the different types of data that need to be stored in the database. Generally, this information is collected as part of the requirements analysis task via entity-relationship diagrams.

3.

Divide the data into tables and columns: Identifies the tables and the information that you want to store in those tables.

4.

Choose primary keys: A primary key is a column or set of columns that uniquely identifies each row of data in a table.

5.

Identify relationships: Identifies how the data in one table is related to the data in another table. For example, for each customer in a Customers table, you may have many orders in the Orders table; this relationship is called a one-to-many relationship.

6.

Apply the normalization process: Applies data normalization rules to ensure that any problems that may affect data integrity are resolved. You’ll learn more about the normalization process later in this lesson.

After you’ve established the purpose of a database, the next set of steps (Step 2 through Step 5) can be completed as part of entity-relationship modeling. The final step of normalization can then be applied to the output from this modeling.

Understanding Entity-Relationship Diagrams
Entity-relationship diagrams (ERDs) are used to model entities, their attributes, and the relationships among entities. Entity-relationship diagrams can help you determine what data needs to be stored in a database.

Entity-relationship modeling is a process used to create the conceptual data model of a system, and entity-relationship diagrams are the graphical modeling tools for accomplishing this modeling. The basic building blocks of an ERD are entity, attribute, and relationship:

•

Entity: An entity is a construct for a physical object or a concept. Examples include an order, a customer, an employee, and so on. An entity is generally named for the noun that it represents.

•

Attribute: Attributes are the distinct properties of an entity. For example, for an Order entity, some useful attributes may be OrderNumber, OrderDate, ShipDate, and ShipVia. Similarly, for an Employee entity, some useful attributes may be EmployeeId, LastName, FirstName, Title, and HireDate. Every entity must have a set of uniquely identifying attributes that is known as the entity’s primary key. For example, an OrderNumber is an attribute that uniquely identifies an order, so it is therefore a primary key for the Order entity.

•

Relationship: A relationship is an association between entities. For example, Takes is a relationship between an Employee entity and an Order entity (i.e., Employee Takes Order).

Note that ERDs don’t show single entities or single relations. For example, there may be thousands of Order entities and hundreds of Customer entities. Instead, these diagrams show entity sets and relationship sets—for instance, all the thousands of Order entities may make up one entity set. In fact, when an Order or Customer appears in an ERD, it usually refers to an entity set rather than an individual entity.

ERDs use certain design conventions. In particular:

•

A rectangle represents an entity set.

•

An ellipse represents an attribute.

•

A diamond represents a relationship set.

•

Solid lines link entity sets to relationship sets and entity sets to attributes.

Figure 6-2 shows an example ERD. In this diagram, the two entity sets are Customer and Order. Attributes associated with Customer are ID, Name, and City. Attributes associated with Order are OrderID, OrderDate, and ShipDate. Those attributes that form a primary key are underlined. Also, as shown in the figure, the relationship between Customer and Order is Places.

Figure 6-2 An entity-relationship diagram 

Figure 6-2 An entity-relationship diagram

Within an ERD, a relationship can be classified as a one-to-one relationship, a one-to-many relationship, or a many-to-many relationship. In Figure 6-2, the line that connects the relationship Places with the entity set Customer is labeled “1,” whereas the line between Places and the entity set Order is labeled “N.” This is an example of a one-to-many relationship. In this relationship, one customer can place many orders, but an order can have only one customer associated with it.

MAPPING ERDs TO A RELATIONAL DATABASE
In order to convert an ERD to a relational database, you must take following steps:

1.

Map the entities: Start by creating a table for each entity set in the diagram. The attributes will become columns. Be sure to set the primary key attribute(s) to the primary key column(s) for the table.

2.

Map the relationship: Next, map the one-to-many relationship by ensuring that the table on the N side of the relationship contains the primary key column of the table on the 1 side of the relationship. For Figure 6-2, this can be accomplished by adding a CustomerID column in the Order table that maps to the ID column of the Customer table. In the context of the Order table, the CustomerID is also called a foreign key. By adding this column in the Order table, it is possible to answer questions such as “What are all the orders placed by a specific customer?” and “Who is the customer for a specific order?”

When mapped to a relational database, the ERD in Figure 6-2 generates the following tables:

Customers

ID

NAME

CITY

1001

Jane Doe

Berlin

1002

John Doe

Tokyo

1003

Howard Steel

Sydney

Orders

ORDERID

CUSTOMERID

ORDERDATE

SHIPDATE

101

1001

10/1/2010

10/7/2010

102

1002

10/5/2010

10/10/2010

103

1001

10/4/2010

10/10/2010

Understanding Data Normalization
The process of data normalization ensures that a database design is free of any problems that could lead to loss of data integrity.

Entity-relationship analysis helps you ensure that you’ve identified the correct data items for your database. Then, through the process of data normalization, you apply a set of normalization rules to make sure that you have established the correct database design—that is, you check whether the columns belong to the right tables in order to ensure that your database is free of any undesirable problems.

For example, as part of entity-relationship analysis, you may come up with a Books table that has the following columns:

Books

BOOKID

BOOKNAME

CATEGORYID

CATEGORYNAME

1

Cooking Light

1001

Cooking

2

Prophecy

1002

Mystery & Thriller

3

Shift

1003

Business

4

The Confession

1002

Mystery & Thriller

However, this design for the Books table suffers from three problems:

•

Insert anomaly: An insert anomaly is a situation in which you cannot insert new data into a database because of an unrelated dependency. For example, if you want your database to have a new CategoryId and CategoryName for history books, the current design will not permit that unless you first have a history book to place in that category.

•

Delete anomaly: A delete anomaly is a situation in which the deletion of one piece of data causes unintended loss of other data. For example, if you were to delete the BookId 3 from the Books table, the very fact that you ever had a CategoryName of Business would be lost.

•

Update anomaly: An update anomaly is a situation in which updating a single data value requires multiple rows to be updated. For example, say you decide to change the Mystery & Thriller category name to just Mystery. With the current table design, you’ll have to change the category name for every book in that category. There is also a risk that if you update the category name in one row, but not the others, you’ll end up having inconsistent data in the database.

Each of these problems can be fixed by following the normalization process. There are five normal forms that are used as part of this process; however, this lesson only discusses the first three, because they are all that is required in most cases.

TAKE NOTE*

Normalization can help you ensure a correct database design, but it cannot ensure that you have the correct data items to begin with.

UNDERSTANDING THE FIRST NORMAL FORM
In order for a table to be in the first normal form (1NF), none of the columns in the table should have multiple values in the same row of data. For example, if a Customers table stores data as shown below, this table is not in 1NF because the PhoneNumber column is storing more than one value in each row.

Customer

ID

FIRSTNAME

LASTNAME

PHONENUMBER

1

Jane

Doe

(503) 555-6874

2

John

Doe

(509) 555-7969,
(509) 555-7970

3

Howard

Steel

(604) 555-3392,
(604) 555-3393

TAKE NOTE*

A general convention is to underline the name of the columns in a table that are part of the primary key.

For this table to be in 1NF, you would need to break the table in two:

Customer

ID

FIRSTNAME

LASTNAME

1

Jane

Doe

2

John

Doe

3

Howard

Steel

CustomerPhones

ID

PHONENUMBER

1

(503) 555-6874

2

(509) 555-7969

2

(509) 555-7970

3

(604) 555-3392

3

(604) 555-3393

Here, the Customers table and the CustomerPhones table are both in 1NF. Both tables have a primary key (Id in the first table and the combination of Id and PhoneNumber in the second table) that establishes a relationship between them. Given any Id for a customer, you can find all phone numbers for that customer without any confusion. On the other hand, LastName is not a primary key because a last name may have duplicate entries.

TAKE NOTE*

Creating repeating columns such as PhoneNumber1 and PhoneNumber2 to normalize the Customer table would not be an acceptable solution because the first normalization form does not allow such repeating columns.

UNDERSTANDING THE SECOND NORMAL FORM
For a table to be in second normal form (2NF), it must first meet the requirements for 1NF. In addition, 2NF requires that all non-key columns are functionally dependent on the entire primary key.

In order to understand 2NF, you must first understand functional dependence. Let’s take the example of the Customers table above. In the Customers table, the Id column is the primary key because it uniquely identifies each row. The columns FirstName and LastName are non-key columns, because they are not part of the primary key. Both FirstName and LastName are functionally dependent on Id because, given a value of Id, you can always find a value for the corresponding FirstName and LastName without any ambiguity. There is no non-key column in the Customers table that does not functionally depend on the primary key. The Customers and CustomerPhones table are therefore already in 2NF.

TAKE NOTE*

2NF only applies to tables that have composite primary keys (i.e., multiple columns together make up the primary key). The combined values of all fields in a composite primary key must be unique. If a table satisfies 1NF and has only a single column in its primary key, then the table also conforms to 2NF.

In contrast, consider the following table:

Orders

ORDERID

CUSTOMERID

ORDERDATE

CUSTOMERNAME

101

1

10/1/2010

Jane Doe

102

2

10/5/2010

John Doe

103

1

10/4/2010

Jane Doe

Here, the OrderId and CustomerId columns together identify a unique row and therefore make up a composite primary key. However, the column OrderDate is functionally dependent only on OrderId, and the column CustomerName is dependent only on CustomerId. This violates the 2NF because the non-key columns are functionally dependent on only part of the primary key.

One possible way you could modify the Orders table to conform to 2NF is to take CustomerName out of the table and have only three columns—OrderId, CustomerId, and OrderDate—with only OrderId serving as the primary key. In this solution, both CustomerId and OrderDate are functionally dependent on OrderId and thus conform to 2NF.

UNDERSTANDING THE THIRD NORMAL FORM
The third normal form (3NF) requires that 2NF is met and that there is no functional dependency between non-key attributes. In other words, each non-key attribute should be dependent on only the primary key and nothing else. For example, consider the following table:

Items

ITEMID

SUPPLIERID

REORDERFAX

101

100

(514) 555-2955

102

11

(514) 555-9022

103

525

(313) 555-5735

Here, ItemId is the primary key. However, ReorderFax is a fax number for the supplier and is therefore functionally dependent on SupplierId. To satisfy the requirement of 3NF, this table should be decomposed into two tables: Items (ItemId, SupplierId) and Supplier (SupplierId, ReorderFax).

Items

ITEMID

SUPPLIERID

101

100

102

11

103

525

Supplier

SUPPLIERID

REORDERFAX

100

(514) 555-2955

11

(514) 555-9022

525

(313) 555-5735

CERTIFICATION READY

Do you understand the basics of relational database management systems?

6.1

Understanding Database Query Methods
THE BOTTOM LINE

Data is at the core of many business applications, and, as a developer, you will likely spend a lot of time working on data-related tasks. In this section, you will learn how to use Structured Query Language (SQL) and SQL Server-stored procedures to select, insert, update, and delete data.

SQL is the language used by most database systems to manage the information in their databases. SQL commands permit you to retrieve and update data. SQL commands also let you create and manage database objects such as tables. SQL may be thought of as a programming language for relational databases. However, SQL is declarative in nature, as opposed to the imperative nature of most common programming languages.

In SQL, you tell the database what needs to done, and it’s the database’s job to figure out how to do it—for example, you can tell the database to select the first 10 rows from a table. Compare this with an imperative programming language such as C#, in which you need to specify in detail how the work is to be performed. For example, you might need to create a loop that runs ten times, set up and initialize variables, move record pointers, and so on.

SQL is an ANSI (American National Standards Institute) standard, but different database vendors have implemented their own extensions to standard SQL. Microsoft SQL Server’s implementation of SQL is called Transact-SQL (T-SQL).

There are two main ways to submit T-SQL to SQL Server. You can either use ad-hoc SQL statements that are executed directly, or you can use stored procedures. Stored procedures are collections of SQL statements and programming logic that are stored on the database server as named objects.

Working with SQL Queries
SELECT, INSERT, UPDATE, and DELETE statements are the four main types of SQL statements used to manipulate SQL Server data.

Using ad-hoc SQL queries is a flexible way to work with a SQL Server database. In this portion of the lesson, you’ll learn the basics about the four main types of SQL statements that help you manipulate SQL Server data:

•

SELECT statements allow you to retrieve data stored in a database.

•

INSERT statements allow you to add new data to a database.

•

UPDATE statements allow you to modify existing data in a database.

•

DELETE statements allow you to delete data from a database.

CONNECTING TO A SQL SERVER DATABASE
You need to connect to a SQL Server database before you can manipulate any information in that database.

In this exercise, you’ll learn how to work with a Microsoft SQL Server database. If you don’t have access to a recent version of SQL Server, you can download SQL Server 2008 Express for free from www.microsoft.com/express/database. This exercise uses the SQL Server sample database Northwind. This database is not installed by default with SQL Server, but you can download the database file by following the instructions at www.msdn.com/en-us/library/ms143221.aspx.

Complete the following exercise to connect to and use the Northwind database with Visual Studio.

CONNECT TO THE NORTHWIND DATABASE
GET READY. Before you begin these steps, be sure to launch Microsoft Visual Studio.

1.

Open the Server Explorer window. Select the Data Connections node, then click the Connect to Database button on the Server Explorer toolbar.

TAKE NOTE*

In Visual Studio Express Edition, the Server Explorer window is called Database Explorer, and it can be opened by selecting View > Other Windows > Database Explorer.

2.

In the Add Connection dialog box, browse to the database file for the Northwind database (northwnd.mdf), as shown in Figure 6-3.

Figure 6-3 Connecting to the Northwind database 

Figure 6-3 Connecting to the Northwind database

3.

Use Windows Authentication as the authentication mode, and click the Test Connection button to make sure you can connect to the database. Finally, click the OK button to add the connection to the database.

4.

Once the connection is established, the database is available as a connection under the Data Connections node in Server Explorer. Expand the database to see the tables, stored procedures, and other database objects, as shown in Figure 6-4.

Figure 6-4 Accessing the Northwind database through Server Explorer 

Figure 6-4 Accessing the Northwind database through Server Explorer

5.

Right-click the NORTHWND.MDF node and select Properties. You should see the Properties window shown in Figure 6-5. In this window, notice the Connection String property. You’ll use the value of this property to connect to the Northwind database from a C# application.

Figure 6-5 Properties window for the Northwind database 

Figure 6-5 Properties window for the Northwind database

PAUSE. You will access data from the Northwind database in the next exercise.

RUNNING SQL QUERIES
There are many ways to communicate with SQL Server in order to run database queries.

There are many ways in which you can send queries to a SQL Server. For example, you can use any of the following:

•

Visual Studio Integrated Development Environment (IDE)

•

C# application

•

SQL Query Analyzer

•

osql command prompt utility

Note that SQL Query Analyzer and osql command prompt utilities are tools installed with SQL Server.

RUN QUERIES FROM VISUAL STUDIO
GET READY. To use Visual Studio IDE and C# applications to run SQL queries, perform these steps:

1.

Select the Northwind database in the Server Explorer. Right-click the database and select New Query. This action opens a Query Designer and shows an Add Table dialog box. Select the Customers table and click Add. Click Close in the Add Table dialog box.

2.

In the SQL pane of the Query Designer (which is the area that displays the text of the query), modify the SQL statement to the following:

SELECT * FROM Customers

3.

From the Visual Studio menu, select the Query Designer > Execute SQL option, or click on the Execute SQL button in the toolbar. The SQL statement will be sent to the SQL server for execution, and results like those in Figure 6-6 should be displayed.

Figure 6-6 Visual Studio Query Designer 

Figure 6-6 Visual Studio Query Designer

The Query Designer in Visual Studio displays up to four panes. From top to bottom, the panes are as follows:

•

Diagram pane: This pane displays the tables involved in the query and the relationships among these tables, as well as all the columns that the tables contain.

•

Criteria pane: The Criteria pane shows the columns that have been selected as part of the query, as well as additional sorting and filtering information.

•

SQL pane: This pane shows the actual SQL statement that will be executed.

•

Results pane: The Results pane shows the results (if any) after the query has been executed.

The Query Designer toolbar includes buttons that you can use to hide or show any of these four panes. For the following exercise, you need only the SQL pane and the Results pane.

RUN QUERIES FROM C# APPLICATION
GET READY. To run queries from C# applications, do the following:

1.

Create a new Windows Application project named QueryCS.

2.

To the Windows Form, add a TextBox control, a Button control, and a DataGridView control. Set the MultiLine property of the TextBox to True. Set the Text property of the Button control to Execute SQL.

3.

Double-click the Button control to generate an event handler for its Click event. Modify the event handler as shown below:

private void button1_Click(
  object sender, EventArgs e)
{
  if (textBox1.TextLength > 0)
  {
   SelectData(textBox1.Text);
  }
}
4.

Add the following method to the class. Be sure to change the connection string to match the local path of the database file on your computer:

private void SelectData(string selectCommandText)
{
  try
  {
    // Change the connection string
    // to match with your system.
    string selectConnection =
    @"Data Source=.\SQLEXPRESS;" +
    @"AttachDbFilename=" +
    @"c:\SqlSampleDB\NORTHWND.MDF;" +
    @"Integrated Security=True;" +
    @"Connect Timeout=30;User Instance=True";
    SqlDataAdapter dataAdapter =
      new SqlDataAdapter(
       selectCommandText, selectConnection);
    DataTable table = new DataTable();
    dataAdapter.Fill(table);
    dataGridView1.DataSource = table;
  }
  catch (Exception ex)
  {
    MessageBox.Show(ex.Message);
  }
}
5.

Add the following using directives to the code:

using System.Data; using System.Data.SqlClient;

Select Debug > Start Debugging to run the project. Enter a valid SQL query and click on the Button control. You should see the output shown in Figure 6-7.

Figure 6-7 Running queries from a C# application 

Figure 6-7 Running queries from a C# application

The code in this exercise implements a SelectData method that initializes a SqlDataAdapter object and uses it to populate a DataTable. The DataTable is then bound as a data source for the DataGridView component. The SqlDataAdapter object acts as a pipeline between SQL Server and the DataTable for retrieving data. The Fill method changes the data in the DataTable to match the data in the data source. The selectCommandText is used to identify the data in the data source.

SELECTING DATA
The SELECT statement is used to retrieve data from one or more database tables.

The SELECT statement generally takes the following form:

SELECT list_of_fields
FROM list_of_tables
WHERE where_clause
GROUP BY group_by_clause
HAVING having_clause
ORDER BY order_by_clause
Each of these lines of code in the SELECT statement is called a clause. The SELECT and FROM clauses are required, but the rest are optional. For example, here’s a SQL statement that contains only the required clauses:

SELECT OrderId, CustomerId
FROM Orders
If you want to list all the fields from a table, you can also use the following shortcut instead of explicitly listing all the fields:

SELECT *
FROM Orders
In addition, you can select information from multiple tables; for example:

Select OrderId, Customers.CustomerId, ContactName
From Orders, Customers
Customers.CustomerId is known as a fully qualified name because it specifies both the table name and field name. This is necessary because both the Orders table and the Customers table include this field, so you must tell SQL Server which particular table you want to refer to.

If you run this query, you will get a lot more records than you might expect. This happens because, although you told SQL Server what tables to include, you didn’t include any information on how to relate those tables. As a result, SQL Server constructs the result set to include all rows of the Customer table for every row of the Orders table. This kind of join is called a cross join, and it is not very helpful in this case.

A more useful query, of course, would match each order with the corresponding customer. The INNER JOIN keyword can help you accomplish this, as shown in the following query:

SELECT OrderID, Customers.CustomerId, ContactName
FROM Orders INNER JOIN Customers
ON Orders.CustomerId = Customers.CustomerId
This query tells SQL Server to take each row in the Orders table and match it with all rows in the Customers table in which the CustomerId of the order equals the CustomerId of the customer. Because CustomerId is unique in the Customers table, this is the same as including only a single row for each order in the result set. In this case, the result set will have as many rows as there are rows in the Orders table.

But what if you want to see only some of the rows in the table? In this situation, you can use the WHERE clause. The WHERE clause evaluates each row for a condition and decides whether to include it in the result set. For example:

TAKE NOTE*

The standard delimiter for text and dates in SQL Server is the single quotation mark.

SELECT * 
FROM Orders
WHERE ShipCountry = 'Canada' 
Here, the WHERE clause looks at every row in the Orders table to see whether the ShipCountry has the exact value “Canada.” If it does, the row is included in the result set; if it does not, the row is not included in the result set.

You can also combine multiple conditions in a single WHERE clause. For example:

SELECT * 
FROM Orders
WHERE (ShipCountry = 'Canada')
AND (OrderDate >= '01/01/97')
AND (OrderDate <= '01/31/97') 
Here, the WHERE conditions filters the orders in which the ShipCountry is “Canada” and the order date is in January 1997.

By default, SQL does not guarantee the results to be in a particular order. However, you can use the ORDER BY clause to ensure that your desired data is returned in a particular order. For example, to list the orders based on their order date, you can use the following query:

SELECT * 
FROM Orders
WHERE (ShipCountry = 'Canada')
AND (OrderDate >= '01/01/97')
AND (OrderDate <= '01/31/97')
ORDER BY OrderDate
You can modify the sort order by using either the keyword ASC (for ascending order) or the keyword DESC (for descending order). The default sort order is ascending. Thus, the following query lists the most recent orders at the top:

SELECT * 
FROM Orders
WHERE (ShipCountry = 'Canada')
AND (OrderDate >= '01/01/97')
AND (OrderDate <= '01/31/97') 
ORDER BY OrderDate DESC
It is quite common for business applications to request aggregate or summarized data. Such requirements can be addressed using the GROUP BY clause and the aggregate functions. For example, you can use the following query to find which countries you ship most of your orders to:

SELECT ShipCountry, COUNT(ShipCountry) AS OrderCount
FROM Orders
GROUP BY ShipCountry
ORDER BY OrderCount DESC
This will display the name of each country followed by the total number of orders shipped to that country. The ORDER BY clause sorts the result and places the countries with the most orders at the top of the list.

You can think of the GROUP BY clause as creating “buckets”—in this case, one for each country. As the database engine examines each record, it tosses it in the appropriate bucket. After this process is complete, the database engine counts the number of records that ended up in each bucket and outputs a row for each one. Figure 6-8 shows the start of the result set from this query.

Figure 6-8 Summarizing information using the GROUP BY clause 

Figure 6-8 Summarizing information using the GROUP BY clause

In the previous SQL statement, Count is an aggregate function—that is, it returns a result based on a group of rows. T-SQL supports a number of different aggregate functions. Some of the most common are as follows:

•

Count: Returns the number of records

•

Sum: Returns the total value in a given column

•

Avg: Returns the average value in a given column

•

Min: Returns the smallest value in a given column

•

Max: Returns the largest value in a given column

UPDATING DATA
The UPDATE statement is used to update information in database tables.

Another useful SQL statement is the UPDATE statement. The purpose of an UPDATE statement is to update or modify data. For example, you can update a field in a record in the Customers table using the following query:

UPDATE Customers
SET ContactName = 'Maria Anderson'
WHERE CustomerId = 'ALFKI'
In this query, the SET keyword tells SQL Server which columns to update, and the WHERE keyword tells it which rows to update. In the Customers table, CustomerId is a primary key and is uniquely identified a single row. Therefore, this UPDATE statement can update one row at most.

Note, however, that you are not limited to updating just a single record. Rather, if the WHERE clause selects multiple records, all of these records will be updated:

TAKE NOTE*

In an UPDATE statement, the SET clause is required and can be specified only once.

UPDATE Customers
SET Country = 'United States'
WHERE Country = 'USA'
You can also update more than one field at a time with an UPDATE statement, as in the following example:

TAKE NOTE*

It is highly recommended that you carefully review the WHERE clause for each UPDATE statement.

If you are not careful, you may update data for more rows than you intend.

UPDATE Customers
SET ContactName = 'Maria Anderson',
CITY = 'Tokyo'
WHERE CustomerId = 'ALFKI'
INSERTING DATA
The INSERT statement is used to add one or more rows to a database table.

The INSERT statement lists the fields for the target table followed by a set of values to insert in these fields. For example, the following INSERT statement inserts a row in the Order Details table:

INSERT INTO [Order Details]
(OrderId, ProductId, UnitPrice, Quantity, Discount)
VALUES (10248, 2, 19.00, 2, 0)
Square brackets are required when the names of tables or fields contain spaces. Here, the first set of parentheses holds a column list, and the second set holds the values to insert. If a field has a default value, can be null, or is an identity field, you can leave it out of the field list, as in the following example:

INSERT INTO [Order Details]
(OrderId, ProductId, UnitPrice, Quantity)
VALUES (10249, 2, 19.00, 2)
This statement works even though no value was specified for the field Discount. Also, with this statement, you can rearrange a field list as long as you rearrange the value list to match:

INSERT INTO [Order Details]
(ProductId, OrderId, UnitPrice, Quantity)
VALUES (2, 10250, 19.00, 2)
The INSERT statement isn’t limited to inserting a single record. In fact, there’s a second format that inserts the results of a SELECT statement into the target table. For example, this query inserts a product from every supplier into the Products table:

INSERT INTO Products
(SupplierId, ProductName, CategoryId)
SELECT SupplierId, 'Almond', 7
FROM Suppliers
This query works by building the results of the SELECT statement and then putting each row returned by the SELECT statements into the target table. Of course, the columns still need to match properly.

DELETING DATA
The DELETE statement is used to remove information from database tables.

The DELETE statement removes data from a table. For practice purposes and to avoid deleting data from the same database, you can copy a table using a SELECT statement, as in the following example:

SELECT * INTO CustomersCopy
FROM Customers
This statement selects all records from the Customers table and copies them to a new table named CustomersCopy.

To delete a single row of data from the CustomersCopy table, you would use the following DELETE statement:

DELETE FROM CustomersCopy
WHERE CustomerId = 'ALFKI'
Be careful, because if you omit the WHERE clause, you will delete all data from the table:

DELETE FROM CustomersCopy
Working with Stored Procedures
A stored procedure is a set of SQL statements that is stored in a database. Stored procedures can be used by multiple applications.

In contrast to ad hoc queries, stored procedures are queries that are stored permanently on a SQL Server. You can think of stored procedures as the SQL equivalent of C# methods.

Stored procedures have two main benefits. First, you can use them to save complex SQL statements for future execution. Second, SQL Server compiles stored procedures so that they run faster than ad hoc queries. In this section of the lesson, you’ll learn how to create and run stored procedures.

CREATING AND RUNNING A STORED PROCEDURE
The CREATE PROCEDURE command can be used to create a new stored procedure.

You can use T-SQL’s CREATE PROCEDURE keyword to create a stored procedure. You can run the CREATE PROCEDURE statement from any interface that allows you to enter and execute T-SQL.

CREATE A STORED PROCEDURE FROM VISUAL STUDIO
GET READY. To create a stored procedure from Visual Studio, perform the following actions:

1.

Open Server Explorer and select the Northwind database. Right-click the Stored Procedure node and select the Add New Stored Procedure option.

2.

In the stored procedure designer, replace the boilerplate text with the following code:

CREATE PROCEDURE GetCustomersFromFrance
AS
  SELECT * FROM Customers
  Where Country = 'France'
RETURN
3.

Save the stored procedure. The stored procedure is now added to the database.

4.

To execute the stored procedure, right-click the stored procedure in the Server Explorer and select Execute. The result from the stored procedure should be displayed in the Output window.

5.

You can also execute this stored procedure from the QueryCS project that you created earlier. Here, instead of a SQL statement, just type the name of the stored procedure and click the Execute SQL button. The result from the stored procedure will be displayed on the Windows Form.

TAKE NOTE*

You can use the ALTER PROCEDURE statement to modify the definition of an existing stored procedure.

WORKING WITH PARAMETERIZED STORED PROCEDURES
Parameterized stored procedures allow you to pass runtime arguments to the SQL Server.

The ability to pass parameters significantly increases the power of stored procedures. The parameter values can be supplied at runtime to the stored procedures.

Say that you want to find out the total sales for a given customer in the Northwind database. In this situation, you should be able to specify the CustomerId at runtime.

CREATE A PARAMETERIZED STORED PROCEDURE
GET READY. To create a parameterized stored procedure, take the following actions:

1.

Open Server Explorer and select the Northwind database. Right-click the Stored Procedure node and select the Add New Stored Procedure option.

2.

In the stored procedure designer, replace the boilerplate text with the following code:

CREATE PROCEDURE dbo.GetCustomerSales
   (
   @CustomerId char(5),
   @TotalSales money OUTPUT
   )

 AS
   SELECT @TotalSales = SUM(Quantity * UnitPrice)
   FROM (Customers INNER JOIN Orders
   ON Customers.CustomerId = Orders.CustomerId)
   INNER JOIN [Order Details]
   ON Orders.OrderId = [Order Details].OrderId
   WHERE Customers.CustomerId = @CustomerId
 RETURN
3.

Save the stored procedure. The stored procedure is now added to the database.

In this stored procedure, both @CustomerId and @TotalSales are parameters. @CustomerId is an input parameter; you must supply a value for this parameter when you run the stored procedure. @TotalSales is an output parameter; it returns a value from the stored procedure. When you run this stored procedure from Visual Studio, you get a dialog box prompting you to enter the value for all the parameters, as shown in Figure 6-9.

Figure 6-9 The Run Stored Procedure dialog box prompts for the parameter values 

Figure 6-9 The Run Stored Procedure dialog box prompts for the parameter values

To run this stored procedure, enter ALFKI as the value for @CustomerId and enter NULL as the value for @TotalSales. When you press the OK button, the calculated value of the output parameter, @TotalSales, is displayed in the Output window.

You cannot, however, run a parameterized stored procedure from the QueryCS project, because the code there can’t accept parameters.

RUN PARAMETERIZED STORED PROCEDURES FROM C#
GET READY. To run parameterized stored procedures from C#, perform the following tasks:

1.

Create a new Windows Application project named ParameterizedSP.

2.

Place a Label control on the form and set its Text property to "Customer Id:". Place a TextBox control next to it and name the control as CustomerIdTextBox. Next, place a Button control and set its Name property as GetTotalSalesButton and the Text property a "Get Total Sales." Finally, place a Label control on the form and name it as TotalSalesLabel. Arrange the controls so they look similar to Figure 6-10.

3.

Double-click the Button control to generate an event handler for its Click event. Modify the event handler as shown below:

private void GetTotalSalesButton_Click(
    object sender, EventArgs e)
{
  TotalSalesLabel.Text = String.Format(
    "Total Sales: {0}",
    GetTotalSales(CustomerIdTextBox.Text));
}
4.

Add the following method to the class. Be sure to change the connection string to match the local path of the database file on your computer:

private double GetTotalSales(string customerId)
{
  double totalSales = −1;
  try
  {
    // Change the connection string
    // to match with your system.
     string connectionString =
    @"Data Source=.\SQLEXPRESS;" +
    @"AttachDbFilename=" +
    @"c:\SqlSampleDB\NORTHWND.MDF;" +
    @"Integrated Security=True;" +
    @"Connect Timeout=30;User Instance=True";
     SqlConnection connection =
       new SqlConnection(connectionString);
     SqlCommand command =
       connection.CreateCommand();
     command.CommandType =
       CommandType.StoredProcedure;
     command.CommandText = "GetCustomerSales";
      command.Parameters.AddWithValue(
       "@CustomerId", customerId);
     command.Parameters.AddWithValue(
       "@TotalSales", null);
     command.Parameters["@TotalSales"].DbType
       = DbType.Currency;
     command.Parameters["@TotalSales"].Direction
       = ParameterDirection.Output;
     connection.Open();
     command.ExecuteNonQuery();

     totalSales = Double.Parse(
       command.Parameters["@TotalSales"]
       .Value.ToString());
     connection.Close();
  }
  catch (Exception ex)
  {
    MessageBox.Show(ex.Message);
  }
  return totalSales;
}
5.

Add the following using directives to the code:

using System.Data; using System.Data.SqlClient;

Select Debug > Start Debugging to run the project. Enter a valid CustomerId. You should see the output shown in Figure 6-10.

Figure 6-10 Running parameterized stored procedures from a C# application 

Figure 6-10 Running parameterized stored procedures from a C# application

In the code, parameters are represented by SqlParameter objects. The code works by setting the value for the @CustomerId parameter, executing the SqlCommand object corresponding to the stored procedure, and then retrieving the Value property of the @TotalSales parameter.

TAKE NOTE*

If you add a new row to a table with an identity column, you can use the SQL Server variable @@IDENTITY to retrieve the value of the identity column for the newly created row.

The previous code has the following lines:

connection.Open();
command.ExecuteNonQuery();
totalSales = Double.Parse(
  command.Parameters["@TotalSales"]
  .Value.ToString());
connection.Close();
Here, you first open the database connection, do what you need to do with the connection, and then close the connection. The object that holds references to the database connection uses a lot of system resources and is therefore costly to run. Accordingly, it is recommended that you close this object as soon as you are done using it. If you don’t close the connection, you are creating a memory leak in the program that could impact its performance.

C# also gives you a using statement that can help ensure that costly objects such as database connections are automatically closed when you are done with them. Here is an alternate version of the above code that makes use of the using statement to automatically close the database connection:

TAKE NOTE*

The object used with the using statement must implement the IDisposable interface.

CERTIFICATION READY

Do you understand the various database query methods?

6.2

// disposing objects with using statement
using (connection)
{
  connection.Open();
  command.ExecuteNonQuery();
  totalSales = Double.Parse(
    command.Parameters["@TotalSales"]
    .Value.ToString());
}
Note that the using statement defines a scope for the connection object. When the code reaches the end of that scope, the connection object is automatically closed, and all resources are released.

CERTIFICATION READY

Do you understand database connection methods?

6.3

Understanding Database Connection Methods
THE BOTTOM LINE

Business applications may require data in various formats. For example, you may need to work with flat files, XML files, and in-memory objects.

The .NET Framework provides classes that are optimized for working with flat files, XML files, and in-memory objects. The data stored inside flat files can be handled by using the classes in the System.IO namespace. To work with XML data, the classes in the System.Xml namespace can be used. Finally, to work with in-memory objects such as a DataSet, classes in the System.Data namespace are used. You will learn more about how to work with each of these data formats in the following sections.

Working with Flat Files
A flat file is a database table that is stored inside a stand-alone disk file.

A flat file usually contains one row of data per line, and the columns are separated by delimiters such as commas or have a fixed length. The data in a flat file can be plain text or binary. These files are called “flat files” to distinguish them from more structured forms of storage, such as relational databases and XML files.

Historically, before the advent of modern databases, flat files were a popular way to store and organize information. Flat files are still useful today, although only in limited scenarios rather than as general-purpose databases. Some of the places in which flat files are used are operating system or application configuration files, when transferring data to remote systems, and when migrating data between noncompatible systems.

File-based input and output in the .NET Framework revolves around the concept of streams and backing store. A stream is a flow of raw data, and a backing store is the source or destination of the stream. A backing store might be a disk file, memory, network connection, etc. You can find classes for working with streams and backing stores in the System.IO namespace. As previously mentioned, flat files can be in either plain-text or binary format. Text files are often organized as lines of text separated by end-of-line characters. The StreamReader and StreamWriter classes provide you with an easy way to manipulate such text files.

Binary files store their content as a sequence of bytes. Although binary files are not human-readable like text files, they are capable of storing a variety of data, such as images, sounds, video, etc. You will always need a computer program to interpret the contents of a binary file. The BinaryReader and BinaryWriter classes provide you with an easy way to manipulate binary files.

In the following exercise, you select columns from the Customers table and write them to a text file. Later, you open this text file and display its contents in the Console window.

READ FROM AND WRITE TO A TEXT FILE
GET READY. To read from and write to a text file, do the following:

1.

Create a new Console Application project named WorkingWithTextFiles.

2.

Add the following code to the Program class. You will need to correct the path to your Northwind database in the code:

static void Main(string[] args)
{
  string myDocumentsPath =
     Environment.GetFolderPath(
     Environment.SpecialFolder.MyDocuments);
  CopyDataToTextFile(myDocumentsPath
     + @"\CustomerList.txt");
  DisplayTextFile(myDocumentsPath
     + @"\CustomerList.txt");
}
staticprivate void CopyDataToTextFile(
 string fileName)
{
  try
  {
      // Change the connection string
      // to match with your system.
      string connectionString =@"Data Source=.\SQLEXPRESS;" +
     @"AttachDbFilename=" +
     @"c:\SqlSampleDB\NORTHWND.MDF;" +
     @"Integrated Security=True;" +
     @"Connect Timeout=30;User Instance=True";
      SqlConnection connection =
       new SqlConnection(connectionString);
      SqlCommand command =
       connection.CreateCommand();

      command.CommandText =
       "SELECT CustomerId, CompanyName,"
       + "ContactName, Phone FROM Customers";
     using (connection)
     {
       connection.Open();
       SqlDataReader reader =
        command.ExecuteReader();
       using (StreamWriter sw =
        new StreamWriter(fileName))
       {
          while (reader.Read())
           {
           string customerRow =
          String.Format("{0}, {1}, {2}, {3}",
          reader.GetValue(0),
          reader.GetValue(1),
          reader.GetValue(2),
          reader.GetValue(3));
          sw.WriteLine(customerRow);
        }
      }
    }
  }
  catch (Exception ex)
  {
    Console.WriteLine(ex.Message);
  }
}
static void DisplayTextFile(string fileName)
{
  try
  {
    using (StreamReader sr =
      new StreamReader(fileName))
    {
      string line;
      while ((line = sr.ReadLine()) != null)
      {
        Console.WriteLine(line);
      }
     }
  }

  catch (Exception ex)
  {
     Console.WriteLine(ex.Message);
  }
}
3.

Add the following using directives to your code:

using System.Data.SqlClient;
  using System.IO;
4.

Build and run the program. Check the My Documents folder for the file name CustomerList.txt and verify that the customer data has been written. Also verify the output on the Console window against the contents of the file.

The code in this exercise first opens a new StreamWriter object and calls its WriteLine method multiple times to write text to a text file. It then creates a StreamReader object to read text from the file that was just created by using the ReadLine method. When there is no data left to read, the ReadLine object returns a null value. The code uses this value to determine when to finish reading from the text file.

Working with XML
Extensible Markup Language (XML) is a text-based format for representing structured data.

In XML, you can store both data and metadata (information about the data being stored). For example, the following XML represents data for two customers:

<?xml version="1.0" encoding="utf-8"?>
<!--Customer List-->
<Customers>
  <Customer Id="ALFKI">
    <CompanyName>Alfreds Futterkiste</CompanyName>
    <Phone>030-0074321</Phone>
  </Customer>
  <Customer Id="EASTC">
    <CompanyName>Eastern Connection</CompanyName>
    <Phone>(171) 555-0297</Phone>
  </Customer>
</Customers>
Even without knowing anything about XML, you can understand the contents of this file just by looking at them. XML consists of tags (contained within angle brackets) and data. Tags always appear in pairs, with each opening tag matched by a closing tag. For example, <Customers> is an opening tag, and </Customers> is the corresponding closing tag.

The first line of an XML document is the XML declaration:

<?xml version="1.0" encoding="utf-8"?>
XML tags that begin with <? are called processing instructions. This processing instruction tells us that the document is an XML document, conforms to the XML version 1.0 specifications, and uses the UTF-8 character set for its data elements.

An opening tag and closing tag together with their contents is called an element. For example, the following is a single XML element from the above document:

<Phone>030-0074321</Phone>
This bit of code defines an element with the name Phone whose value is 030-0074321. Elements can be nested, but they cannot overlap. For example, the following XML is invalid because of the overlap between the CompanyName and Phone elements:

<Customer Id="EASTC">
    <CompanyName>Eastern Connection<Phone>
    </Phone>(171) 555-0297</CompanyName>
  </Customer>
</Customers>
XML documents are hierarchical in nature. Every XML document contains a single root element that contains all the other nodes. An XML document can therefore be visualized as a tree of nodes.

Elements can contain attributes. An attribute is a piece of data that further describes an element. For example:

<Customer Id="ALFKI">
Here, the Customer element includes an attribute whose name is Id and whose value is ALFKI.

Finally, an XML document can contain comments. Comments start with the characters <!-- and end with the characters -->.

XML is often more complex than what is discussed in this section. However, these basics are enough for you to understand most XML documents that you’ll likely run into until you start working with XML in depth.

There are many ways in which you can work with XML data. The classes that work with XML data are organized in the System.Xml namespace. This portion of the lesson focuses on the following commonly used classes:

•

XmlReader and XmlWriter: These classes provide a fast, noncached, forward-only way to read or write XML data.

•

XmlDocument: This class is an in-memory representation of XML data and allows navigation and editing of the XML document.

In the following exercise, you use the XmlReader class to read the XML file name Customers. xml in a sequential and forward-only manner.

READ FROM AN XML FILE
GET READY. To read from an XML file, do the following:

1.

Create a new Console Application project named WorkingWithXmlReader.

2.

Add the following code to the Main method of the Program class:

using (XmlReader reader =
 XmlReader.Create("Customers.xml"))
{
  while (reader.Read())
  {

    if (reader.IsStartElement())
    {
      switch (reader.Name)
      {
        case "CompanyName":
          if (reader.Read())
          {
            Console.Write(
            "Company Name: {0}, ",
             reader.Value);
          }
          break;
        case "Phone":
          if (reader.Read())
          {
            Console.WriteLine(
             "Phone: {0}", reader.Value);
          }
          break;
      }
    }
  }
}
3.

Next, add the following using directive to the program:

using System.Xml;
4.

Now, add a new XML file named Customers.xml to the project. Make sure the xml file contains the following data:

<?xml version="1.0" encoding="utf-8"?>
<!--Customer List-->
<Customers>
  <Customer Id="ALFKI">
    <CompanyName>Alfreds Futterkiste</CompanyName>
    <Phone>030-0074321</Phone>
  </Customer>
  <Customer Id="EASTC">
    <CompanyName>Eastern Connection</CompanyName>
    <Phone>(171) 555-0297</Phone>
  </Customer>
</Customers>
Build the program. Copy the Customers.xml file to the program executable folder. Run the program. You should see a list of all the company names and phone numbers. The code in this exercise first creates a new instance of XmlReader by using the XmlReader. Create method. This will throw an exception if the file is not found. The program will terminate when the XmlReader.Read method has nothing to read. You can use properties such as Name and Value to access various portions of XML.

Working with DataSet
A DataSet is an in-memory representation of relational data.

A DataSet is an in-memory representation of relational data. Just like a database, a DataSet can have tables, relations, and data-integrity constraints such as unique constraints or foreignkey constraints. A DataSet is usually created by retrieving data from a data source such as a database. Once you have created a DataSet, you can work with all the data in the DataSet even when the link to the source data source is temporarily unavailable. When there are any changes to the data, only the in-memory copy of the data is updated. Connection to the data source is needed only when it is time to update the data source with the changes from the DataSet. DataSet is very useful for creating disconnected applications. Disconnected applications are applications that can continue to function without a constant connection to network resources such as databases.

All DataSet-related classes are part of the System.Data namespace. A DataSet object is created by using the DataSet class. The DataSet consists of a collection of DataTable objects. A DataTable is just like a relational database table. A DataTable object has a collection of DataColumn objects that represent the columns in the table. The rows in the DataTable are represented by the DataRow collection.

The DataAdapter acts as a bridge between the data source and the DataSet. The DataAdapter stores the data connection and data commands needed to connect to the data source. The DataAdapter also provides commands for retrieving data from the data source and commands for updating the data source with any changes.

The .NET Framework provides three DataAdapter classes to work with different type of data sources:

•

The OdbcDataAdapter class is used to work with ODBC data sources.

The OdbcDataAdapter class is part of the System.Data.Odbc namespace.

•

The OleDbDataAdapter class is used to work with OLEDB data sources.

The OleDbDataAdapter class is part of the System.Data.OleDb namespace.

•

The SqlDataAdapter class is used to work with SQL Server databases.

The SQLDataAdapter class is part of the System.Data.SqlClient namespace.

TAKE NOTE*

You can also connect to a SQL Server database by using the OdbcAdapter and OleDbAdapter classes. However, the SQLDataAdapter class is optimized for SQL Server. Therefore, when working with SQL Server, it is preferable to use the SQLDataAdapter class.

In a typical application that creates and updates a DataSet, you will need to carry out the following steps:

1.

Build and fill each DataTable in the DataSet with data from the data source by using a DataAdapter.

2.

Change the data in the individual DataTable objects by adding, updating, or deleting DataRow objects.

3.

Invoke the AcceptChanges method on the dataset. This method connects to the original data sources and updates them with all the changes made to the DataSet since it was loaded or since the last time AcceptChanges was called. Alternatively, you can call the RejectChanges method to cancel all the changes that were made to the DataSet since it was loaded or since the last time AcceptChanges was called.

In the following exercise, you use the classes discussed so far to read data from the SQL Server’s Northwind database into a DataSet and then iterate over the Customer table to display the order numbers for each customer.

READ FROM AN IN-MEMORY DATASET OBJECT
GET READY. To read from an in-memory DataSet Object, do the following:

1.

Create a new Console Application project named WorkingWithDataSet.

2.

Replace the code in the Program class with the following code. Be sure to change the connection string to match the local path of the database file on your computer:

static void Main(string[] args)
{
  WorkingWithDataSet();
}
static void WorkingWithDataSet()
{
  string cString = @"Data Source=.\SQLEXPRESS;"
  + @"AttachDbFilename=B:\SqlSampleDB\NORTHWND.MDF;"
  + "Integrated Security=True;"
  + "Connect Timeout=30;User Instance=True";
  SqlConnection northwindConnection =
    new SqlConnection(cString);
  string customerCommandText =
    "SELECT * FROM Customers";
  SqlDataAdapter customerAdapter =
    new SqlDataAdapter(
     customerCommandText, northwindConnection);
   string ordersCommandText =
    "SELECT * FROM Orders";
  SqlDataAdapter ordersAdapter =
    new SqlDataAdapter(
      ordersCommandText, northwindConnection);

DataSet customerOrders = new DataSet();
customerAdapter.Fill(
  customerOrders, "Customers");
ordersAdapter.Fill(
  customerOrders, "Orders");
DataRelation relation =
  customerOrders.Relations.Add("CustomerOrders",
  customerOrders.Tables["Customers"]
    .Columns["CustomerID"],
  customerOrders.Tables["Orders"]
    .Columns["CustomerID"]);
foreach (DataRow customerRow in
  customerOrders.Tables["Customers"].Rows)
{
  Console.WriteLine(customerRow["CustomerID"]);
  foreach (DataRow orderRow in
    customerRow.GetChildRows(relation))
    Console.WriteLine("\t" +
      orderRow["OrderID"]);
}
  Console.WriteLine(
    "Press any key to continue . . .");
  Console.ReadKey();
}
3.

Add the following using directive to the program:

using System.Data; using System.Data.SqlClient;

4.

Select Project > Set as Startup Project to set the project as the startup project for the solution.

5.

Select Debug > Start Debugging (or press F5) to run the program. Notice that the console window lists all the customers from the Customers table. Each CustomerID is followed by the OrderID corresponding to that customer.

The code in this exercise first creates a DataSet with two DataTable objects, Customers and Orders. The DataSet also creates a DataRelation object that establishes the relationship between the Customers and the Orders table on the CustomerID column. This relationship allows you to call the GetChildRow method on a customer row to retrieve the order rows corresponding to each customer.

CERTIFICATION READY

Do you understand the various database connection methods?

6.3

TAKE NOTE*

A DataSet can read and write data as XML documents. To write data as XML, use the WriteXml method of the DataSet class. To read XML document data, use the ReadXml method of the DataSet class.

SKILL SUMMARY
IN THIS LESSON, YOU LEARNED THE FOLLOWING:

•

A relational database organizes information into tables. A table is a list of rows and columns.

•

Relational database design is the process of determining the appropriate relational database structure to satisfy the business requirements.

•

Entity-relationship diagrams are used to model the entities, their attributes, and the relationships among entities. The entity-relationship diagrams can help you in determine what data needs to be stored in a database.

•

The process of data normalization ensures that a database design is free of any problems that could lead to loss of data integrity. Most design issues can be resolved by ensuring that the tables satisfy the requirements of the third normal form.

•

The Structured Query Language (SQL) provides statements such as SELECT, INSERT, UPDATE, and DELETE to work with relational data.

•

A stored procedure is a set of SQL statements that is stored in a database. Stored procedures can be used by multiple applications.

•

The XmlReader and XmlWriter classes provide a fast, noncached, forward-only way to read or write XML data. The XmlDocument class is an in-memory representation of XML data and allows navigation and editing of the XML document.

•

The DataSet class represents an in-memory representation of relational data. The DataAdapter class acts as a bridge between the data source and the DataSet. The DataAdapter stores the data connection and data commands needed to connect to the data source.

Knowledge Assessment
Fill in the Blank
Complete the following sentences by writing the correct word or words in the blanks provided.

1.

In order for a table to be in the _______________, none of the columns should have multiple values in the same row of data.

2.

The _______________ requires that all non-key columns are functionally dependent on the entire primary key.

3.

The _______________requires that there is no functional dependency among non-key attributes.

4.

The basic building blocks for an entity-relationship diagram are _______________, _______________, and _______________.

5.

The _______________ clause in a SELECT statement evaluates each row for a condition and decides whether to include it in the result set.

6.

The object used with the using statement must implement the _______________ interface.

7.

T-SQL’s _______________ statement can be used to create a stored procedure.

8.

In the process of _______________, you apply a set of rules to ensure that your database design helps with data integrity and ease of maintenance in the future.

9.

You find classes for working with streams and backing stores in the _______________ namespace.

10.

The _______________ format is a hierarchical data representation format.

Multiple Choice
Circle the letter that corresponds to the best answer.

1.

Your application needs to store the product image out to a disk file. You’d like to minimize the size of this disk file. Which of the following objects should you use to write the file?

a.

FileStream

b.

StreamWriter

c.

BinaryWriter

d.

XmlWriter

2.

Your C# program needs to return the total number of customers in a database. The program will be used several times a day. What is the fastest way to return this information from your program?

a.

Write a SQL query and use the SqlCommand.ExecuteScalar method to execute the query.

b.

Create a stored procedure to return the total number of customers, then use the SqlCommand.ExecuteScalar method to execute the stored procedure.

c.

Write a SQL query and use the SqlDataAdapter.Fill method to execute the query.

d.

Create a stored procedure to return the total number of customers, then use the SqlDataAdapter.Fill method to execute the stored procedure.

3.

You need to modify the records in a Products table by marking certain products as Discontinued. However, you need to do this only when the UnitsInStock and UnitsOnOrder are both zero. Which of the following SQL statements should you use?

a.

INSERT

b.

SELECT

c.

UPDATE

d.

DELETE

4.

You need to update the Region fields for customers in Japan. You write the following SQL UPDATE statement:

UPDATE Customers SET Region = 'EastAsia'

You test the query on a test database and find that more records were affected than you expected. You need to correct the SQL statement. What should you do?

a.

Add a WHERE clause to the UPDATE statement.

b.

Add an additional SET clause to the UPDATE statement.

c.

Add a GROUP BY clause to the UPDATE statement.

d.

Add a HAVING clause to the UPDATE statement.

5.

You are developing an application that needs to retrieve a list of customers from a SQL Server database. The application should move through the list sequentially once, processing each customer’s record. Which of the following classes should you use to hold the customer list in order to achieve maximum performance?

a.

DataSet

b.

DataTable

c.

DataView

d.

SqlDataReader

6.

The application you are developing needs to read data from a flat file that include items such as a five-digit integer key, followed by a 20-character customer name, followed by two date and time fields. Which of the following classes should you use?

a.

FileStream

b.

StreamReader

c.

BinaryReader

d.

DataReader

7.

You are developing an application that will need to copy data from a SQL Server view to a DataSet. You name the DataSet object dsData. Which of the following methods should you use to copy the data?

a.

Fill

b.

InsertCommand

c.

SelectCommand

d.

Update

8.

You are developing an application that manages customers and their orders. Which of the following situations is not a good candidate for implementation with stored procedures in your application?

a.

Retrieving the list of all customers in the database

b.

Retrieving the list of all orders for particular customers

c.

Inserting a new order into the Orders table

d.

Ad hoc querying by the database administrator

9.

Your application connects to a SQL Server database that contains a table called Employees with the following columns:

EmployeeID (int, identity) EmployeeType (char(1)) EmployeeDate (datetime) You need to write a query that deletes all rows from the table where the EmployeeType value is either C or T. You do not want to delete any other rows. Which statement should you use?

a.

DELETE FROM Employees WHERE EmployeeType LIKE '[CT]'

b.

DELETE FROM Employees WHERE EmployeeType LIKE '[C-T]'

c.

DELETE FROM Employees WHERE EmployeeType LIKE 'C' OR 'T'

d.

DELETE * FROM Employees WHERE EmployeeType IN ('C', 'T')

10.

Your application includes a SqlDataAdapter object named sqlDataAdapter that connects to the Employees table. Based on this SQLDataAdapter, your application also includes a DataSet object dsEmployees. What line of code should you use to load the data from the database into the DataSet object?

a.

dsEmployees = sqlDataAdapter.Fill("Employees");

b.

sqlDataAdapter.Fill("dsEmployees", "Employees");

c.

sqlDataAdapter.Fill(dsEmployees);

d.

sqlDataAdapter.Fill(dsEmployees, "Employees");

Competency Assessment
Scenario 6-1: Creating an Entity-Relationship Diagram
A company has a number of employees, and each employee may be assigned to one or more projects. In addition, each project can have one or more employees working on it. Draw an entity-relationship diagram for this situation.

Scenario 6-2: Creating a Stored Procedure
You often need to generate a list of customers from a given country. Therefore, you decide to create a stored procedure that accepts the name of country as a parameter and returns all the customers from that country. How would you go about doing this?

Proficiency Assessment
Scenario 6-3: Normalizing Tables
You are converting an entity-relationship diagram into tables. You come up with the following table design:

Books

BOOKID

BOOKNAME

CATEGORYID

CATEGORYNAME

1

Cooking Light

1001

Cooking

2

Prophecy

1002

Mystery & Thriller

3

Shift

1003

Business

4

The Confession

1002

Mystery & Thriller

You need to apply normalization rules to ensure data integrity. How would you ensure that the Books table is in the third normal form?

Scenario 6-4: Creating and Handling Events
You are working on an application that requires you to save customer information from the Customers table of the Northwind database into an XML file. This XML file will be used for various data-integration tasks. You need to make sure that the root node of the XML is called Customers. The root node will then have a Customer node for each customer in the Customers table. How should you accomplish this task?
