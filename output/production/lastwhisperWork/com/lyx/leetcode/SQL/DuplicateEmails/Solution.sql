# 182. Duplicate Emails
# having 对由sum、count或其它集合函数运算结果的输出进行限制
# having count（学号）指的是 学生数目（ 大于等于）数值
SELECT Email FROM person
GROUP BY Email
HAVING count(*) > 1