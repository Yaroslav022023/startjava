\echo 'display table:'
SELECT * 
FROM jaegers;

\echo 'display not destroyed robots:'
SELECT * 
FROM jaegers 
WHERE status = 'Not destroyed';

\echo 'display robots of series: Mark-1 and Mark-4:'
SELECT * 
FROM jaegers 
WHERE mark IN ('Mark-1', 'Mark-4');

\echo 'display all robots except series: Mark-1 and Mark-4:'
SELECT * 
FROM jaegers 
WHERE mark NOT IN ('Mark-1', 'Mark-4');

\echo 'sort the table in descending order by the mark column:'
SELECT * 
FROM jaegers 
ORDER BY mark DESC;

\echo 'display information about the oldest robot:'
SELECT * 
FROM jaegers 
WHERE launch = 
        (
        SELECT MAX(launch) 
          FROM jaegers
        );

\echo 'display the robots that destroyed the most kaiju:'
SELECT * 
FROM jaegers 
WHERE kaijukill >= 
        (
        SELECT MAX(kaijukill) 
          FROM jaegers 
         WHERE kaijukill <> 
            (
            SELECT MAX(kaijukill) 
              FROM jaegers
            )
        );

\echo 'display average weight of robots:'
SELECT ROUND(AVG(weight),3) AS AVG_weight_robots 
FROM Jaegers;

\echo 'increase by 1 unit column 'kaijuKill' at robot that have not yet been destroyed:'
UPDATE jaegers 
SET kaijukill = kaijukill + 1
WHERE status = 'Not destroyed';
SELECT * 
FROM jaegers;

\echo 'delete destroyed robots:'
DELETE FROM jaegers 
WHERE status = 'Destroyed';
SELECT * 
FROM jaegers;