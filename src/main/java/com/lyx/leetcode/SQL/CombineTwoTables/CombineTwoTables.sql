# Write your MySQL query statement below
# 175. Combine Two Tables
SELECT
  FirstName,
  LastName,
  City,
  State
FROM
  Person LEFT JOIN Address ON Person.PersonId = Address.PersonId;