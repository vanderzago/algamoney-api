CREATE SEQUENCE algamoneyapi.pessoa_seq;

CREATE TABLE algamoneyapi.pessoa (
	codigo BIGINT PRIMARY KEY DEFAULT NEXTVAL ('algamoneyapi.pessoa_seq'),
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN NOT NULL,
	logradouro VARCHAR(100),
	numero INTEGER,
	complemento VARCHAR(20),
	bairro VARCHAR(50),
	cep VARCHAR(10),
	cidade VARCHAR(100),
	estado VARCHAR(2)	
) ;

grant SELECT, INSERT, DELETE, UPDATE on table algamoneyapi.pessoa to algamoneyapp;
grant USAGE, SELECT on sequence algamoneyapi.pessoa_seq to algamoneyapp;

INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Vander',true,'Rua Ronan Riveiro',10,'Ap. 402 bloco 03','Alto Umuarama','38.400-000','Uberlândia','MG');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Renata',true,'Rua Ronan Riveiro',10,'Ap. 402 bloco 03','Alto Umuarama','38.400-000','Uberlândia','MG');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Amanda',true,'Rua Ronan Riveiro',10,'Ap. 402 bloco 03','Alto Umuarama','38.400-000','Uberlândia','MG');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Guilherme',true,'Rua Ronan Riveiro',10,'Ap. 402 bloco 03','Alto Umuarama','38.400-000','Uberlândia','MG');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Vânia',true,'Rua IBM',10900,null,'DB2','36.440-500','Campinas','SP');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Victor',true,'Rua Suiça',400,null,'Federer','46.440-555','São Paulo','SP');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Vanessa',true,'Rua Bradesco',3,null,'Money','36.777-770','Osasco','SP');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Maria Eduarda',true,'Rua Bradesco',3,null,'Money','36.777-770','Osasco','SP');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Vera',true,'Rua Casa',8977,null,'Jardim Belmonte','36.563-360','Osasco','SP');
INSERT INTO algamoneyapi.pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Eduardo',true,'Rua Casa',8977,null,'Jardim Belmonte','36.563-360','Osasco','SP');