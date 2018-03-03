CREATE TABLE algamoneyapi.usuario (
	codigo BIGINT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ;

CREATE TABLE algamoneyapi.permissao (
	codigo BIGINT PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ;

CREATE TABLE algamoneyapi.usuario_permissao (
	codigo_usuario BIGINT NOT NULL,
	codigo_permissao BIGINT NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES algamoneyapi.usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES algamoneyapi.permissao(codigo)
) ;

INSERT INTO algamoneyapi.usuario (codigo, nome, email, senha) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO algamoneyapi.usuario (codigo, nome, email, senha) values (2, 'Maria Silva', 'maria@algamoney.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO algamoneyapi.permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO algamoneyapi.permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO algamoneyapi.permissao (codigo, descricao) values (3, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO algamoneyapi.permissao (codigo, descricao) values (4, 'ROLE_REMOVER_PESSOA');
INSERT INTO algamoneyapi.permissao (codigo, descricao) values (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO algamoneyapi.permissao (codigo, descricao) values (6, 'ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO algamoneyapi.permissao (codigo, descricao) values (7, 'ROLE_REMOVER_LANCAMENTO');
INSERT INTO algamoneyapi.permissao (codigo, descricao) values (8, 'ROLE_PESQUISAR_LANCAMENTO');

-- admin
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);

-- maria
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (2, 5);
INSERT INTO algamoneyapi.usuario_permissao (codigo_usuario, codigo_permissao) values (2, 8);
