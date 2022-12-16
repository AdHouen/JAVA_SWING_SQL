-- EXERCICE 1 : 
SELECT * FROM emp WHERE JOB='MANAGER'AND DEPTNO>=20;

-- EXERCICE 2 :
SELECT * FROM emp WHERE JOB<>'MANAGER'AND HIREDATE>='01/01/1981' AND HIREDATE<='31/12/1981';

-- EXERCICE 3 :
SELECT emp.ename FROM emp WHERE ename LIKE '%A%' AND ename LIKE '%M%';

-- EXERCICE 4 :
SELECT emp.ename FROM emp WHERE ename LIKE '%A%A%';

-- EXERCICE 5 :
SELECT * FROM emp WHERE COMM IS NOT NULL;

-- EXERCICE 6 :
SELECT ename, deptno, job, hiredate FROM emp ORDER BY deptno ASC, job ASC, hiredate DESC;

-- EXERCICE 7 :
SELECT * FROM emp INNER JOIN dept ON dept.deptno = emp.deptno WHERE loc = 'DALLAS';

-- EXERCICE 8 : 
-- SELECT emp.ename, emp.hiredate, emp.mgr, emp.hiredate FROM emp;

-- Exercice 9 : 
SELECT emp.ename, emp.hiredate FROM emp WHERE emp.hiredate = (SELECT emp.hiredate FROM emp WHERE emp.empno = 7698);

-- Exercie 10 :
SELECT * FROM emp WHERE emp.hiredate = (SELECT emp.hiredate FROM emp WHERE ename = 'FORD');

