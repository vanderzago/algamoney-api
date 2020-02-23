CREATE SEQUENCE algamoneyapi.contato_seq;

CREATE TABLE algamoneyapi.contato (
  	codigo BIGINT PRIMARY KEY DEFAULT NEXTVAL ('algamoneyapi.contato_seq'),
	codigo_pessoa BIGINT NOT NULL,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
  	FOREIGN KEY (codigo_pessoa) REFERENCES algamoneyapi.pessoa(codigo)
) ;

insert into algamoneyapi.contato (codigo, codigo_pessoa, nome, email, telefone) values (1, 1, 'Marcos Henrique', 'marcos@algamoney.com', '00 0000-0000');