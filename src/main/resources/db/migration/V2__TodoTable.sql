CREATE TABLE todo (
    id SERIAL CONSTRAINT todo_pk PRIMARY KEY ,
    title VARCHAR(30) NOT NULL ,
    finished BOOLEAN ,
    created_at TIMESTAMP
)