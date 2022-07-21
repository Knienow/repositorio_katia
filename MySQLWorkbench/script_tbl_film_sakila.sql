SELECT film_id, nome 
FROM film 
ORDER BY nome asc LIMIT 50;

ALTER TABLE film 
RENAME COLUMN title TO nome;

SELECT film_id, nome 
FROM film 
ORDER BY nome desc LIMIT 50;

SELECT nome, length 
FROM film
WHERE length <= 90
ORDER BY length asc;

SELECT COUNT(*) 
FROM film;

SELECT nome 
FROM film
WHERE nome REGEXP '^[B, H, Z]'
ORDER BY nome asc;

/*SELECT FROM_UNIXTIME(length,'%HH:%MM:%SS') as duracao from
film;*/


