/* Alunos Anderson Lima e Katia Nienow */

SELECT P.pergunta, R.resposta
FROM pergunta as P, resposta as R
WHERE P.id = R.pergunta_id;


