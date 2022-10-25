SELECT user_name, first_name, last_name, COUNT(ug.id)
FROM users
JOIN users_games AS ug ON users.id = ug.user_id
WHERE user_name = 'nakov';

SELECT user_name, first_name, last_name, (SELECT COUNT(*) FROM users_games WHERE user_id = u.id)
FROM users AS u
WHERE user_name = 'nakov'; 