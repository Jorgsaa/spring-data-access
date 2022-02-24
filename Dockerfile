FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY Chinook_Sqlite.sqlite Chinook_Sqlite.sqlite
ENV SQLITE_DATABASE_PATH "Chinook_Sqlite.sqlite"
ENTRYPOINT ["java","-jar","/app.jar"]