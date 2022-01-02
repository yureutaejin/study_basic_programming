select * from copang_main.item;
select * from copang_main.stock;

# 다른 종류의 테이블 조인하기 1
select
	item.id,
    item.name,
    stock.item_id,
    stock.inventory_count
from item left outer join stock
on item.id = stock.item_id;		# 두 테이블이 item 테이블의 id 값을 기준으로 merge됨

select
	i.id,
    i.name,
    s.item_id,
    s.inventory_count
from item as i right outer join stock as s
on i.id = s.item_id;		# 두 테이블이 stock 테이블의 item_id 값을 기준으로 merge됨

# 다른 종류의 테이블 조인하기 2
select
	i.id,
    i.name,
    s.item_id,
    s.inventory_count
from item as i inner join stock as s
on i.id = s.item_id;

# 실습과제_Foreign Key와 Join assignment
-- select
--     ppc.name,
--     coalesce(s.sales_volume, "판매량 정보 없음")
-- from pizza_price_cost as ppc left outer join sales as s
-- on ppc.id = s.menu_id;

# join => 결합연산(가로방향으로 테이블을 합침)
# intersect, minus(except), union => 집합연산(세로방향으로 테이블을 합침) 단, 같은 종류의 테이블끼리만 가능

# 같은 종류의 테이블 join하기
select
	old.id as old_id,
    old.name as old_name,
    new.id as new_id,
    new.name as new_name
from item as old left outer join item_new as new
on old.id = new.id
order by new.id asc;

select
	old.id as old_id,
    old.name as old_name,
    new.id as new_id,
    new.name as new_name
from item as old right outer join item_new as new
on old.id = new.id
where old.id is null;

select
	old.id as old_id,
    old.name as old_name,
    new.id as new_id,
    new.name as new_name
from item as old inner join item_new as new
on old.id = new.id;	# 두 테이블의 column 이름이 같을 경우에는 using(column 이름)으로 줄일 수 있음

# union 활용(두 조회 결과를 하나로 합쳐주며 겹치는 것은 하나로만 보여줌), union all을 사용하면 중복 제거 x
select * from item
union
select * from item_new;

# 서로 다른 3개의 테이블 join하기
alter table review
add foreign key (mem_id) references member (id),
add foreign key (item_id) references item (id);

select
	i.name, i.id,
    r.item_id, r.star, r.comment, r.mem_id,
    m.id, m.email
from
	item as i left outer join review as r
		on r.item_id = i.id
	left outer join member as m
		on r.mem_id = m.id;
        
# 의미있는 데이터 추출하기 1
select i.id, i.name, avg(star)
from
	item as i left outer join review as r
		on r.item_id = i.id
	left outer join member as m
		on r.mem_id = m.id
where m.gender = 'f'
group by i.id, i.name
order by avg(star) DESC;

# 의미있는 데이터 추출하기 2
select i.id, i.name, avg(star), count(*)
from
	item as i left outer join review as r
		on r.item_id = i.id
	left outer join member as m
		on r.mem_id = m.id
where m.gender ='f'
group by i.id, i.name
having count(*) > 1
order by 
	avg(star) desc, count(*) desc;    
    
select i.id, i.name, avg(star), count(*)
from
	item as i left outer join review as r
		on r.item_id = i.id
	left outer join member as m
		on r.mem_id = m.id
where m.gender ='m'
group by i.id, i.name
having count(*) > 1
order by 
	avg(star) desc, count(*) desc;
    
select * from review where item_id = 2;

# 실습과제_여러 테이블 조인하기
select
	year(i.registration_date) as '등록 연도',
	count(*) as "리뷰 개수",
    avg(star) as "별점 평균값"
from
	review as r inner join item as i
		on r.item_id = i.id
	inner join member as m
		on r.mem_id = m.id
where i.gender = "u"
# having count(*) >= 10
group by year(i.registration_date)
order by avg(star) desc;

# natural join => 두 테이블에서 같은 이름의 컬럼을 찾아서 자동으로 그것을 조인조건으로 설정하고 inner join
select *
from
	item as i natural join review as r;

# cross join => 한 테이블의 하나의 row에 다른 테이블의 모든 row들을 매칭하고, 그 다음 row들에서도 같은 방법으로 매칭 반복으로 두 테이블의 row들의 모든 조합을 보여주는 join
select * from member cross join stock;

# self join => 테이블이 자기 자신과 조인
# full outer join => 두 테이블의 left outer join 결과와 right outer join 결과를 합치는 join, 오라클에는 full outer join이 존재
# non-equi join => on에 등호가 아닌 조건이 들어가는 것


# 서브쿼리 => SQL 문 안에 부품처럼 들어가는 select 문
select i.id, i.name, avg(star) as avg_star
from item as i left outer join review as r
on r.item_id = i.id
group by i.id, i.name
having avg_star < (select avg(star) from review)
order by avg_star desc;

# select 절에 있는 subquery
select
	id,
    name,
    price,
    (select max(price) from item)	# 집계함수는 하나의 row만 출력해서 대개 group by와 함께 사용되지만, 스칼라 서브쿼리로 사용할 경우 총 row 수 만큼 반복되어 실행됨(select 내에서 단독으로 사용될 경우에 허용)
from copang_main.item;

# where 절에 있는 subquery 1
select
	id,
    name,
    price,
    (select avg(price) from item) as avg_price
from copang_main.item
where price > (select avg(price) from item);

select
	id,
    name,
    price
from copang_main.item
where price = (select max(price) from item);

select
	id,
    name,
    price
from copang_main.item
where price = (select min(price) from item);

# where 절에 있는 subquery 2
select * from item
where id in (
select item_id
from review
group by item_id having count(*) >= 3
);

# same as
SELECT
i. id, i. name, COUNT(*)
FROM item AS i LEFT OUTER JOIN review AS r
ON r. item_id = i. id
GROUP BY i. id, i. name
HAVING COUNT(*) >= 3;

# ANY, SOME => ex) WHERE view_count > ANY(subquery) 서브쿼리가 리턴하는 값들 중 어느하나보다도 view_count가 크다면 True 리턴
-- select * from FOR_TEST.codeit_theater where view_count > any(select view_count from FOR_TEST.codeit_theater where category = 'ACTION') AND category != "Action")
# ALL은 반대

# 실습과제_서브쿼리 기초 과제
select *
from review as r
where r.item_id in (select i.id from item as i where i.registration_date <= '2018-12-31');

# FROM 절에 있는 서브쿼리
select
	substring(address, 1, 2) as region,
    count(*) as review_count
from review as r left outer join member as m
on r.mem_id = m.id
group by substring(address,1,2)
having region is not null
	and region != '안드';
    
select
	avg(review_count),
    max(review_count),
    min(review_count)
    
from	# from 뒤 서브쿼리로 만들어진 table을 derived table이라 함. derived table은 alias를 꼭 붙여야 함
	(select
		substring(address, 1, 2) as region,
		count(*) as review_count
	from review as r left outer join member as m
		on r.mem_id = m.id
	group by substring(address,1,2)
	having region is not null
		and region != '안드') as review_count_summary;


# 서브쿼리 종류
## 스칼라 서브쿼리 => 단일값 리턴 쿼리
## 하나의 column안에 여러 row값이 들어있는 형태의 결과를 리턴하는 쿼리 -> IN, ANY(SOME), ALL과 함께 사용가능
## 하나의 테이블 형태를 리턴하는 서브쿼리


# EXISTS, NOT EXISTS와 상관 서브쿼리
## 비상관 서브쿼리: 서브쿼리만 독립적으로 실행해도 실행에 문제가 없는 서브쿼리
## 상관 서브쿼리: 서브쿼리가 outer 쿼리에 적힌 테이블 이름 등과 상관관계를 갖고있어서 독립적으로 실행되지 못하는 서브쿼리
select * from item
	where exists (select * from review where review.item_id = item.id);
select * from item
	where not exists (select * from review where review.item_id = item.id);

select *,
(select min(height)
from member as m2 where birthday is not null and height is not null
and year(m1.birthday) = year(m2.birthday)) as min_height_in_the_year
from member as m1
order by min_height_in_the_year ASC;

# 실습과제_서브쿼리 종합과제

select
	MAX(copang_report.price) as max_price,
    AVG(copang_report.star) as avg_star,
    COUNT(DISTINCT(copang_report.email)) as distinct_email_count
from (select
		i.price,
		r.star,
		m.email
	from item as i inner join review as r
		on i.id = r.item_id
	inner join member as m
		on m.id = r.mem_id) as copang_report;

# 서브쿼리 중첩 해결 - View
select i.id, i.name, avg(star) as avg_star, count(*) as count_star
from item as i left outer join review as r on r.item_id = i.id
	left outer join member as m on r.mem_id = m.id
where m.gender = 'f'
group by i.id, i.name
having count(*) >= 2
order by avg(star) desc, count(*) desc;

create view three_tables_joined as
select i.id, i.name, avg(star) as avg_star, count(*) as count_star
from item as i left outer join review as r on r.item_id = i.id
	left outer join member as m on r.mem_id = m.id
where m.gender = 'f'
group by i.id, i.name
having count(*) >= 2
order by avg(star) desc, count(*) desc;

select * from copang_main.three_tables_joined;

select * from copang_main.three_tables_joined
where avg_star = (
select max(avg_star) from copang_main.three_tables_joined
) and count_star = (
	select max(count_star) from copang_main.three_tables_joined
);

# 데이터베이스 파악
show databases;
show full tables in copang_main;
describe item;


# 실습과제_뷰와 데이터 분석 실무 과제
-- create view v_emp as
-- 	select id, name, age, department, phone_num, hire_date
-- 	from employee;
--     
-- select * from v_emp;
