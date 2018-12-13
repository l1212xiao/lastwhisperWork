#181. Employees Earning More Than Their Managers
SELECT Name AS Employee
FROM Employee e
WHERE e.Salary > (SELECT Salary
                  FROM Employee
                  WHERE Id = e.ManagerId);