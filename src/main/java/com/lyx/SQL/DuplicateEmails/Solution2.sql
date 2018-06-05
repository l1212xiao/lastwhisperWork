#182. Duplicate Emails
SELECT DISTINCT Email
FROM person p1
WHERE Email IN (
  SELECT Email
  FROM person p2
  WHERE p1.Email = p2.Email
        AND p1.Id <> p2.Id
)
