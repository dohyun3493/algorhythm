# parent의 형질을 가져와서 비교해야 됨.

select b.id, b.genotype, a.genotype
from ECOLI_DATA as a join ECOLI_DATA as b
on a.id = b.parent_id
where a.genotype & b.genotype = a.genotype
order by b.id asc;
