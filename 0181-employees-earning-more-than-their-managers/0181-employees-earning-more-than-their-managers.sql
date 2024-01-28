# Write your MySQL query statement below
select e.name as Employee
FROM Employee e
where e.salary >(select m.salary from employee m where e.managerId=m.id)