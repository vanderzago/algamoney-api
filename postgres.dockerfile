FROM postgres:10.4-alpine

LABEL Author="Vander Zago"

VOLUME  ["/etc/postgresql", "/var/log/postgresql", "/var/lib/postgresql"]

EXPOSE 5432