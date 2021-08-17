FROM payara/micro
COPY target/ROOT.war $DEPLOY_DIR
COPY dbc.jar $PAYARA_DIR
COPY dbc.txt $PAYARA_DIR

ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addLibs", "/opt/payara/dbc.jar", "--deploy", "/opt/payara/deployments/ROOT.war", "----postbootcommandfile", "/opt/payara/dbc.txt"]

