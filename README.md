# Build
mvn clean package && docker build -t com.alexandruleonte/Dosar .

# RUN

docker rm -f Dosar || true && docker run -d -p 8080:8080 -p 4848:4848 --name Dosar com.alexandruleonte/Dosar 