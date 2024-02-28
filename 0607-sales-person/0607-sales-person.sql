# Write your MySQL query statement below
# select s.name from salesperson as s 
# where s.sales_id not in
# (
#     select sales_id from orders as o left join company as c
#     on o.com_id = c.com_id where c.name = 'RED'
# )

select  distinct s.name
from salesperson s 
left join orders o
on s.sales_id =o.sales_id 
where s.sales_id not in( select o.sales_id from orders o  left join company c on c.com_id = o.com_id where c.name='red')