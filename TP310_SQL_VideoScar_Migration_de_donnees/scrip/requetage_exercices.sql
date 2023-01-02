-- EXERCICE 1 
SELECT film.filmcod , film.filmtit, film.filman FROM film INNER JOIN categorie ON film.catcod = categorie.catcod WHERE categorie.catcod = 'FA';

-- EXERCICE 2
SELECT film.filmcod , film.filmtit FROM film  WHERE film.filnat = 'FRA' OR film.filnat = 'F' AND film.filman = 1980;

-- EXERCICE 3
SELECT film.filnat FROM film ORDER BY film.filnat ASC;

-- EXERCICE 4
SELECT film.filmcod, film.filnat FROM film WHERE filman='&Annee_de_sortie' ORDER BY film.filmtit DESC;

-- Exercice 5
select * from realise where reanom like ('&reanom%');

-- Exercice 6
select filman,count(*) from film group by filman order by filman;

-- Exercice 7
select catcod,count(*),avg(filmdur),min(filmdur),max(filmdur) from film group by catcod having count(*)>=10 order by catcod;

-- Exercice 8
select k7typ,count(*),avg(k7pri) from k7 group by k7typ;

-- Exercice 9
select filmtit,reanom,reapre from film f,realise r where filmcod=&filmcod and f.reacod=r.reacod;

-- Exercice 10
select filmtit,actnom,actpre from film f,acteur a,jouer j where f.filmcod=&filmcod and f.filmcod=j.filmcod and j.actcod=a.actcod;

-- Exercice 11
select distinct reanom,reapre,actnom,actpre from realise r,film f, jouer j,acteur a where r.reacod=&reacod and f.reacod=r.reacod and j.filmcod=f.filmcod and a.actcod=j.actcod;

-- Exercice 12
select catlib from categorie c, film f, jouer j, acteur a where a.actcod=&actcod and a.actcod=j.actcod and j.filmcod=f.filmcod and c.catcod=f.catcod;

-- Exercice 13
select f.filmcod,filmtit,f.reacod,r.reanom,r.reapre from realise r,film f where reanom like ('&reanom%') and r.reacod=f.reacod order by r.reacod;

-- Exercice 14
select distinct a1.actcod,a1.actnom,a1.actpre from acteur a1,jouer j1,jouer j2 where j2.actcod=&actcod and j2.filmcod=j1.filmcod and j1.actcod=a1.actcod and a1.actcod!=j2.actcod;

-- Exercice 15
select f.filmcod,filmtit,filman from film f,jouer j where j.actcod=&actcod and f.reacod=&reacod and j.filmcod=f.filmcod;

-- Exercice 16
select filmtit,filman,filnat,catlib,reanom,reapre,actnom,actpre,k7cod,k7typ,k7loc from film f,categorie c,jouer j,acteur a,realise r,k7 k where f.filmcod=&filmcod and f.catcod=c.catcod and f.filmcod=j.filmcod and j.actcod=a.actcod and f.reacod=r.reacod and f.filmcod=k.filmcod(+)

-- Exercice 17
select f.filmcod,filmtit from film f,jouer j1,jouer j2 where j1.actcod=&actcod1 and j2.actcod=&actcod2 and j1.filmcod=j2.filmcod and j1.filmcod=f.filmcod;

-- EXERCICE 18


-- EXERCICE 19


-- EXERCICE 20


-- EXERCICE 21


-- EXERCICE 22


-- EXERCICE 23

