# Estágio 1: Build da aplicação com Maven
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Baixa as dependências
RUN ./mvnw dependency:go-offline

COPY src/ ./src/

# Empacota a aplicação, gerando o JAR
RUN ./mvnw package -DskipTests

# -----------------------------------------------------------

# Estágio 2: Execução da aplicação em um ambiente mínimo
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copia apenas o JAR final do estágio de build
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

# Ponto de entrada para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
