#Setup
- Install oracle database
- Create schema/user "dosar"
- Copy persistence_public.xml as persistence.xml
- Copy web_public.xml as web.xml
- Copy flyway_public.conf as flyway.conf
- Run mvn clean flyway:migrate -Dflyway.configFiles=flyway.conf
- Copy run_public.sh as run.sh
- Run: build.sh and run.sh
--------------------------
Angular:
>ng build --deploy-url=/client-app/

---------------------------
How to make a migration file:
- in scripts run:
>java Migrate make create_someting_table

- edit the file created and:
>compile-all.sh

>migrate.sh