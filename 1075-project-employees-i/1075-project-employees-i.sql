# Write your MySQL query statement below
select  project_id , ROUND(avg(experience_years ),2) as  average_years
from 
Project p left join Employee e
on p.employee_id =e.employee_id 
GROUP BY p.project_id
