-- EXERCICE 1 : 
SELECT * FROM emp WHERE JOB='MANAGER'AND deptno >= 20; --METHODE 1 
SELECT * FROM emp WHERE JOB='MANAGER'AND (deptno = 20 OR deptno = 30);  --METHODE 2 


-- EXERCICE 2 :
SELECT emp.ename, emp.job, emp.hiredate FROM emp WHERE JOB<>'MANAGER'AND HIREDATE>='01/01/1981' AND HIREDATE<='31/12/1981'; --METHODE 1 
SELECT emp.ename, emp.job, emp.hiredate FROM emp WHERE JOB != 'MANAGER'AND emp.hiredate BETWEEN '01/01/1981' AND '31/12/1981'; --METHODE 2 

-- EXERCICE 3 :
SELECT emp.ename FROM emp WHERE ename LIKE '%A%' AND ename LIKE '%M%';

-- EXERCICE 4 :
SELECT emp.ename FROM emp WHERE ename LIKE '%A%A%';

-- EXERCICE 5 :
SELECT * FROM emp WHERE COMM IS NOT NULL;

-- EXERCICE 6 :
SELECT ename, deptno, job, hiredate FROM emp ORDER BY deptno ASC, job ASC, hiredate DESC;

-- EXERCICE 7 :
SELECT * FROM emp INNER JOIN dept ON dept.deptno = emp.deptno WHERE loc = 'DALLAS'; --METHODE 1 

-- EXERCICE 8 : 
SELECT emp.ename, emp.hiredate, mgr.ename, mgr.hiredate FROM emp, emp mgr WHERE emp.mgr = mgr.empno AND emp.hiredate < mgr.hiredate;

-- Exercice 9 : 
SELECT emp.ename, emp.hiredate FROM emp WHERE emp.hiredate < (SELECT emp.hiredate FROM emp WHERE emp.empno = 7698); --METHODE 1
SELECT e1.ename, e1.hiredate FROM emp e1,emp e2 WHERE e1.hiredate < e2.hiredate and e2.ename='BLAKE'; --METHODE 2
SELECT emp.ename, emp.hiredate FROM emp, emp blake WHERE blake.ename = 'BLAKE' AND blake.hiredate > emp.hiredate; --METHODE 3

-- Exercie 10 :
SELECT * FROM emp WHERE emp.hiredate = (SELECT emp.hiredate FROM emp WHERE ename = 'FORD') AND ename !='FORD';

--Exercice 11
SELECT * FROM emp WHERE emp.hiredate < ALL (SELECT emp.hiredate FROM emp WHERE emp.deptno = 10);

--Exercice 12
SELECT x.ename FROM emp x WHERE x.sal > (SELECT emp.sal FROM emp WHERE x.mgr = emp.empno)AND x.mgr IS NOT NULL; 

--Exercice 13
SELECT emp.job, COUNT (emp.job) AS "Nombre d'employes" FROM emp GROUP BY emp.job ORDER BY COUNT (*) DESC;

--Exercice 14
SELECT emp.ename, emp.sal, emp.deptno FROM emp WHERE (emp.deptno, emp.sal) IN (SELECT emp.deptno, MAX (emp.sal) FROM emp GROUP BY emp.deptno);

--Exercice 15
SELECT emp.job, AVG(emp.sal) AS "Salaire moyen" FROM emp GROUP BY emp.job HAVING AVG(emp.sal) = (SELECT MIN(AVG(emp.sal)) FROM emp GROUP BY emp.job);

--Exercice 16
UPDATE emp  SET emp.sal = emp.sal + 0.05* (SELECT emp.sal FROM emp WHERE emp.ename = 'KING') WHERE emp.job = 'MANAGER';

SELECT emp.ename, emp.job, emp.sal FROM emp;

rollback;

--Exercice 17
INSERT INTO salgrade SELECT emp.deptno, MIN(emp.sal), MAX(emp.sal) FROM emp GROUP BY emp.deptno;

SELECT * FROM salgrade;

rollback;

--Exercice 18
DELETE FROM emp WHERE empno IN (SELECT empno FROM emp e, (SELECT AVG(sal) AS sal, deptno FROM emp GROUP BY deptno) s WHERE s.sal > e.sal AND s.deptno = e.deptno);

SELECT * FROM emp;

rollback;

ALTER SESSION SET NLS_DATE_LANGUAGE = FRENCH;