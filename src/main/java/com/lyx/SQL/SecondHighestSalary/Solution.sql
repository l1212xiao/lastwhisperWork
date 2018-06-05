SELECT MAX(Salary) FROM employee
WHERE Salary < (SELECT MAX(Salary) FROM employee)