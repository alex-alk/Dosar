#Setup
- Install oracle database
- Create schema/user "dosar"
- Copy persistence_public.xml as persistence.xml
- Copy web_public.xml as web.xml and change ip, etc
- Copy flyway_public.conf as flyway.conf
- Run mvn clean flyway:migrate -Dflyway.configFiles=flyway.con
- Run: run.sh
--------------------------
Angular:
>ng build --deploy-url=/client-app/

- copy dist/ClientApp contents into webapp/client-app
