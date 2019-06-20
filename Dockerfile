
# prepare the app's image
FROM openjdk:8-jdk-alpine

# copy the init script
COPY init.sh /

# copy the artifact and properties
RUN mkdir -pv /usr/local/apps/helloworld-service

# copy the artifact from the build container
ADD ./target/helloworld-service-1.4-SNAPSHOT.war /usr/local/apps/helloworld-service/helloworld-service-1.4-SNAPSHOT.war
ADD ./helloworld-service.properties /usr/local/apps/helloworld-service/helloworld-service.properties

RUN chown 2000 /usr/local/apps/helloworld-service -R

EXPOSE 8080

# run the init script every time the container starts
CMD ["/bin/sh", "-c", "/bin/sh /init.sh"]
