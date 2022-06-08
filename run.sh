mvn clean
mvn package
java -jar ../pm.jar target/ROOT.war --addLibs ojdbc11.jar --port 80 --sslPort 443
$SHELL

