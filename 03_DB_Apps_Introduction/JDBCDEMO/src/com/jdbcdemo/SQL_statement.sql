SELECT user_name, first_name, last_name, COUNT(ug.id)
FROM users
JOIN users_games AS ug ON users.id = ug.user_id
WHERE user_name = 'nakov';