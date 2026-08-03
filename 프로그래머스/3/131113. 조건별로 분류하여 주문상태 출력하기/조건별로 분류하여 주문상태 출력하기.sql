select order_id, product_id, out_date,
    case
        when date(out_date) is null then '출고미정'
        when date(out_date) <= '2022-05-01' then '출고완료'
        else '출고대기'
    end as '출고여부'
from FOOD_ORDER
order by order_id asc