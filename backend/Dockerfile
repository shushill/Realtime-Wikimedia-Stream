FROM eclipse-temurin:17-jdk-focal





WORKDIR /app



ADD ./backend /app/backend
ADD ./consumer /app/consumer
ADD ./producer /app/producer

RUN chmod +x /app/backend/consumer.sh
RUN chmod +x /app/backend/producer.sh

