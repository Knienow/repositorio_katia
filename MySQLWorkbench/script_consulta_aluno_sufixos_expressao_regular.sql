SELECT nome, celular
FROM aluno
WHERE nome REGEXP '[tia^-son^]'
ORDER BY nome asc;
