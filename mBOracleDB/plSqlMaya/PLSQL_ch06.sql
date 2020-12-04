set serveroutput on;
/*IF ELSE, CASE*/
DECLARE
    V_MYAGE NUMBER;
    V_GRADE  CHAR(1) := UPPER('&grade');
    V_APPRAISAL VARCHAR2(20);
    V_DEPID DEPARTMENTS.DEPARTMENT_ID%TYPE;
    V_DEPNAME DEPARTMENTS.DEPARTMENT_NAME%TYPE;
BEGIN
    IF V_MYAGE < 11 THEN
       DBMS_OUTPUT.PUT_LINE('I am a child');
    ELSIF V_MYAGE BETWEEN 11 AND 12 THEN
        DBMS_OUTPUT.PUT_LINE('I am a pre-teenager');
    ELSIF V_MYAGE BETWEEN 13 AND 19 THEN
        DBMS_OUTPUT.PUT_LINE('I am a teenager');
    ELSE
        DBMS_OUTPUT.PUT_LINE('I am young');
    END IF;
    
    V_APPRAISAL := CASE 
         WHEN V_GRADE  = 'A' THEN 'Excellent'
         WHEN V_GRADE  IN ('B','C') THEN 'Good'          
         ELSE 'No such grade'   
     END;
   DBMS_OUTPUT.PUT_LINE ('Grade: '|| V_GRADE  ||' Appraisal ' || V_APPRAISAL);
    DBMS_OUTPUT.PUT_LINE ('------');
    CASE V_GRADE
         WHEN 'A' THEN 
            V_APPRAISAL := 'Excellent';
            SELECT DEPARTMENT_ID, DEPARTMENT_NAME INTO V_DEPID, V_DEPNAME
            FROM DEPARTMENTS
            WHERE dePARTMENT_ID = 10;
         WHEN 'B' THEN
            V_APPRAISAL := 'Good';
        WHEN 'C' THEN
            V_APPRAISAL := 'Good';
         ELSE V_APPRAISAL := 'No such grade';   
     END CASE;
   DBMS_OUTPUT.PUT_LINE ('Grade: '|| V_GRADE  ||' Appraisal ' || V_APPRAISAL);
   DBMS_OUTPUT.PUT_LINE ('Dept ID: '|| V_DEPID  ||' Dept Name:' || V_DEPNAME);

END;
/
/*LOOPS*/
DECLARE
  v_countryid    locations.country_id%TYPE := 'CA';
  v_loc_id       locations.location_id%TYPE;
  v_counter		  NUMBER(2) := 1;
  v_new_city     locations.city%TYPE := 'Montreal';
BEGIN
  SELECT MAX(location_id) INTO v_loc_id FROM locations
  WHERE country_id = v_countryid;
  /*
  
  LOOP
    INSERT INTO locations(location_id, city, country_id)   
    VALUES((v_loc_id + v_counter), v_new_city, v_countryid);
    v_counter := v_counter + 1;
    EXIT WHEN v_counter > 3;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(v_counter-1||' rows added.');
  
  WHILE v_counter <= 6 LOOP
    INSERT INTO locations(location_id, city, country_id)   
    VALUES((v_loc_id + v_counter), v_new_city, v_countryid);
    v_counter := v_counter + 1;
  END LOOP;*/

  FOR i IN   reverse 7..9 LOOP
    INSERT INTO locations(location_id, city, country_id)   
    VALUES((v_loc_id + i), v_new_city, v_countryid );
  END LOOP;
END;
/

select max(location_id) from locations where country_id = 'CA';

select * from locations where location_id > 1939 and country_id = 'CA';

/*nested loop*/
declare counter number;
BEGIN
 <<outerloop>>
  FOR I IN 1 .. 10 LOOP    
    counter := 0;
    CONTINUE WHEN I = 2;
    <<innerloop>>
    LOOP
        DBMS_OUTPUT.PUT_LINE ('i='|| I || '/counter=' || counter);
        counter := counter + 1;
        EXIT WHEN MOD(I+counter,5) = 0; /*exit inner loop*/
        EXIT OUTERLOOP WHEN MOD(I,3) = 2; /*exit outer loop*/
    END LOOP innerloop;
    
  END LOOP outerloop;
END;
/

SELECT * FROM LOCATIONS;