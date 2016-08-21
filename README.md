# JerseyAndJDBCExample
Example application that uses:
1.MySQL JDBC connection to implement DAO classes for persisting entities.
2.Jersey framework to implement RESTful Web services.

#Important note
DatabaseConnection class holds database information(username, password, dbname...) that needs to be populated according to the runtime environment
before running application. Also database needs to be created that has tables that correspond to model classes located in skomarica.examples.jerseyjdbc.model package.
