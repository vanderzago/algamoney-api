FROM postgres:10.4-alpine

LABEL Author="Vander Zago"

VOLUME  ["/etc/postgresql", "/var/log/postgresql", "/var/lib/postgresql"]

COPY "sql/init.sql" "/docker-entrypoint-initdb.d"

EXPOSE 5432