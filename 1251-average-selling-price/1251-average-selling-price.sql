# Write your MySQL query statement below
select p.product_id , ROUND(SUM(P.price * c.units) / SUM(c.units), 2) as average_price
from Prices p
left join UnitsSold c
on p.product_id =c.product_id
where c.purchase_date >= p.start_date 
and p.end_date >= c.purchase_date
group by p.product_id