alter table contato add constraint FK2fbi18g7f9soi69fdo0thb1t foreign key (codigo_pessoa) references algamoneyapi.pessoa;
GRANT SELECT, INSERT, UPDATE, DELETE ON algamoneyapi.contato TO algamoneyapp;
GRANT USAGE, SELECT ON algamoneyapi.contato_seq TO algamoneyapp;