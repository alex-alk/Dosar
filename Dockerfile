FROM payara/micro
COPY target/Dosar.war $DEPLOY_DIR
COPY dbc.jar $PAYARA_HOME

