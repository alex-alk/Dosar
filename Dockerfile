FROM airhacks/glassfish
COPY ./target/Dosar.war ${DEPLOYMENT_DIR}
