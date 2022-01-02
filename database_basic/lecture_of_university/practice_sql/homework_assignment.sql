-- 1번
SELECT pack_id, speed , sector_id
FROM acdb_packages
WHERE sector_id =
    (SELECT sector_id FROM acdb_packages WHERE pack_id = 10);

SELECT a.pack_id, a.speed, a.sector_id
FROM acdb_packages a INNER JOIN acdb_packages b
ON (a.sector_id = b.sector_id AND b.pack_id = 10);


-- 2번
SELECT first_name , last_name , join_date FROM acdb_customers
WHERE
    extract(year from join_date) = (SELECT extract(year from join_date) FROM acdb_customers WHERE customer_id = 372) 
    AND
    extract (month from join_date) = (SELECT extract (month from join_date) FROM acdb_customers WHERE customer_id = 372);
    
SELECT
    a.first_name, a.last_name, a.join_date
FROM ACDB_CUSTOMERS a INNER JOIN ACDB_CUSTOMERS b
ON (extract(year from a.join_date) = extract(year from b.join_date) AND extract(month from a.join_date) = extract(month from b.join_date) AND b.customer_id = 372);

-- 3번
SELECT first_name , last_name , city , state, pack_id
FROM acdb_customers
WHERE pack_id IN (SELECT pack_id FROM acdb_packages WHERE speed = '5Mbps');

SELECT a.first_name, a.last_name, a.city, a.state, a.pack_id
FROM acdb_customers a INNER JOIN acdb_packages b
ON (a.pack_id = b.pack_id AND b.speed = '5Mbps');

-- 4번
SELECT first_name , monthly_discount , pack_id , main_phone_num , secondary_phone_num
FROM acdb_customers
WHERE pack_id IN
       (SELECT pack_id
        FROM acdb_packages
        WHERE sector_id IN
                  (SELECT sector_id
                   FROM acdb_sectors
                   WHERE sector_name = 'Business'));

SELECT c.first_name, c.monthly_discount, c.pack_id, c.main_phone_num, c.secondary_phone_num
FROM acdb_sectors a INNER JOIN acdb_packages b
ON (a.sector_id = b.sector_id AND a.sector_name = 'Business')
INNER JOIN acdb_customers c
ON (c.pack_id = b.pack_id);

-- 5번
SELECT customer_id , first_name , city , state ,birth_date , monthly_discount
FROM acdb_customers
WHERE birth_date =(SELECT birth_date FROM acdb_customers WHERE customer_id = 179) AND monthly_discount > (SELECT monthly_discount FROM acdb_customers WHERE customer_id = 107);

SELECT a.customer_id, a.first_name, a.city, a.state, a.birth_date, a.monthly_discount
FROM acdb_customers a INNER JOIN acdb_customers b
ON (a.birth_date = b.birth_date AND b.customer_id = 179)
INNER JOIN acdb_customers c
ON (b.monthly_discount > c.monthly_discount AND c.customer_id = 107);

-- 6번
SELECT pack_id ,speed , monthly_payment
FROM acdb_packages
WHERE monthly_payment > ALL(SELECT monthly_payment FROM acdb_packages WHERE speed = '5Mbps');

SELECT a.pack_id, a.speed, a.monthly_payment
FROM acdb_packages a
WHERE NOT EXISTS (SELECT * FROM acdb_packages WHERE speed = '5Mbps' AND a.monthly_payment <= monthly_payment);

-- 7번
SELECT pack_id, speed , monthly_payment
FROM acdb_packages
WHERE monthly_payment >
ANY (SELECT monthly_payment FROM acdb_packages WHERE speed = '5Mbps');

SELECT pack_id, speed, monthly_payment
FROM acdb_packages a
WHERE EXISTS (SELECT * FROM acdb_packages WHERE speed = '5Mbps' AND a.monthly_payment > monthly_payment);

-- 8번
SELECT pack_id ,speed , monthly_payment
FROM acdb_packages p1
WHERE EXISTS (select * FROM acdb_packages p2 WHERE p2.speed = '5Mbps' and p1.monthly_payment <= p2.monthly_payment);

SELECT pack_id, speed, monthly_payment
FROM acdb_packages p1
WHERE ((SELECT count(*) FROM acdb_packages p2 WHERE p2.speed = '5Mbps' AND p1.monthly_payment <= p2.monthly_payment) > 0);

-- 9번
SELECT pack_id ,speed , monthly_payment
FROM acdb_packages p1
WHERE NOT EXISTS (select * FROM acdb_packages p2 WHERE p2.speed = '5Mbps' AND p1.monthly_payment <= p2.monthly_payment);

SELECT pack_id, speed, monthly_payment
FROM acdb_packages p1
WHERE ((SELECT count(*) FROM acdb_packages p2 WHERE p2.speed = '5Mbps' AND p1.monthly_payment <= p2.monthly_payment) = 0);

-- 10번
SELECT pack_id ,speed , monthly_payment
FROM acdb_packages p1
WHERE p1.pack_id IN (select p2.pack_id FROM acdb_packages p2 WHERE p2.speed = '5Mbps' AND p1.monthly_payment <= p2.monthly_payment);

SELECT pack_id, speed, monthly_payment
FROM acdb_packages p1
WHERE EXISTS (SELECT p2.pack_id FROM acdb_packages p2 WHERE p2.speed = '5Mbps' AND p1.monthly_payment <= p2.monthly_payment AND p1.pack_id IN p2.pack_id);

-- 11번
SELECT pack_id ,speed , monthly_payment
FROM acdb_packages p1
WHERE p1.pack_id NOT IN (select p2.pack_id FROM acdb_packages p2 WHERE p2.speed = '5Mbps' AND p1.monthly_payment <= p2.monthly_payment);

SELECT pack_id, speed, monthly_payment
FROM acdb_packages p1
WHERE NOT EXISTS (SELECT p2.pack_id FROM acdb_packages p2 WHERE p2.speed = '5Mbps' AND (p1.monthly_payment <= p2.monthly_payment) AND (p1.pack_id IN p2.pack_id));

-- 12번
SELECT pack_id ,speed , monthly_payment
FROM acdb_packages
WHERE monthly_payment > ALL(SELECT monthly_payment FROM acdb_packages WHERE speed = '5Mbps');

SELECT pack_id, speed, monthly_payment
FROM acdb_packages
WHERE monthly_payment >
    (SELECT MAX(monthly_payment)
    FROM acdb_packages
    GROUP BY speed
    HAVING speed = '5Mbps');

SELECT pack_id, speed, monthly_payment
FROM acdb_packages
WHERE monthly_payment >
    (SELECT MAX(monthly_payment)
    FROM acdb_packages 
    WHERE speed = '5Mbps');
    
-- 13번
SELECT pack_id ,speed , monthly_payment
FROM acdb_packages
WHERE monthly_payment
> SOME(SELECT monthly_payment FROM acdb_packages WHERE speed = '5Mbps');

SELECT pack_id, speed, monthly_payment
FROM acdb_packages
WHERE monthly_payment >
    (SELECT MIN(monthly_payment)
    FROM acdb_packages
    GROUP BY speed
    HAVING speed = '5Mbps');

SELECT pack_id, speed, monthly_payment
FROM acdb_packages
WHERE monthly_payment > 
    (SELECT MIN(monthly_payment)
    FROM acdb_packages
    WHERE speed ='5Mbps');