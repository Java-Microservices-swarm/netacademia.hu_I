FROM openjdk:jre-alpine

ADD hero-swarm.jar /opt/wildfly-swarm.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "-Dswarm.port.offset=1","/opt/wildfly-swarm.jar", "-Dswarm.ds.name=hoeds", "-Dswarm.ds.username=hoe", "-Dswarm.ds.password=hoe", "-Dswarm.ds.connection.url=jdbc:mysql://172.17.0.1:3306/hoe?useSSL=false", "-Djava.net.preferIPv4Stack=true"]
