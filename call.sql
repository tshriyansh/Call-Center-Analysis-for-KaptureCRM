// this is SQL Queries wich will help us to create table and database .

CREATE TABLE call (
    id SERIAL PRIMARY KEY,
    from_number VARCHAR(20) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    duration INT NOT NULL
);

INSERT INTO call (from_number, start_time, end_time, duration) VALUES
    ('9999900000', '2021-01-13 06:00:05', '2021-01-13 06:23:06', 181),
    ('9999902010', '2021-01-13 06:12:49', '2021-01-13 06:14:44', 115),
    ('9991323232', '2021-01-13 07:02:49', '2021-01-13 07:14:44', 715),
    ('8484848484', '2021-01-13 08:12:49', '2021-01-13 08:14:44', 115),
    ('9378373737', '2021-01-13 10:12:49', '2021-01-13 10:14:44', 115),
    ('9837373737', '2021-01-13 12:12:49', '2021-01-13 12:14:44', 115),
    ('9973737373', '2021-01-13 15:12:49', '2021-01-13 15:14:44', 115);
