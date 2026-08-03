select CATEGORY, sum(b.sales) as TOTAL_SALES
from BOOK as a join BOOK_SALES as b using(book_id)
where date(sales_date) > '2021-12-31' and
date(sales_date) < '2022-02-01'
group by a.category
order by category asc;