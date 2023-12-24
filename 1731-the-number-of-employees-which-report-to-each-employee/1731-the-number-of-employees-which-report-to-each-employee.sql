# Write your MySQL query statement below
select mgr.employee_id , mgr.name, count(e.reports_to) as reports_count ,round(avg(e.age )) as average_age 
from employees  e
 join employees mgr 
 on e.reports_to  =mgr.employee_id 
 group by employee_id

 order by employee_id 