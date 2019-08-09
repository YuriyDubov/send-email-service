FROM openjdk:12-alpine

RUN apk --no-cache add bash

RUN mkdir -p /opt/service

ADD build/SendEmailService.jar /opt/service
ADD entry.sh /opt/service
ADD start.sh /opt/service
ADD crontab.txt /opt/service

WORKDIR /opt/service

RUN chmod 755 /opt/service/entry.sh /opt/service/start.sh
RUN /usr/bin/crontab /opt/service/crontab.txt

CMD ["/opt/service/entry.sh"]