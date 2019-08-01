FROM alpine

WORKDIR /work

COPY src ./src
COPY libs ./libs
COPY build.xml ./

RUN apk update && apk add openjdk8 && apk add apache-ant
RUN ant package

CMD ["java", "-jar", "/work/build/SendEmailService.jar"]