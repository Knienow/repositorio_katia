/*Anderson Lima e Katia Nienow*/
DELETE FROM pergunta WHERE id>0;
SELECT * FROM db_prova.pergunta;

INSERT INTO pergunta(id, pergunta, prova_id) 
VALUES(2, 'O que é um banco de dados?', 784),
	  (3, 'Explique o que é um SGBD e cite exemplos?', 784),
	  (4, 'O que são DML, DCL, DDL e DQL?', 784),	
      (5, 'O que é uma Entidade?', 784),
      (6, 'Descreva o que é uma chave primária.', 784),
      (7, 'Descreva o que é uma chave estrangeira.', 784),
      (8, 'Cite a diferença entre chave primária e chave estrangeira.', 784),
      (9, 'Um campo do tipo char armazena quais valores? E do tipo int, varchar, date, datetime?', 784),
      (10 , 'Explique a(s) diferenças entre os tipos Time, Year, DateTime e Date?', 784),
      (11 , 'Explique para que serve a instrução DELETE.', 784);      