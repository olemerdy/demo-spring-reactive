CREATE TABLE IF NOT EXISTS person
(
    id                 UUID  NOT NULL,
    name               VARCHAR(256) NOT NULL,
    birth_date         DATE,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            INTEGER,
    PRIMARY KEY (id)
);