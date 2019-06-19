CREATE TABLE clinica(
   id          	INT           	NOT NULL IDENTITY,
   nome        	VARCHAR (250)	NOT NULL,
   cnpj		VARCHAR (250)	NOT NULL,
   telefone	VARCHAR (250)	NOT NULL,
   endereco	VARCHAR (250)	NOT NULL,
   bairro	VARCHAR (250)	NOT NULL,
   cidade	VARCHAR (250)	NOT NULL,
   uf		VARCHAR (250)	NOT NULL,
   cep		VARCHAR (250)	NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE plano(
   id          INT              NOT NULL IDENTITY,
   nome        VARCHAR (250)    NOT NULL,
   sexo        CHAR(1)              ,
   PRIMARY KEY (id)
);

CREATE TABLE procedimento(
   id          INT              NOT NULL IDENTITY,
   nome        VARCHAR (250)    NOT NULL,
   ano         INT              ,
   clinica_id  INT              NOT NULL,
   FOREIGN KEY (clinica_id) REFERENCES clinica(id),
   PRIMARY KEY (id)
);

CREATE TABLE usuario(
   id			INT				NOT NULL IDENTITY,
   nome			VARCHAR (250)	NOT NULL,
   cpf			VARCHAR (250)	NOT NULL,
   sexo			CHAR (1)		NOT NULL,
   telefone		INT,
   celular 		INT,
   endereco		VARCHAR (250)	NOT NULL,
   bairro		VARCHAR (250)	NOT NULL,
   cep			INT				NOT NULL,
   cidade		VARCHAR (250)	NOT NULL,
   uf			VARCHAR (2)		NOT NULL,
   email		VARCHAR (250)	NOT NULL,
   nome_usuario	VARCHAR (250)	NOT NULL,
   senha		VARCHAR (250)	NOT	NULL,
   conf_senha	VARCHAR (250)	NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE marcacao(
   id          		INT              	NOT NULL IDENTITY,
   hora				VARCHAR (250)    	NOT NULL,
   data        		VARCHAR (250)    	NOT NULL,
   usuario_id  		INT              	NOT NULL,
   plano_id			INT					NOT NULL,
   procedimento_id	INT					NOT NULL,
   clinica_id		INT					NOT NULL,
   FOREIGN KEY (usuario_id) REFERENCES usuario(id),
   FOREIGN KEY (plano_id) REFERENCES plano(id),
   FOREIGN KEY (procedimento_id) REFERENCES procedimento(id),
   FOREIGN KEY (clinica_id) REFERENCES clinica(id),
   PRIMARY KEY (id)
);

CREATE TABLE animal(
   id          	INT           	NOT NULL IDENTITY,
   nome        	VARCHAR (250)	NOT NULL,
   tipo			CHAR (1)	    NOT NULL,
   peso			Float (6)	    NOT NULL,
   raca		    VARCHAR (250)	NOT NULL,
   cor   		VARCHAR (250)	NOT NULL,
   pelagem		CHAR (1)	    NOT NULL,
   PRIMARY KEY (id)
);
