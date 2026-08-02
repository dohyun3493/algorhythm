select distinct a.user_id, a.product_id
from ONLINE_SALE as a join ONLINE_SALE as b on a.user_id = b.user_id
and a.product_id = b.product_id and a.ONLINE_SALE_ID != b.ONLINE_SALE_ID
order by a.user_id asc, a.product_id desc;

