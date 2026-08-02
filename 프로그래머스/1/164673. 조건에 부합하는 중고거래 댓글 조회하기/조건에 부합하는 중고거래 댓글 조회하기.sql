select a.title, a.board_id, b.reply_id, b.writer_id, b.contents, b.created_date
from USED_GOODS_BOARD as a
join USED_GOODS_REPLY as b 
using(board_id)
where year(a.CREATED_DATE) = 2022 and month(a.CREATED_DATE) = 10
order by b.CREATED_DATE	 asc, a.TITLE asc;