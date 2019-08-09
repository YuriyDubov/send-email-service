# Send Email Service

### Description 
It's a simple service for receiving information about NBA games by e-mail.
This service gets information from open API, wraps up data to an HTML template 
and sends an email for you.

### Requirements
During the development of this service was used jdk-12.0.2 also openjdk-12.

### Build
This service uses Ant to build. You can use "package" target in build.xml for build jar archive.
The result named SendEmailService.jar will be in the build folder. 
```
ant -buildfile build.xml package
```

### Usage
You should change credentials in `config.properties` file. 
Login and password are credentials of Gmail mail of the sender.
Recipient is the email address of the recipient of any mail.

To start the application, run the following command:

```
java -jar SendEmailService.jar
```

If you want to receive an email every day, you can build a docker image of this application
 using the dockerfile.
 
 ```
 docker build -t SendEmailService .
 ``` 
 
  Then run this image in the docker container.
  
  ```
  docker run -d SendEmailService
  ```