### Run a postgres database using docker

```bash
docker run --name spb_db --rm -e  POSTGRES_PASSWORD=pass123 -e POSTGRES_DB=students --net=host -v pgdata14:/var/lib/postgresql/data  -d postgres:14
```

## remove db data
```bash
docker volume rm pgdata14
```



Links:
* [install docker](https://tinyurl.com/2m3bhahn)