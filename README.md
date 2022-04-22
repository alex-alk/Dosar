#Setup
- Install oracle database
- Create schema/user "dosar"
- Copy persistence_public.xml as persistence.xml
- Copy scripts/db_public.txt as scripts/db.txt
- Install git (need git bash)
- In scripts run: migrate.sh
- Copy run_public.sh as run_sh
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