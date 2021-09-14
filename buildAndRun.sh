
#mvn clean package && docker build -t com.alexandruleonte/Dosar .
#docker rm -f Dosar || true && docker run -d -p 8080:8080 -p 4848:4848 --name Dosar com.alexandruleonte/Dosar

java -jar pm.jar target/ROOT.war --port 8080 --outputUberJar ROOT.jar