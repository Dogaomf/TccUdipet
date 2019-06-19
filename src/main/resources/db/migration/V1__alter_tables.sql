ALTER TABLE procedimento(
   id          INT              NOT NULL IDENTITY,
   nome        VARCHAR (250)    NOT NULL,
   codproc     INT              NOT NULL,
   tipo        VARCHAR (250)    NOT NULL,
   descproc    VARCHAR (250)    NOT NULL,
   PRIMARY KEY (id)
);

