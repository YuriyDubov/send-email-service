FROM arraylabs/docker-alpine-cron

WORKDIR /work

ADD src ./src
ADD libs ./libs
ADD build.xml ./

RUN apk update && apk add openjdk8 && apk add apache-ant

RUN ant package

RUN chmod 777 ./build/SendEmailService.jar

ADD crontab.txt /etc/cron.d/crontab.txt

# Give execution rights on the cron job
# RUN chmod 0644 /etc/cron.d/crontab

ADD script.sh /script.sh

ADD entry.sh /entry.sh
RUN chmod 777 /script.sh
RUN chmod 777 /entry.sh

# Apply cron job
RUN /usr/bin/crontab /etc/cron.d/crontab.txt

# CMD cron
WORKDIR /
CMD /entry.sh