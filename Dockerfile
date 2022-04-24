FROM payara/micro:5.2022.2-jdk11
COPY target/ROOT.war $PAYARA_DIR
COPY ojdbc11.jar $PAYARA_DIR

ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addLibs", "/opt/payara/ojdbc11.jar", "--deploy", "/opt/payara/ROOT.war", "--port", "80", "--sslPort", "443"]

