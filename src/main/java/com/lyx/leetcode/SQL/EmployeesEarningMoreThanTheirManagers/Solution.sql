#181. Employees Earning More Than Their Managers
SELECT e3.Name AS Employee
FROM (
       SELECT
         e1.Id,
         e1.Name,
         e1.Salary,
         e1.ManagerId,
         e2.ManagerSalary
       FROM employee e1 LEFT JOIN
         (SELECT
            Id,
            Salary AS ManagerSalary
          FROM employee) e2
           ON e1.ManagerId = e2.Id
     ) e3
WHERE e3.Salary > e3.ManagerSalary