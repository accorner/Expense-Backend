# 1️⃣ Use official Java 17 JDK image
FROM eclipse-temurin:17-jdk-alpine

# 2️⃣ Set working directory inside container
WORKDIR /app

# 3️⃣ Copy Maven wrapper and pom.xml first (for caching dependencies)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# 4️⃣ Download dependencies (cache layer)
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# 5️⃣ Copy the rest of the project
COPY src ./src

# 6️⃣ Build Spring Boot app
RUN ./mvnw clean package -DskipTests

# 7️⃣ Expose the port your Spring Boot uses
EXPOSE 8080

# 8️⃣ Run the Spring Boot jar
CMD ["java", "-jar", "target/expense-backend.jar"]
