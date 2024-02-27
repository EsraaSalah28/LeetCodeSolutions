# Write your MySQL query statement below

select customer_number
from orders
group by customer_number
having count(order_number) =(select count(order_number) as count from orders  group by customer_number order by count desc limit 1 );