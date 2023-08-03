# Write your MySQL query statement below
select e1.name 
from Employee e1 
join Employee e2
on e2.managerId =e1.id
group by (e2.managerId)
having count(e2.managerId)>=5
