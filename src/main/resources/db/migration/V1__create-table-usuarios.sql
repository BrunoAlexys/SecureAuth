CREATE TABLE tb_usuarios
(
    id    BINARY(16)   NOT NULL,
    nome  VARCHAR(255) NOT NULL,
    cpf   VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    `role` SMALLINT    NOT NULL,
    CONSTRAINT pk_tb_usuarios PRIMARY KEY (id)
);
