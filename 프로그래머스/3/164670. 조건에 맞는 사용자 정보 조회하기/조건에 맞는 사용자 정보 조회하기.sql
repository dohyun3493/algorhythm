select a.USER_ID, a.NICKNAME, 
CONCAT(CONCAT(CONCAT(CONCAT(a.CITY, " "), STREET_ADDRESS1), " "), STREET_ADDRESS2) as '전체주소',
CONCAT(SUBSTR(TLNO, 1, 3), '-', SUBSTR(TLNO, 4, 4), '-', SUBSTR(TLNO, 8, 4)) as '전화번호'
from USED_GOODS_USER as a join (
    select WRITER_ID
    from USED_GOODS_BOARD 
    group by WRITER_ID
    having count(WRITER_ID) >= 3
) as b on a.USER_ID = WRITER_ID
order by a.USER_ID desc;
