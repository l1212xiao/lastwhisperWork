# Write your MySQL query statement below
# 183. Customers Who Never Order
SELECT name AS Customers
FROM Customers
WHERE id NOT IN (SELECT CustomerId
                 FROM Orders)