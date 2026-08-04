select count(fish_type), max(length), fish_type
from fish_info as a join (
    select FISH_TYPE, avg(length) as avg
    from FISH_INFO
    group by FISH_TYPE
    having AVG(IFNULL(LENGTH, 10)) >= 33
) as b using(fish_type)
group by fish_type
order by fish_type asc;

