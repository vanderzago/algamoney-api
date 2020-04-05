CREATE SEQUENCE algamoneyapi.estado_seq;

CREATE TABLE algamoneyapi.estado (
	codigo BIGINT PRIMARY KEY DEFAULT NEXTVAL ('algamoneyapi.estado_seq'),
	nome VARCHAR(50) NOT NULL
);

INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(1, 'Acre');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(2, 'Alagoas');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(3, 'Amazonas');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(4, 'Amapá');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(5, 'Bahia');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(6, 'Ceará');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(7, 'Distrito Federal');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(8, 'Espírito Santo');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(9, 'Goiás');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(10, 'Maranhão');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(11, 'Minas Gerais');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(12, 'Mato Grosso do Sul');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(13, 'Mato Grosso');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(14, 'Pará');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(15, 'Paraíba');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(16, 'Pernambuco');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(17, 'Piauí');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(18, 'Paraná');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(19, 'Rio de Janeiro');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(20, 'Rio Grande do Norte');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(21, 'Rondônia');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(22, 'Roraima');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(23, 'Rio Grande do Sul');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(24, 'Santa Catarina');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(25, 'Sergipe');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(26, 'São Paulo');
INSERT INTO algamoneyapi.estado (codigo, nome) VALUES(27, 'Tocantins');


CREATE SEQUENCE algamoneyapi.cidade_seq;

CREATE TABLE algamoneyapi.cidade (
	codigo BIGINT PRIMARY KEY DEFAULT NEXTVAL ('algamoneyapi.cidade_seq'),
	nome VARCHAR(50) NOT NULL,
  codigo_estado BIGINT NOT NULL,
  FOREIGN KEY (codigo_estado) REFERENCES algamoneyapi.estado(codigo)
);

INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (1, 'Belo Horizonte', 11);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (2, 'Uberlândia', 11);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (3, 'Uberaba', 11);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (4, 'São Paulo', 26);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (5, 'Campinas', 26);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (6, 'Rio de Janeiro', 19);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (7, 'Angra dos Reis', 19);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (8, 'Goiânia', 9);
INSERT INTO algamoneyapi.cidade (codigo, nome, codigo_estado) VALUES (9, 'Caldas Novas', 9);



ALTER TABLE algamoneyapi.pessoa DROP COLUMN cidade;
ALTER TABLE algamoneyapi.pessoa DROP COLUMN estado;
ALTER TABLE algamoneyapi.pessoa ADD COLUMN codigo_cidade BIGINT;
ALTER TABLE algamoneyapi.pessoa ADD CONSTRAINT fk_pessoa_cidade FOREIGN KEY (codigo_cidade) REFERENCES algamoneyapi.cidade(codigo);

UPDATE algamoneyapi.pessoa SET codigo_cidade = 2;