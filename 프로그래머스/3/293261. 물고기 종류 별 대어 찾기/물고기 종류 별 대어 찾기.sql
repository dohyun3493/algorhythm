select ID, FISH_NAME, a.LENGTH
from FISH_INFO as a join FISH_NAME_INFO as b using(FISH_TYPE)
where (a.LENGTH, a.FISH_TYPE) in (
    select max(length) as LENGTH, a.fish_type
    from FISH_INFO as a join FISH_NAME_INFO as b
    using (FISH_TYPE)
    group by fish_type
)
order by ID asc;