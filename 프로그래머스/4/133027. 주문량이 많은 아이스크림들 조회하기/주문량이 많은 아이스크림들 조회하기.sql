select FLAVOR
from FIRST_HALF as c join(
    select flavor, sum(b.TOTAL_ORDER) as sum
    from FIRST_HALF as a join JULY as B
    using(FLAVOR)
    group by flavor) as d using(FLAVOR)
order by (TOTAL_ORDER + SUM) desc
limit 3;
    



