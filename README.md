#Setup
- Install oracle database
- Create schema/user "dosar"
- Copy persistence_local.xml as persistence.xml
- Copy db_ip_local.txt as db_ip.txt in /scripts/ 
- Install git (need git bash)
- In scripts run: migrate.sh
- Run: build.sh and run.sh
--------------------------
Angular:
>ng build --deploy-url=/client-app/

>ng build --base-href // for routing
---------------------------
How to make a migration file:
- in scripts run:
>java Migrate make create_someting_table

- edit the file created and:
>compile-all.sh

>migrate.sh