--liquibase dialect

-- changeSet belov:1

CREATE TABLE notification_task
(
    id      BIGSERIAL PRIMARY KEY,
    chat_id BIGINTEGER NOT NULL,
    text TEXT NOT NULL ,
    date_time TIMESTAMP NOT NULL

)