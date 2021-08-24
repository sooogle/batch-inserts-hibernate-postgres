# JDBC batch inserts with Hibernate and PostgreSQL

This app shows how to enable JDBC batch inserts using Hibernate and PostgreSQL.

- Annotate auto-generated keys with `@GeneratedValue(strategy = GenerationType.SEQUENCE)`. Don't use `SERIAL` not `BIGSERIAL`.
- Set `spring.jpa.properties.hibernate.jdbc.batch_size` to appropriate value.
- Set `reWriteBatchedInserts` to true in the JDBC URL.

Run `docker compose up` and `./gradlew test` then you can find following logs on the PostgreSQL container. 

```sql
insert into todo (description, id) values ($1, $2),($3, $4),($5, $6), ...
parameters: $1 = 'todo0', $2 = '1', $3 = 'todo1', $4 = '2', $5 = 'todo2', $6 = '3', ...
```

### Reference
- https://stackoverflow.com/a/50882952
- https://vladmihalcea.com/postgresql-multi-row-insert-rewritebatchedinserts-property/