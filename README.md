#Setup
- Install oracle database
- Create schema "dosar"
- Copy persistence_local.xml as persistence.xml
- In scripts/migrations run: java Migrate migrate
- Run: build.sh and run.sh
--------------------------
Angular:
>ng build --deploy-url=/client-app/

>ng build --base-href // for routing
---------------------------
How to make a migration file:
- in scripts/migrations run:
>java Migrate make create_someting_table

- edit the file created and:
>compile-all.sh

>java Migrate migrate