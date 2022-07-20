-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: db_prova
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id` int NOT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `sobrenome` varchar(45) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `git_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'49-998306452','Anderson','Lima','andersonlima@gmail.com','@anderson95'),(2,'49-991457825','Katia','Nienow','nienowkatia@gmail.com','@knienow');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno_prova`
--

DROP TABLE IF EXISTS `aluno_prova`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno_prova` (
  `aluno_id` int NOT NULL,
  `prova_id` int NOT NULL,
  KEY `fk_prova_idx` (`prova_id`),
  KEY `fk_aluno_idx` (`aluno_id`),
  CONSTRAINT `fk_aluno` FOREIGN KEY (`aluno_id`) REFERENCES `aluno` (`id`),
  CONSTRAINT `fk_prova` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno_prova`
--

LOCK TABLES `aluno_prova` WRITE;
/*!40000 ALTER TABLE `aluno_prova` DISABLE KEYS */;
/*!40000 ALTER TABLE `aluno_prova` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pergunta`
--

DROP TABLE IF EXISTS `pergunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pergunta` (
  `id` int NOT NULL,
  `pergunta` varchar(150) NOT NULL,
  `prova_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pergunta_prova1_idx` (`prova_id`),
  CONSTRAINT `fk_pergunta_prova1` FOREIGN KEY (`prova_id`) REFERENCES `prova` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pergunta`
--

LOCK TABLES `pergunta` WRITE;
/*!40000 ALTER TABLE `pergunta` DISABLE KEYS */;
INSERT INTO `pergunta` VALUES (2,'O que é um banco de dados?',784),(3,'Explique o que é um SGBD e cite exemplos?',784),(4,'O que são DML, DCL, DDL e DQL?',784),(5,'O que é uma Entidade?',784),(6,'Descreva o que é uma chave primária.',784),(7,'Descreva o que é uma chave estrangeira.',784),(8,'Cite a diferença entre chave primária e chave estrangeira.',784),(9,'Um campo do tipo char armazena quais valores? E do tipo int, varchar, date, datetime?',784),(10,'Explique a(s) diferenças entre os tipos Time, Year, DateTime e Date?',784),(11,'Explique para que serve a instrução DELETE.',784);
/*!40000 ALTER TABLE `pergunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prova`
--

DROP TABLE IF EXISTS `prova`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prova` (
  `id` int NOT NULL,
  `disciplina` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prova`
--

LOCK TABLES `prova` WRITE;
/*!40000 ALTER TABLE `prova` DISABLE KEYS */;
INSERT INTO `prova` VALUES (784,'Bancos de Dados Relacionais e SQL');
/*!40000 ALTER TABLE `prova` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resposta` (
  `id` int NOT NULL,
  `resposta` varchar(1000) DEFAULT NULL,
  `pergunta_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_resposta_pergunta1_idx` (`pergunta_id`),
  CONSTRAINT `fk_resposta_pergunta` FOREIGN KEY (`pergunta_id`) REFERENCES `pergunta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resposta`
--

LOCK TABLES `resposta` WRITE;
/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
INSERT INTO `resposta` VALUES (101,'É uma estrutura que permite armazenar e distribuir de forma inteligente tudo aquilo que é importante, como informação, para a empresa. Para que este gerenciamento de informações funcione, é necessário o SGBD - Sistema de Gerenciamento de Banco de Dados',2),(102,'O SGBD é o Sistema de Gerenciamento de Banco de Dados, um conjunto de softwares que permitem que determinadas áreas de cada companhia acessem o banco de dados e usufruam das informações de acordo com a necessidade. São exemplos de SGBD os sistemas MySQL, SQLserver, PostgreSQL e DB2.',3),(103,'DML, DCL, DDL e DQL são subconjuntos de comandos do SQL. O DML é o Data Manipulation Language, subconjunto que define os comandos usados para manipular os dados armazenados em um banco. Os comandos mais importantes do DML são: INSERT, DELETE e UPDATE. O DCL é o Data Control Language é o subconjunto no qual encontramos comandos para controlar o acesso aos dados da nossa base. Através deste conjunto conseguimos estabelecer restrições e permissões para quem acessa o banco por meio dos comandos GRANT e REVOKE. O DDL é o Data Definition Language, um subconjunto de SQL que apresenta comandos usados para gerenciar as estrutruras do banco de dados. Com ele podemos criar, atualizar e remover objetos da base, como tabelas e índices através dos comandos CREATE, DROP e ALTER. Por fim, o DQL é o Data Query Language, responsável pela consulta de dados através do comando SELECT',4),(104,'A Entidade representa um objeto do mundo real no MER, como carros, pessoas e empresas. Pode ser classificada em três tipos: 1) Entidades Fortes - Não dependem de outras para existir; 2)Entidades Fracas - Dependem de outras para exisitir; 3)Entidades Associativas - São utilizadas quando existe a necessiadade de associar uma entidade a um relacionamento.',5),(105,'A chave primária (Primary Key) é um identificador único de um registro na tabela, sendo que nesta chave só podem conter valores únicos e não nulos.',6),(106,'A chave estrangeira (Foreign Key) é uma referência à uma chave primária de uma tabela em outra tabela, permitindo, assim, que as tabelas se relacionem.',7),(107,'Enquanto a chave primária aceita somente valores não nulos, a chave estrangeira aceita valores nulos. Além disso, a chave estrangeira trata-se de uma referência da chave primária numa tabela. Importante referir que o tipo e o tamanho dos dados das chaves primária e estrangeira devem ser iguais.',8),(108,'O tipo CHAR e o tipo VARCHAR armazenam caractere, contudo, enquanto CHAR armazena dados de comprimento fixo, VARCHAR armazena dados de comprimento variável. Utilizaremos CHAR quando os tamanhos dos dados que desejamos armazenar na coluna de uma tabela são consistentes e semelhantes. Exemplo: CPF e CEP. Quando quisermos armazenar tamanhos de dados que variam consideravelmente, utilizaremos o VARCHAR. Exemplo: endereço e nome. O INT armazena dados do tipo inteiro de tamanho até 4 bytes. O DATE armazena dados referentes à data no formato YYYYY-MM-DD. O DATETIME trata-se de uma combinação de data e hora, baseado no período 24 horas, no formato YYYY-MM-DD HH:MM:SS.',9),(109,'TIME representa valores de hora no formato HH:MM:SS, enquanto o YEAR representa valores referentes a ano no formato de YYYY ou YY e o DATE representa valores referentes a data no formato YYYY-MM-DD. O DATETIME representará a combinação de data e hora no formato YYYY-MM-DD HH:MM:SS no intervalo de 1000-01-01 00:00:00.000000 a 9999-12-31 23:59:59.999999.',10),(110,'O comando DELETE é responsável por remover todo e qualquer registro do banco de dados. Este comando não é reversível, portanto deve ser usado com parcimônia.',11);
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-19 11:39:11
