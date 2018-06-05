SELECT ifnull(
           (SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1, 1), NULL)
  AS SecondHighestSalary

SELECT ifnull(
           (SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT 1 offset 1), NULL)
  AS SecondHighestSalary
