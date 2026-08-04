select concat('/home/grep/src/', a.BOARD_ID, '/' , 
              b.FILE_ID,  b.FILE_NAME, b.FILE_EXT) as FILE_PATH
from used_goods_board as a join used_goods_file as b
using(board_id)
where b.board_id =(
    select board_id
    from used_goods_board
    order by views desc
    limit 1
)
order by b.file_id desc;



