--liquibase formatted sql

--changeset developer:001-create-example-table
CREATE TABLE example_table (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
