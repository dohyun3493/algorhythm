select YEAR(a.DIFFERENTIATION_DATE) as YEAR, 
b.max - a.SIZE_OF_COLONY as YEAR_DEV, 
a.ID as ID
from ECOLI_DATA as a join
(select max(size_of_colony) as max, year(DIFFERENTIATION_DATE) as year
from ECOLI_DATA
group by year(DIFFERENTIATION_DATE)) as b
on YEAR(a.DIFFERENTIATION_DATE) = b.year
order by YEAR(a.DIFFERENTIATION_DATE) asc, YEAR_DEV asc;




