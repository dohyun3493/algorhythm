select b.ANIMAL_ID, b.NAME
from ANIMAL_INS as a right join ANIMAL_OUTS as b 
using(ANIMAL_ID)
where A.DATETIME is null
order by b.ANIMAL_ID, b.NAME;

