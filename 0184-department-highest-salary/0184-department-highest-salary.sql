# Write your MySQL query statement below
select d.name as Department , e.name as Employee ,e.salary as Salary
from employee e , department d
where d.id = e.departmentId
and(e.departmentId , e.salary) IN(select e.departmentId, max(e.salary) from employee e
                                 group by e.departmentId
                                 )