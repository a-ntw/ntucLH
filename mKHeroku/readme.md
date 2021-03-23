Heroku with Postgres on mac
===
https://www.heroku.com/
- easyhm$9c

This exercise to deploy of app to Heroku, and using Heroku Postgres for database.


1. login to Heroku, and create new App.
2. at tab **Resource**, add in `Heroku Postgres`.
3. Amend `application.properties` and `pom.xml` prior to git add & push

210308Heroku.png<img src="210308Heroku.png">

#### installation, git init, git push
for my mac, I relog in to admin. from Terminal and run:
`curl https://cli-assets.heroku.com/install-ubuntu.sh | sh`

Back login to user, at terminal:
``` console
antw@Mac-mini ~ % heroku --version
 ›   Warning: Our terms of service have changed: https://dashboard.heroku.com/terms-of-service
heroku/7.50.0 darwin-x64 node-v12.16.2

antw@Mac-mini mKHeroku % heroku login
heroku: Press any key to open up the browser to login or q to exit: 
 ›   Error: quit

antw@Mac-mini mKHeroku % java --version
java 11.0.8 2020-07-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.8+10-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.8+10-LTS, mixed mode)
antw@Mac-mini mKHeroku % ls
SpringBootManyToMany
antw@Mac-mini mKHeroku % cd SpringBootManyToMany

antw@Mac-mini SpringBootManyToMany % git init
Initialized empty Git repository in /Users/antw/ntuc/mKHeroku/SpringBootManyToMany/.git/
antw@Mac-mini SpringBootManyToMany % heroku git:remote -a ntuclearn
set git remote heroku to https://git.heroku.com/ntuclearn.git
antw@Mac-mini SpringBootManyToMany % git add .
antw@Mac-mini SpringBootManyToMany % git commit -am "Init many to many" 
[master (root-commit) 7aab878] Init many to many
 46 files changed, 2631 insertions(+)

antw@Mac-mini SpringBootManyToMany % git push heroku master
...
remote: Verifying deploy... done.
To https://git.heroku.com/ntuclearn.git
 * [new branch]      master -> master
antw@Mac-mini SpringBootManyToMany % pwd
/Users/antw/ntuc/mKHeroku/SpringBootManyToMany

```
Some optional commands:
- heroku logs
- heroku logs —tail
- data.sql, add in bnext to application.properties


#### application.properties
``` properties
#spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCL
#spring.datasource.username=sridhar
#spring.datasource.password=sridhar
#
##spring.jpa.show-sql=true
#spring.jpa.hibernate.ddl-auto=update
#
##spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle10gDialectls

######## for Heroku only
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hiberhate.hdbc.lob.non_contextual_creation=true
spring.datasource.initialization-mode=always
### and also at pom.xml

```
Pom.xml
``` xml
<!-- only version 1.8 for Heroku to work	 -->	
	<properties>
		<Java.version>1.8</java.version>
	</properties>

	...

<!-- comment out for Heroku only	 -->	
<!-- 		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency> -->
<!-- for Heroku only	 -->	
		<dependency>
			    <groupId>org.postgresql</groupId>
			    <artifactId>postgresql</artifactId>
			    <scope>runtime</scope>
		</dependency>
		
```
---
#### CarZoom. Init 3 roles

210312carzoom.png <img src="210312carzoom.png">
	
- this was done on the carzoom's codes with only Employee and Role, wiihout Customer, Vehicle, Hire.
- initiat with role data via sql script, to insert 3 roles. Thereafter need to remove.
- this file, data.sql placed at carzoom/src/main/resources
- ref: https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
``` sql
/* -- REM if necessary:
-- DROP TABLE EMPLOYEES_ROLES;
-- DROP TABLE EMPLOYEES;
-- DROP TABLE ROLE;

-- REM Or if necessary:
-- Delete ROLE;
*/

Insert into ROLE (NAME) values ('ADMIN');
Insert into ROLE (NAME) values ('MANAGER');
Insert into ROLE (NAME) values ('USER');

-- for schema creation need to `spring.jpa.hibernate.ddl-auto=none`
```
``` console
antw@Mac-mini carzoom % git add .              
antw@Mac-mini carzoom % git commit -am "ONLY init: data sql, insert ADMIN MANAGER USER"
[master a934d1a] ONLY init: data sql, insert ADMIN MANAGER USER
 1 file changed, 2 insertions(+), 2 deletions(-)
antw@Mac-mini carzoom % git push heroku master                                         
Enumerating objects: 11, done.

```

