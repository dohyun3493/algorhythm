select SALES_DATE, PRODUCT_ID, USER_ID,	SALES_AMOUNT
from ONLINE_SALE
where month(SALES_DATE) = 3

union all 

select SALES_DATE, PRODUCT_ID, null as  USER_ID, SALES_AMOUNT
from OFFLINE_SALE
where month(SALES_DATE) = 3

order by SALES_DATE asc, product_id asc, user_id asc;