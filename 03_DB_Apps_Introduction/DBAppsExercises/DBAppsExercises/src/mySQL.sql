SELECT * FROM minions as m
                  JOIN minions_villains mv on m.id = mv.minion_id;


SELECT v.name, count(distinct mv.minion_id) AS minions_count
FROM villains AS v
    JOIN minions_villains AS mv ON v.id = mv.villain_id
GROUP BY mv.villain_id
HAVING minions_count > 15
ORDER BY minions_count;


SELECT m.name, m.age
FROM minions AS m
JOIN minions_villains mv on m.id = mv.minion_id
WHERE mv.villain_id = 1

SELECT * FROM villains AS v
WHERE v.id = ?