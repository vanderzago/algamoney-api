alter table algamoneyapi.cidade add constraint FK3p3ii5fk4vpyyp0bju26kggbb foreign key (codigo_estado) references algamoneyapi.estado;

GRANT SELECT, INSERT, UPDATE, DELETE ON algamoneyapi.cidade TO algamoneyapp;
GRANT USAGE, SELECT ON algamoneyapi.cidade_seq TO algamoneyapp;
GRANT SELECT, INSERT, UPDATE, DELETE ON algamoneyapi.estado TO algamoneyapp;
GRANT USAGE, SELECT ON algamoneyapi.estado_seq TO algamoneyapp;