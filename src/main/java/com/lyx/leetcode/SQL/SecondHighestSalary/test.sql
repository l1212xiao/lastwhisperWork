SELECT ename,dname,sal,deptno FROM(SELECT A.ename,b.dname,A.sal,A.empno,b.deptno,
     COUNT(1)OVER(PARTITION BY A.deptno)counts,
     AVG(a.sal)over(partition BY a.deptno)avg_sal
   FROM emp A, dept b
   WHERE A.deptno=b.deptno
  )WHERE sal >avg_sal AND counts>1