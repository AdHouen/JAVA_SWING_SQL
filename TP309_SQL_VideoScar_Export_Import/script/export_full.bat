REM @echo off
prompt CMD$g
REM
REM
REM NAME
REM   *.bat
REM
REM DESCRIPTION
REM   Commande d'export de la BD
REM USAGE
REM
REM REMARQUE
REM   Certaines variables d'environnement 
REM   doivent ?tre positionn?es ...
REM
REM
REM   CREATION : Xavier HER
REM        MAJ : 


REM V?rification de la pr?sence des variables d'environnement
if (%ORACLE_HOME%) == () goto nooraclehome


REM set SOURCE=%PROJETS_HOME%\...\Oracle
set SOURCE=.


%ORACLE_HOME%\bin\exp videoscar/videoscar@localhost/xepdb1 owner=videoscar file=videoscar.dmp


pause

goto exit

:nooraclehome
echo ORACLE_HOME variable d environement non positionnee
pause
exit 1

:exit
echo SCRIPT TERMINE SANS ERREUR
pause
exit 0