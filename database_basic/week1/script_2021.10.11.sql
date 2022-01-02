# select, from, where 연습
# 어떤 db를 사용할 지 확실히 정하면 USE copang_main; 처럼 지정후, DB를 따로 언급하지 않아줘도 됨
SELECT * FROM copang_main.member;
SELECT * FROM copang_main.member WHERE email = 'taehos@hanmail.net';
SELECT * FROM copang_main.member;
select * from copang_main.member where age BETWEEN 30 and 39;
select * from copang_main.member where age >= 27;
select * from copang_main.member where age not between 30 and 39;
select * from copang_main.member where sign_up_day > '2019-01-01';
select * from copang_main.member where sign_up_day between '2018-01-01' and '2018-12-31';

# LIKE -> pandas의 str.contains()나 str.startswith()과 유사 
select * from copang_main.member where address LIKE '서울%'; # 서울로 시작하는 모든 문자열을 출력
select * from copang_main.member where address LIKE '%고양%'; # 고양이 중간에 들어가는 모든 문자열을 출력

# 조건 표현식
## != <>
select * from copang_main.member where gender != 'm';
select * from copang_main.member where gender <> 'm';

## IN -> 딱 해당 값들만 조회
select * from copang_main.member where age IN (20, 30);

## 언더바(_) -> 언더바 하나 당 문자 하나
select * from copang_main.member where email like 'c_____@%';

# DATE 타입 관련 함수
select * from copang_main.member where year(birthday) = '1992';
select * from copang_main.member where month(birthday) IN (6, 7, 8);
select * from copang_main.member where month(birthday) between 6 and 8;
select * from copang_main.member where dayofmonth(sign_up_day) between 15 AND 31;
select email, sign_up_day, datediff(sign_up_day, '2019-01-01') from copang_main.member;
select email, sign_up_day, curdate(), datediff(sign_up_day, curdate()) from copang_main.member;
select email, sign_up_day, datediff(sign_up_day, birthday) / 365 from copang_main.member;
select email, sign_up_day, date_add(sign_up_day, INTERVAL 300 day) from copang_main.member;
select email, sign_up_day, date_sub(sign_up_day, INTERVAL 250 day) from copang_main.member;
select email, sign_up_day, unix_timestamp(sign_up_day) from copang_main.member; # 1970년 1월 1일을 기준으로 총 몇초가 지났는가?
select email, sign_up_day, from_unixtime(unix_timestamp(sign_up_day)) from copang_main.member; # 사람이 읽을 수 있는 식으로 재변환

# 여러 개의 조건 걸기
## 주의점: SQL에서 AND가 OR보다 우선순위가 높음
select * from copang_main.member where gender = 'm' and address like '서울%' and age between 25 and 29;
select * from copang_main.member where month(sign_up_day) between 3 and 5 or month(sign_up_day) between 9 and 11;
select * from copang_main.member where (gender = 'f' and  height >= 170) or (gender = 'm' and height >= 180);

# 실습과제_데이터 조회 과제
select * from copang_main.member where (age between 20 and 29) and (month(sign_up_day) = 7);

# 이스케이핑: 특수문자 사용과 문자열에서의 특수문자 사용이 겹쳐 인식오류가 날 때 -> \를 앞에 붙여주면 해결
# 대소문자 구분: 앞에 BINARY 예약어를 붙여주면 해결됨

# 정렬
## SQL 문법상 WHERE은 ORDER BY 앞에 나와야함
## SELECT '표시하고 싶은 column명' FROM 'DB이름.table명' WHERE 조건적용대상 조건문 ORDER BY 정렬문 LIMIT 수;
## INTEGER 타입은 정렬이 수의 크기대로 결정되지만, TEXT 타입에서의 수는 ASCI code 변환 후 한 문자씩 문자 순서 비교 후 정렬 - 1로 시작하면 1끼리 순서 정렬 후 2 정렬 시작
## CAST('' AS '') -> 일시적으로, 제시한 column을 제시한 타입으로 바꾸어라
## signed 타입 -> 양수와 음수를 포함한 모든 정수를 나타낼 수 있는 데이터 타입

select * from copang_main.member order by height ASC; # null을 가장 작은 값으로 취급, 기본적으로 오름차순(Ascending) 정렬
select * from copang_main.member order by height DESC; # Descending
select * from copang_main.member where (gender = 'm') and (weight >= 70) order by height ASC;

select * from copang_main.member order by year(sign_up_day) DESC, email ASC; # 1순위: 가입연도, 2순위: 이메일 오름차순
select * from copang_main.member order by CAST(age AS char) ASC;
select * from copang_main.member order by CAST(age AS signed) ASC;

# 데이터 일부만 추려보기 -> LIMIT, Pagination
select * from copang_main.member order by sign_up_day DESC LIMIT 10; # .head(10)
select * from copang_main.member order by sign_up_day DESC LIMIT 8, 2; # index count는 list와 동일 -> index 8번부터 2개를 뽑아내라.

# 실습과제_데이터 정렬 과제
## SELECT * FROM member ORDER BY star ASC, registration_date DESC LIMIT 5;


# 데이터의 특성 구하기
SELECT COUNT(email) FROM copang_main.member;
SELECT COUNT(height) FROM copang_main.member; # COUNT 함수는 NULL의 갯수는 빼고 셈
SELECT COUNT(*) FROM copang_main.member; # 전체 row 갯수를 세므로 NULL값과 관련없이 전체를 셈

SELECT MAX(height) FROM copang_main.member; # 최댓값 출력
SELECT MIN(weight) FROM copang_main.member; # 최솟값 출력
SELECT AVG(weight) FROM copang_main.member; # 평균값 출력, null 값은 제외하고 평균값을 구함
SELECT SUM(age) FROM copang_main.member; # 합계 출력
SELECT STD(age) FROM copang_main.member; # 표준편차 출력
SELECT FLOOR(height) FROM copang_main.member; # 내림함수
SELECT ROUND(height) FROM copang_main.member; # 반올림 함수

# NULL을 다루는 방법
## NULL은 어떻게 연산해도 NULL이다.
SELECT * FROM copang_main.member WHERE address IS NULL; # 주의점: IS NULL과 = NULL은 다르다. NULL은 존재하지 않는 값이기 때문에 등호식에서 TRUE가 나올 수가 없다.
SELECT * FROM copang_main.member WHERE address IS NOT NULL;

# NULL값 변환
## COALESCE
SELECT COALESCE(height, '####'), COALESCE(weight, '---'), COALESCE(address, '@@@') FROM copang_main.member; # NULL 값이 있는 경우 변환

## IFNULL
SELECT IFNULL(height, 'N/A') FROM copang_main.member;

## IF
SELECT IF(height IS NOT NULL, height, 'N/A') FROM copang_main.member; # np.where(조건식, 만족 출력값, 조건식 만족x시 출력)과 비슷

## CASE
SELECT
	(CASE
		WHEN height IS NOT NULL THEN height
        ELSE 'N/A'
	END) AS height
FROM copang_main.member;



# 이상치 제외
SELECT age FROM copang_main.member WHERE age BETWEEN 5 AND 100;
SELECT address FROM copang_main.member WHERE address NOT LIKE '%호';

# 실습과제_데이터 분석 과제
## SELECT COUNT(*), ROUND(AVG(star)) from review WHERE comment IS NOT NULL;

# 컬럼끼리 계산하기
SELECT email, height, weight, weight / ((height/100) * (height/100)) FROM copang_main.member;
# 컬럼에 alias 붙이기
SELECT email, height, weight, weight / (height/100)^2 AS 'BMI' FROM copang_main.member;
SELECT email, height AS 키, weight AS 몸무게, weight / (height/100)^2 AS BMI FROM copang_main.member;
SELECT email, CONCAT(height, 'cm', ', ', weight, 'kg') AS '키와 몸무게',
weight / (height/100)^2 AS BMI FROM copang_main.member; # CONCAT() -> .join과 비슷한 역할 + column끼리 연결 가능

# 컬럼의 값 변환해서 보기
## CASE: 특정 값을 원하는 방식으로 변환해서 표현하게 해줌

SELECT
	email, 
    CONCAT(height, 'cm', ', ', weight, 'kg') AS '키와 몸무게',
    weight/ ((height/100) * (height/100)) AS BMI, 
    (CASE
		WHEN weight IS NULL OR height IS NULL THEN '비만 여부 알 수 없음'
        WHEN weight / ((height/100)*(height/100)) >= 25 THEN '과체중 또는 비만'
        WHEN weight / ((height/100)*(height/100)) >= 18.5
			AND weight / ((height/100)*(height/100)) < 25 THEN '정상'
		ELSE '저체중'
	END) AS obesity_check
FROM copang_main.member
ORDER BY obesity_check ASC;
    
    
# 실습과제_컬럼 자유롭게 다루기 과제
## SELECT name, price, price/cost, (CASE WHEN (price/cost) >= 1 AND (price/cost) < 1.5 THEN 'C. 저효율 메뉴' WHEN (price/cost) >= 1.5 AND (price/cost) < 1.7 THEN 'B. 중효율 메뉴' WHEN (price/cost) >= 1.7 THEN 'A. 고효율 메뉴' END) AS 'efficiency' FROM pizza_price_cost ORDER BY efficiency DESC, price ASC LIMIT 6;

# 고유값만 보기
SELECT DISTINCT(gender) FROM copang_main.member; # df['~'].unique(), df['~'].value_counts()
SELECT DISTINCT(SUBSTRING(address, 1, 2)) FROM copang_main.member;
SELECT COUNT(DISTINCT(gender)) FROM copang_main.member;
SELECT COUNT(DISTINCT(SUBSTRING(address, 1, 2))) AS region_count FROM copang_main.member; # SQL 문자열 함수의 경우 예외적으로 1부터 시작

# 문자열 관련 함수
SELECT *, LENGTH(address) FROM copang_main.member; # 길이
SELECT email, UPPER(email) FROM copang_main.member; # 대문자 전환
SELECT email, LOWER(email) FROM copang_main.member; # 소문자 전환
SELECT email, LPAD(age, 10, '0') FROM copang_main.member; # 왼쪽에 10개의 0을 채워라
SELECT email, RPAD(age, 10, '0') FROM copang_main.member; # 오른쪽에 10개의 0을 채워라

SELECT * FROM copang_main.trim_test;
SELECT LTRIM(word) FROM copang_main.trim_test; # 왼쪽 공백 삭제
SELECT RTRIM(word) FROM copang_main.trim_test; # 오른쪽 공백 삭제
SELECT TRIM(word) FROM copang_main.trim_test; # 양쪽 공백 삭제

# 그루핑해서 보기
## Aggregate function(집계 함수): 그루핑을 통해 생성된 각 그룹의 수치적인 특성을 구하는 함수로 COUNT, AVG, MIN, etc....등이 있다.
## GROUP BY를 사용하기 전에는 하나의 그룹이라고 생각하면 됨
## GROUP BY 사용 시 SELECT 절에는, GROUP BY 뒤에서 사용한 컬럼들이나 COUNT, MAX 등과 같은 집계함수(특정 row의 값이 아니라 그룹 내 모든 row들에 함수를 적용해서 출력하기 때문)만 사용 가능
SELECT gender FROM copang_main.member GROUP BY gender; # 그루핑되어있는 상태로 DISTINCT와 다름
SELECT gender, COUNT(*) FROM copang_main.member GROUP BY gender; # 테이블이 그루핑이 되어있어 함수가 긱 그룹별로 적용됨
SELECT gender, COUNT(*), AVG(height) FROM copang_main.member GROUP BY gender; # AVG도 마찬가지
SELECT
	gender,
    COUNT(*),
    AVG(height),
    MIN(weight)
FROM copang_main.member
GROUP BY gender; # MIN도 마찬가지

SELECT MAX(height) FROM copang_main.member GROUP BY gender;

SELECT SUBSTRING(address, 1, 2) as region, gender, COUNT(*) FROM copang_main.member GROUP BY SUBSTRING(address, 1, 2), gender; # 분류 조건을 중복으로 달아서 더 세분화된 그루핑

SELECT
	SUBSTRING(address, 1, 2) as region, 
    gender, 
    COUNT(*)
FROM copang_main.member
GROUP BY
	SUBSTRING(address, 1, 2),
    gender
HAVING
	region = '서울'
    AND gender = 'm'; # WHERE은 테이블에서 row를 조회할 때 조건을 사용할 때 사용하는 구문, HAVING은 그루핑 된 테이블에서 조건을 사용할 때 사용하는 구문


    
SELECT
	SUBSTRING(address, 1, 2) as region, 
    gender, 
    COUNT(*)
FROM copang_main.member
GROUP BY
	SUBSTRING(address, 1, 2),
    gender
HAVING
	region IS NOT NULL
ORDER BY
	region ASC,
    gender DESC;

# 작성순서 정리: SELECT FROM WHERE GROUP BY HAVING ORDER BY LIMIT
# 실행순서 정리: FROM WHERE GROUP BY HAVING SELECT ORDER BY LIMIT

# 실습과제_그루핑해서 보기 과제
## SELECT category, main_month, COUNT(*), SUM(view_count) AS 총 관객 수 FROM 2020_movie_report GROUP BY category, main_month HAVING main_month = 5 AND SUM(view_count) >= 3000000;

SELECT
	SUBSTRING(address, 1, 2) as region, 
    gender, 
    COUNT(*)
FROM copang_main.member
GROUP BY
	SUBSTRING(address, 1, 2),
    gender
WITH ROLLUP
HAVING
	region IS NOT NULL
ORDER BY
	region ASC,
    gender DESC; # WITH ROLLUP 사용 시 먼저 제시된 그루핑 조건이 상위 조건으로 인식되고 후조건을 총계로 모아 후조건과 관계 없는 계층부분 총계를 보여주는 row를 추가 출력해준다. 즉 GROUP BY 나열 순서에 따라 WITH ROLLUP 순서도 달라진다.
    
SELECT YEAR(sign_up_day) AS s_year, YEAR(birthday) AS b_year, gender, COUNT(*) FROM copang_main.member
GROUP BY YEAR(sign_up_day), YEAR(birthday), gender WITH ROLLUP
ORDER BY s_year DESC;

SELECT YEAR(sign_up_day) AS s_year, gender, SUBSTRING(address, 1, 2) AS region, GROUPING(YEAR(sign_up_day)), GROUPING(gender), GROUPING(SUBSTRING(address, 1, 2)), COUNT(*)
FROM copang_main.member
GROUP BY YEAR(sign_up_day), gender, SUBSTRING(address, 1, 2) WITH ROLLUP
ORDER BY s_year DESC; # GROUPING 함수는 인자를 그루핑 기준에서 고려하지 않았을 때 1, 고려했을 때 0 return 즉 NULL 값이 있는 column일 경우 GROUPING에서 1 return