### Initial data

#### application.properties
 ref: https://javabydeveloper.com/spring-boot-loading-initial-data/
```
#DataSource
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/orcl
spring.datasource.username=stepsauth
spring.datasource.password=stepsauth

spring.jpa.hibernate.use-new-id-generator-mappings=false
spring.jpa.hibernate.ddl-auto=update

# runonly once, to import data
spring.datasource.initialization-mode=always 
```

#### data.sql
``` sql
Insert into ROLE (NAME) values ('ADMIN');
Insert into ROLE (NAME) values ('MANAGER');
Insert into ROLE (NAME) values ('USER');
Insert into EMPLOYEE (EMPNAME,PASSWORD) values ('admin','$2a$10$u97XKnz.e2i.C9ADAgkMYuZvtpnKgVA6R8a9BJglIBLaghkXGCDQq');
Insert into EMP_ROLES (EMPID,ROLEID) values (1,1);
Insert into EMPLOYEE (EMPNAME,PASSWORD) values ('ntuc','$2a$10$60iSTtJQWjz08JJElVOjM.vhbBMHPoozv1MfroZxkBHjDAjnRG8Tm');
Insert into EMP_ROLES (EMPID,ROLEID) values (2,1);
Insert into EMP_ROLES (EMPID,ROLEID) values (2,2);
Insert into EMP_ROLES (EMPID,ROLEID) values (2,3);
```
