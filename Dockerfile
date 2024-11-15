# Etapa de construção
FROM maven:3.9.4-amazoncorretto-21 AS build

WORKDIR /app

# Copia os arquivos do projeto para o container
COPY . .

# Executa o build do projeto
RUN mvn clean package

# Etapa de execução
FROM amazoncorretto:21

WORKDIR /app

# Copia o JAR do container de build
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
