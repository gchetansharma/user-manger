FROM eclipse-temurin:19-jre-focal as builder
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-manger.jar
RUN java -Djarmode=layertools -jar user-manger.jar extract

FROM eclipse-temurin:19-jre-focal
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]