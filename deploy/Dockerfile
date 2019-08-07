FROM openjdk:12.0.2

WORKDIR /source
# copy application WAR (with libraries inside)
COPY build/SendEmailService.jar ./
# specify default command
CMD ["java", "-jar", "/source/SendEmailService.jar"]