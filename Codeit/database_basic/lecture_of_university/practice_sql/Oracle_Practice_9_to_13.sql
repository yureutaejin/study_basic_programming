--Oracle Practice #9
select c.first_name, c.last_name, c.city, c.state, c.pack_id
from ACDB_CUSTOMERS c
where c.pack_id in (
    select p.pack_id
    from ACDB_PACKAGES p
    where p.speed = '5Mbps'); -- 1번
    
select c.first_name, c.last_name, c.city, c.state, c.pack_id
from ACDB_CUSTOMERS c inner join ACDB_PACKAGES p
ON (c.pack_id = p.pack_id) AND (p.speed = '5Mbps');


select c.first_name, c.monthly_discount, c.pack_id, c.main_phone_num, c.secondary_phone_num
from ACDB_CUSTOMERS c
where c.pack_id in (
    select p.pack_id
    from ACDB_PACKAGES p
    where p.sector_id = (
        select s.sector_id
        from ACDB_SECTORS s
        where s.sector_name = 'Business')); -- 2번
        
select c.first_name, c.monthly_discount, c.pack_id, c.main_phone_num, c.secondary_phone_num
from ACDB_CUSTOMERS c inner join ACDB_PACKAGES p
ON (c.pack_id = p.pack_id)
inner join ACDB_SECTORS s
ON (p.sector_id = s.sector_id) AND (s.sector_name = 'Business');

select pack_id, speed, monthly_payment
from ACDB_PACKAGES
where monthly_payment >
    ALL(select monthly_payment from ACDB_PACKAGES where speed = '5Mbps'); -- 3번
    
select pack_id, speed, monthly_payment
from ACDB_PACKAGES
where monthly_payment >
    ANY(select monthly_payment from ACDB_PACKAGES where speed = '5Mbps'); -- 4번
    
-- Oracle Practice # 10
select min(last_name), max(last_name) from ACDB_CUSTOMERS; -- 1번

select count(state), count(distinct state) from ACDB_CUSTOMERS; -- 2번

select min(monthly_discount), max(monthly_discount), avg(monthly_discount) from ACDB_CUSTOMERS; -- 3번

select first_name || ' ' || last_name as name from ACDB_CUSTOMERS where monthly_discount > (select avg(monthly_discount) from ACDB_CUSTOMERS); -- 4번

-- Oracle Practice # 11
select state, count(*) from ACDB_CUSTOMERS group by state order by count(*) DESC; -- 1번, order by에서 select에서 사용한 집계함수 alias 사용 가능

select pack_id, count(*) from ACDB_CUSTOMERS where monthly_discount > 20 group by pack_id; -- 2번, having 절은 집계함수에 대해서 사용 or grouping 조건에 대한 일반 조건에 대해서 사용

-- Oracle Practice # 12
select pack_id, count(*) from ACDB_CUSTOMERS group by pack_id having count(*) > 100; -- 1번

select state, min(monthly_discount) from ACDB_CUSTOMERS group by state having min(monthly_discount) > 10; -- 2번

select count(*), speed from ACDB_PACKAGES where monthly_payment > 50 group by speed having count(*) > 3 order by count(*) ASC; 

-- Oracle Practice # 13
select c.first_name, c.last_name, p.speed, p.monthly_payment from ACDB_CUSTOMERS c inner join ACDB_PACKAGES p ON c.pack_id = p.pack_id; -- a번

select c.first_name, c.last_name, p.speed, p.monthly_payment from ACDB_CUSTOMERS c left outer join ACDB_PACKAGES p ON c.pack_id = p.pack_id; -- b번

select c.first_name, c.last_name, p.speed, p.monthly_payment from ACDB_CUSTOMERS c right outer join ACDB_PACKAGES p ON c.pack_id = p.pack_id; -- c번

select c.first_name, c.last_name, p.speed, p.monthly_payment from ACDB_CUSTOMERS c full outer join ACDB_PACKAGES p ON c.pack_id = p.pack_id; -- d번


-- # DB_Design practice

-- create table R(a int, b int, c int);
-- insert into R values(0,0,0);
-- insert into R values(2,0,1);

select * from R;

select a
from R
group by a
having count(b) > 1
UNION
select b
from R
group by b
having count(c) > 1;