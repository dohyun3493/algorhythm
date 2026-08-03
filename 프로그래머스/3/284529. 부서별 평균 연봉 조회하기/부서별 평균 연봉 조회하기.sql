select a.DEPT_ID, a.DEPT_NAME_EN, ROUND(avg(b.SAL), 0) as AVG_SAL
from HR_DEPARTMENT as a join HR_EMPLOYEES as b using(DEPT_ID)
group by DEPT_ID
order by AVG_SAL desc;