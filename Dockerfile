FROM openjdk:8u232-jdk-slim
VOLUME /tmp
EXPOSE 8443
ADD target/kollus-live-0.0.1-SNAPSHOT.jar kollus-live.jar

ENV JAVA_OPTS=""
ENV SPRING_PROFILE="KUBE"

ENTRYPOINT exec java $JAVA_OPTS \
    -Djava.security.egd=file:/dev/./urandom \
    -Dspring.profiles.active=$SPRING_PROFILE \
    -jar kollus-live.jar