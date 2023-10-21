# Write your MySQL query statement below
select firstName ,lastName,city,state from  Address a
Right Join  Person p
on a.personId = p.personId