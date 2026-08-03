select a.ANIMAL_ID, a.NAME
from ANIMAL_INS as a join ANIMAL_OUTS as b using(ANIMAL_ID)
order by b.DATETIME - a.DATETIME desc
limit 2;