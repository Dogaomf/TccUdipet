CREATE TABLE fornecedor(
   id			INT		NOT NULL IDENTITY,
   nome			VARCHAR (250)	NOT NULL,
   cnpj			VARCHAR (250)	NOT NULL,
   sexo			CHAR (1)	NOT NULL,
   telefone		INT,
   celular 		INT,
   area			VARCHAR (250)	NOT NULL,
   especialidade	VARCHAR (250)	NOT NULL,
   email		VARCHAR (250)	NOT NULL,
   nome_usuario		VARCHAR (250)	NOT NULL,
   senha		VARCHAR (250)	NOT NULL,
   conf_senha		VARCHAR (250)	NOT NULL,
   PRIMARY KEY (id)
);
