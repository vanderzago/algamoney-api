FROM anapsix/alpine-java

LABEL Author="Vander Zago"

WORKDIR "/opt"

VOLUME [ "/opt" ]

COPY "target/algamoney-api-0.0.1-SNAPSHOT.jar" "/opt/algamoney-api-0.0.1-SNAPSHOT.jar"

ENTRYPOINT ["java","-jar","algamoney-api-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080