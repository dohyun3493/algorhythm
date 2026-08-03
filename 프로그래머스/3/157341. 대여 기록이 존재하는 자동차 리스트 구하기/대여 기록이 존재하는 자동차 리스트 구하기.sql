select distinct a.car_id
from CAR_RENTAL_COMPANY_CAR as a
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as b using(CAR_ID)
where a.car_type = '세단' 
and MONTH(b.start_date) = 10
order by car_id desc;