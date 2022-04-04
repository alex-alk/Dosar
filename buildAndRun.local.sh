
#mvn clean package && docker build -t com.alexandruleonte/Dosar .
#docker rm -f Dosar || true && docker run -d -p 8080:8080 -p 4848:4848 --name Dosar com.alexandruleonte/Dosar


mvn clean
mvn package
java -jar ../pm.jar target/ROOT.war --addLibs ojdbc11.jar --postbootcommandfile dbc_local.txt --port 80 --sslPort 443