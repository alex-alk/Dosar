FROM payara/micro
COPY target/ROOT.war $DEPLOY_DIR
COPY dbc.jar $HOME_DIR
COPY dbc.txt $HOME_DIR

ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addLibs", "/opt/payara/dbc.jar", "--deploy", "$DEPLOY_DIR/ROOT.war", "----postbootcommandfile", "$HOME_DIR/dbc.txt"]

