
/*
CREATE TABLE SPRING_SESSION (
	PRIMARY_ID CHAR(36) NOT NULL,
	SESSION_ID CHAR(36) NOT NULL,
	CREATION_TIME NUMERIC(19,0) NOT NULL,
	LAST_ACCESS_TIME NUMERIC(19,0) NOT NULL,
	MAX_INACTIVE_INTERVAL NUMERIC(10,0) NOT NULL,
	EXPIRY_TIME NUMERIC(19,0) NOT NULL,
	PRINCIPAL_NAME VARCHAR(100),
	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);


CREATE TABLE SPRING_SESSION_ATTRIBUTES (
	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
	ATTRIBUTE_NAME VARCHAR(200	) NOT NULL,
	ATTRIBUTE_BYTES BYTEA NOT NULL,
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
);
*/

/*
insert into ROLE (NAME)  values  ('ROLE_ADMIN');
insert into ROLE (NAME)  values  ('ROLE_MANAGER');
insert into ROLE (NAME)  values  ('ROLE_USER');

insert into VEH_STATUS (NAME)  values  ('FREE');
insert into VEH_STATUS (NAME)  values  ('HIRED');
insert into VEH_STATUS (NAME)  values  ('SUSPENDED');

insert into EMPLOYEE (EMAIL, EMP_FULL_NAME, EMPNAME, ISACTIVE, JOB_TITLE, PASSWORD, PHONE_NO, PSWD_EXPIRY, USER_EXPIRY)
            VALUES ('root@carDate.com', 'Simon Sridhar', 'root', TRUE, 'Director', '$2y$12$B6v4.Xt3A/Ru850pmXwzjunyTZJkcv3kTOekHB2.vU/jmh31I9XiG',
                    '+9198989897', '27-MAY-2021', '27-JUL-2021');

insert into EMPLOYEES_ROLES (EMPLOYEEID, ROLEID)  
SELECT EMPLOYEE.EMPLOYEEID, ROLE.ROLEID
 from EMPLOYEE,
      ROLE
 where EMPLOYEE.EMPNAME='root' and ROLE.NAME='ROLE_ADMIN';
*/

/*
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Monica Geller',  '15-JUN-1964','+155534568765','m.geller@friends.com',TRUE,'Birmingham','Alabama, United States','FRIENDS01','New York','14-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Rachel Green',   '11-FEB-1969','+155534568766','r.green@friends.com',TRUE,'Sherman Oaks, Los Angeles','California, United States','FRIENDS02','New York','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Joey Tribbiani', '11-FEB-1969','+155534568767','j.tribbiani@friends.com',FALSE,'Newton','Massachusetts, United States','FRIENDS05','New York','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Chandler Bing',  '19-AUG-1969','+155534568768','c.bing@friends.com',TRUE,'Williamstown','Massachusetts, United States','FRIENDS03','New York','14-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Phoebe Buffay',  '30-JUL-1963','+155534568769','p.buffay@friends.com',TRUE,'Encino, Los Angeles','California, United States','FRIENDS04','New York','14-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Ross Green',     '02-NOV-1969','+155534568761','ross.green@friends.com',TRUE,'Flushing','New York, United States','FRIENDS06','New York','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Jerry Seinfeld', '29-APR-1954','+155534568775','j.seinfeld@seinfeld.com',FALSE,'Brooklyn','New York, United States','SEINFELD0','New York','14-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('George Costanza','23-SEP-1959','+155534568785','g.costanza@seinfeld.com',TRUE,'Newark','New Jersey, United States','SEINFELD2','New York','14-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Kramer Cosmos',  '24-JUL-1949','+155534568795','k.cosmos@seinfeld.com',TRUE,'Culver City','California, United States','SEINFELD3','New York','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Elaine Benes',   '13-JAN-1961','+155534568715','e.benes@seinfeld.com',TRUE,'Manhattan','New York, United States','SEINFELD1','New York','14-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Newman Doe',     '07-AUG-1955','+155534568725','newman@seinfeld.com',TRUE,'Newyork','New York, United States','SEINFELD4','New York','14-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Frank Costanza', '08-JUN-1927','+155534568735','f.costanza@seinfeld.com',TRUE,'Upper West Side','New York, United States','SEINFELD5','New York','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Patrick Jane',   '30-JUL-1969','+155534569765','p.janes@mentalist.com',FALSE,'Launceston','Australia','MENTAL000','Sacramento','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Teresa Lisbon',  '19-JUN-1972','+155534560765','t.lisbon@mentalist.com',TRUE,'Chicago','Illinois, United States','MENTAL001','Sacramento','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Wayne Rigsby',   '02-JUL-1978','+155534561765','w.rigsby@mentalist.com',TRUE,'Chepstow','United Kingdom','MENTAL005','Sacramento','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Kimball Cho',    '16-MAR-1973','+155534562765','k.cho@mentalist.com',TRUE,'San Francisco','California, United States','MENTAL004','Sacramento','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Grace Van Pelt', '04-APR-1983','+155534563765','gvpelt@mentalist.com',TRUE,'St. George','Utah, United States','MENTAL002','Sacramento','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Murphy Brown',   '09-MAY-1946','+155534668765','m.brown@murphybrown.com',TRUE,'Beverly Hills','California, United States','MURPHYB01','Georgetown','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Corky Sherwood', '14-SEP-1964','+155534768765','c.sherwood@murphybrown.com',TRUE,'Alexandria','Louisiana, United States','MURPHYB02','Georgetown','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Miles Siverberg','27-FEB-1961','+155534868765','m.silverberg@murphybrown.com',TRUE,'Evanston','Illinois, United States','MURPHYB03','Georgetown','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Frank Fontana',  '24-AUG-1949','+155534968765','f.fontana@murphybrown.com',TRUE,'Brooklyn','New York, United States','MURPHYB04','Georgetown','15-JAN-2021');
Insert into CUSTOMER (CUSTNAME,DOB,PHONENO,EMAIL,ISACTIVE,ADDR1,ADDR2,NRIC,CITY,DATEUPD) values ('Jim Dial',       '23-MAY-1936','+155534168765','j.dial@murphybrown.com',TRUE,'Saint Paul','Minnesota, United States','MURPHYB05','Georgetown','15-JAN-2021');
*/

/*
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('BMW', 'X5', 4800, 350, 241, 'BMW101',100, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Bentley', 'Continental GTC', 6000, 552, 314, 'BEN610',150, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Mercedes', 'C Class Cabriolet', 2000, 390, 248, 'MCD2000',120, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Mercedes', 'S Class', 2000, 254, 249, 'MCS2000',120, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Audi', 'RS6', 4000, 591, 250, 'AUD6',240, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Ferrari', '488 Pista', 3900, 711, 340, 'FRI438',380, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('BMW', '4 Series Convertible', 2000, 181, 235, 'BMW420',120, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Mercedes', 'E Class Cabriolet', 2200, 249, 246, 'MCD2200',150, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Mercedes', 'G63 AMG', 5500, 544, 210, 'MCD6300',400, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Porsche', 'Macan', 6000, 400, 266, 'PSC60',500, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Aston Martin', 'DB11 Volante', 4000, 503, 300, 'ASM114',400, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Ferrari', '488 Spider', 3900, 660, 327, 'FRI4889',600, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Mercedes Benz', 'V Class', 2100, 190, 207, 'MCD2100',130, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Audi', 'Q7', 3000, 225, 250, 'AUD7', 220, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Lamborghini', 'Huracan Spyder', 5200, 571, 324, 'LBG5200',600, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
Insert into VEHICLE (VEH_BRAND, VEH_MODEL, ENG_CAP, BHP, TOP_SPEED, VEH_LIC_PLATE, DAILY_RATE, VEHSTTSID)    values ('Porsche', 'Cayenne', 4800, 385, 275, 'PSC4800',500, (select VEHSTTSID FROM VEH_STATUS where name ='FREE'));
*/