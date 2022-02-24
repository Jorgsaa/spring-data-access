FROM openjdk:17-jdk-alpine
ARG JAR_FILE="build/libs/spring-data-access-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} app.jar
COPY Chinook_Sqlite.sqlite Chinook_Sqlite.sqlite
EXPOSE $PORT
ENV SQLITE_DATABASE_PATH "Chinook_Sqlite.sqlite"
ENTRYPOINT ["java","-jar","/app.jar"]