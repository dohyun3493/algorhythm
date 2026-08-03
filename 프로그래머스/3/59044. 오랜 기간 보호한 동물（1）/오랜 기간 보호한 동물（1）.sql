select NAME, DATETIME
from animal_ins
where animal_id not in(
    select animal_id
    from animal_ins as a join animal_outs as b using(animal_id)
)
order by DATETIME asc
limit 3;