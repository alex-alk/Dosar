FROM payara/micro:5.2022.2-jdk11
COPY target/ROOT.war $PAYARA_DIR
COPY ojdbc11.jar $PAYARA_DIR

ENTRYPOINT ["java", "-jar", "$PAYARA_DIR/payara-micro.jar", "--addLibs", "$PAYARA_DIR/ojdbc11.jar", "--deploy", "$PAYARA_PATH/ROOT.war"]

