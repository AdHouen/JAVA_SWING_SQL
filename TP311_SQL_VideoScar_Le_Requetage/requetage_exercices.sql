-- EXERCICE 1 
SELECT film.filmcod , film.filmtit, film.filman FROM film INNER JOIN categorie ON film.catcod = categorie.catcod WHERE categorie.catcod = 'FA';

-- EXERCICE 2
SELECT film.filmcod , film.filmtit FROM film  WHERE film.filnat = 'FRA' OR film.filnat = 'F' AND film.filman = 1980;

-- EXERCICE 3
SELECT film.filnat FROM film ORDER BY film.filnat ASC;

-- EXERCICE 4
SELECT film.filmcod, film.filnat FROM film WHERE filman='&Annee_de_sortie' ORDER BY film.filmtit DESC;

-- EXERCICE 5
SELECT * FROM realise WHERE reanom='&Nom_realisateur' LIKE '%';

-- EXERCICE 6


-- EXERCICE 7


-- EXERCICE 8


-- EXERCICE 9


-- EXERCICE 10


-- EXERCICE 11


-- EXERCICE 12


-- EXERCICE 13


-- EXERCICE 14


-- EXERCICE 15


-- EXERCICE 16


-- EXERCICE 17


-- EXERCICE 18


-- EXERCICE 19


-- EXERCICE 20


-- EXERCICE 21


-- EXERCICE 22


-- EXERCICE 23

