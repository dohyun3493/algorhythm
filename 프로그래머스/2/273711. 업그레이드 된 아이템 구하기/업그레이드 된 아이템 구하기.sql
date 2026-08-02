select a.ITEM_ID, b.ITEM_NAME, b.RARITY
from ITEM_TREE as a join ITEM_INFO as b using(ITEM_ID)
where PARENT_ITEM_ID in(select ITEM_ID
from ITEM_INFO 
where rarity = 'RARE')
order by a.ITEM_ID desc;