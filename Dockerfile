FROM payara/micro:5.2021.3-jdk11
COPY ROOT.jar $DEPLOY_DIR
COPY dbc.jar $PAYARA_DIR
COPY dbc.txt $PAYARA_DIR

ENTRYPOINT ["java", "-jar", "/opt/payara/deployments/ROOT.jar", "--addLibs", "/opt/payara/dbc.jar", "--postbootcommandfile", "/opt/payara/dbc.txt"]

