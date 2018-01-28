CREATE SEQUENCE algamoneyapi.categoria_seq;

CREATE TABLE algamoneyapi.categoria (
	codigo BIGINT PRIMARY KEY DEFAULT NEXTVAL ('categoria_seq'),
	nome VARCHAR(50) NOT NULL
) ;    
INSERT INTO algamoneyapi.categoria (nome) values ('Lazer');
INSERT INTO algamoneyapi.categoria (nome) values ('Alimentação');
INSERT INTO algamoneyapi.categoria (nome) values ('Supermercado');
INSERT INTO algamoneyapi.categoria (nome) values ('Farmácia');
INSERT INTO algamoneyapi.categoria (nome) values ('Outros');
