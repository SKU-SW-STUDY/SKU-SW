use gisa;
select * from gisa;
truncate gisa;	/* 테이블 데이터 구조 초기화 명령어 */

select * from gisa;
SELECT @@AUTOCOMMIT;

/*[문제사용쿼리]*/
/* 1. 지역코드가 B 인 자료에 대하여 (국어점수 + 영어점수)으로 내림차순 정렬했을 
때 5번째 학번 출력하시오. 동일값 발생시 학번에 대한 오름차순 정렬하시오. */

/* MYSQL 은 OFFSET 0번째 부터 시작 */
select std_no from gisa where loc_code = 'B' order by (kor + eng) desc, std_no asc
limit 1 offset 4;  -- 5번째 부터 1개 출력하기 

/* 2. 지역코드가 B 인 자료에 대하여 (국어점수 + 영어점수) 중 가장 큰값을 출력하되, 
만약 동일 값 발생시는 한번만 출력하시오
*/
select max(kor + eng) from gisa where loc_code = 'B' ;
select distinct(kor + eng) from gisa where loc_code = 'B' order by (kor+eng) desc;

/* 3. (영어점수 + 수학점수)가 120점 이상인 자료의 (총점 + 점수포인트) 
합계를 출력하시오 [A : 5, B : 15, C : 20]
*/
select total, acc_code from gisa where (eng + math) > 120;

/*SQL IF ELSE 문 */
select sum(total) + sum(case when acc_code='A' then 5 when acc_code='B' then 15 when acc_code='C' then 20 end) point from gisa where (eng + math) >= 120;

/* 4. 성취도가 A, B인 자료에 대해 (국어점수 + 지역코드 점수포인트)의 50 이상인 
자료의 건수를 출력하시오 [A:5, B:10, C:15]
*/
select kor, loc_code from gisa where acc_code in ('A', 'B');

/*SQL IF ELSE 문 */
select count(*) as cnt from gisa 
where acc_code in ('A', 'B') and (kor + (case when loc_code='A' then 5 when loc_code='B' then 10 when loc_code='C' then 15 end)) >= 50;

