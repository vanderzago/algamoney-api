create user algamoneyapp with encrypted password 'Alg@moneyap1';
create role algamoneycrud;
grant SELECT, UPDATE, INSERT, DELETE ON ALL TABLES IN SCHEMA algamoneyapi to algamoneycrud;
grant algamoneycrud to algamoneyapp;