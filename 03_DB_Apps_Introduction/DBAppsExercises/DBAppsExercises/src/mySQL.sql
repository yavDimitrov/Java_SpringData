SELECT * FROM minions as m
                  JOIN minions_villains mv on m.id = mv.minion_id;


SELECT v.name, count(distinct mv.minion_id) AS minions_count
FROM villains AS v
    JOIN minions_villains AS mv ON v.id = mv.villain_id
GROUP BY mv.villain_id
HAVING minions_count > 15
ORDER BY minions_count;