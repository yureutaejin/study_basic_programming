'
alter table "ACDB_SECTORS" ADD CONSTRAINT "SECTOR_ID_PK" PRIMARY KEY("SECTOR_ID");
alter table "ACDB_PACKAGES" ADD CONSTRAINT "PACK_ID_PK" PRIMARY KEY("PACK_ID");
alter table "ACDB_CUSTOMERS" ADD CONSTRAINT "CUSTOMER_ID_PK" PRIMARY KEY("CUSTOMER_ID");


alter table "ACDB_PACKAGES" ADD CONSTRAINT "SECTOR_ID_FK" FOREIGN KEY("SECTOR_ID") REFERENCES "ACDB_SECTORS"("SECTOR_ID") ENABLE;
alter table "ACDB_CUSTOMERS" ADD CONSTRAINT "PACK_ID_FK" FOREIGN KEY("PACK_ID") REFERENCES "ACDB_PACKAGES"("PACK_ID") ENABLE;
'

--Oracle Practice #6
SELECT c.last_name, c.first_name, c.pack_id, p.speed from ACDB_CUSTOMERS c, ACDB_PACKAGES p WHERE c.pack_id = p.pack_id; -- 1번
SELECT c.last_name, c.first_name, c.pack_id, p.speed from ACDB_CUSTOMERS c inner join ACDB_PACKAGES p ON(c.pack_id = p.pack_id);

SELECT p.pack_id, p.speed, p.monthly_payment, s.sector_name from ACDB_PACKAGES p, ACDB_SECTORS s where p.sector_id = s.sector_id; -- 2번
SELECT p.pack_id, p.speed, p.monthly_payment, s.sector_name from ACDB_PACKAGES p inner join ACDB_SECTORS s ON(p.sector_id = s.sector_id);

SELECT c.last_name ||' '|| c.first_name, p.pack_id, p.speed, p.monthly_payment, s.sector_name from ACDB_PACKAGES p, ACDB_SECTORS s, ACDB_CUSTOMERS c
WHERE p.sector_id = s.sector_id and c.pack_id = p.pack_id; -- 3번
select c.last_name || ' ' || c.first_name, p.pack_id, p.speed, p.monthly_payment, s.sector_name from ACDB_CUSTOMERS c inner join ACDB_PACKAGES p ON(c.pack_id = p.pack_id) inner join ACDB_SECTORS s ON(p.sector_id = s.sector_id);

SELECT c.last_name|| ' ' || c.first_name, p.pack_id, p.speed, p.monthly_payment, s.sector_name from ACDB_PACKAGES p, ACDB_SECTORS s, ACDB_CUSTOMERS c
WHERE p.sector_id = s.sector_id and c.pack_id = p.pack_id and s.sector_name = 'Business'; -- 4번
select c.last_name|| ' ' || c.first_name, p.pack_id, p.speed, p.monthly_payment, s.sector_name from ACDB_CUSTOMERS c inner join ACDB_PACKAGES p ON(c.pack_id = p.pack_id) inner join ACDB_SECTORS s ON(p.sector_id = s.sector_id AND s.sector_name = 'Business');

--Oracle Practice #7
SELECT customer_id from ACDB_CUSTOMERS WHERE monthly_discount > 5
INTERSECT
SELECT customer_id from ACDB_CUSTOMERS c, ACDB_PACKAGES p WHERE c.pack_id = p.pack_id and p.monthly_payment > 100; -- 1번
select customer_id from ACDB_CUSTOMERS WHERE monthly_discount > 5
INTERSECT
select customer_id from ACDB_CUSTOMERS c inner join ACDB_PACKAGES p ON (c.pack_id = p.pack_id AND p.monthly_payment >100);

SELECT CITY from ACDB_CUSTOMERS WHERE STATE = 'California'
UNION ALL
SELECT CITY from ACDB_CUSTOMERS c, ACDB_SECTORS s, ACDB_PACKAGES p WHERE s.sector_id = p.sector_id AND c.pack_id = p.pack_id AND p.sector_id = s.sector_id;

SELECT CITY from ACDB_CUSTOMERS WHERE STATE = 'California'
UNION
SELECT CITY from ACDB_CUSTOMERS c, ACDB_SECTORS s, ACDB_PACKAGES p WHERE s.sector_id = p.sector_id AND c.pack_id = p.pack_id AND p.sector_id = s.sector_id; -- 2번

select city from ACDB_CUSTOMERS where state = 'California'
UNION ALL
select city from acdb_customers c inner join acdb_packages p ON (c.pack_id = p.pack_id) inner join acdb_sectors s ON (p.sector_id = s.sector_id);

select city from ACDB_CUSTOMERS where state = 'California'
UNION
select city from acdb_customers c inner join acdb_packages p ON (c.pack_id = p.pack_id) inner join acdb_sectors s ON (p.sector_id = s.sector_id);

SELECT last_name, first_name
FROM ACDB_CUSTOMERS c, ACDB_SECTORS s, ACDB_PACKAGES p
WHERE c.pack_id = p.pack_id AND p.sector_id = s.sector_id AND s.sector_id = p.sector_id
MINUS
SELECT last_name, first_name
FROM ACDB_CUSTOMERS
WHERE city = 'Seattle' OR city = 'San Francisco'; -- 3번



--Oracle Practice #8
SELECT pack_id, speed, sector_id
FROM ACDB_PACKAGES
WHERE sector_id = (SELECT sector_id from ACDB_PACKAGES where pack_id = 10); -- 1번

select a.pack_id, a.speed, a.sector_id
from acdb_packages a inner join acdb_packages b
ON (a.sector_id = b.sector_id AND b.pack_id = 10);

SELECT first_name, last_name, join_date
FROM ACDB_CUSTOMERS
WHERE extract(year from join_date) =
(SELECT extract(year from join_date) from ACDB_CUSTOMERS WHERE customer_id = 372)
AND
extract (month from join_date) =
(SELECT extract(month from join_date) from ACDB_CUSTOMERS WHERE customer_id = 372); -- 2번

SELECT customer_id, first_name, city, state, birth_date, monthly_discount from acdb_customers
where birth_date = (select birth_date from acdb_customers where customer_id = 179)
AND
monthly_discount >
(select monthly_discount from acdb_customers where customer_id = 107); -- 3번

select a.customer_id, a.first_name, a.city, a.state, a.birth_date, a.monthly_discount
from acdb_customers a inner join acdb_customers b
ON (a.birth_date = b.birth_date AND b.customer_id = 179)
inner join acdb_customers c
ON (b.monthly_discount > c.monthly_discount AND c.customer_id = 107);
