select c.REST_ID, c.REST_NAME, c.FOOD_TYPE, c.FAVORITES,
c.ADDRESS, ROUND(avg(score), 2) as SCORE
from(
select a.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, 
b.REVIEW_SCORE as score
from REST_INFO as a join REST_REVIEW as b
on a.rest_id = b.rest_id
where a.address is not null and a.address like '서울%') as c
group by c.rest_id
order by SCORE desc, c.favorites desc;
