# Write your MySQL query statement below
select customer_id , COUNT(visit_id) as count_no_trans 
from visits v
where visit_id
 NOT in (select visit_id from  Transactions )
GROUP BY customer_id

